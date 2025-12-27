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
		System.out.println(new BCryptPasswordEncoder().encode("pavi"));
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		if(encoder.matches("pavi", "$2a$10$S.sv3HqUa/nL7RXKT1vEL.hSDiNb131ABoc..T5k9Cckq/j.O0fQG")){
			System.out.println("password matched");
		}else{
			System.out.println("no match");
		}
	}
    }

