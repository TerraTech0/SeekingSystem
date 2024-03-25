package com.example.seekingsystem.Controller;

import com.example.seekingsystem.Api.ApiResponse;
import com.example.seekingsystem.Model.User;
import com.example.seekingsystem.Service.UserService;
import jakarta.persistence.PostLoad;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/seeker-system")
@AllArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/get")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUsers(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added successfully!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUsers(id, user);
        return ResponseEntity.status(200).body(new ApiResponse("user updated successfully!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        if (id == null){
            return ResponseEntity.status(400).body(new ApiResponse("user not found!"));
        }
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("user deleted successfully!"));
    }
}
