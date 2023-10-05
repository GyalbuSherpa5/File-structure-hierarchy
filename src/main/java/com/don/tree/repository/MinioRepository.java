package com.don.tree.repository;

import com.don.tree.entity.TreeNode;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface MinioRepository extends ReactiveMongoRepository<TreeNode, String> {
    Mono<TreeNode> findByName(String name);
}
