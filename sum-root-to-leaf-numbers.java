// Time Complexity : O(n) n: number of node
// Space Complexity : O(h) h : height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// if left and right node are numm then node is leaf, return the number when you hit leaf, add for both left anf right
// if one of left or right are null then its not leaf, return 0

public int sumNumbers(TreeNode root) {
    return calculateSum(root,0);
}
private int calculateSum(TreeNode root, int num) {
    if(root == null) { return 0;}
    num = (num*10) + root.val;
    if(root.left == null && root.right == null) return num;
    return calculateSum(root.left,num) + calculateSum(root.right,num);
}