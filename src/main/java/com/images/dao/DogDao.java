package com.images.dao;

import java.util.List;

public interface DogDao {

	public void persist(DogEntity entity);
	public List<DogEntity> findDogs();
	DogEntity findDogByDid(int did);
	String deleteDogByDid(int did);

}
