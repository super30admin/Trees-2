import java.util.*;

public class BuildBinaryTreeFromPostAndInorder {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length == 0 || postorder.length == 0) return null;
        map = new HashMap<>();
        idx = postorder.length-1;
        for(int i = 0; i < inorder.length ; i++) {
            map.put(inorder[i],i);
        }
        
        return helper(postorder,0,postorder.length-1);
    }
    
    private TreeNode helper(int[] postorder, int start, int end) {
        //base
        if(start > end) return null;
        //logic
        int rootVal = postorder[idx];
        idx--;
        int inIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        
        root.right = helper(postorder,inIdx+1,end);
        root.left = helper(postorder,start,inIdx-1);
        
        return root;
    }

}
