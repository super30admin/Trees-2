//---------------------Iterative---------------
// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//here we are making stack and pushing root and currNum in stack until we reach null, then we pop and add
//the currNum in final Sum
class Pair {
    TreeNode tree;
    int num;

    Pair(TreeNode root, int num) {
        this.tree = root;
        this.num = num;
    }
}

class Solution {
    public int sumNumbers(TreeNode root) {
        int currNum = 0;
        int Sum = 0;
        Stack<Pair> st = new Stack<>();
        while (!st.isEmpty() || root != null) {

            while (root != null) {
                currNum = currNum * 10 + root.val;
                Pair p = new Pair(root, currNum);
                st.push(p);
                root = root.left;
            }

            Pair temp = st.pop();
            root = temp.tree;
            currNum = temp.num;
            // System.out.println(" root and currNum"+root.val+" and "+currNum);
            if (root.left == null && root.right == null) {
                Sum += currNum;
            }

            root = root.right;
        }
        return Sum;
    }
}

// -----------------------------------recursive-----------------
// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

// we are calling recirsive function until we reach null and keep calculating
// currNum made by traversing tree
// then, we add the num to sum when we reach leaf

class Solution {

    public int sumNumbers(TreeNode root) {
        return helper(root, 0, 0);

    }

    public int helper(TreeNode root, int currentNum, int Sum) {
        if (root == null)
            return Sum;
        if (root.right == null && root.left == null) {
            Sum += currentNum * 10 + root.val;
            return Sum;
        }

        return helper(root.left, currentNum * 10 + root.val, Sum) +
        // if(root.right==null && root.left==null)
        // Sum+=currentNum*10+root.val;

                helper(root.right, currentNum * 10 + root.val, Sum);
        // if(root.right==null && root.left==null)
        // Sum+=currentNum*10+root.val;

    }
}