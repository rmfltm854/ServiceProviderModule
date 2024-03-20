package com.example.user.controller;

import com.example.user.DTO.humanResourceDto;
import com.example.user.Entity.department;
import com.example.user.Service.ClientService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.user.ServiceSide.trackingModule.traking;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@Slf4j
public class clientController{

    @Autowired
    ClientService service;
    traking track = new traking();//fileTracking호출


    @PostConstruct//종속성 주입이 완료된 후 실행되어야 하는 메서드에 사용된다. 이 어노테이션은 다른 리소스에서 호출되지 않아도 수행된다.
    public void init() throws Exception {
        track.init();
    }

    @GetMapping("/getUser")
    public humanResourceDto  getUser(){
        humanResourceDto result = service.getUserInfo("20193290");//전달받은 dto객체 반환.
        System.out.println(result);
        return result;
    }

    @GetMapping("/getAllUser")
    public List<humanResourceDto> getAllUser(){
        List<humanResourceDto> result = service.getAllUserService();//전달받은 dto객체 반환.
        System.out.println(result);
        return result;
    }

    @GetMapping("/department")
    public Optional<department>  searchUser(){
        Optional<department> departInfo = service.findDepartmentByHID("20193290");
        System.out.println(departInfo.getClass());
        return departInfo;
    }
}
