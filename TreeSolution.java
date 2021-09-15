import java.util.*;
// Time Complexity : N
// Space Complexity :N
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class TreeSolution {
    static HashMap<Integer,Integer> map;
    static int idx = -1;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        idx = postorder.length-1;
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,postorder.length-1);
    }
    private TreeNode helper( int[] postorder, int start, int end){
        if(idx <0 || start>end){
            return null;
        }
        TreeNode root = new TreeNode(postorder[idx]);
        idx--;
        int rootidx = map.get(root.val);
        root.left = helper(postorder,start,rootidx-1);
        root.right = helper(postorder,rootidx+1,end);
        return root;
    }

// Time Complexity : N
// Space Complexity :1
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
//https://leetcode.com/problems/sum-root-to-leaf-numbers/
static int sum =0;
public int sumNumbers(TreeNode root) {
    helper(root,0);
    return sum;
}
private static void helper(TreeNode root,int num){
    if(root == null){
        return;
    }
    if(root.left == null && root.right == null){
        sum = sum + num*10 + root.val;
    }
    helper(root.left,num*10+root.val);
    helper(root.right,num*10 + root.val);
}
}
