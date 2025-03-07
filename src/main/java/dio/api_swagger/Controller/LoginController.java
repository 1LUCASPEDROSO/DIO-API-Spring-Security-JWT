package dio.api_swagger.Controller;

import dio.api_swagger.DTO.Login;
import dio.api_swagger.DTO.Session;
import dio.api_swagger.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("login")
    public Session login(@RequestBody Login login){
        return loginService.login(login);
    }
}
