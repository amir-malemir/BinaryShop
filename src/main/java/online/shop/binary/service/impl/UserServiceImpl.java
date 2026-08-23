package online.shop.binary.service.impl;

import org.springframework.stereotype.Service;

import online.shop.binary.service.UserService;
import online.shop.binary.users.User;
import online.shop.binary.users.UserRepository;

@Service
public class UserServiceImpl
        extends BaseServiceImpl<User, UserRepository>
        implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}