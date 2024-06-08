//Time Complexity O(N) and Space Complexity O(N)

##Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

# Approach
# Postorder traversal is Left->Right->Root. Last element in postorder list would be the root element. Find root in inorder list. All elements to its left would be left children and all elements to right would be right children
# Find the length of element to the right of root node in inorder list and use that length to find the right children the postorder and similarly for left children. It would be in reverse order
# Recrusively call the left and right children and for left pass postLeft,inLeft list and for right side pass postRight,inRight

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null && postorder == null) return null;
        if(inorder.length != postorder.length) return null;
        postIdx=postorder.length-1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(map,0,inorder.length-1,postorder);

    }

     public TreeNode helper(HashMap<Integer,Integer> map, int start,int end, int[] postorder){

        if(start>end) return null;

        int rootVal = postorder[postIdx];
        postIdx--;
        System.out.println(postIdx);
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = map.get(rootVal);

        root.right = helper(map,rootIdx+1,end,postorder);
        root.left = helper(map,start,rootIdx-1,postorder);


        return root;

    }
}
