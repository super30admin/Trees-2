class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // create map and store the indices of the values in the inorder array
        Map<Integer,Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        // create a root to store the recursively built tree using inorder and postorder arrays
        TreeNode root = buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap);

        // return root of constructed tree
        return root;
    }

    private TreeNode buildTree(int[] in, int inStart, int inEnd, int[] po, int poStart, int poEnd, Map<Integer,Integer> inMap) {
        // BASE CONDITION: if the start index is greater than the end index for either array, return null
        if(inStart > inEnd || poStart > poEnd) return null;

        // PostOrder -> Left, Right , Root --> so create root with the value at the end index of the postorder array
        TreeNode root = new TreeNode(po[poEnd]);
        
        // Find the index of the root in the inorder array using inMap
        int rootIdx = inMap.get(po[poEnd]);
        
        // Calculate the number of nodes in the left subtree
        int numsLeft = rootIdx - inStart;

        // Recursively build the left subtree:
        root.left = buildTree(in, inStart, rootIdx - 1, po, poStart, poStart + numsLeft - 1, inMap);

        // Recursively build the right subtree:
        root.right = buildTree(in, rootIdx + 1, inEnd, po, poStart + numsLeft, poEnd - 1, inMap);

        // our recursion will go to the bottom (single node level) and build the tree and come back
        return root;
    }
}