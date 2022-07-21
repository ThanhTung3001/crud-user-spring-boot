package edu.uploadfile.profile_upload.Repository;

import edu.uploadfile.profile_upload.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
