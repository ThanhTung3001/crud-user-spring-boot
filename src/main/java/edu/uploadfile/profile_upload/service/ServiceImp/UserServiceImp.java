package edu.uploadfile.profile_upload.service.ServiceImp;

import edu.uploadfile.profile_upload.Entity.UserEntity;
import edu.uploadfile.profile_upload.Repository.UserRepository;
import edu.uploadfile.profile_upload.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    final UserRepository repository;

    public UserServiceImp(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserEntity save(UserEntity userEntity) {

        return repository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteById(Long id) throws Exception {

            UserEntity user = repository.getReferenceById(id);
            if(user!=null){
                repository.delete(user);
                return true;
            }else{
                throw new Exception("User not found");
            }

    }
}
