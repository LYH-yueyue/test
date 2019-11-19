package com.liu.Repository;

import com.liu.pojo.Hotel;
import com.liu.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    User findUserByUsernameAndPassword(String username, String password);


    //User findByUsername(String username);
}
