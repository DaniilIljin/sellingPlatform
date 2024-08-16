 package com.example.backend.security;

 import com.example.backend.model.Item;
 import com.fasterxml.jackson.annotation.JsonBackReference;
 import com.fasterxml.jackson.annotation.JsonIgnore;
 import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 import com.fasterxml.jackson.annotation.JsonManagedReference;
 import jakarta.persistence.*;
 import lombok.*;

 import java.util.List;
 import java.util.Set;

 @Entity
 @NoArgsConstructor
 @Data
 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
 @Table(name = "\"user\"")
 public class User{

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false)
     private String name;

     @Column( nullable = false)
     private String email;

     @JsonIgnore
     @Column(nullable = false)
     private String password;

     @Column(nullable = false)
     private String address;

     @Column(name = "additional_info", nullable = false)
     private String additionalInfo;

     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
     @JsonBackReference
     private List<Item> itemsAsUser;

     @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
     @JsonBackReference
     private List<Item> itemsAsSeller;

     @ManyToMany
     @JoinTable(
             name = "liked_items",
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "item_id")
     )
     @JsonManagedReference
     private Set<Item> likedItems;

 }
