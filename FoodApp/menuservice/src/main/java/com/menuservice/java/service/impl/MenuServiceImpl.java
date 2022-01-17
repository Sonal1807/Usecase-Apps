package com.menuservice.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.menuservice.java.dto.FoodResponseProj;
import com.menuservice.java.entity.Menu;
import com.menuservice.java.exception.FoodItemNotFoundException;
import com.menuservice.java.repo.MenuRepository;
import com.menuservice.java.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {
	@Autowired
	MenuRepository menuRepository;
	@Autowired
	private MenuRepository repository;

	@Override
	public List<FoodResponseProj> getFoodItemByName(String foodName) {
		List<FoodResponseProj> foodResponseProjList = menuRepository.findByFoodNameContaining(foodName);
		if (foodResponseProjList.isEmpty())
			throw new FoodItemNotFoundException("no fooditem present with given name: " + foodName);
		return foodResponseProjList;
	}

	@Override
	public List<Menu> findPaginated(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Menu> pagedResult = repository.findAll(paging);
		return pagedResult.toList();
	}
}
