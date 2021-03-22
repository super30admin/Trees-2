Problem: Construct binary tree from inorder and postorder traversal
// Time Complexity : O(n^2) for first approach, O(n) for second approach
// Space Complexity : O(n^2) for first approach, O(n) for second
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : First approach was straight forward, second approach made sense after class


// Your code here along with comments explaining your approach
-----------------------------------------------------  Approach 1 ---------------------------------
  class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //Inorder:[9,3,15,20,7] // Left Root right
        //Postorder: [9,15,7,20,3]//Left Right root
        
        if(inorder==null || inorder.length==0) return null;
        if(postorder==null || postorder.length==0) return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index=-1;
        
        //finding the index of root from inorder to get the left subtree
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                index=i;
                break;
            }
        }
        
        //inorder
        int[] inLeft = Arrays.copyOfRange(inorder,0,index);
        int[] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
        
        //postorder
        int[] postLeft = Arrays.copyOfRange(postorder,0,index);
        int[] postRight = Arrays.copyOfRange(postorder,index,postorder.length-1);
        
        root.left = buildTree(inLeft,postLeft);
        root.right = buildTree(inRight,postRight);
        
        return root;
    }
}


---------------------------------------------------------- Approach 2 ---------------------------------------------------
  class Solution {
    //global value for post order
    private int postorderindex;
    private Map<Integer, Integer> hashMap;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    
        if(postorder==null || postorder.length==0) return null;
        
        postorderindex = postorder.length-1;
        
        //hashmap for inorder values and index
        hashMap = new HashMap<>();
        
        //first we need to copy inorder values and indices to hashmap for constant time retrieval of root index in inorder
        for(int i=0;i<inorder.length;i++){
            hashMap.put(inorder[i],i);
        }
        
        return arrayToTree(inorder, postorder, 0, inorder.length-1);
    }
    
    
    //In this method, we will still use recursion but use ranges in one array rather than creating four seperate arrays
    private TreeNode arrayToTree(int[] inorder, int[] postorder, int left, int right){
        //if there are no elements to construct the tree
        if(left>right){
            return null;
        }
        
        //post order array last element is root, select and increment
        TreeNode root = new TreeNode(postorder[postorderindex--]);
        
        int index = hashMap.get(root.val);//getting root index in inorder
        
        root.right = arrayToTree(inorder, postorder, index+1,right);
        root.left = arrayToTree(inorder, postorder, left,index-1);
        
        
        return root;
    }
}
