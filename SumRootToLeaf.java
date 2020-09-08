// TC: O(N) where N represents the elements in the tree we have traversed.
// SC: O(N) for recursion stack

// We are using dfs approach where we are navigating to the left subtree and adding the values of the root to the existing sum. Once we have found the sum of
// left subtree, we traverse recursively to the right subtree and find the sum till the leaf node. Once we have found the sum of both subtrees. 
// Add those 2 sums to find the final sum.


public class SumRootToLeaf {

	public int SumRoot(TreeNode root) {
		return Sum(root, 0);
	}
	
	public int Sum(TreeNode root, int sum) {
		
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return sum*10+root.val;
		
		return Sum(root.left, sum*10+root.val) + Sum(root.right, sum*10+root.val);
	}
	
	public static void main(String[] args) {
		
		SumRootToLeaf st = new SumRootToLeaf();
		
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.left.left = new TreeNode(5);
		
		System.out.println(st.SumRoot(root));
	}
}
