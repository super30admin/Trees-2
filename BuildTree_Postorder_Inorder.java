import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(n)
// Space Complexity : O(n); 
class BuildTree_Postorder_Inorder{
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}	
	int postorderIdx;
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	postorderIdx=postorder.length-1;
        inorderMap= new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length-1);
    }
    private TreeNode helper(int[] postorder, int left, int right) {
    	//base
        if(left > right) return null;
        
        //logic        
        //root= last element in postorder array (i.e.postorder= left->right->root)
        int rootVal= postorder[postorderIdx];
        postorderIdx--;
        TreeNode root= new TreeNode(rootVal);
        
        //root divides inorder array into two parts. Build left and right subtree.        
        root.right=helper(postorder, inorderMap.get(rootVal)+1, right);
        root.left=helper(postorder, left, inorderMap.get(rootVal)-1);
        
        return root;
    }
	
	//Driver Code
	public static void main(String[] args) {
		BuildTree_Postorder_Inorder ob = new BuildTree_Postorder_Inorder();
		int[] inorder= {9,3,15,20,7};
		int[] postorder= {9,15,7,20,3};
		
		TreeNode root= ob.buildTree(inorder,postorder);
		System.out.println("Tree built from given postorder and inorder is: "+root.val);
	}
}