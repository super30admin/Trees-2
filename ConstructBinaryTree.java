// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach




import java.util.HashMap;


public class ConstructBinaryTree {
    int index;
    HashMap<Integer,Integer> hm;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null|| inorder.length==0){
            return null;
        }
        hm=new HashMap<>();
        index=postorder.length-1;
       for(int  i=0;i<inorder.length;i++){
           hm.put(inorder[i],i);
        }
        return helper(postorder,0,postorder.length-1);
    }
    private TreeNode helper(int [] postorder,int start,int end){
        if(start>end){
            return null;
        }
        int idx=hm.get(postorder[index]);
        TreeNode root=new TreeNode(postorder[index]);
        index--;
        root.right=helper(postorder,idx+1,end);
        root.left=helper(postorder,start,idx-1);
        return root;
        
    }
}
