package dev.archie.ExpenseShare.mapper;

import dev.archie.ExpenseShare.dto.SignUpResponseDTO;
import dev.archie.ExpenseShare.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


public class UserEntityToDto {
    public static SignUpResponseDTO toUserDto(User user){
        SignUpResponseDTO signUpResponseDTO = new SignUpResponseDTO();
        signUpResponseDTO.setEmail(user.getEmail());
        signUpResponseDTO.setName(user.getName());
        return signUpResponseDTO;
    }
}
