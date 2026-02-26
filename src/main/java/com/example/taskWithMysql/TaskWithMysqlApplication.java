package com.example.taskWithMysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TaskWithMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskWithMysqlApplication.class, args);
	}
	@Bean
CommandLineRunner init(UserRepository userRepo, BCryptPasswordEncoder encoder) {
    return args -> {
        if (userRepo.findByUsername("admin").isEmpty()) {
            userRepo.save(new User(
                "admin",
                encoder.encode("admin123"),
                "ROLE_ADMIN"
            ));
        }
    };
}

}
