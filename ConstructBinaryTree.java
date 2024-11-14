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
 // Approach : From preorder list mark the root and now iterate through In order array to find the root that matches preorder root.
 // Using that idx now identify the preorder left/right range and inorder left/right range and strat building the tree. 
 // Time : o(n)*n = o(n^2)
 // Space : O(n^2)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length ==0) return null;
        int rootVal = preorder[0];
        int idx = -1; // mark the root index in my InOrder array
        for(int i =0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                idx=i;
            }
        }
        int[] preleft = Arrays.copyOfRange(preorder,1,idx+1);
        int[] preright = Arrays.copyOfRange(preorder,idx+1,preorder.length);
        int[] inleft=Arrays.copyOfRange(inorder,0,idx);
        int[] inright=Arrays.copyOfRange(inorder,idx+1,inorder.length);

        TreeNode root = new TreeNode(rootVal); // start building the tree
        root.left = buildTree(preleft,inleft);
        root.right = buildTree(preright,inright);  
        return root;
    }
}


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
 // Approach : To solve the repetive problem of computing root we create a map for in order to store tha value to idx.
 // 
 // Time : O(n)
 // Space : O(n) // not creating any ranges of left and right
class Solution {
    HashMap<Integer,Integer> map;
    int idx = 0; // This is the root index in my preorder traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        // Build HashMap for inorder values -> index
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i); // 
        };
        return helper(preorder,inorder,0,inorder.length-1); // start & end index of inorder
    }
    private TreeNode helper(int[] preorder,int[] inorder,int start , int end){
        // base case
        if(idx == preorder.length || start>end) return null;
        // logic
        // find the rootidx of inorder traversal
        int rootIdx = map.get(preorder[idx]);
        TreeNode root = new TreeNode(preorder[idx]);
        idx++; // preorder traversal index increase . It will give new root;
        root.left = helper(preorder,inorder,start,rootIdx-1);
        root.right = helper(preorder,inorder,rootIdx+1,end);
        return root;
    }
}


