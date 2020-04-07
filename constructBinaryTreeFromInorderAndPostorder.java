//time complexity: O(n)
//space complexity: O(h)
//where n is the number of elements in tree. h is the height tree
import java.util.*;
class ConstructTreeSolution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length ==0) return null;
        idx = postorder.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i],i);
        }
        return buildTree_dfs(0, postorder.length - 1, postorder, map);
    }
    
    public TreeNode buildTree_dfs(int min, int max, int[] post, Map<Integer, Integer> map)
    {
        
        if(min > max || idx < 0)
            return null;
        TreeNode root = null;
        
        int pos = map.get(post[idx]);
        if(pos <= max && pos >= min)
        {
            root = new TreeNode(post[idx]);
            idx--;
            root.right= buildTree_dfs(pos+1, max, post, map);
            root.left= buildTree_dfs(min, pos-1, post, map);
         
        }
        return root;
    }
}