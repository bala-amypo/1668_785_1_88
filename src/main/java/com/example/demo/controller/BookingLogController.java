// package com.example.demo.controller;

// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.model.BookingLog;
// import com.example.demo.service.BookingLogService;
// import jakarta.validation.Valid;

// @RequestMapping("/BookingLog")
// @RestController
// public class BookingLogController{
//     @Autowired  BookingLogService ser;
//     @PostMapping("/register")
//     public BookingLog sendData(@RequestBody BookingLog stu){
//         return ser.postData4(stu);
//     }
//     @GetMapping("/get")
//     public List<BookingLog> getval(){
//         return ser.getAllData4();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData4(id);
//     }
//     @GetMapping("/find/{id}")
//     public BookingLog find(@PathVariable Long id){
//         return ser.getData4(id);
//     }
//     @PutMapping("/put/{id}")
//     public BookingLog putval(@PathVariable Long id,@RequestBody BookingLog entity){
//         return ser.updateData4(id,entity);
//     }
// }