package com.images.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DogDaoImpl implements DogDao {
	
	@Autowired
	@Qualifier("jdbcTempate")
	private JdbcTemplate jdbcTemplate;
	
   
	@Override
	public void persist(DogEntity entity) {
		 String sql="insert into dogs_tbl(name,price,color) values(?,?,?)";
		 Object[] data=new Object[] {entity.getName(),entity.getPrice(),entity.getColor()};
		 jdbcTemplate.update(sql,data);
		System.out.println(entity);
	}
	
	@Override
	public List<DogEntity> findDogs() {
		 String sql="select did,name,price,color from dogs_tbl";
		 List<DogEntity> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper(DogEntity.class));
		 return list;
	}
	
	@Override
	public DogEntity findDogByDid(int did) {
		 String sql="select did,name,price,color from dogs_tbl where did="+did;
		 DogEntity dogEntity=(DogEntity)jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(DogEntity.class));
		 return dogEntity;
	}
	
	@Override
	public String deleteDogByDid(int did) {
		 String sql="delete from dogs_tbl where did="+did;
         int rows=jdbcTemplate.update(sql);
		 return rows>0?"deleted":"not deleted";
	}
}
