// // package com.example.demo.exception;

// // import org.springframework.http.HttpStatus;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.web.bind.annotation.ExceptionHandler;
// // import org.springframework.web.bind.annotation.RestControllerAdvice;

// // @RestControllerAdvice
// // public class GlobalExceptionHandler {

// //     @ExceptionHandler(BadRequestException.class)
// //     public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
// //         return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
// //     }

// //     @ExceptionHandler(ConflictException.class)
// //     public ResponseEntity<String> handleConflict(ConflictException ex) {
// //         return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
// //     }

// //     @ExceptionHandler(ResourceNotFoundException.class)
// //     public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
// //         return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
// //     }

// //     @ExceptionHandler(Exception.class)
// //     public ResponseEntity<String> handleGeneric(Exception ex) {
// //         return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
// //     }
// // }




// package com.example.demo.exception;

// import org.springframework.http.*;
// import org.springframework.web.bind.annotation.*;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(BadRequestException.class)
//     public ResponseEntity<String> bad(BadRequestException e) {
//         return ResponseEntity.badRequest().body(e.getMessage());
//     }

//     @ExceptionHandler(ConflictException.class)
//     public ResponseEntity<String> conflict(ConflictException e) {
//         return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//     }

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<String> notFound(ResourceNotFoundException e) {
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//     }
// }
