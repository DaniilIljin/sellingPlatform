 package com.example.backend.security;

 import com.example.backend.model.Item;
 import jakarta.persistence.*;
 import lombok.*;
 import org.springframework.security.core.GrantedAuthority;
 import org.springframework.security.core.userdetails.UserDetails;

 import java.util.Collection;
 import java.util.List;
 import java.util.Set;

 @Entity
 @NoArgsConstructor
 @Data
 @Table(name = "\"user\"")
 public class User implements UserDetails {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false)
     private String name;

     @Column( nullable = false)
     private String email;

     @Column(nullable = false)
     private String password;

     @Column(nullable = false)
     private String address;

     @Column(name = "additional_info", nullable = false)
     private String additionalInfo;

     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
     private List<Item> itemsAsUser;

     @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
     private List<Item> itemsAsSeller;

     @ManyToMany
     @JoinTable(
             name = "liked_items",
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "item_id")
     )
     private Set<Item> likedItems;

     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
         return List.of(() -> "READ");
     }

     @Override
     public String getUsername() {
         return name;
     }
 }
