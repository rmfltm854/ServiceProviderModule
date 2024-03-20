package com.example.clientside;


import com.example.clientside.DTO.departments_InfoDto;
import com.example.clientside.DTO.humanResourceDto;
import com.example.clientside.Service.ClientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ClientSideApplicationTests {

	@Autowired
	ClientService service;


	@DisplayName("getUser")
	@Test
	void jpagetUser() { //HID를 통한 유저 정보 조회
		humanResourceDto departInfo = service.getUserInfo("20193288");
		System.out.println(departInfo.getClass());
		System.out.println(departInfo);
	}

	@DisplayName("getAllUser")
	@Test
	void jpagetAllUser() {//모든 유저 정보 조회
		List<humanResourceDto> departInfo = service.getAllUserService();
		System.out.println(departInfo.get(0));

	}

	@DisplayName("getAllDepartments")
	@Test
	void jpagetAllDepartments() {//부서 정보 조회
		List<departments_InfoDto> departmentsInfo = service.getDepartmentInfo();
		System.out.println(departmentsInfo);

	}

	@DisplayName("getDepartmentByHID")
	@Test
	void getDepartmentByHID() {//HID를 통한 소속부서 조회
		humanResourceDto departInfo = service.getUserInfo("20193288");
		service.findDepartmentByHID(departInfo.getHID());
	}

	@DisplayName("saveUser")
	@Test
	void saveUser(){//유저등록
		int result = service.saveUser("20193288","192.168.0.2","dufrns12@@",26,"김범수");
		System.out.println(result);
	}

	@DisplayName("saveDepartsInfo")
	@Test
	void saveDeparts(){//부서 등록
		int result = service.saveDepartmentsInfo("회계부",7);
		System.out.println(result);
	}

	@DisplayName("saveDepartment")
	@Test
	void jpasaveDepartment() {//HID,부서이름,직급 을 입력받아 해당 부서에 저장
		service.saveDepartment("20193288","회계부",6);
	}


}
