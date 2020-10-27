package com.cistem.constructionerp.repository;

import com.cistem.constructionerp.entity.SubGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubGroupRepository extends JpaRepository<SubGroupEntity, Integer> {
}
