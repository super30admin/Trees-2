// Time Complexity : O(N) where N is the number of nodes
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Create a map of inoder indexes, recursively build tree from postorder,
//by using indexes
public class ConstructBTreePostInorder {
    Map<Integer,Integer> map= new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length==0) return null;

        this.idx=postorder.length-1;
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);

        return helper(postorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int start, int end){
        if(start>end) return null;

        int rootVal= postorder[idx];

        TreeNode root= new TreeNode(rootVal);
        idx--;
        int rootIdx= map.get(rootVal);

        root.right=helper(postorder,rootIdx+1,end);
        root.left=helper(postorder, start,rootIdx-1);

        return root;
    }
}
