package kg.seit.company_project_rest_api_jwt;

import kg.seit.company_project_rest_api_jwt.enums.Role;
import kg.seit.company_project_rest_api_jwt.models.User;
import kg.seit.company_project_rest_api_jwt.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CompanyProjectRestApiJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyProjectRestApiJwtApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            User user = new User();
            user.setName("Seit");
            user.setSurname("Narynbaev");
            user.setEmail("seit@gmail.com");
            user.setRole(Role.ADMIN);
            user.setPassword(passwordEncoder.encode("1234"));
            userRepository.save(user);
        };
    }

}
