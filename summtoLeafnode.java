// Time Complexity :o(N)
// Space Complexity :0(H)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: storing number in local stack
// Recursive Solution

class Solution {
    int sum;
    
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
        
    }
    
    private void helper(TreeNode root, int num)
    {
        if(root == null)
        {
            return;
        }
        
        helper(root.left, num*10 + root.val);
        System.out.println(num);
        helper(root.right, num*10+root.val);
        if(root.left == null && root.right == null)
        {
            sum += num*10+root.val;
            System.out.println(sum);
        }
    }
}

// Iterative solution

class Solution {

  
    class Pair{
        TreeNode node;
        int value;

        public Pair(TreeNode node, int value){
            this.node = node;
            this.value = value;
        }

        public TreeNode getNode(){
            return this.node;
        }

        public int getValue(){
            return this.value;
        }

    }

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        int currNum = 0;
        Stack<Pair> st = new Stack<>();

        while(root != null || !st.isEmpty()){
            while(root != null){
                currNum = currNum * 10 + root.val;
                Pair p = new Pair(root, currNum);
                st.push(p);
                root = root.left;

            }
            // st.pop();
            Pair p = st.pop();
            root = p.getNode();
            currNum = p.getValue();

            // if leaf nodes
            if( root.left == null && root.right == null){
                sum += currNum;
            }

            root = root.right;
        }
        return sum;
    }

} 