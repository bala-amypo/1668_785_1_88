// src/main/java/com/example/demo/service/ApartmentUnitService.java
package com.example.demo.service;

import com.example.demo.model.ApartmentUnit;

public interface ApartmentUnitService {
    ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit);
    ApartmentUnit getUnitByUser(Long userId);
}
// // package com.example.demo.service;

// // import java.util.List;
// // import com.example.demo.model.ApartmentUnit;

// // public interface ApartmentUnitService{
// //     ApartmentUnit postData5(ApartmentUnit use);
// //     List<ApartmentUnit>getAllData5();
// //     String  DeleteData5(Long id);
// //     ApartmentUnit getData5(Long id);         
// //     ApartmentUnit updateData5(Long id,ApartmentUnit entity);                                                        
// // }



// // package com.example.demo.service;

// // import com.example.demo.model.ApartmentUnit;

// // public interface ApartmentUnitService {

// //     ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit);

// //     ApartmentUnit getUnitByUser(Long userId);
// // }




// package com.example.demo.service;

// import com.example.demo.model.ApartmentUnit;

// public interface ApartmentUnitService {

//     ApartmentUnit createUnit(String unitNumber, Integer floor, Long userId);

//     ApartmentUnit getUnitByUser(Long userId);

//     ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit);  // MUST match Impl
// }
