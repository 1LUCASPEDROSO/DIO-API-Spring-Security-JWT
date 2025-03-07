package dio.api_swagger.Controller;

import dio.api_swagger.Entity.User;
import dio.api_swagger.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }
}