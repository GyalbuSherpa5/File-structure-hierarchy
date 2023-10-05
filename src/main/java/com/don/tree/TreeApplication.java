package com.don.tree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*class TreeNode {
    int value;
    List<TreeNode> children;

    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}

class TreeTraversal {
    public static List<Integer> getChildren(TreeNode root, int target) {
        List<Integer> result = new ArrayList<>();
        dfs(root, target, result);
        return result;
    }

    private static boolean dfs(TreeNode node, int target, List<Integer> result) {
        if (node == null) {
            return false;
        }
        if (node.value == target) {
            for (TreeNode child : node.children) {
                result.add(child.value);
            }
            return true;
        }
        for (TreeNode child : node.children) {
            if (dfs(child, target, result)) {
                return true;
            }
        }
        return false;
    }
}*/

@SpringBootApplication
public class TreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreeApplication.class, args);

       /* TreeNode root = new TreeNode(1);
        root.children.add(new TreeNode(2));
        root.children.add(new TreeNode(3));
        root.children.add(new TreeNode(4));

        root.children.get(0).children.add(new TreeNode(5));
        root.children.get(0).children.add(new TreeNode(6));

        root.children.get(1).children.add(new TreeNode(7));
        root.children.get(1).children.add(new TreeNode(8));
        root.children.get(1).children.add(new TreeNode(9));

        root.children.get(2).children.add(new TreeNode(10));
        root.children.get(2).children.add(new TreeNode(11));

        int target = 1;
        List<Integer> children = getChildren(root, target);
        System.out.println("Children of " + target + ": " + children);*/
    }

}
