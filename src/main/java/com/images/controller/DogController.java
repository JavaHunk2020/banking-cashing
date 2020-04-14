package com.images.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.images.controller.vo.ApplicationResponseVO;
import com.images.controller.vo.DogVO;
import com.images.service.DogService;

@RestController
public class DogController {
	
	// It is a cotroller file
	
	@Autowired
	private DogService dogService;
	
	//HTTP = OPTION,PATCH,GET,POST,DELETE,PUT
	@PostMapping("/dogs")
	public ApplicationResponseVO addDog(@RequestBody DogVO dogVO) {
		//
		dogService.save(dogVO);
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		applicationResponseVO.setDescription("Dog is saved successfully.");
		applicationResponseVO.setStatus("success");
		return applicationResponseVO;
	}
	
	//HTTP = OPTION,PATCH,GET,POST,DELETE,PUT
	@PutMapping("/dogs")
	public ApplicationResponseVO updateDog(@RequestBody DogVO dogVO) {
			dogService.save(dogVO);
			ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
			applicationResponseVO.setDescription("Dog is saved successfully.");
			applicationResponseVO.setStatus("success");
			return applicationResponseVO;
	}
	
	@GetMapping("/dogs")
	public List<DogVO> findDogs() {
		List<DogVO> dogVOs=dogService.findDogs();
		return dogVOs;
	}
	
	
	@GetMapping("/dogs/{did}")
	public DogVO findDogByDid(@PathVariable int did) {
		DogVO dogVO=dogService.findDogByDid(did);
		return dogVO;
	}
	
	@DeleteMapping("/dogs/{did}")
	public ApplicationResponseVO deleteDogByDid(@PathVariable int did) {
		String result=dogService.deleteDogByDid(did);
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		applicationResponseVO.setDescription("Dog is deleted successfully.");
		applicationResponseVO.setStatus(result);
		return applicationResponseVO;
	}


}
