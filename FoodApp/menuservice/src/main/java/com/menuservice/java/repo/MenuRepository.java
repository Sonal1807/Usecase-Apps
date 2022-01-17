package com.menuservice.java.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.menuservice.java.dto.FoodResponseProj;
import com.menuservice.java.entity.Menu;

@Repository
public interface MenuRepository extends PagingAndSortingRepository<Menu, Integer> {

	List<FoodResponseProj> findByFoodNameContaining(String foodName);

}
