/*
Time complexity : O(N).

    Building the hashmap takes O(N) time, as there are N nodes to add, and adding items to a hashmap has a cost
    of O(1), so we get N⋅O(1)=O(N).

    Building the tree also takes O(N) time. The recursive helper method has a cost of O(1) for each call
    (it has no loops), and it is called once for each of the N nodes, giving a total of O(N).

    Taking both into consideration, the time complexity is O(N) + O(N) = O(2N) = O(N).

Space complexity : O(N).

    Building the hashmap and storing the entire tree each requires O(N) memory. The size of the implicit system
    stack used by recursion calls depends on the height of the tree, which is O(N) in the worst case and O(logN)
    on average. Taking both into consideration, the space complexity is O(N).
 */

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTreeInorderPostorder {

    int postorderIndex;
    HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postorderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();

        //As we need to fetch the root index from inorder always, we can use hashmap to store the index
        for(int i=0; i<inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeUsingArray(postorder, 0, postorder.length-1);
    }

    private TreeNode buildTreeUsingArray(int[] postorder, int left, int right)
    {
        if(left > right) return null;

        //postorder will give us the root and we can create a root node, root will be the end of array
        int rootValue = postorder[postorderIndex];
        postorderIndex--;
        TreeNode root = new TreeNode(rootValue);

        //postorder => left right root [left, right, root], so first we find the right subarray
        root.right = buildTreeUsingArray(postorder,
                inorderIndexMap.get(rootValue)+1,
                right);

        root.left = buildTreeUsingArray(postorder,
                left,
                inorderIndexMap.get(rootValue)-1);

        return root;
    }
}