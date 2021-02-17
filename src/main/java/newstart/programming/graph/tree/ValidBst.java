package newstart.programming.graph.tree;


import java.util.ArrayList;
import java.util.List;

public class ValidBst {
    /*98. Validate Binary Search Tree
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
Input: root = [2,1,3]
Output: true
* */
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return true;
        return root.left.val < root.val && root.val < root.right.val;
    }
/*94. Binary Tree Inorder Traversal
Given the root of a binary tree, return the inorder traversal of its nodes' values.
* */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null) return result;
        inorderTraversal(root, result);
        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if(root == null) return;
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
