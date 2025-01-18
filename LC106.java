/*
 * Approach 1:
 *     Time Complexity: O(n^2) : as we are visiting each node and at each node we are doing linear search in inorder array. Inlcudes O(n) array reversal complexity.
 *     Space Complexity: O(n) : as the stack space is O(n) in the worst case when tree is skewed.
 * 
 * Approach 2:
 *    Time Complexity: O(n) : as we are visiting each node.  Inlcudes O(n) array reversal complexity
 *    Space Complexity: O(n) : as the hashmap space is O(n) + stack space is O(n) in the worst case when tree is skewed.
 * 
 * where n represents total number of nodes in a binary tree
 */

import java.util.*;

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

/*
 * Approach 1
 */
public class LC106 {
    int postIdx = 0;

    private void reverse(int arr[]) {
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i < j) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
            i++;
            j--;
        }
    }

    private int findMid(int[] inorder, int s, int e, int tar) {
        for (int i = s; i <= e; i++) {
            if (inorder[i] == tar)
                return i;
        }
        return -1;
    }

    private TreeNode build(int postorder[], int inorder[], int s, int e) {
        if (s > e)
            return null;
        int currPostVal = postorder[postIdx++];
        int mid = findMid(inorder, s, e, currPostVal);
        TreeNode root = new TreeNode(currPostVal);
        root.right = build(postorder, inorder, mid + 1, e);
        root.left = build(postorder, inorder, s, mid - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        reverse(postorder);
        return build(postorder, inorder, 0, inorder.length - 1);
    }
}

/*
 * Approach 2
 */
class LC106_2 {
    int postIdx = 0;

    private void reverse(int arr[]) {
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i < j) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
            i++;
            j--;
        }
    }

    private TreeNode build(int postorder[], int inorder[], int s, int e, HashMap<Integer, Integer> map) {
        if (s > e)
            return null;
        int currPostVal = postorder[postIdx++];
        int mid = map.get(currPostVal);
        TreeNode root = new TreeNode(currPostVal);
        root.right = build(postorder, inorder, mid + 1, e, map);
        root.left = build(postorder, inorder, s, mid - 1, map);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        reverse(postorder);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, inorder, 0, n - 1, map);
    }
}