// Time complexity is O(N) as we are iterating through all the nodes
// Space complexity is O(N/2) i.e O(N) as queue will be  storing the maximum element in the last row
// this solution is submitted on leetcode
import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

public class BigN45SumOfRootToLeafUsingBFS {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		int result = 0;
		// edge case:
		if (root == null)
			return result;
		Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
		queue.offer(new Pair(root, 0));
		while (!queue.isEmpty()) {
			Pair<TreeNode, Integer> q = queue.poll();
			TreeNode node = q.getKey();
			int value = q.getValue();
			if (node != null) {
				value = value * 10 + node.val;
				if (node.left == null && node.right == null) {
					result += value;
				}
				queue.offer(new Pair(node.left, value));
				queue.offer(new Pair(node.right, value));
			}
		}
		return result;
	}
}
