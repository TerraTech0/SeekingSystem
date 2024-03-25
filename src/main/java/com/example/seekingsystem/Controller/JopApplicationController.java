package com.example.seekingsystem.Controller;

import com.example.seekingsystem.Api.ApiResponse;
import com.example.seekingsystem.Service.JopApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jop-applications")
@AllArgsConstructor
public class JopApplicationController {

    private final JopApplicationService jopApplicationService;

    @GetMapping("/get")
    public ResponseEntity getAllJopApplications(){
        return ResponseEntity.status(200).body(jopApplicationService.getAllJobApplications());
    }

    @PostMapping("/apply/{userId}/{jopPostId}")
    public ResponseEntity applyForJop( @PathVariable Integer userId, @PathVariable Integer jopPostId){
        Boolean result = jopApplicationService.applyForJop(userId, jopPostId);
        if (result.equals(false)){
            return ResponseEntity.status(400).body("you can't add jop application without user id or jop post id!");
        }
        jopApplicationService.applyForJop(userId, jopPostId);
        return ResponseEntity.status(200).body(new ApiResponse("jop applied successfully!"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity withDrawJopApplication(@PathVariable Integer id){
        jopApplicationService.withDrawJopApplication(id);
    return ResponseEntity.status(200).body(new ApiResponse("the jop application deleted successfully!"));
    }

}
