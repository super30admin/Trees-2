// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Constructing binary tree one root element at a time from postorder. Construct hashmap for inorder to get index of root in inorder in O(1) time. Using that index, we can find left and right subtree elements in inorder. Recursively calling for left and right subtree.

class Solution {

    HashMap<Integer,Integer> map;
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length-1; map = new HashMap();
        for(int i =0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(postorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int l, int r){
        if(l>r) return null;

        int rootV = postorder[idx--];
        TreeNode root = new TreeNode(rootV);
        int rootI = map.get(rootV);

        root.right = helper(postorder, rootI+1, r);
        root.left = helper(postorder, l, rootI-1);

        return root;
    }

    public TreeNode buildTreeBrute(int[] inorder, int[] postorder) {

        if(postorder.length == 0) return null;

        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex =-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                rootIndex = i;
                break;
            }
        }

        int [] inLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int [] inRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        int [] posLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int [] posRight = Arrays.copyOfRange(postorder, posLeft.length, postorder.length-1);

        root.left = buildTree(inLeft, posLeft);
        root.right = buildTree(inRight, posRight);

        return root;
    }
}