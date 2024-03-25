package com.example.seekingsystem.Service;

import com.example.seekingsystem.Model.JopPost;
import com.example.seekingsystem.Repository.JopPostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JopPostService {

    private final JopPostRepository jopPostRepository;

    public List<JopPost> getAllJopPosts(){
        return jopPostRepository.findAll();
    }

    public void addJopPost(JopPost jopPost){
        jopPostRepository.save(jopPost);
    }

    public Boolean updateJopPost(Integer id, JopPost jopPost){
        //jp here means JopPost
        JopPost jp = jopPostRepository.findById(id).orElse(null);
        if (jp == null){
            return false;
        }
        jp.setTitle(jopPost.getTitle());
        jp.setDescription(jopPost.getDescription());
        jp.setSalary(jopPost.getSalary());
        jp.setLocation(jopPost.getLocation());
        jp.setPostingDate(jopPost.getPostingDate());
        jopPostRepository.save(jp);
        return true;
    }

    public Boolean deleteJopPost(Integer id){
        JopPost jopPost = jopPostRepository.findById(id).orElse(null);
        if (jopPost == null){
            return false;
        }
        jopPostRepository.delete(jopPost);
        return true;
    }
}
