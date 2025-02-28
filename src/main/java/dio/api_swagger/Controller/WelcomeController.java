package dio.api_swagger.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "welcome to my spring boot web api";
    }
    @GetMapping("/users")
    public String users(){
        return "Authorized user";
    }
    @GetMapping("/manager")
    public String menager(){
        return "Authorized manager";
    }
}
