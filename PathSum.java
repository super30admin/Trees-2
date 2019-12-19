/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
Time Complexity: O(n)
Space Complexity: O(n)//including recursive stack
Did the code run successfully on leetcode? Yes
Recursive Approach: Multiply previous value with 10 and add the present node value
*/
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }


    private int helper(TreeNode node, int value){

        //Base cases
        if(node==null)
            return 0;
        if(node.left==null && node.right==null)
            return value*10 + node.val;


        return helper(node.left, value*10+node.val) + helper(node.right, value*10 + node.val);
    }


} 

/*
Time Complexity: O(n)
Space Complexity: O(n)
Did the code run successfully on leetcode? Yes
Interative approach: A key value pair with Node and the current Sum at that node is created
*/
import javafx.util.Pair;
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        int result = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.push(new Pair(root, 0));

        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int value = pair.getValue();

            if(node!=null){
                if(node.left==null && node.right==null){
                    result += value*10 + node.val;
				}
                stack.push(new Pair(node.left, value*10 + node.val));
                stack.push(new Pair(node.right,value*10 + node.val));
            }
        }


        return result;
    }
} 