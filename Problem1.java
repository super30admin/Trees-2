// Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

// Time Complexity : O(N)
// Space Complexity : O(Height of Tree(recursion stack) + N(for hashmap))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


// Your code here along with comments explaining your approach


class Solution {
    int p;
    Map<Integer, Integer> mappy;

    private TreeNode helper(int[] inorder, int[] postorder, int ii, int ij){
        //base
        if(ii==ij){
            return null;
        }

        //logic
        int rootVal=postorder[p-1];
        TreeNode root=new TreeNode(rootVal);
        p--;

        // Search in in-order
        int k=mappy.getOrDefault(rootVal, ii);
        while(inorder[k]!=rootVal){
            if(!mappy.containsKey(inorder[k])){
                mappy.put(inorder[k], k);
            }
            k++;
        }

        root.right=helper(inorder,postorder,k+1,ij);
        root.left=helper(inorder,postorder,ii,k);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.mappy = new HashMap<>();
        this.p=postorder.length;
        return helper(inorder, postorder, 0, inorder.length);
    }
}