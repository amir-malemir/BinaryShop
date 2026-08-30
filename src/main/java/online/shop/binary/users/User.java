package online.shop.binary.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.shop.binary.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private Boolean active = true;
}