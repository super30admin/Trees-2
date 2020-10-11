class Solution {// solution time of O(n) and space of O(height)
    public int sumNumbers(TreeNode root) {
        int total_sum = 0, curr_sum = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
        stack.push(new Pair(root, 0));
        
        while (!stack.isEmpty()) {
          Pair<TreeNode, Integer> p = stack.pop();
          root = p.getKey();
          curr_sum = p.getValue();

          if (root != null) {
          curr_sum = curr_sum * 10 + root.val;
          // if it's a leaf, update root-to-leaf sum
          if (root.left == null && root.right == null) {
            total_sum += curr_sum;
          } else {
          stack.push(new Pair(root.right, curr_sum));
          stack.push(new Pair(root.left, curr_sum));
        }
      }
    }
    return total_sum;
    }
}