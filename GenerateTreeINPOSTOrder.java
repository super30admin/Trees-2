
/*Time Complexity: O(n*n) traversing to every node and for each root we are finding its .
 * Space Complexity: O(1) no extra space but stack space will be there which is O(h).
 * Leetcode: yes
 * Any Issues: No
 */
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
//this is an alternative way of doing generating where we are finding the index by using linear search 
//which makes the time complexity O(n * n) but space is O(1)
class Solution {
    private TreeNode generate(int[] inorder, int ilow,  int ihigh, int[] postorder, int plow, int phigh)
    {
        if(ilow > ihigh || plow > phigh)
            return null;
        TreeNode root = new TreeNode(postorder[phigh]);
       
        int inorderIndex = find(inorder, postorder[phigh]);
         
        int postorderIndex = plow + inorderIndex-ilow;
        root.left = generate(inorder, ilow, inorderIndex-1, postorder, plow, postorderIndex-1);
        root.right = generate(inorder, inorderIndex+1, ihigh, postorder, postorderIndex, phigh-1);
        
       
        return root;
    }
    private int find(int[] arr, int ele)
    {
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == ele)
                return i;
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return generate(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
}
