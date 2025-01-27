// Optimized approach:
// In this approach, using hashmap for O(1) lookup for the index of the root in
// each call. And also instead of creating new arrays everytime, just keeping
// the indices start and end for the inorder array, so it will be space
// optimized as well.

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    // This is the idx of root, which will be given by decrementing everytime from
    // postorder array
    int idx;
    // Hashmap for storing the all the nodes of inorder array and it's index
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Base case
        if (inorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        // Initialize map and idx
        map = new HashMap<>();
        // Note in pre we gave index=0 because preorder(Root,L,R) and in this
        // postorder(L,R,Root). Therefore, idx will be from last element
        // and we will decrement each time
        idx = postorder.length - 1;
        // Put all the nodes of inorder array and it's index in hashmap
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // Call the recursive createtree function with start as 0 and end as
        // inorder.length-1
        return createTree(postorder, 0, inorder.length - 1);

    }

    private TreeNode createTree(int[] postorder, int start, int end) {
        // Base case, any point if start is > end, that we means we have reached to the
        // leaf node and there are no more left and right subtrees to that node, so
        // return null
        if (start > end) {
            return null;
        }
        // Root will be given from last element of postorder array
        int rootVal = postorder[idx];
        // Decrement the index to get the correct root in the next recursive call
        idx--;
        // Then create that root node
        TreeNode root = new TreeNode(rootVal);
        // Get the position of root node in inorder array
        int rootIdx = map.get(rootVal);
        // Make the right recursive call first because postorder array(start rootidx+1
        // and end as same)
        root.right = createTree(postorder, rootIdx + 1, end);
        // Make the left recursive call where the start will be same and end will be
        // rootidx - 1
        root.left = createTree(postorder, start, rootIdx - 1);
        // return root
        return root;
    }
}