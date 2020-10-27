package com.cistem.constructionerp.controller;

import com.cistem.constructionerp.entity.SubGroupEntity;
import com.cistem.constructionerp.exception.ResourceNotFoundException;
import com.cistem.constructionerp.repository.SubGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subGroup")
public class SubGroupController {

    @Autowired
    private SubGroupRepository repo;
    private SubGroupEntity subgroup;

    @GetMapping("/getSubGroups")
    public List<SubGroupEntity> getSubGroups(){
        return repo.findAll();
    }

    @GetMapping("/{group_id}")
    public List<SubGroupEntity> getSubGroupByGroupId(@PathVariable(value = "group_id") int group_id){
        return (List<SubGroupEntity>) this.repo.findById(group_id)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found belong to category with id :" + group_id));
    }

    @PostMapping("/addSubGroup")
    public String addSubGroup(@RequestBody SubGroupEntity subgroups){
        repo.save(subgroups);
        return "Sub Group added";
    }

    @PutMapping("/{id}")
    public SubGroupEntity updateSubGroup(@RequestBody SubGroupEntity subgroup, @PathVariable ("id") int subGroupId) {
        SubGroupEntity existingSubGroup = this.repo.findById(subGroupId)
                .orElseThrow(() -> new ResourceNotFoundException("group not found with id :" + subGroupId));;
        existingSubGroup.setGroup_id(subgroup.getGroup_id());
        existingSubGroup.setId(subgroup.getId());
        existingSubGroup.setName(subgroup.getName());
        return this.repo.save(existingSubGroup);
    }
}
