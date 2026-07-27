package online.shop.binary.service;

import org.springframework.stereotype.Service;

import online.shop.binary.users.User;
import online.shop.binary.users.UserRepository;

@Service
public class UserService extends BaseService<User, UserRepository> {
    
    public User findByUsername(String username) {
        return null;
    }
}