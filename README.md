# Trees-2
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. We know that the root is traversed at the end in postorder traversal, so we know that we will get the root from the postorder array
2. we will use hashmap to store the index of all the elements present in the inorder array so that we can easily divide the tree in left and right subtree
3. Suppose the index at which we find root value in inorder array is i then we will cal recursion from strat to i-1 which will represent the left subtree and i+1 to end will represent the right subtree
4. we will first form the right subtree and then the left bcz we are getting the root from the postorder where the right is traversed before the root so every element present in the postorder array before root will represent the right child
## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

class Solution {
    int postIdx;
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }

        postIdx = postorder.length - 1;

        // Build hashmap of inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildSubtree(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubtree(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);

        int index = inorderIndexMap.get(rootVal);

        // Build right first, then left
        root.right = buildSubtree(inorder, postorder, index + 1, end);
        root.left = buildSubtree(inorder, postorder, start, index - 1);

        return root;
    }
}

## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
   

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

1. We will do inorder traversal to calculate the sum of the root to leaf node 
2. the currSum will be 0 in the beginning and we we add the root value as we traverse from root to leaf 
3. currSum will be calculated as currSum*10+root.val
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, 0);

        return sum;
    }

    private void dfs(TreeNode root, int currSum){
        if(root == null){
            return;
        }

        currSum = currSum * 10 + root.val;
        dfs(root.left, currSum);

        if(root.left == null && root.right == null){
            sum += currSum;
            return;
        }

        dfs(root.right, currSum);
    }
}