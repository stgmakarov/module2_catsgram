package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Stanislav Makarov
 */
@RestController
@RequestMapping("/users")
public class UserController {
    Set<User> users = new HashSet<>();

    @GetMapping()
    public List<User> getAllUsers(){
        return List.copyOf(users);
    }

    @PostMapping()
    public User addUser(@RequestBody User user) throws UserAlreadyExistException, InvalidEmailException {
        if(users.contains(user)) throw new UserAlreadyExistException();
        if(user.getEmail().isEmpty()||user.getEmail()==null) throw new InvalidEmailException();
        users.add(user);
        return user;
    }

    @PutMapping()
    public User updateUser(@RequestBody User user) throws InvalidEmailException {
        if(user.getEmail().isEmpty()||user.getEmail()==null) throw new InvalidEmailException();
        users.add(user);
        return user;
    }


    private class UserAlreadyExistException extends RuntimeException {
    }

    private class InvalidEmailException extends RuntimeException {
    }
}
