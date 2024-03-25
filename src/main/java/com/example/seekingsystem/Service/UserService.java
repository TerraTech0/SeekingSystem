package com.example.seekingsystem.Service;

import com.example.seekingsystem.Model.User;
import com.example.seekingsystem.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUsers(User user){
        userRepository.save(user);
    }

    public Boolean updateUsers(Integer id, User user){
        User u = userRepository.getById(id);
        if (u == null){
            return false;
        }
        u.setName(user.getName());
        u.setAge(user.getAge());
        u.setRole(user.getRole());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());

        userRepository.save(u);
        return true;
    }

    public Boolean deleteUser(Integer id){
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            return false;
        }
        userRepository.delete(user);
        return true;
    }
}
