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

    
    //method 1 : in postorder we observe that last element is the root
        //as postorder traversal is : left, right, root
    
    //time complexity : O(n^2)
    //space complexity :O(n^2)
    
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        
        
//         if(postorder.length == 0){
//             return null;
//         }
        
//         int n = postorder.length;
//         TreeNode root = new TreeNode(postorder[n-1]);
        
//         //find root element index in inoder array
//         int index = 0;
//         for(int i = 0 ;i < inorder.length;i++){
//             if(inorder[i] == root.val){
//                 index = i;
//                 break;
//             }
//         }
        
//         //after getting the index divide the arrays
//         int []leftInorder = Arrays.copyOfRange(inorder, 0 , index);
        
//         int []rightInorder = Arrays.copyOfRange(inorder,index+1,inorder.length);
        
//         int []leftPostOrder = Arrays.copyOfRange(postorder,0,index);
        
//         int []rightPostOrder = Arrays.copyOfRange(postorder,index,postorder.length-1);
        
//         root.left = buildTree(leftInorder,leftPostOrder);
//         root.right = buildTree(rightInorder,rightPostOrder);
        
//         return root;
//     }
    
    
    
    /*
    method 2: recursive approach by using extra spce to reduce the search time from o(n) to o(1)
    
    time complexity: O(n)
    space complexity: O(n)
    */
class ConstructBinaryTree2 {
    HashMap<Integer,Integer> map;
    int index;
    
    public TreeNode buildTree(int[] inorder, int[] postorder){
            if(postorder.length == 0){
                return null;
            }
        
        
        int n = postorder.length;
        this.map = new HashMap<>();
        this.index = n-1;
        //add all elements of inorder to hashmap
        for(int i =0 ;i < inorder.length; i++){
            map.put(inorder[i] , i);
        }
        
       return helper(postorder,0,inorder.length-1);
    }
    
    private TreeNode helper(int[]postorder,int start,int end){
        //base
        if(start > end){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[index--]);
        
        int rootIndex = map.get(root.val);
        
        root.right = helper(postorder, rootIndex+1, end);
        
        root.left = helper(postorder, start , rootIndex - 1);
        
        return root;
    }
    
}