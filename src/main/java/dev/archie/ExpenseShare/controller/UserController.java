package dev.archie.ExpenseShare.controller;

import dev.archie.ExpenseShare.dto.LoginRequestDTO;
import dev.archie.ExpenseShare.dto.SignUpRequestDTO;
import dev.archie.ExpenseShare.entity.User;
import dev.archie.ExpenseShare.exception.InvalidLoginException;
import dev.archie.ExpenseShare.exception.InvalidSignUpException;
import dev.archie.ExpenseShare.mapper.UserEntityToDto;
import dev.archie.ExpenseShare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody SignUpRequestDTO signUpRequestDTO){
        if(signUpRequestDTO.getName() == null || signUpRequestDTO.getEmail() == null || signUpRequestDTO.getPassword() == null){
            throw new InvalidSignUpException("Please enter correct details and try again");
        }
        return ResponseEntity.ok(
                UserEntityToDto.toUserDto(
                        userService.signUp(signUpRequestDTO.getName(),
                                            signUpRequestDTO.getEmail(),
                                            signUpRequestDTO.getPassword()
                        )
                )
        );
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequestDTO){
        if(loginRequestDTO.getEmail() == null || loginRequestDTO.getPassword() == null){
            throw new InvalidLoginException("Please enter valid credentials and try again");
        }
        return ResponseEntity.ok(
                UserEntityToDto.toUserDto(
                        userService.login(
                                loginRequestDTO.getEmail(),
                                loginRequestDTO.getPassword()
                        )
                )
        );
    }



}
