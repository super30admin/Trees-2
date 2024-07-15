// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

import java.util.HashMap;

public class PostOrderConstruct {
HashMap<Integer,Integer> map;
int idx;
       
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    
        if(postorder.length ==0) return null;
        this.map = new HashMap<>();
        for(int i=0;i< inorder.length;i++){
            map.put(inorder[i], i);
        }
        
        return helper(postorder,0,inorder.length-1);
      
    }

    public TreeNode helper(int[] postorder,int start,int end){
        if(start>end) return null;

        int rootval = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootval);
        int rootIdx = map.get(rootval); //inorder array index
        
        root.left = helper(postorder, rootIdx+1, end);
        root.right = helper(postorder, start, rootIdx-1);

        return root;
    }
}
