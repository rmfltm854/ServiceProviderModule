package com.example.user.Service;

import com.example.user.DTO.departments_InfoDto;
import com.example.user.DTO.humanResourceDto;
import com.example.user.Entity.department;
import com.example.user.Entity.departments_Info;
import com.example.user.Entity.humanResourceEntity;
import com.example.user.JPARepo.departmentRepo;
import com.example.user.JPARepo.departments_InfoRepo;
import com.example.user.JPARepo.humanResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired//HR 레포 연결
    humanResourceRepo HR;

    @Autowired//부서 정보 DB연결
    departments_InfoRepo DIR;

    @Autowired//부서 DB 연결
    departmentRepo DR;

    public humanResourceDto getUserInfo(String HID){//조회한 유저의 정보를 DTO로 변환후 controller로 전달.
        humanResourceEntity userInfo = HR.findByHID(HID);
        humanResourceDto dto = new humanResourceDto(userInfo);
        return dto;
    }

    public List<humanResourceDto> getAllUserService(){//조회한 유저의 정보를 DTO로 변환후 controller로 전달.
        List<humanResourceEntity> userInfo = HR.findAll();
        List<humanResourceDto> resultDto = new ArrayList<>();
        for(int i = 0;i<userInfo.size();i++){
            humanResourceDto dto = new humanResourceDto(userInfo.get(i));
            resultDto.add(dto);
        }
        return resultDto;
    }

    public List<departments_InfoDto> getDepartmentInfo(){//조회한 유저의 정보를 DTO로 변환후 controller로 전달.
        List<departments_Info> departmentsInfo = DIR.findAll();
        List<departments_InfoDto> resultDto = new ArrayList<>();
        for(int i = 0;i<departmentsInfo.size();i++){
            departments_InfoDto dto = new departments_InfoDto(departmentsInfo.get(i));
            resultDto.add(dto);
        }
        return resultDto;
    }

    public Optional<department> findDepartmentByHID(String HID){//각부서별 구성원 획득
        humanResourceEntity userInfo = HR.findByHID(HID);
        Optional<department> HR = DR.findDepartmentByHID(userInfo);
        System.out.println(HR);
        return HR;
    }

    public int saveUser(String hid,String hip, String pw,int age,String name){
        try{
            humanResourceDto hDto= new humanResourceDto();
            hDto.setHID(hid);
            hDto.setHIP(hip);
            hDto.setPW(pw);
            hDto.setAge(age);
            hDto.setName(name);
            humanResourceEntity humanEntity = new humanResourceEntity(hDto);
            HR.save(humanEntity);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    public int saveDepartmentsInfo(String departName, int max_level){
        try{
            departments_InfoDto diDto = new departments_InfoDto();
            diDto.setDepartsName(departName);
            diDto.setMax_Level(max_level);

            departments_Info diEntity = new departments_Info(diDto);
            DIR.save(diEntity);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public int saveDepartment(String HID, String dName,int level){//각부서별 구성원 저장 1=success 0 = Fail -> HID,부서이름,level을 입력받아야함.

        try{
            humanResourceEntity userInfo = HR.findByHID(HID);
            List<departments_Info> departmentsInfo = DIR.findByDepartsName(dName);
            department dp = new department(level,userInfo,departmentsInfo.get(0));
            DR.save(dp);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

}
