// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, figuring out that root.right happens first and then left was tricky


// Your code here along with comments explaining your approach - have an idx that starts from the right, and make that the root everytime
//then recursively call the right and then left. decrement idx 

import java.util.*;

public class constructTree {
    public static class TreeNode {
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

    static  Map<Integer, Integer> map;
    static int idx;
    static int n;
    public static TreeNode buildTree(int[] inorder, int[] postorder){
        map = new HashMap<>();
        n = inorder.length;
        idx = n-1;
        for(int i =0; i < n; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, n-1);
    }

    public static TreeNode helper(int[] postorder, int start, int end){
        if(start > end) return null;
        int rootVal = postorder[idx];
        idx--;
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postorder, rootIdx+1, end);
        root.left = helper(postorder, start, rootIdx-1);

        return root;
    }

    public static void main(String[] args){
        int in[] = new int[]{9,3,15,20,7};
        int post[] = new int[]{9,15,7,20,3};
        buildTree(in, post);
    }
}
