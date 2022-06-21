
// approch 1
// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

// approch 2
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes I was trying first traverse throught left subtree and then right subtree 
//(line 116 and 117) but it gave me error of index out of bound.
// so I have swap it it runs fine But I am not sure why it is happening

import java.util.Arrays;
import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Main {

    // approch 1
    public static TreeNode buildTree1(int[] inorder, int[] postorder) {

        // base case
        if (inorder.length == 0)
            return null;
        // length of the postorder
        int n = postorder.length;
        // here we are traversing in postorder so we start from the end
        int rootVal = postorder[n - 1];
        // create root node for each recursion
        TreeNode root = new TreeNode(rootVal);
        // find index of the rootVal in inorder array
        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }
        // when we find rootIndex in the inorder array left side of this index is left
        // subtree and right side will be right sub tree. we are doing this until we
        // find on each side there is only single element so we can build our tree.
        // inorder left subtree
        // left subtree of inorder
        int[] il = Arrays.copyOfRange(inorder, 0, rootIdx);
        // System.out.println(Arrays.toString(il));
        // right subtree of inorder
        int[] ir = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        // System.out.println(Arrays.toString(ir));
        // left subtree of postorder
        int[] pl = Arrays.copyOfRange(postorder, 0, il.length);
        // System.out.println(Arrays.toString(pl));
        // right subtree of postorder
        int[] pr = Arrays.copyOfRange(postorder, pl.length, n - 1);
        // System.out.println(Arrays.toString(pr));
        root.left = buildTree1(il, pl);
        root.right = buildTree1(ir, pr);

        return root;
    }

    // global declaration of HashMap ;
    private static HashMap<Integer, Integer> map;

    // index for traversing through preorder;
    private static int idx;

    // approch 2
    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        idx = inorder.length - 1;

        // put inorder values and it index in the map.
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length - 1);
    }

    // helper function
    private static TreeNode helper(int[] postorder, int left, int right) {

        // if left > right that means left pointer and right pointer crossed each other
        // that means there is no further nodes so we return null
        if (left > right)
            return null;
        // rootVal from the postorder
        int rootVal = postorder[idx--];
        // creating root node at each recursion
        TreeNode root = new TreeNode(rootVal);
        // recursion

        // here first we find index of the root value in inorder array then divide it
        // using pointer to recurse.

        root.right = helper(postorder, map.get(rootVal) + 1, right);
        root.left = helper(postorder, left, map.get(rootVal) - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] postorder = new int[] { 9, 15, 7, 20, 3 };
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };
        TreeNode result = buildTree1(inorder, postorder);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
        result = buildTree2(inorder, postorder);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
    }
}