package online.shop.binary.users;

import online.shop.binary.base.BaseController;
import online.shop.binary.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User, UserService> {
    
	@PostMapping("/merge")
	public ResponseEntity<UserResponseDto> merge(@RequestBody UserMergeDto dto) {
	    User user = userService.saveOrUpdate(dto);
	    return ResponseEntity.ok(userService.toResponseDto(user));
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestBody BaseDeleteDto<Long> deleteDto) {
	    userService.deleteAllById(deleteDto.getIds());
	    return ResponseEntity.noContent().build();
	}
}