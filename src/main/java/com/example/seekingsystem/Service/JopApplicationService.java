package com.example.seekingsystem.Service;

import com.example.seekingsystem.Model.JopApplication;
import com.example.seekingsystem.Model.JopPost;
import com.example.seekingsystem.Model.User;
import com.example.seekingsystem.Repository.JopApplicationRepository;
import com.example.seekingsystem.Repository.JopPostRepository;
import com.example.seekingsystem.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JopApplicationService {
    private final JopApplicationRepository jopApplicationRepository;
    private final UserRepository userRepository; //this is the way to how create a forgien key
    private final JopPostRepository jopPostRepository;


    public List<JopApplication> getAllJobApplications(){
        return jopApplicationRepository.findAll();
    }


    //create method to applyForJob using userId and jobPostId
    public Boolean applyForJop(Integer userId, Integer jobPostId){
        User user = userRepository.findById(userId).orElse(null);
        JopPost jobPost = jopPostRepository.findById(jobPostId).orElse(null);
        if (user == null || jobPost == null){
            return false;
        }
        JopApplication apply = new JopApplication();
        apply.setUser_id(userId);
        apply.setJop_post_id(jobPostId);
        jopApplicationRepository.save(apply);
        return true;
    }


    public Boolean withDrawJopApplication(Integer id){
        JopApplication withDraw = jopApplicationRepository.findById(id).orElse(null);
        if (withDraw == null){
            return false;
        }
        jopApplicationRepository.delete(withDraw);
        return true;
    }

}
