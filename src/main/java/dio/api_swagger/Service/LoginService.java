package dio.api_swagger.Service;

import dio.api_swagger.DTO.Login;
import dio.api_swagger.DTO.Session;
import dio.api_swagger.Entity.User;
import dio.api_swagger.Repository.UserRepository;
import dio.api_swagger.Security.JWTCreator;
import dio.api_swagger.Security.JWTObject;
import dio.api_swagger.Security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SecurityConfig securityConfig;

    @Autowired
    private PasswordEncoder encoder;

    public Session login(Login login){

          User user = userRepository.findByUsername(login.username());
            if (user != null){
                boolean passWordOk = encoder.matches(login.password(), user.getPassword());
                if (!passWordOk){
                    throw new RuntimeException("Senha invalida para o login: "+login.username());
                }
                JWTObject jwtObject = new JWTObject();
                jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
                jwtObject.setExpiration(new Date(System.currentTimeMillis() + 3600000L)); // time of gereted token plus expiration time
                jwtObject.setRoles(user.getRoles());
                return new Session(user.getUsername(), JWTCreator.createToken(securityConfig.getPREFIX(),securityConfig.getKEY(),jwtObject));
            }
            throw  new RuntimeException("Erro ao tentar fazer login");
    }
}
