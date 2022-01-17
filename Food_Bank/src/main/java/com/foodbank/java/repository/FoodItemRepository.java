package com.foodbank.java.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.foodbank.java.Dto.FoodItemResponseMap;
import com.foodbank.java.entity.FoodItem;

@Repository
public interface FoodItemRepository extends CrudRepository<FoodItem, Integer> {

	List<FoodItemResponseMap> findByFoodId(Integer foodId);

	

}
