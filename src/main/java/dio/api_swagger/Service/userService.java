package dio.api_swagger.Service;

import dio.api_swagger.Entity.User;
import dio.api_swagger.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;
    public void createUser(User user){
        String pass = user.getPassword();
        user.setPassword(encoder.encode(pass)); // encrypiting password
        userRepository.save(user);
    }
}
