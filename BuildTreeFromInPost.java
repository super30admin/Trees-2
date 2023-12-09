// Time Complexity : O(n) //build HashMap, recursion
// Space Complexity : O(n) // HashMap + recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -
import java.util.HashMap;
import java.util.Map;

/*
Same as building tree from Inorder and Preorder but, for postorder the root will be at the end of the array and when we iterate backwards we get Right then Left
So, helper function needs to eval root, right,left resp.
 */
public class BuildTreeFromInPost {
    int pIdx;//postorder iterative index- starts from len-1
    Map<Integer,Integer> inMap = new HashMap<>(); //Map to store indexes of inorder elements
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int idx = 0;
        pIdx = postorder.length -1;

        inMap = new HashMap<>();
        for(int i : inorder)
            inMap.put(i,idx++);

        return helper(postorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int sIdx, int eIdx){

        //base
        if(sIdx>eIdx) return null;

        //root value
        int rootVal = postorder[pIdx];
        pIdx--;

        TreeNode root = new TreeNode(rootVal);

        int rIdx = inMap.get(rootVal);
        root.right = helper(postorder, rIdx + 1, eIdx);
        root.left = helper(postorder, sIdx, rIdx -1);

        return root;
    }

    public static void main(String[] args) {
        BuildTreeFromInPost p = new BuildTreeFromInPost();
        TreeNode n = p.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}
