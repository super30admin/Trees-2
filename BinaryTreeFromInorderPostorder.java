// Time Complexity : O(n) — each node is processed once; HashMap lookups are O(1) avg
// Space Complexity : O(n) for the HashMap + O(h) recursion stack (worst-case O(n))
// Did this code successfully run on LeetCode : Yes

// approach:
// 1) Build a value->index map from inorder to split subtrees in O(1).
// 2) Keep a global postIndex starting at postorder.length-1; pick root = postorder[postIndex--].
// 3) Recurse: build right subtree using (inIndex+1 to end), then left using (start to inIndex-1).


import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderPostorder {
    private Map<Integer, Integer> inorderIndexMap;
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndexMap = new HashMap<>();
        postIndex = postorder.length - 1;

        for(int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int start, int end){
        if(start > end){
            return null;
        }

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderIndexMap.get(rootVal);
        root.right = build(inorder, postorder, inIndex + 1, end);
        root.left = build(inorder, postorder, start, inIndex - 1);

        return root;
    }
}
