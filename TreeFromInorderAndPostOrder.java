// Time Complexity : O(n).
// Space Complexity : O(n) space for hash map.
// Did this code successfully run on Leetcode : Yes
// Approach : The idea is, the last element of postorder array will be the root and it's corresponding position in the inorder array gives the left and right subtrees from it's left and right
// sides of the index position found. We start building the right subtrees as we are looping from end of postorder array, it gives right subtree's root. We do this process by storing the elements of inorder array in hashmap as search is O(1). We maintain start and end pointers, and find the index
// of postorder array's value in inorder array. The left side of that index gives the left subtree and right gives the right subtree. We recurse until start and end ointer cross each other,
// which means the corresponding children are null.

class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.idx = postorder.length - 1; //start from end of postorder array as it has the root
        this.map = new HashMap<>();
        for(int i = 0 ; i< inorder.length; i++){
            map.put(inorder[i], i); //hashmap to store indices of inorder array so that search is O(1)
        }
        return helper(postorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int start, int end){
        //base
        if(start > end){
            return null;
        }

        //logic
        TreeNode node = new TreeNode(postorder[idx]);  //create a node with postorder[idx] as root
        int p = map.get(postorder[idx]); //get the index of corresponding inorder array
        idx--;
        node.right = helper(postorder, p+1, end); //build right part of node first
        node.left = helper(postorder, start, p-1); //build left part of node
        return node;
    }
}