package com.estate.repository;

import com.estate.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByUserName(String name);

    //tim user theo rolecode
    List<UserEntity> findByRoles_CodeAndStatus(String rolecode, String status);

    //tim user theo buildingId
    List<UserEntity> findByBuildings_Id(Long buildingId);

}
