/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*Algorithm:
Interative solution
    1. We will create a key value pair and push it for each node.
    2. For each node the key will be the respective node and the value will be previous value*10 + prev node value.
    3. If it is a leaf node then we will add the value to till that point to result.
    
    Time Complexity: O(n)
    Space Complexity: O(Height of the tree)
    
    Did the code run successfully on leetcode? Yes

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
                if(node.left==null && node.right==null)
                    result += value*10 + node.val;
                stack.push(new Pair(node.left, value*10 + node.val));
                stack.push(new Pair(node.right,value*10 + node.val));
            }
        }
        
        
        return result;
    }
}