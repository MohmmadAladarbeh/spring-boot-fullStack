package com.rest.app.repositories;

import com.rest.app.models.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);
    UserInfo findFirstById(Long id);

}
