package edu.uploadfile.profile_upload.service;

import edu.uploadfile.profile_upload.Entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity save(UserEntity userEntity);
    List<UserEntity>getAll();

    boolean deleteById(Long id) throws Exception;
}
