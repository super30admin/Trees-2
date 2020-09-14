class ConstructInorderPostorder {
    //  Time Complexity:    O(n^2)  
            // ==>  Worst Case: left skewed [A,B,C,D], [D,C,B,A] ==> [A,null,B,null,C,null,D]
            // For  n recursions, we are searching in n elements
            // storing indexes of inorder traversal in a hashmap for searching, can bring to O(n) time.
    //  Space Complexity:   O(n) 
            // ==> O(n) is recursion stack space and c is constant space for arrays created
            // can be reduced to O(n) by just passing the indexes instead of arrays, using hashmaps
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0)
            return null;
        
        // 1. Fetching the root from postorder[]
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int index = -1;
        
        // 2. Finding the root's index in inorder, thats splits left and right subarrays
        for(int i = 0; i < inorder.length; i++){
            if(root.val == inorder[i]){
                index = i;
                break;
            }
        }
        
        // 3. Sub-arrays
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
        
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length - 1);
        
        // 4. Recursion call for left and right nodes
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        return root;
    }
}