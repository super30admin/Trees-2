// Time Complexity : O(n) where n = number of nodes in the tree
// Space Complexity : O(h) where h = height of binary tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Problem2 {
    
    private static int ans = 0;

    public static int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return ans;
    }
    
    private static void sumNumbers(TreeNode root, int currentnum) {
        if (root == null) {
            return;
        }
        // If present node is not null, update currentnum to currentnum*10 + value at root
        currentnum = currentnum*10 + root.val;
        // If present node is leaf node, add the value of currentnum to ans
        if (root.left == null && root.right == null) {
            ans += currentnum;
        }
        // Left subtree
        sumNumbers(root.left, currentnum);
        // Right subtree
        sumNumbers(root.right, currentnum);
    }

    // Function to make the binary tree
    public static TreeNode makeTree(Integer[] arr, int i) {
        if (i >= arr.length) {
            return null;
        }
        if (arr[i] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[i]);
        root.left = makeTree(arr, 2 * i + 1);
        root.right = makeTree(arr, 2 * i + 2);
        return root;
    }

    // Function to print the binary tree
    public static void printTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
          return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                res.add(null);      
            } else {
                q.add(curr.left);
                q.add(curr.right);
                res.add(curr.val);
          }
        }
        int i = res.size()-1;
        while (res.get(i) == null) {
            res.remove(i--);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Integer[] levelarr = {4,9,0,5,1};
        TreeNode root = makeTree(levelarr, 0);
        // printTree(root);
        int ans = sumNumbers(root);
        System.out.println(ans);

    }


}
