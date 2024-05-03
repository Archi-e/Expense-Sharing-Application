package dev.archie.ExpenseShare.service;

import dev.archie.ExpenseShare.entity.User;
import dev.archie.ExpenseShare.exception.InvalidLoginException;
import dev.archie.ExpenseShare.exception.InvalidSignUpException;
import dev.archie.ExpenseShare.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signUp(String name, String email, String password) {
        User savedUser = userRepository.findByEmail(email);
        if(savedUser!=null) throw new InvalidSignUpException("User already exist");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        if (!password.matches(passwordRegex)) {
            throw new InvalidSignUpException("Password must have at least 8 characters, "
                    + "one lowercase letter, one uppercase letter, "
                    + "one digit, and one special character.");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        User savedUser = userRepository.findByEmail(email);
        if( savedUser == null){
            throw new InvalidLoginException("No account with this email address. Please sign up first");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password, savedUser.getPassword())){
            return savedUser;
        }

        else{
            throw new InvalidLoginException("Incorrect password, please enter valid credentials");
        }
    }
}
