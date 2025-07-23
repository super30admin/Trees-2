//Time Complexity (TC):O(n). Each node is processed once.
//Space Complexity (SC):O(n). HashMap stores n elements. Recursion stack can go up to O(n) in skewed trees.

//Build a map of inorder values to their indices for O(1) lookup.
//Recursively construct the tree by picking preorder elements in order as roots.
//Use the inorder index map to divide into left and right subtrees.

class Solution {
    
    int preorderIndex;

    public TreeNode buildTree(int[] preorderTraversal, int[] inorderTraversal) {
        HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorderTraversal.length; i++) {
            inorderIndexMap.put(inorderTraversal[i], i);
        }
        this.preorderIndex = 0;
        return buildSubtree(preorderTraversal, 0, preorderTraversal.length - 1, inorderIndexMap);
    }

    private TreeNode buildSubtree(int[] preorderTraversal, int inorderStart, int inorderEnd, HashMap<Integer, Integer> inorderIndexMap) {
        // Base case
        if (inorderStart > inorderEnd) return null;

        int rootValue = preorderTraversal[preorderIndex];
        preorderIndex++;

        int inorderRootIndex = inorderIndexMap.get(rootValue);

        TreeNode root = new TreeNode(rootValue);

        root.left = buildSubtree(preorderTraversal, inorderStart, inorderRootIndex - 1, inorderIndexMap);
        root.right = buildSubtree(preorderTraversal, inorderRootIndex + 1, inorderEnd, inorderIndexMap);
        
        return root;
    }
}
