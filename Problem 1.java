// Time Complexity : O(n)
// Space Complexity : O(inorder) , for storing the hashMap, O (n) for storing the tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : creating the ranges were tough


// Your code here along with comments explaining your approach

/*
 

Post Order = Left -> right -> root, which means the last element would be root, and before that is right, and before that is Left

We will start by taking each element from the end of the post order

we will then go right and update the range for right

we will then go left and update the range for left
 */
class Solution {

    int postIndex =0;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        // we need to find the index of root in the inorder , so we will create a hashmap of that

        map = new HashMap<Integer,Integer>();
        postIndex = postorder.length-1; // start from the last

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(postorder,inorder,0,inorder.length-1); 
    }

        private TreeNode helper(int[] postorder, int[] inorder,int start,int end){


        //base case
        if(start > end || postIndex<0){
            return null;
        }


        //logic

        // we will get the next element from protected
        int rootVal = postorder[postIndex--];
        TreeNode node = new TreeNode();
        node.val = rootVal;

        int rootIndex = map.get(rootVal); // getting index of root on inorder


        //recurse
        // Post order = Left -> Right -> root
        // Since we are at the root, we will go Right first and then left
        //go right

        node.right = helper(postorder,inorder,rootIndex+1,end);// traverse the right subtree, not incluing rootindex

         // go left
          // Since we are at the root, we will go Right first and then left
        node.left = helper(postorder,inorder,start,rootIndex-1); // traverse the left subtree, not incluing rootindex
        
        return node;

    }
}
