package online.shop.binary.users;

import online.shop.binary.base.BaseController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User, UserService> {
    
    @GetMapping("/username/{username}")
    public User findByUsername(@PathVariable String username) {
        return service.findByUsername(username);
    }
}