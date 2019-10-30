/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* 129. Sum Root to Leaf Numbers, Recursion, Internally uses a recursive stack
Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode node, int value) {
        //Base
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return value * 10 + node.val;

        return helper(node.left, value * 10 + node.val) + helper(node.right, value * 10 + node.val);

    }
}


/* 129. Sum Root to Leaf Numbers, Recursion, Explicitly use a stack here
Time Complexity: O(n)
Space Complexity: O(n)
*/
import javafx.util.Pair;

class Solution {
    public int sumNumbers(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        int result = 0;
        stack.push(new Pair(root, 0));

        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> p = stack.pop();
            TreeNode node = p.getKey();
            int cur_sum = p.getValue();

            if(node!=null){
                if(node.left == null && node.right == null)
                    result += cur_sum*10 + node.val;
                stack.push(new Pair(node.left, cur_sum*10 + node.val));
                stack.push(new Pair(node.right, cur_sum*10 + node.val));
            }
        }
        return result;
    }
}





//# Definition for a binary tree node.
//        # class TreeNode:
//        #     def __init__(self, x):
//        #         self.val = x
//        #         self.left = None
//        #         self.right = None
//not storing(number, val) in tuple here, efficient solution

class Solution:
        def sumNumbers(self, root: TreeNode) -> int:
        parent = 0
        counter = 0
        stack = []
        if root== None :
        return 0

        stack.append(root)

        while stack :

        n = stack.pop()
        if n == None :
        parent = int(parent/10)
        continue

        parent = parent*10 + n.val
        stack.append(None)

        if not n.left and not n.right :
        counter += parent

        if n.right :
        stack.append(n.right)

        if n.left :
        stack.append(n.left)

        return counter