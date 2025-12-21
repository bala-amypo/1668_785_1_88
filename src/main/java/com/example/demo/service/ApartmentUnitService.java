package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ApartmentUnit;

public interface BookingLogService{
    BookingLog postData4(BookingLog use);
    List<BookingLog>getAllData4();
    String  DeleteData4(Long id);
    BookingLog getData4(Long id);         
    BookingLog updateData4(Long id,BookingLog entity);                                                        
}