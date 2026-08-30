package online.shop.binary.users.dto;

import lombok.Getter;
import lombok.Setter;
import online.shop.binary.base.dto.BaseMergeDto;

@Getter
@Setter
public class UserMergeDto extends BaseMergeDto<Long> {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}