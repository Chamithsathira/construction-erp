package com.cistem.constructionerp.repository;

import com.cistem.constructionerp.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity , Integer> {
}
