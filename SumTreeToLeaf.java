// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


//iterative 

class Solution {
    int i;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
       if(inorder.length == 0 || postorder.length == 0)
         return null;
        map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i],i);
        }
        i = postorder.length - 1;
        return helper(inorder,postorder,0,inorder.length-1);
        
    }
    
    
    private TreeNode helper(int[] inorder,int[] postorder ,int low , int high){
        
        if( low > high || i < 0)
            return null;
        
        int index = map.get(postorder[i]);
        TreeNode root = new TreeNode(inorder[index]);
        i--;
        root.right =  helper(inorder, postorder,index+1,high);
        root.left =  helper(inorder,postorder, low, index-1 );
        
        return root;
        
    }
}

//recurisve


// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        
        if(root == null)
            return 0;
     
        return helper(root, 0);
    }
    
    private int helper(TreeNode root , int curSum){
        
        //base
        if(root == null){
           System.out.println("here");
            return 0 ;
        }
     
        if(root.left == null  && root.right == null){
           return curSum *10 +root.val;
          
       }
        //logic
        return helper(root.left,curSum*10+root.val) +  helper(root.right,curSum*10+root.val);
        
    }
}
