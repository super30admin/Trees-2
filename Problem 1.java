// Time Complexity : O(n)
// Space Complexity : O(inorder) , for storing the hashMap
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : creating the ranges were tough


// Your code here along with comments explaining your approach

/*
we will take each element one by one from the preorder, as in pre order the root is first 

we then go left and create a range on in order and go right by creating a range on inorder
 */
class Solution {

    HashMap<Integer,Integer> map;
    int preIndex =0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // we need to find the index of root in the inorder , so we will create a hashmap of that

        map = new HashMap<Integer,Integer>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(preorder,inorder,0,inorder.length-1);        
    }

    private TreeNode helper(int[] preorder, int[] inorder,int start,int end){


        //base case
        if(start > end || preIndex>=preorder.length){
            return null;
        }


        //logic

        // we will get the next element from protected
        int rootVal = preorder[preIndex++];
        TreeNode node = new TreeNode();
        node.val = rootVal;

        int rootIndex = map.get(rootVal); // getting index of root on inorder


        //recurse
        // go left
        node.left = helper(preorder,inorder,start,rootIndex-1); // traverse the left subtree, not incluing rootindex

        //go right

        node.right = helper(preorder,inorder,rootIndex+1,end);// traverse the right subtree, not incluing rootindex
        
        return node;

    }
}