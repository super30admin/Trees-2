// Time Complexity : O(n)
// Space Complexity : O(n) -> using datastructure to store the nodes and indexes.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Maintained pointers to keep track on inorder array start and end. An index to keep track of post order.
 * Iterating from end of postorder we get the root of each subtree. Checking the same in inorder, we get the right and left subtrees.
 * Finally we end up building the tree with post order and in order arrays.
 * 
 */

    
    int postIndex;
    HashMap<Integer,Integer> inorderMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(postorder == null || postorder.length == 0)
            return null;
        
        inorderMap = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        
        postIndex = postorder.length - 1;
        
        return buildTreeHelper(inorder,postorder,0,inorder.length-1);
        
    }
    
    private TreeNode buildTreeHelper(int[] inorder,int[] postorder,int inStart,int inEnd){
        
        if(inStart>inEnd)
            return null;
        
        TreeNode root = new TreeNode(postorder[postIndex]);
        
        postIndex--;
        
        //Root -> Right -> Left
        int index = inorderMap.get(root.val);
        
        
        root.right = buildTreeHelper(inorder,postorder,index+1,inEnd);
        root.left = buildTreeHelper(inorder,postorder,inStart,index-1);
        
        
        return root; 
        
        
    }
    
    
 // Time Complexity : O(n)
 // Space Complexity : O(1) 
 // Did this code successfully run on Leetcode : yes
 // Any problem you faced while coding this : no


 // Your code here along with comments explaining your approach
 /*
  *	A recursive approach, every iteration keep adding the currentSum by multiplying it with 10 and add with the current root value.
  * Recurse the left subtree. Once you hit the leaf, return the current sum which would add up to the right subtree. 
  */
    
    
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root,0);
    }
    
    private int sumNumbersHelper(TreeNode root, int sum){
        if(root == null)
            return 0;
        
        int currentSum = sum * 10 + root.val;
        
        if(root.left==null && root.right==null){
            return currentSum;
        }
        
        return sumNumbersHelper(root.left,currentSum)+sumNumbersHelper(root.right,currentSum);
    } 