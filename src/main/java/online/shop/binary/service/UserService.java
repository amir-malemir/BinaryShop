package online.shop.binary.service;

import online.shop.binary.users.User;
import online.shop.binary.users.dto.UserFilterDto;
import online.shop.binary.users.dto.UserMergeDto;
import online.shop.binary.users.dto.UserResponseDto;

import java.util.List;

public interface UserService extends BaseService<User> {
    User findByUsername(String username);
    UserResponseDto saveOrUpdate(UserMergeDto dto);
    List<UserResponseDto> filter(UserFilterDto filterDto);
    void deleteAllById(List<Long> ids);
    UserResponseDto toResponseDto(User entity);
}