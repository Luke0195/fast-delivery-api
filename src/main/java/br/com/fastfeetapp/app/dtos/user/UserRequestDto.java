package br.com.fastfeetapp.app.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto implements Serializable {

    @NotBlank(message = "The field name is required")
    private String name;
    @NotBlank(message =  "The field email is required")
    @Email(message = "The field email is required")
    private String email;
    @NotBlank(message =  "The field password is required")
    private String password;
    @JsonProperty("avatar_url")
    private MultipartFile avatarUrl;
}
