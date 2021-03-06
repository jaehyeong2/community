package jaefactory.community.dto;

import jaefactory.community.domain.user.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignUpDto {

    @NotBlank
    private String username;
    @NotBlank
    private String realName;
    @NotBlank
    private String password;
    @NotBlank
    private String email;

    public User toEntity() {
        return User.builder()
                .username(username).realName(realName).password(password).email(email)
                .build();
    }

}
