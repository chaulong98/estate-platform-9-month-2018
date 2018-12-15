package com.example.repository;


import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
    UserEntity findOneByUserName(String name);
    /*boolean existsByUserNameAndBuildingsId(String name, long buildingId);*/
    List<UserEntity> findByStatusAndRoles_Code(int status, String roleCode);
}
