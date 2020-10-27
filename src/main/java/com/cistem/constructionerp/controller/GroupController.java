package com.cistem.constructionerp.controller;

import com.cistem.constructionerp.entity.GroupEntity;
import com.cistem.constructionerp.exception.ResourceNotFoundException;
import com.cistem.constructionerp.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupRepository repo;
    private GroupEntity groups;

    @GetMapping("/{category_id}")
    public List<GroupEntity> getGroupByCategoryId(@PathVariable (value = "category_id") int category_id){
        return (List<GroupEntity>) this.repo.findById(category_id)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found belong to category with id :" + category_id));
    }

    @GetMapping("/getGroups")
    public List<GroupEntity> getGroups(){
        return repo.findAll();
    }

    @PostMapping("/addGroup")
    public String addGroup(@RequestBody  GroupEntity groups){
        repo.save(groups);
        return "Group added";
    }

    @PutMapping("/{id}")
    public GroupEntity updateGroup(@RequestBody GroupEntity group, @PathVariable ("id") int groupId) {
        GroupEntity existingGroup = this.repo.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("group not found with id :" + groupId));;
        existingGroup.setCategory_id(group.getCategory_id());
        existingGroup.setId(group.getId());
        existingGroup.setName(group.getName());
        return this.repo.save(existingGroup);
    }


}
