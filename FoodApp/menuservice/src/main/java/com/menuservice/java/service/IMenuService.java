package com.menuservice.java.service;

import java.util.List;

import com.menuservice.java.dto.FoodResponseProj;
import com.menuservice.java.entity.Menu;

public interface IMenuService {

	List<FoodResponseProj> getFoodItemByName(String foodName);

	List<Menu> findPaginated(int pageNo, int pageSize);

}
