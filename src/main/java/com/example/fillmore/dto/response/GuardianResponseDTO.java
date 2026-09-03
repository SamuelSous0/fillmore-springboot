package com.example.fillmore.dto.response;

import com.example.fillmore.model.Guardian;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuardianResponseDTO {

    private Long id;
    private UserResponseDTO user;

    public static GuardianResponseDTO fromEntity(Guardian guardian) {
        if (guardian == null) return null;
        return GuardianResponseDTO.builder()
                .id(guardian.getId())
                .user(UserResponseDTO.fromEntity(guardian.getUser()))
                .build();
    }
}