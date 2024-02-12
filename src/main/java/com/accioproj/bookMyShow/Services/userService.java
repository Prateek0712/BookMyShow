package com.accioproj.bookMyShow.Services;

import com.accioproj.bookMyShow.Entity.User;
import com.accioproj.bookMyShow.Repositories.userRepo;
import com.accioproj.bookMyShow.Requests.addUserRqst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    private userRepo userRepo1;
    @Autowired
    private JavaMailSender mailSender;
    public String addUser(addUserRqst userDto)
    {
        User user = User.builder()
                .name(userDto.getName())
                .emailId(userDto.getEmail())
                .phoneNo(userDto.getPhoneNo())
                .build();
        user =userRepo1.save(user);
        SimpleMailMessage sm=new SimpleMailMessage();
        sm.setFrom("pustakalay7120@gmail.com");
        sm.setTo(user.getEmailId());
        sm.setSubject("Hello "+user.getName()+" ");
        sm.setText("Hii "+user.getName()+" Login Succesfully Thanks for Choosing Pratik's Backend Server");
        mailSender.send(sm);

        return "User Added Succesfully";
    }
}
