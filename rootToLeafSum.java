// Time Complexity : O(n)because we have to traverse each node once.
// Space Complexity :O(h) where h is the height of recursion stack.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// First Approach is iterative to keep a stack of pair of (Node, num_sofar) ..go left and keep on pushing those nodes whose subtrees havent been explored completely
// while pushing num_sofar to stack also remember to push the updated num_sofar at each node
//for any particluar node the above thing will handle the left sub trees but when we reach leftmost null we pop the stack
// popping returns the pair from which we retrieve the parent node and the num_sofar at that point..
// now for the parent we see if it is an intermediate node or leaf node. if leaf add it to res
// set the root as root.right to check all possible right subtrees.
class Solution {
    class Pair {
        TreeNode node;
        int num_sofar;

        Pair(TreeNode node) {
        }

        Pair(TreeNode node, int num_sofar) {
            this.node = node;
            this.num_sofar = num_sofar;
        }
    }

    public int sumNumbers(TreeNode root) {
        int res = 0;
        int num_sofar = 0;
        Stack<Pair> st = new Stack<>();

        // when all the left nodes have been traversed, we will enter the outer while
        // loop again since stack is not empty even though our root is null

        // since our root( left most element) is null, hence it will pop(go to parent)
        // now here we will check if its leaf node or not
        // if leaf node then add it to res
        // at the end we want to go to root.right
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                num_sofar = num_sofar * 10 + root.val;
                st.push(new Pair(root, num_sofar));
                root = root.left;
            }
            Pair p = st.pop();
            root = p.node;
            num_sofar = p.num_sofar;
            // only add if it is the leaf node
            if (root.left == null && root.right == null)
                res += p.num_sofar;
            root = root.right;
        }

        return res;

    }
}

// ////////////////////////////// Recursive solution
// second approach is to use a helper function which takes in two params the
// current node (root) and num_sofar(num so far that point)
// if current node is null return 0
// if not update num_sofar.. check if it is the leaf node.. if yes return
// the num_sofar
// if not leaf then it is an intermediate node..so we return the sum of left and
// right child.

class Solution {
    public int sumNumbers(TreeNode root) {

        return helper(root, 0);
    }

    private int helper(TreeNode root, int num_sofar) {
        if (root == null)
            return 0;

        num_sofar = num_sofar * 10 + root.val;
        if (root.left == null && root.right == null) {

            return num_sofar;
        } else
            return helper(root.left, num_sofar) + helper(root.right, num_sofar);
    }
}