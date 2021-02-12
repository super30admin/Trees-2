import java.util.*;
//Problem1 
// Time Complexity : O(n)
// Space Complexity : O(n)


//Same as building from preorder & inorder
//except the root is at the last index of postorder array
class Solution1 {
    private int postIndex;

     //map to store indices for inorder traversal
    //so that we can easily access the index of the root with O(1)
    private HashMap<Integer, Integer> hashMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }

        hashMap = new HashMap<>(); 
        postIndex = postorder.length - 1;
        
        //storing values mapped to indices from inorder array
        for(int i = 0; i < inorder.length; i++){
            hashMap.put(inorder[i],i);
        }
        
        return buildNewTree(inorder, postorder, 0, inorder.length - 1);
    }
    private TreeNode buildNewTree(int[] inorder, int[] postorder, 
                                    int inStart,//starting point of the node in the inorder array
                                    int inEnd){//ending point of the node in the inorder array{
        
        //if starting Index > ending Index
        //then not a valid node
        //meaning its a leaf
        if(inStart > inEnd){
            return null;
        }

        //get the root from the preorder(starting at the last index , then index -1,......)
        TreeNode root = new TreeNode(postorder[postIndex]);

        //Decrement Index for the next root
        postIndex--;
        
        //get the value of the root from the hashmap
        int index = hashMap.get(root.val);

        //move to the left(recurssion)
        root.right = buildNewTree(inorder, postorder, index+1, inEnd);

        //move to the right(recurrsion)
        root.left = buildNewTree(inorder, postorder, inStart, index-1);
        
        //get the binary tree
        return root;
    }
}

//Problem1 
// Time Complexity : O(n)
// Space Complexity : O(depth)

class Solution2 {
    private int output;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return output;
        }
        
        output = 0;
        
        sum(root, 0);
        return output;
    }
    
    private void sum(TreeNode root, int curr){
        //1 base case
        //if root is null, then we are done 
        if(root == null){
            return;
        }
        
        //the sum at curr root is = last sum * 10 + root.val
        curr = curr * 10 + root.val;
        
        //2nd base case
        //if we reach the leaf i.e. root.left and root.right is null
        if(root.left == null && root.right == null){

            //then add the current sum to the output
            output += curr;
            return;
        }
        //1st go the left and then right
        //preorder traversal
        sum(root.left, curr);
        sum(root.right, curr);
    }
}