// src/main/java/com/example/demo/model/User.java
package com.example.demo.model;

public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private ApartmentUnit apartmentUnit;

    public User() {}

    public User(Long id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public ApartmentUnit getApartmentUnit() { return apartmentUnit; }
    public void setApartmentUnit(ApartmentUnit apartmentUnit) {
        this.apartmentUnit = apartmentUnit;
    }
}
// // src/main/java/com/example/demo/model/User.java
// package com.example.demo.model;

// public class User {
//     private Long id;
//     private String name;
//     private String email;
//     private String password;
//     private String role;
//     private ApartmentUnit apartmentUnit;

//     public User() {}

//     public User(Long id, String name, String email, String password, String role) {
//         this.id = id;
//         this.name = name;
//         this.email = email;
//         this.password = password;
//         this.role = role;
//     }

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }

//     public ApartmentUnit getApartmentUnit() { return apartmentUnit; }
//     public void setApartmentUnit(ApartmentUnit apartmentUnit) {
//         this.apartmentUnit = apartmentUnit;
//     }
// }
// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String username;
//     private String email;
//     private String password;
//     private String role;

//     // No-args constructor
//     public User() {}

//     // Full constructor (without id, as it's auto-generated)
//     public User(String username, String email, String password, String role) {
//         this.username = username;
//         this.email = email;
//         this.password = password;
//         this.role = role;
//     }

//     // Getters and setters
//     public Long getId() { return id; }

//     public String getUsername() { return username; }
//     public void setUsername(String username) { this.username = username; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }
// }
