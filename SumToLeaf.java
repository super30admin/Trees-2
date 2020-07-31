/**
Problem: Find the sum from root to leaf of the tree.
Time Complexity: O(n), where n is the number of nodes in the tree
Space Complexity: O(d), where d is the depth of the tree

Approach 1 : Iterative solution
1. Use a stack. As you traverse thru the tree, keep pushing the value of the current node, and also, the current sum.
2. Current sum is calculated by multiplying 10 to the previous root value and then adding the current root value.
3. After one branch of the tree is completely traversed from root to the leaf, it is added to the result.
4. In the similar way, the whole tree is traversed, and we get the result at the end.


Approach 2 : Recursive solution
Same approach, but recursive solution.

 */


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

 //Iterative Solution
public class Pair {
    TreeNode key;
    int value;
    Pair(TreeNode root, int value) {
        this.key = root;
        this.value = value;
    }
    public TreeNode getKey() {
        return this.key;
    }
    public int getValue() {
        return this.value;
    }
}
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int currSum = 0, result = 0;
        Stack<Pair> st = new Stack<>();
        while(root != null || !st.isEmpty()) {
            while(root != null) {
                currSum = currSum*10 + root.val;
                st.push(new Pair(root, currSum));
                root = root.left;
            }
            Pair p = st.pop();
            root = p.getKey();
            currSum = p.getValue();
            if(root.left == null && root.right == null) {
                result += currSum;
            }
            root = root.right;
        }
        return result;
    }
}

//Recursive Solution
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return getSum(root, 0);
    }
    public int getSum(TreeNode root, int currSum) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return currSum*10 + root.val;
        }
        int left = getSum(root.left, currSum*10 + root.val);
        int right = getSum(root.right, currSum*10 + root.val);
        return left+right;
    }
}
