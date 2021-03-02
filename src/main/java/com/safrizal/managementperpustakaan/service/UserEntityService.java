package com.safrizal.managementperpustakaan.service;

import com.safrizal.managementperpustakaan.entity.UserEntity;
import com.safrizal.managementperpustakaan.model.UserRequest;

public interface UserEntityService {

    UserEntity getUser(Integer id);

    UserEntity insertUser(UserRequest userRequest);

    UserEntity editUser(Integer id,UserRequest userRequest);

    Integer deleteUser(Integer id);


}
