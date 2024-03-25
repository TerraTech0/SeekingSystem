package com.example.seekingsystem.Controller;

import com.example.seekingsystem.Api.ApiResponse;
import com.example.seekingsystem.Model.JopPost;
import com.example.seekingsystem.Repository.JopPostRepository;
import com.example.seekingsystem.Service.JopPostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jop-post")
@AllArgsConstructor
public class JopPostController {

    private final JopPostService jopPostService;

    @GetMapping("/get")
    public ResponseEntity getAllJopPosts(){
        return ResponseEntity.status(200).body(jopPostService.getAllJopPosts());
    }

    @PostMapping("/add")
    public ResponseEntity addJopPost(@RequestBody @Valid JopPost jopPost, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jopPostService.addJopPost(jopPost);
        return ResponseEntity.status(200).body(new ApiResponse("jop post added successfully!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJopPost(@PathVariable Integer id, @RequestBody @Valid JopPost jopPost, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jopPostService.updateJopPost(id, jopPost);
        return ResponseEntity.status(200).body(new ApiResponse("jop post updated successfully!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJopPost(@PathVariable Integer id){
        jopPostService.deleteJopPost(id);
        return ResponseEntity.status(200).body(new ApiResponse("jop post deleted successfully!"));
    }
}
