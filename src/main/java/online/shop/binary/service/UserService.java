package online.shop.binary.service;

import online.shop.binary.users.User;

public interface UserService extends BaseService<User> {

    User findByUsername(String username);
}