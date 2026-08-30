package online.shop.binary.service.impl;

import org.springframework.stereotype.Service;
import online.shop.binary.service.UserService;
import online.shop.binary.users.User;
import online.shop.binary.users.UserRepository;
import online.shop.binary.users.dto.UserFilterDto;
import online.shop.binary.users.dto.UserMergeDto;
import online.shop.binary.users.dto.UserResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl
        extends BaseServiceImpl<User, UserRepository>
        implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public UserResponseDto saveOrUpdate(UserMergeDto dto) {
        User user;
        if (dto.getId() != null) {
            // آپدیت: ابتدا چک می‌کنیم وجود دارد یا نه
            user = repository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getId()));
        } else {
            user = new User();
        }
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());

        User savedUser = repository.save(user);
        return toResponseDto(savedUser);
    }

    @Override
    public List<UserResponseDto> filter(UserFilterDto filterDto) {
        return repository.findAll().stream()
                .filter(u -> filterDto.getUsername() == null || (u.getUsername() != null && u.getUsername().contains(filterDto.getUsername())))
                .filter(u -> filterDto.getEmail() == null || (u.getEmail() != null && u.getEmail().contains(filterDto.getEmail())))
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        repository.deleteAllById(ids);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public UserResponseDto toResponseDto(User entity) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }
}