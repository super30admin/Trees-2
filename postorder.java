//Run on LeetCode? Yes
//Time Complexity: O(n)
//Space Complexity:😲(n)
//Take the last node of postorder as new root
//While pp.length -1 to 0 : find the root in inorder and divide accordingly
//Keep pushing data into stack as everything as they are root heads
//Add node to right as prev!=null
//If it is null add to left
//Since in LNR right is encountered first do prev == null in the end
 
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
public TreeNode buildTree(int[] inorder, int[] postorder) {
if(inorder.length ==0 || postorder.length==0)
return null;
 
int pp = postorder.length -1;
int ip = inorder.length -1;
 
Stack<TreeNode> stack = new Stack();
 
TreeNode prev = null;
 
TreeNode root = new TreeNode(postorder[pp]);
 
stack.push(root);
 
pp--;
 
while(pp>=0)
{
while(!stack.isEmpty() && inorder[ip]==stack.peek().val)
{
prev = stack.pop(); //This is the root node
ip--; //Check others as leaf node
}
 
TreeNode newNode = new TreeNode(postorder[pp]); //keep pushing nodes till we reach right node
 
if(prev!=null)
{
prev.left = newNode; //prev is a root node
}
else if(!stack.isEmpty())
{
TreeNode currTop = stack.peek();
currTop.right = newNode;
}
 
prev =null;
stack.push(newNode);
pp--;
 
 
}
 
return root;
}
}
