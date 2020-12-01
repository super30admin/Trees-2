package Nov30;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SumRootToLeafNumbers {
    
    /*
    Time Complexity: O(n) because we will visit every node of the given tree exactly once.
    Space Complexity: O(h) because stack will have at max h no.of nodes where h is height of the tree.
    Approach: Iterative approach used.
    
    */
    
    // custom class to hold every node of the tree alongwith the # formed from root till this node.
    class Pair {
        TreeNode node;
        int num;
        public Pair(TreeNode n, int no) {
            node = n;
            num = no;
        }  
    }
    
    int result = 0;
    
    public int sumNumbers(TreeNode root) {
        
        // edge
        if (root == null) {
            return 0;
        }
        
        Pair pair = new Pair(root, root.val);
        // each node will be pushed to a stack of Pair elements, processed and then its non null children will be pushed after creating a Pair type element for them.
        Stack<Pair> st = new Stack<>();
        st.push(pair);
        
        while (!st.isEmpty()) {
        	
            Pair cur = st.pop();
            // when both children are null for a node, it means we are at a leaf node, so we have to add the # achieved on this path from root till this leaf node to a result variable.
            if (cur.node.left == null && cur.node.right == null) {
                result = result + cur.num;
            } 
            if (cur.node.left != null) {
                int temp = (cur.num*10)+cur.node.left.val;
                Pair left = new Pair(cur.node.left, temp);
                st.push(left);
            } 
            if (cur.node.right != null) {
                int temp = (cur.num*10)+cur.node.right.val;
                Pair right = new Pair(cur.node.right, temp);
                st.push(right);
            }
        }   
        return result;
    }
}