package com.don.tree.service;

import com.don.tree.entity.TreeNode;
import com.don.tree.response.ChildToSaveDto;
import com.don.tree.response.GetLocationDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface LocationService {
    Mono<String> saveChildLocation(String parentName, ChildToSaveDto node);

    Mono<List<String>> getAllLocation(GetLocationDto getLocationDto);

    Mono<String> saveParent(TreeNode treeNode);
}
