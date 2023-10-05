package com.don.tree.controller;

import com.don.tree.entity.TreeNode;
import com.don.tree.response.ChildToSaveDto;
import com.don.tree.response.GetLocationDto;
import com.don.tree.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping("/addParent")
    public Mono<String> addParent(@RequestBody TreeNode treeNode){
        TreeNode node = new TreeNode();
        node.setName(treeNode.getName());
        node.setChildren(new ArrayList<>());
        return locationService.saveParent(node);
    }

    @PostMapping("/saveChild/{parentName}")
    public Mono<String> addChild(@PathVariable String parentName, @RequestBody ChildToSaveDto node){
        return locationService.saveChildLocation(parentName, node);
    }

    @GetMapping("/getAllLocation")
    public Mono<List<String>> getAllLocation(@RequestBody GetLocationDto getLocationDto){
        return locationService.getAllLocation(getLocationDto);
    }

}
