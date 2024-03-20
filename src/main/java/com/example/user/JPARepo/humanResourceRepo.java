package com.example.user.JPARepo;

import com.example.user.Entity.humanResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface humanResourceRepo extends JpaRepository<humanResourceEntity, Long> {

    humanResourceEntity findByHID(String HID);

    List<humanResourceEntity> findAll();

}
