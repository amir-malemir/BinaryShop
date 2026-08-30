package online.shop.binary.users.dto;

import online.shop.binary.base.dto.BaseFilterDto;

public class UserFilterDto extends BaseFilterDto {
    private String username;
    private String email;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}