 package com.example.backend.security;

 import com.example.backend.model.Item;
 import jakarta.persistence.*;
 import lombok.*;

 import java.util.List;
 import java.util.Set;

 @Entity
 @Setter
 @Getter
 @NoArgsConstructor
 @AllArgsConstructor
 @ToString
 @Table(name = "user")
 public class User{

     @Id
     private long id;

     @Column(name = "name", nullable = false)
     private String name;

     @Column(name = "email", nullable = false)
     private String email;

     @Column(name = "password", nullable = false)
     private String password;

     @Column(name = "address", nullable = false)
     private String address;

     @Column(name = "additional_info", nullable = false)
     private String additionalInfo;

     @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
     private List<Item> itemsAsUser;

     @OneToMany(mappedBy = "seller", orphanRemoval = true, cascade = CascadeType.ALL)
     private List<Item> itemsAsSeller;

     @ManyToMany
     @JoinTable(
             name = "liked_items",
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "item_id")
     )
     private Set<Item> likedItems;

 }
