//Run on LeetCode? Yes
//Time Complexity: O(n)
//Space Complexity:😲(1)
//Go through recursively left and right and keep adding the sums of left and right
//The sum at every node will be prev sum*10 +root.val(current val)
 
 
/**
* Definition for a binary tree node.
* public class TreeNode {
* int val;
* TreeNode left;
* TreeNode right;
* TreeNode(int x) { val = x; }
* }
*/
class Solution {
public int sumNumbers(TreeNode root) {
int sum= 0;
 
return findSum(root,sum);
 
}
 
public int findSum(TreeNode root,int sum)
{
if(root==null)
return 0;
 
if(root.left==null && root.right==null) return sum*10+root.val;
 
return findSum(root.left,sum*10+root.val) + findSum(root.right,sum*10+root.val);
 
}
}
 
