//Construct Binary Tree from Inorder and Postorder Traversal

//Brute Force Approach 
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(postorder.length == 0) return null;

        int rootVal = postorder[postorder.length-1];

        TreeNode root = new TreeNode (rootVal);
        if(postorder.length==1)
        {

            return root;

        }
        int idx = -1;

        for(int i=0;i<postorder.length;i++)
        {
            if(inorder[i]==rootVal)
            {
            idx = i;
            break;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, idx);
        int[] inRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int[] postRight = Arrays.copyOfRange(postorder, idx, postorder.length-1);

        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);

        return root;
        
    }
}


//Sum Root to Leaf Numbers

// Recursive Approach 

// Time Complexity : O(n)
// Space Complexity : O(h) [Height of the tree]
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int currNum)
    {
        
        if(root == null)
        {
            return;
        }
            currNum=currNum*10+root.val;
            if(root.left == null && root.right == null)
                result += currNum;
            System.out.print(root.val + " ");
            System.out.println(currNum);
            helper(root.left, currNum);
            helper(root.right, currNum);
            return;
    }
}


 // Iterative Approach 


// Time Complexity : O(n)
// Space Complexity : O(h) [Height of the tree]
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
 
 class Solution {
    public int sumNumbers(TreeNode root) {
        
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int currNum = 0;
        int result = 0;
        
        while(root !=null || !st.isEmpty()){
            while(root != null)
            {
                currNum = currNum*10+root.val;
                st.push(root);
                numSt.push(currNum);
                root = root.left;
            }
        root = st.pop();
        currNum = numSt.pop();
        if(root.left ==null && root.right ==null){
            result+=currNum;
        }

        root = root.right;
        
    }
        return result;
    }


    
}