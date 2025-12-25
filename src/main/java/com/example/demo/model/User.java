// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String name;

//     @Column(nullable = false, unique = true)
//     private String email;   

//     @Column(nullable = false)
//     private String password; 

//     @Enumerated(EnumType.STRING)
//     @Column(nullable = false)
//     private Role role = Role.RESIDENT; 
// }



package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role = "RESIDENT";

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    private ApartmentUnit apartmentUnit;

    public User() {}

    public User(Long id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public String getRole() { return role; }

    public void setApartmentUnit(ApartmentUnit apartmentUnit) {
        this.apartmentUnit = apartmentUnit;
    }
}
