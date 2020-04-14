package com.images.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.images.controller.vo.DogVO;
import com.images.dao.DogDao;
import com.images.dao.DogEntity;

@Service
public class DogServiceImpl implements DogService{
	
	@Autowired
	private DogDao dogDao;
    
	@Override
	public String save(DogVO dog) {
		System.out.println(dog);
		DogEntity dogEntity=new DogEntity();
		BeanUtils.copyProperties(dog, dogEntity);
		dogDao.persist(dogEntity);
		return "saved";
	}
	
	
	@Override
	public List<DogVO> findDogs() {
		List<DogEntity> listEntity=dogDao.findDogs();
		List<DogVO> dogVOs=new ArrayList<>();
		for(DogEntity entity:listEntity) {
			DogVO dogVO=new DogVO();
			BeanUtils.copyProperties(entity,dogVO);
			dogVOs.add(dogVO);
		}
		return dogVOs;
	}
	
	@Override
	public DogVO findDogByDid(int did) {
		DogEntity dogEntity=dogDao.findDogByDid(did);
		DogVO dogVO=new DogVO();
		BeanUtils.copyProperties(dogEntity,dogVO);
		return dogVO;
	}
	
	@Override
	public String deleteDogByDid(int did) {
		String result=dogDao.deleteDogByDid(did);
		return result;
	}
}
