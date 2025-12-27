// package com.example.demo;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class DemoApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(DemoApplication.class, args);
// 	}

// }





// package com.example.demo;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class DemoApplication {
//     public static void main(String[] args) {
//         SpringApplication.run(DemoApplication.class, args);
//     }
// }





package com.example.demo;
   import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    
     
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("mith"));
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		if(encoder.matches("pavi", "$2a$10$LWYbSzKkuYtLZgveAVCbW.d5T/KMTk5aLVuXN2EoM6gtMxIY8TDOS")){
			System.out.println("password matched");
		}else{
			System.out.println("no match");
		}
	}
    }

