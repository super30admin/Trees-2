// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height ( no of elements possible in recursive stack at a point)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


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
class Solution {
    class Pair // pair class to store the root along with sum
    {
        TreeNode node;
        int value;
        
        public Pair(TreeNode node, int value)
        {
            this.node = node;
            this.value = value;
        }
        
        public TreeNode getKey()
        {
            return this.node;
        }
        
        public int getValue()
        {
            return this.value;
        }
    }
    
    public int sumNumbers(TreeNode root) {
       int result = 0;
        int sum = 0;
       Stack<Pair> stack = new Stack<>(); // creating stack for pairs
       while(root!=null || !stack.isEmpty()) // till the node becomes null and stack is empty, we excute
       {
           while(root!=null) // till we reach null
           {
               sum = sum*10 + root.val; // finding sum for the root
               stack.push(new Pair(root,sum)); // adding root and sum to stack
               root = root.left; // traversing left
           }

           //on popping we get a pair
           Pair p = stack.pop();
           root = p.getKey();
           sum = p.getValue(); // getting the sum corresponding to the root we popped

           //checking whether its a leaf node
            if(root.left == null && root.right==null)
                result += sum;// if leaf we add the popped sum to result
           
           root = root.right; // traverse right
        
       }
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h) stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


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
class Solution {
    
    public int sumNumbers(TreeNode root) {
       
        return inorder(root, 0); // calling recursive inorder method with sum 0
        
    }
    
    private int inorder(TreeNode root, int sum)
    {
        //base
        if(root == null) // when we reach a point where there is one child and other is null
            return 0; // we have to return 0
        
        if(root.left==null && root.right==null)
             return sum*10+root.val; // calculate sum for the leaf and return sum
            
   
        //logic
        int left = inorder(root.left, sum*10 + root.val); // calling for left subtree with sum
        int right = inorder(root.right, sum*10 + root.val); // calling for right subtree with sum
        
        return left + right; // adding result of left sum and right branch
        
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n) for hashmap, h not included as tree is returned as result (output data structure)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


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
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>(); // to store inorder values and their index
    int index; // to traverse the preorder array 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1; // setting index to end of postorder array as that is the root

        for(int i=0;i<inorder.length;i++) // adding values to the hashmap
            map.put(inorder[i],i);
        
        return helper(inorder, postorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end)
    {
        //base
        if(start>end || index == 0) // when the range gets over i.e we have a leaf node or all elements have been traversed
            return null;
            
        //logic
        TreeNode root = new TreeNode(postorder[index]); // using preorder we create the root starting at end of array
        index--; // next value will give right values and then left
        
        int inIndex = map.get(root.val); // getting the index of root in inorder

        //creating the right subtree of node first as the next value we get in postorder is the right subtree
        root.right = helper(inorder, postorder, inIndex+1, end);
        //creating the left subtree of node
        root.left = helper(inorder, postorder, start, inIndex-1);
        
        return root;
    }
}