// space complexity - o(2n) - number of nodes
//time - o(n) where n is number of nodes
//Ran on Leetcode successfully : Yes
// Problem faced  : No
// Recursive approach : start from end of post order thatw ill be root, find the element inorder, and divide inorder in two part to
// construct the left and right of tree.
class Solution {

    int postorderIndex = Integer.MAX_VALUE;

    Map<Integer, Integer> map = null;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length-1;
        map = new HashMap<>();

        for(int i = 0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTree(inorder, postorder, 0, postorder.length-1);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int start, int end) {

        if(start > end ) return null;

        TreeNode curr = new TreeNode(postorder[postorderIndex]);

        int mid = map.get(postorder[postorderIndex]);
        postorderIndex--;

        curr.right = buildTree(inorder, postorder, mid+1, end);
        curr.left = buildTree(inorder, postorder, start, mid-1);

        return curr;
    }
}
