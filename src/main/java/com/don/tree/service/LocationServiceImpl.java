package com.don.tree.service;

import com.don.tree.entity.TreeNode;
import com.don.tree.repository.MinioRepository;
import com.don.tree.response.ChildToSaveDto;
import com.don.tree.response.GetLocationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final MinioRepository minioRepository;

    @Override
    public Mono<String> saveParent(TreeNode treeNode) {
        return minioRepository.save(treeNode).then(Mono.just("Saved"));
    }

    @Override
    public Mono<String> saveChildLocation(String parentName, ChildToSaveDto node) {

        return minioRepository.findByName(parentName)
                .flatMap(rootFolder ->{
                    TreeNode targetNode = findNode(rootFolder, node.getDirectory());

                    TreeNode treeNode = new TreeNode(node.getFolderName());
                    assert targetNode != null;
                    targetNode.getChildren().add(treeNode);

                    return minioRepository.save(rootFolder);
                }).then(Mono.just("data saved"));
    }

    private TreeNode findNode(TreeNode rootFolder, String directory) {
        if (rootFolder.getName().equals(directory)) {
            return rootFolder;
        } else {
            for (TreeNode child : rootFolder.getChildren()) {
                TreeNode found = findNode(child, directory);
                if (found != null) {
                    return found;
                }
            }
            return null;
        }
    }

    @Override
    public Mono<List<String>> getAllLocation(GetLocationDto getLocationDto) {
        return minioRepository.findByName(getLocationDto.getParentDirectory())
                .flatMap(parent->{
                    List<String> children = getChildren(parent, getLocationDto.getTargetDirectory());
                    return Mono.just(children);
                });
    }

    private List<String> getChildren(TreeNode parent, String targetDirectory) {
        List<String> result = new ArrayList<>();
        dfs(parent, targetDirectory, result);
        return result;
    }

    private static boolean dfs(TreeNode node, String target, List<String> result) {
        if (node == null) {
            return false;
        }
        if (node.getName().equals(target)) {
            for (TreeNode child : node.getChildren()) {
                result.add(child.getName());
            }
            return true;
        }
        for (TreeNode child : node.getChildren()) {
            if (dfs(child, target, result)) {
                return true;
            }
        }
        return false;
    }
}
