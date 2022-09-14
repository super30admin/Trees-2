// Construct Binary Tree from Inorder and Postorder Traversal

// Optimized using HashMap and start-end pointers
public class ConstructBTOptimized {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length==0) return null;
        map = new HashMap<>();
        idx = postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] postorder, int start, int end){
        //base
        if(start>end) return null;
        
        //logic
        int rootVal = postorder[idx];
        int rootIdx = map.get(rootVal);
        idx--;
        TreeNode root = new TreeNode(rootVal);
        
        root.right = helper(postorder,rootIdx+1,end);
        root.left = helper(postorder,start,rootIdx-1);
        return root;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)
