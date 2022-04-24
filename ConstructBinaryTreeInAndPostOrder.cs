// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, took some help from leetcode solution


// Your code here along with comments explaining your approach


    int postorderIndex;
    Dictionary<int, int> inorderDict = null;
    public TreeNode BuildTree(int[] inorder, int[] postorder) {
      if(postorder == null || postorder.Length == 0 || inorder == null || inorder.Length == 0)
            return null;
        postorderIndex = postorder.Length - 1;
        
        //save all values of inroder in dictionary
        //so that we can grab all left and right subtree based on root node value from inorder array
        //as inorder is left, root, right
        inorderDict = new Dictionary<int, int>();
        for(int i =0; i < inorder.Length; i++)
        {
            inorderDict.Add(inorder[i], i);
        }
        
        return helper(postorder, 0, postorder.Length - 1);
    }
    
    private TreeNode helper(int[] postorder, int left, int right)
    {
        if(left > right)
            return null;
        
        //get root node value from preorder array
        //as postorder array is left, right, root
        int rootvalue = postorder[postorderIndex];
        postorderIndex--;
        TreeNode root = new TreeNode(rootvalue);
        
        //call helper method again for right subtree, 
        //left index we can get from inorder dictionary based on root value
        root.right = helper(postorder, inorderDict[rootvalue] + 1, right);
        
        //call helper method again for left subtree, 
        //right index we can get from inorder dictionary based on root value
        root.left = helper(postorder, left, inorderDict[rootvalue] - 1);    
        
        return root;
    }