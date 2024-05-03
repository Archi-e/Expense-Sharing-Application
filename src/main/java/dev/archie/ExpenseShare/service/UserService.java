package dev.archie.ExpenseShare.service;

import dev.archie.ExpenseShare.entity.User;
import dev.archie.ExpenseShare.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;


public interface UserService {
    User signUp(String name, String email, String password);
    User login(String email, String password);
}
