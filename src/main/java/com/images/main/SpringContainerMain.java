package com.images.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.images.controller.vo.DogVO;
import com.images.service.DogService;

public class SpringContainerMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("dog-service.xml");
		DogService dogService=(DogService)applicationContext.getBean("dogServiceImpl");
		DogVO dog=new DogVO();
		dog.setColor("white");
		dog.setName("Joe");
		dog.setPrice(122);
		dogService.save(dog);
		
		List<DogVO> dogVOs=dogService.findDogs();
		for(DogVO dogVO:dogVOs) {
			System.out.println(dogVO);
		}
	}
}
