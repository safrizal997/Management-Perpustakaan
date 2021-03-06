package com.safrizal.managementperpustakaan.controller;

import com.safrizal.managementperpustakaan.entity.UserEntity;
import com.safrizal.managementperpustakaan.model.UserRequest;
import com.safrizal.managementperpustakaan.service.UserEntityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"User Service"}, description = "Handling User Action")
public class UserController {


    @Autowired
    UserEntityService userEntityService;

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable("id") Integer id){
        return userEntityService.getUser(id);
    }

    @GetMapping
    public List<UserEntity> getAllUser(){
        return userEntityService.getAllUser();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity insertUser(@RequestBody UserRequest userRequest){
        return userEntityService.insertUser(userRequest);
    }

    @PutMapping("/{id}")
    public UserEntity editUser(@PathVariable("id") Integer id,@RequestBody UserRequest userRequest){
        return userEntityService.editUser(id, userRequest);
    }

    @DeleteMapping("/({delete}")
    public Integer deleteUser(@PathVariable("delete") Integer id){
        return  userEntityService.deleteUser(id);
    }


}
