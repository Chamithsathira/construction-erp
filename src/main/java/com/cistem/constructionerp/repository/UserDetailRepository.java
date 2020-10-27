package com.cistem.constructionerp.repository;

import com.cistem.constructionerp.entity.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Deshala Mendis
 * @version 1.0
 * @since 09.10.2020
 */
@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Long> {

    List<UserDetailEntity> findAll();

    UserDetailEntity findByUserName(String username);

}
