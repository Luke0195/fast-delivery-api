package br.com.fastfeetapp.app.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto implements Serializable {

    private UUID id;
    private String name;
    private String email;
    private String password;
    @JsonProperty("avatar_url")
    private String avatarUrl;
}
