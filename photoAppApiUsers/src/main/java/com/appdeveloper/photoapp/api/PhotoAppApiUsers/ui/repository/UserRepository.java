package com.appdeveloper.photoapp.api.PhotoAppApiUsers.ui.repository;

import com.appdeveloper.photoapp.api.PhotoAppApiUsers.ui.data.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
