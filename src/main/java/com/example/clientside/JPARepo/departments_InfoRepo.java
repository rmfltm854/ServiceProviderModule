package com.example.clientside.JPARepo;

import com.example.clientside.Entity.departments_Info;
import com.example.clientside.Entity.humanResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface departments_InfoRepo extends JpaRepository<departments_Info, Long> {

    List<departments_Info> findByDepartsName(String Departs_name);

    List<departments_Info> findAll();


}
