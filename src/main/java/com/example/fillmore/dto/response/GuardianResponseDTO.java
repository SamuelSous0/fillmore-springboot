package com.example.fillmore.dto.response;

import com.example.fillmore.model.Guardian;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuardianResponseDTO {

    private Long id;
    private UserResponseDTO user;

    // TODO: Descomentar quando o StudentResponseDTO estiver disponível
    // private List<StudentResponseDTO> students;

    public static GuardianResponseDTO fromEntity(Guardian guardian) {
        if (guardian == null) return null;
        return GuardianResponseDTO.builder()
                .id(guardian.getId())
                .user(UserResponseDTO.fromEntity(guardian.getUser()))
                // .students(guardian.getStudents() != null 
                //     ? guardian.getStudents().stream().map(StudentResponseDTO::fromEntity).toList() 
                //     : List.of())
                .build();
    }
}