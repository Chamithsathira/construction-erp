package com.cistem.constructionerp.controller;

import com.cistem.constructionerp.entity.CategoryEntity;
import com.cistem.constructionerp.exception.ResourceNotFoundException;
import com.cistem.constructionerp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository repo;

    @GetMapping("/getCategory")
    public List<CategoryEntity> getCategories(){
        return this.repo.findAll();
    }

    @GetMapping("/{id}")
    public CategoryEntity getCategoryById(@PathVariable (value = "id") int id){
        return this.repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category not found with Id " + id));
    }

    @PostMapping("/addCategory")
    public String addCategory(@RequestBody CategoryEntity category){
        repo.save(category);
        return "Category Added";
    }

    public CategoryEntity updateCategory(@RequestBody CategoryEntity category, @PathVariable("id") int id){
        CategoryEntity existingCategory= this.repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with Id " + id));
        existingCategory.setDescription(category.getDescription());
        existingCategory.setCode(category.getCode());
        existingCategory.setName(category.getName());
        return this.repo.save(existingCategory);
    }
}
