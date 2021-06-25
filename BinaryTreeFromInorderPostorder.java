//Time and Space Complexity: O(n)

class Solution {
		int n = 0;
		Map<Integer, Integer> map = new HashMap<>();
		public TreeNode buildTree(int[] inorder, int[] postorder) {
			n = inorder.length-1;
			for (int i=0; i< inorder.length; i++){
				map.put(inorder[i], i);   
			}
			return buildTree(postorder, inorder, 0, inorder.length-1);
		}

		private TreeNode buildTree(int[] postorder, int[] inorder, int start, int end) {
			if (start > end) return null;
			TreeNode root = new TreeNode(postorder[n]);
			n--;
			if (start == end) return root;
			int index = map.get(root.val);
			root.right = buildTree(postorder, inorder, index + 1, end);
			root.left = buildTree(postorder, inorder, start, index - 1);
			return root;
		}
}
