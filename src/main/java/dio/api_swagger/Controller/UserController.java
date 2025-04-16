package dio.api_swagger.Controller;

import dio.api_swagger.Entity.User;
import dio.api_swagger.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @GetMapping("/{username}")
    public List<String> getRoles( @PathVariable String username){
      return userService.getRoles(username);
    }
}