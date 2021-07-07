// Time Complexity : Iterative : O(n), n is number of nodes , Recursive : O(n) 
// Space Complexity : Iterative : O(n)   , Recursive : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    //create a class pair for stack
    //stack has to keep both root and curSum till that root
    //so pair has node,value
    //class pair : constructor, getKey(to get the root node), getValue(to get the curSum)
    class Pair {
        TreeNode node;
        int value;
        
        public Pair(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }
        
        public TreeNode getKey() {
            return this.node;
        }
        
        public int getValue() {
            return this.value;
        }
        
    }
    
    public int sumNumbers(TreeNode root) { 
        
        //if root == null, tree is empty, so return sum = 0
        if(root == null) return 0;
        
        //Stack of type Pair
        Stack<Pair> st = new Stack<>();
        //result stores total sum
        int result = 0; 
        //curSum : sum till that root(included)
        int curSum = 0;
        
        //do till root != null or stack not empty
        while(root != null || !st.isEmpty()) {
            //go left till root!= null
            //if root == null, ie no more left elements, then pop and go right
            while(root != null) {
                //find curSum till that node (prev curSum*10 + value of the node)
                curSum = curSum*10 + root.val;
                //push it into the stack as a Pair 
                //create new Pair 
                st.push(new Pair(root, curSum));
                //go left
                root = root.left;
            }
            //pop the top element of stack (pair)
            //save the popped element as a pair, to get root and value
            Pair p = st.pop();
            //root is key (root required to find root.right)
            root = p.getKey();
            //curSum is value, to calc root.right curSums
            curSum = p.getValue();
            
            //if leaf node, add the curSum to result
            if(root.left == null && root.right == null) {
                result = result + curSum; 
            }  
            //else go to right side and continue
            root = root.right;
            
        } return result;       
    }
}


//Recursive Solution :

class Solution {
 
    public int sumNumbers(TreeNode root) { 
        
        //if root == null, tree is empty, so return sum = 0
        if(root == null) return 0;
        //int curSum = 0; 
        //call helper function with root and cursum =0 at start
        return helper(root, 0);   
    }
    
    private int helper(TreeNode root, int curSum) {
        //if any root = null (we know we have pointed to leaf.child) return 0
        if(root == null) return 0; 
        //if roots both children are null, then root is leaf node, so get the curSum
        //since curSum does not include the roots value, cal cursum and return
        if(root.left == null && root.right == null) {
            return curSum = curSum*10 + root.val;
        }
        //helper function to recursively call left and right
        return helper(root.left, curSum*10 + root.val) + helper(root.right, curSum*10 + root.val);
        
    }

}

