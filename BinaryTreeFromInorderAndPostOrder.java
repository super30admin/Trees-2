//Time: O(N^2) | Space: O(N^2)
// Brute force
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);
        int rootInorderIdx = -1;
        for(int i=0;i<inorder.length;i++) {
            if(inorder[i] == rootVal){
                rootInorderIdx = i;
                break;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootInorderIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootInorderIdx+1, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, postorder.length-inRight.length-1);
        int[] postRight = Arrays.copyOfRange(postorder, postorder.length-1-inRight.length, postorder.length-1);
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        return root;
    }
}

// Time:O(N) | Space: O(N)
// Efficient soln using hashMap on inorder
// Traversing the postorder from last, finding its left and subtrees on inorder, adding the root to the result
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        postIndex = postorder.length-1;
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return builder(postorder, 0, postorder.length-1);
    }
    private TreeNode builder(int[] postorder, int start, int end) {
        if(start > end) return null;
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int rootValIndx = map.get(rootVal);
        root.right = builder(postorder, rootValIndx+1,end);
        root.left = builder(postorder,start, rootValIndx-1);
        return root;
    }
}