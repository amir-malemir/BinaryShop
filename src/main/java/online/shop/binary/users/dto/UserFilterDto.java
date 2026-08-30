package online.shop.binary.users.dto;

import lombok.Getter;
import lombok.Setter;
import online.shop.binary.base.dto.BaseFilterDto;

@Getter
@Setter
public class UserFilterDto extends BaseFilterDto {
    private String username;
    private String email;
    private Boolean active;
}