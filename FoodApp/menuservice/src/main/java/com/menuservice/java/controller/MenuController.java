package com.menuservice.java.controller;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.menuservice.java.dto.FoodResponseProj;
import com.menuservice.java.entity.Menu;
import com.menuservice.java.repo.MenuRepository;
import com.menuservice.java.service.IMenuService;

@RestController
@Validated
public class MenuController {
	@Autowired
	IMenuService menuService;
	@Autowired
	MenuRepository menuRepository;

	@GetMapping("/foodItems")
	public ResponseEntity<List<FoodResponseProj>> getFoodItemByName(@RequestParam String foodName) {
		return new ResponseEntity<List<FoodResponseProj>>(menuService.getFoodItemByName(foodName), HttpStatus.ACCEPTED);
	}

	@GetMapping("/foodItems/{pageNo}/{pageSize}")
	public List<Menu> getPaginated(@PathVariable int pageNo, @PathVariable int pageSize) {
		return menuService.findPaginated(pageNo, pageSize);

	}

}
