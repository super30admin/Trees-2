// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this : while splitting left and right node.


// Your code here along with comments explaining your approach: I used hashMap to find the root value and did Recursion to make BT on left and right side of the tree.
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return ConstructBinaryTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }
    public TreeNode ConstructBinaryTree(int inorder[], int inStart, int inEnd, int postorder[], int postStart, int postEnd, HashMap<Integer,Integer> map){
        if(inStart>inEnd || postStart>postEnd){
            return null;
        }

        TreeNode root=new TreeNode(postorder[postEnd]);
        int idx= map.get(root.val);
        int leftTreeSize= idx-inStart;
        root.left=ConstructBinaryTree(inorder, inStart, idx-1, postorder, postStart, postStart+leftTreeSize-1, map);
        root.right=ConstructBinaryTree(inorder, idx+1, inEnd, postorder, postStart+leftTreeSize, postEnd-1, map);
        return root;
    }
}