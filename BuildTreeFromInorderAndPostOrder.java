// Time Complexity : O(n)
// Space Complexity : O(n) where n is the the number of nodes
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;
public class BuildTreeFromInorderAndPostOrder {
    class TreeNode1 {
        int val;
        TreeNode1 left;
        TreeNode1 right;
        TreeNode1(int val) {
            this.val = val;
            left = right = null;
        }
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    TreeNode1 buildTree(int[] postorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return constructTree(postorder, inorder, 0, postorder.length-1, postorder.length-1);
    }

    TreeNode1 constructTree(int[] postorder, int[] inorder, int start, int end, int index) {

        if(start > end) return null;

        int rootVal = postorder[index];
        TreeNode1 root = new TreeNode1(rootVal);

        int rootIndex = map.get(rootVal);
        root.left = constructTree(postorder, inorder, start, rootIndex - 1, index-(end-rootIndex) -1);
        root.right = constructTree(postorder, inorder, rootIndex + 1,end,  index - 1);

        return root;
    }
    void preorder(TreeNode1 node) {
        if(node != null) {
            System.out.print(node.val + "  ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    public static void main(String[] args) {
        int[] inorder = {};
        int[] postorder = {};
        BuildTreeFromInorderAndPostOrder tree = new BuildTreeFromInorderAndPostOrder();
        TreeNode1 root = tree.buildTree(postorder, inorder);
        System.out.println("Root of tree :" + root.val);
        System.out.println("Pre Order Traversal");
        tree.preorder(root);
    }
}
