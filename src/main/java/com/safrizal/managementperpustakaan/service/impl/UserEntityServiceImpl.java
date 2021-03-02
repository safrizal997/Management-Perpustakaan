package com.safrizal.managementperpustakaan.service.impl;

import com.safrizal.managementperpustakaan.entity.UserEntity;
import com.safrizal.managementperpustakaan.model.UserRequest;
import com.safrizal.managementperpustakaan.repository.UserEntityRepository;
import com.safrizal.managementperpustakaan.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public UserEntity getUser(Integer id) {
        return userEntityRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userEntityRepository.findAll();
    }

    @Override
    public UserEntity insertUser(UserRequest userRequest) {
        System.out.println(userEntityRepository.existsByEmail(userRequest.getEmail()));

        if (!userEntityRepository.existsByEmail(userRequest.getEmail())) {

            UserEntity userToSave = new UserEntity();
            userToSave.setUserName(userRequest.getUserName());
            userToSave.setEmail(userRequest.getEmail());
            userToSave.setEducation(userRequest.getEducation());
            userToSave.setMajor(userRequest.getMajor());

            return userEntityRepository.save(userToSave);
        }
        return null;
    }

    @Override
    public UserEntity editUser(Integer id, UserRequest userRequest) {

        Optional<UserEntity> userFromDB = userEntityRepository
                .findById(id);

        if (userFromDB.isPresent()){
            UserEntity editUserToSave = new UserEntity();

            editUserToSave.setUserName(userRequest.getUserName());
            editUserToSave.setEmail(userRequest.getEmail());
            editUserToSave.setEducation(userRequest.getEducation());
            editUserToSave.setMajor(userRequest.getMajor());

            return userEntityRepository.save(editUserToSave);
        }
        return null;
    }

    @Override
    public Integer deleteUser(Integer id) {

        Optional<UserEntity> userFromDB = userEntityRepository
                .findById(id);

        if (userFromDB.isPresent()){
            userEntityRepository.deleteById(id);

            return 1;
        }
        return 0;
    }
}
