package online.shop.binary.users;

import online.shop.binary.base.BaseController;
import online.shop.binary.base.dto.BaseDeleteDto;
import online.shop.binary.service.UserService;
import online.shop.binary.users.dto.UserFilterDto;
import online.shop.binary.users.dto.UserMergeDto;
import online.shop.binary.users.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User, UserService> {

    @Autowired
    private UserService userService;

    @PostMapping("/merge")
    public ResponseEntity<UserResponseDto> merge(@RequestBody UserMergeDto dto) {
        UserResponseDto response = userService.saveOrUpdate(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<UserResponseDto>> filter(@RequestBody UserFilterDto filterDto) {
        List<UserResponseDto> response = userService.filter(filterDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/batch")
    public ResponseEntity<Void> delete(@RequestBody BaseDeleteDto<Long> deleteDto) {
        userService.deleteAllById(deleteDto.getIds());
        return ResponseEntity.noContent().build();
    }
}