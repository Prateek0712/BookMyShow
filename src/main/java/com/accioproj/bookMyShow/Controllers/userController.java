package com.accioproj.bookMyShow.Controllers;

import com.accioproj.bookMyShow.Requests.addUserRqst;
import com.accioproj.bookMyShow.Services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService userService1;
    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody addUserRqst userDto)
    {
        return new ResponseEntity(userService1.addUser(userDto), HttpStatus.CREATED);
    }

}
