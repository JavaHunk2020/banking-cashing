package com.images.service;

import java.util.List;

import com.images.controller.vo.DogVO;

public interface DogService {

	public String save(DogVO dog);
	List<DogVO> findDogs();
	DogVO findDogByDid(int did);
	String deleteDogByDid(int did);

}
