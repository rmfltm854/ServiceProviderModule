package com.example.user.JPARepo;

import com.example.user.Entity.departments_Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface departments_InfoRepo extends JpaRepository<departments_Info, Long> {

    List<departments_Info> findByDepartsName(String Departs_name);

    List<departments_Info> findAll();


}
