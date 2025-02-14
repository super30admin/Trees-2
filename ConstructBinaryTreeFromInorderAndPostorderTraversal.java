import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
In postorder array we move right to left, because we get the last element as the root element. We store elements and their indexes of inorder array in 
map. Using root as postorder element, we find its index in inorder array using the map. left of this index would be the left subtree and right of this index would be the 
right subtree.
*/
class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    Map<Integer,Integer> map=new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        idx=n-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return inpost(postorder,0,n-1);
    }
    public TreeNode inpost(int[] postorder,int start,int end){
        //base
        if(start>end){
            return null;
        }

        //logic
        int rootval=postorder[idx];
        idx--;
        TreeNode root=new TreeNode(rootval);
        int rootidx=map.get(rootval);
        root.right= inpost(postorder,rootidx+1,end);
        root.left= inpost(postorder,start,rootidx-1);
        return root;
    }
}