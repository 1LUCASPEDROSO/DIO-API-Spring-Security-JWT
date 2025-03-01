package dio.api_swagger.init;

import dio.api_swagger.Entity.User;
import dio.api_swagger.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public  void run(String... args) throws Exception{
        User admin = userRepository.findByUsername("admin");
        if (admin == null){
            admin = new User();
            admin.setName("Admin");
            admin.setUsername("admin");
            admin.setPassword("12345");
            admin.getRoles().add("MANAGERS");
            userRepository.save(admin);
        }
        User user = userRepository.findByUsername("user");
        if (user == null){
            user = new User();
            user.setName("user");
            user.setUsername("user");
            user.setPassword("1234");
            user.getRoles().add("USERS");
            userRepository.save(user);
        }
    }
}
