import java.util.HashMap;

public class Construct_Binary_Tree_from_Postorder_and_inorder {
	//Approach: I use hashmap to store the indices of the nodes. Then I iterate through the inorder array, thereby getting the root from postorder traversal. Here for postorder traversal, 
	//am iterating in decreasing order to get the root.
	//2. Then , Divide the left and root children index based on the root index and recursively construct the tree. 
	HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>(); index = postorder.length-1;
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i], i);
        }
        return helper(postorder, inorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] postorder, int[] inorder, int start, int end)
    {
        if(start > end || index < 0) return null;
        int idx = map.get(postorder[index]);
        TreeNode root = new TreeNode (inorder[idx]);
        index--;
        root.right = helper(postorder, inorder, idx+1, end);
        root.left = helper(postorder, inorder, start, idx-1);
        
        return root;
    }
}

//Time Complexity : O(n) where n is length of the inorder array
//Space Complexity : O(h) where h is the height of the tree. Since the recursive stack might hold elements equal to the height of the tree at worst case.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :