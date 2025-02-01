package com.example.backend.service;

import com.example.backend.dto.ItemCreateDTO;
import com.example.backend.dto.ItemFullDTO;
import com.example.backend.dto.ItemDTO;
import com.example.backend.mapper.ItemMapper;
import com.example.backend.model.*;
import com.example.backend.security.User;
import com.example.backend.specification.ItemSpecs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final RepositoryManager repositoryManager;

    private final ItemMapper mapper;

    private final EntityManager entityManager;


    public List<Item> getItemsByParams(Long categoryId, Long sizeId, Long brandId,
                               Long sellerId, String name, int status,
                               String description, BigDecimal minPrice,
                                       BigDecimal maxPrice, Long userId)  {

        return repositoryManager.getItemRepository().findAll(ItemSpecs.buildSpecification(
                categoryId, sizeId, brandId, sellerId,
                name, status, description, minPrice, maxPrice, userId
        ));
    }

    public List<ItemDTO> getAllItems() {
        return repositoryManager
                .getItemRepository()
                .findAll()
                .stream()
                .map(mapper::convertItemToItemDTO)
                .toList();
    }


    public ItemDTO getItemById(Long id) {
        return repositoryManager
                .getItemRepository()
                .findById(id)
                .map(mapper::convertItemToItemDTO)
                .orElseThrow(() -> new EntityNotFoundException("Item wasn't found"));
    }

    public List<ItemDTO> getItemsByCategoryId(Long categoryId) {
        return repositoryManager
                .getItemRepository()
                .findAllByCategoryId(categoryId)
                .stream()
                .map(mapper::convertItemToItemDTO)
                .toList();
    }

    // подумать где убрать а где оставить transactional
    @Transactional
    public Item saveItem(ItemFullDTO itemFullDTO) {

        Item item = mapper.convertItemFullDTOtoItem(itemFullDTO);
        return repositoryManager.getItemRepository().save(item);
    }

    @Transactional
    public Item addNewItem(ItemCreateDTO itemCreateDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = repositoryManager
                .getUserRepository()
                .findByNameEquals(authentication.getName())
                .orElseThrow(() -> new UsernameNotFoundException("user wasnt found"));

        Item item = new Item();

        // по идее переместить это всё в mapper надо
        // ну и эксепшен норм сделать
        // но щас похуй пусть пока так
        try {
            item.setName(itemCreateDTO.getName());
            item.setDescription(itemCreateDTO.getDescription());
            item.setStatus(0);
            item.setPrice(itemCreateDTO.getPrice());
            item.setBrand(repositoryManager
                    .getBrandRepository()
                    .getReferenceById(itemCreateDTO.getBrandId()));
            item.setSize(repositoryManager
                    .getSizeRepository()
                    .getReferenceById(itemCreateDTO.getSizeId()));
            item.setSeller(user);
            item.setCategory(repositoryManager
                    .getCategoryRepository()
                    .getReferenceById(itemCreateDTO.getCategoryId()));
        } catch (EntityNotFoundException e) {
            throw new RuntimeException();
        }

        Item savedItem = repositoryManager.getItemRepository().save(item);

        for (String pictureName : itemCreateDTO.getPictureNames()) {

            Picture picture = new Picture();
            picture.setItem(savedItem);
            // иначе null а null нельзяй
            picture.setFileName("hz");
            picture.setFileLocation(pictureName);
            repositoryManager.getPictureRepository().save(picture);
        }

        return savedItem;
    }

    public void deleteItem(Long id) {

        Item item = repositoryManager
                .getItemRepository()
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item for deleting " +
                        "wasn't found"));

        repositoryManager.getItemRepository().delete(item);
    }

    //ситуация если в ид в дто и ид в path variable разые
    @Transactional
    public void updateItem(Long id, ItemFullDTO itemFullDTO) {

        // добавить хэндлинг эксепшена если айтема с таким ид нет
        Item item = repositoryManager
                .getItemRepository()
                .getReferenceById(id);


        item.setName(itemFullDTO.getName());
        item.setDescription(item.getDescription());
        item.setPrice(itemFullDTO.getPrice());
        if (itemFullDTO.getStatus() != null) item.setStatus(itemFullDTO.getStatus());

        // поменять метод на такой же метод но ерпозитории
        Category category = entityManager
                .getReference(Category.class, itemFullDTO.getCategoryId());
        item.setCategory(category);

        Brand brand = entityManager
                .getReference(Brand.class, itemFullDTO.getBrandId());
        item.setBrand(brand);

        Size size = entityManager
                .getReference(Size.class, itemFullDTO.getSizeId());
        item.setSize(size);

        User seller = entityManager
                .getReference(User.class, itemFullDTO.getSellerId());
        item.setSeller(seller);

        if (itemFullDTO.getUserId() != null) {
            User user = entityManager
                    .getReference(User.class, itemFullDTO.getUserId());
            item.setUser(user);
        }

        repositoryManager
                .getItemRepository()
                .save(item);
    }
}
