// package com.example.demo.model;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.Min;
// import lombok.*;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class ApartmentUnit {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true)
//     private String unitNumber;   

//     @Min(0)
//     @Column(nullable = false)
//     private int floor;           

//     @OneToOne
//     @JoinColumn(name = "owner_id", nullable = false, unique = true)
//     private User owner;
// }



// package com.example.demo.model;

// public class ApartmentUnit {

//     private Long id;
//     private String unitNumber;
//     private Integer floor;
//     private User owner;

//     public ApartmentUnit() {}

//     public ApartmentUnit(Long id, String unitNumber, Integer floor, User owner) {
//         this.id = id;
//         this.unitNumber = unitNumber;
//         this.floor = floor;
//         this.owner = owner;
//     }

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getUnitNumber() { return unitNumber; }
//     public void setUnitNumber(String unitNumber) { this.unitNumber = unitNumber; }

//     public Integer getFloor() { return floor; }
//     public void setFloor(Integer floor) { this.floor = floor; }

//     public User getOwner() { return owner; }
//     public void setOwner(User owner) { this.owner = owner; }
// }




// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "apartment_units")
// public class ApartmentUnit {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String unitNumber;

//     @Column(nullable = false)
//     private Integer floor;

//     @OneToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private User owner;

//     public ApartmentUnit() {}

//     public ApartmentUnit(Long id, String unitNumber, Integer floor, User owner) {
//         this.id = id;
//         this.unitNumber = unitNumber;
//         this.floor = floor;
//         this.owner = owner;
//     }

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getUnitNumber() { return unitNumber; }
//     public void setUnitNumber(String unitNumber) { this.unitNumber = unitNumber; }

//     public Integer getFloor() { return floor; }
//     public void setFloor(Integer floor) { this.floor = floor; }

//     public User getOwner() { return owner; }
//     public void setOwner(User owner) { this.owner = owner; }
// }





package com.example.demo.model;

// JPA imports
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "apartment_units")
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String unitNumber;

    @Column(nullable = false)
    private Integer floor;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    public ApartmentUnit() {}

    public ApartmentUnit(Long id, String unitNumber, Integer floor, User owner) {
        this.id = id;
        this.unitNumber = unitNumber;
        this.floor = floor;
        this.owner = owner;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUnitNumber() { return unitNumber; }
    public void setUnitNumber(String unitNumber) { this.unitNumber = unitNumber; }

    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
