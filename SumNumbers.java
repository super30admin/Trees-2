// Time Complexity : O(n) n is the number of elements in the tree
// Space Complexity : O(h) h= height of tree because we can store max of height no of elements in the stack at a time
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach

// Iterative

class Solution {
    class Pair {
        TreeNode node;
        int value;
        public Pair(TreeNode node,int value) {
            this.node = node;
            this.value=value;
        }
        public TreeNode getKey(){
            return this.node;
        }
        public int getValue() {
            return this.value;
        }
    }
    public int sumNumbers(TreeNode root) {
        Stack<Pair> st = new Stack<>();
        int curSum = 0, result = 0;
        while(root!=null || !st.isEmpty()) {
            while(root!=null) {
                curSum= curSum*10 + root.val;
                st.push(new Pair(root,curSum));
                root=root.left;
            }
            Pair p = st.pop();
            root = p.getKey();
            curSum = p.getValue();
            if(root.left==null && root.right==null) {
                result+=curSum;
            }
            root=root.right;
        }
        return result;
    }
}


// Recursive

// Approach: We will start from root value. Its going to be the first digit 
// then for left child we will call the same function with root as left child and  
// the value which will be passed to it will be the product of the current value with 10 + the current node's value , 
// similarly we will be doing for the right tree as well and we will keep on doing this 
// till the time we have not reached the leaf node and while coming back from the called functions 
// we will be adding all the values which we have got and finally we can return the resultant answer.

class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }
    public int sum(TreeNode node,int s) {
        if(node==null) return 0;
        if(node.right==null && node.left==null) return s*10+node.val;
        return sum(node.left,s*10+node.val)+sum(node.right,s*10+node.val);
    }
}