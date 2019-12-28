// Time Complexity - O(n) where n is the number of elements in the tree
// Space Complexity - O(h) if we consider the recursive stack as the extra space. At a time maximum there will be elements equal to the height of the tree.
// Below recursive solution worked on LeetCode

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);  // call helper  function for root node with value initialized as 0
    }
    private int helper(TreeNode node, int value){
        if(node == null)    return 0;     // if node is null return 0 value
        if(node.left == null && node.right == null) // if both left and right node is null
            return value*10 + node.val;
        return helper(node.left,value*10 + node.val) + helper(node.right,value*10 + node.val); // if atleast one of the right and left has value
    }
}

// Non recursive solution
// Time Complexity - O(n) where n is the number of elements in the tree
// Space Complexity -O(h) since at a time there will be elements in the stack equal to the height of the tree
// In this solution we are using pairs which will have the current node and the value so far calculated based on the previous root. The result will hold the total value from all the leaf nodes resultant values. I am adding the left and right to the stack only when they are not null. If both left and right is null it means leaf node is reached and we can add the value of the node.

import javafx.util.Pair;
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null)    return 0;
        Stack<Pair<TreeNode,Integer>> st = new Stack<>();   
        int result =0;
        st.push(new Pair(root,0));
        while(!st.isEmpty()){
            Pair<TreeNode, Integer> p = st.pop();
            TreeNode node = p.getKey();         // get key of the pair which is the node
            int value = p.getValue();           // get value of the pair which is the value from the previoud root nodes
            if(node.left == null && node.right == null){    // if leaf node is reached calculate the value and add it to the result
                result += value*10 + node.val;
            }
            if(node.left != null)           // push the left node to stack if it is not null
                st.push(new Pair(node.left,value*10 + node.val));
            if(node.right != null)              // push the right node to stack if it is not null
                st.push(new Pair(node.right,value*10 + node.val));
        }
        return result;
    }
}
