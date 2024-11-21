// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problems faced: No

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

public class RootToLeafSum {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		int sum = 0;
		Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
		q.add(new Pair(root, 0));

		while (!q.isEmpty()) {
			Pair<TreeNode, Integer> p = q.poll();
			TreeNode node = p.getKey();
			int value = p.getValue();
			if (node != null) {
				value = value * 10 + node.val;
				if (node.left == null && node.right == null) {
					sum += value;
				}
				q.add(new Pair(node.left, value));
				q.add(new Pair(node.right, value));
			}
		}
		return sum;
	}
}
