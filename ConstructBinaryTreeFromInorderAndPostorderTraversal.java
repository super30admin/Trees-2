

// TC : O(n) // n = postorder.length
// SC : O(n)

package S30_Codes.Trees_2;
import java.util.HashMap;
import java.util.Map;


// Definition for a binary tree node.
class TreeNode {
    int val;
    S30_Codes.Trees_2.TreeNode left;
    S30_Codes.Trees_2.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, S30_Codes.Trees_2.TreeNode left, S30_Codes.Trees_2.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int[] inorder, postorder;
    int postorderIdx;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.postorderIdx = postorder.length-1;

        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTree(0, inorder.length-1);
    }

    private TreeNode buildTree(int inStartIdx, int inEndIdx){
        if(inStartIdx > inEndIdx)
            return null;

        TreeNode newNode = new TreeNode(postorder[postorderIdx--]);

        int nodeInInorderIdx = getNodeIdx(newNode.val);
        newNode.right = buildTree(nodeInInorderIdx+1, inEndIdx);
        newNode.left = buildTree(inStartIdx, nodeInInorderIdx-1);

        return newNode;
    }

    private int getNodeIdx(int val){
        return map.get(val);
    }
}
