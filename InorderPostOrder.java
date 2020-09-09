// Time Complexity : O(T(n/2)+n)where N/2 is because we are dividing and n because of the for loop which is O(n)(Masters Theorm) 
// Space Complexity : O(h) where h is the height of the tree which is the recursion call 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// we use a recursive approach where our base case is if post/inorder null(return null for this which can be used in root.left or root.right of subtree in case if they are null)
//if not  here we know that the last element of postorder of any subprob will give me the current root.
// create a new node ROOT with val as the val of the last element in preorder(root) 
// we find that value in the inorder(say at idx,this is where our root is present for inorder)  and break into right(exclude root) and left subarray(exclude root)
// at that idx we break our postorder as well into left(start from 0 till idx since last is root) and right subarray(from i to second last.. since our last is root)
// for root.left,we will  buildtree(postleft and inleft)(subprob) similarly for the root.right(subprob)
// return the new root created

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return null;

        // last element
        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);

        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == val)
                break;
        }
        int postLeft[] = Arrays.copyOfRange(postorder, 0, i);
        int postRight[] = Arrays.copyOfRange(postorder, i, postorder.length - 1);

        int inLeft[] = Arrays.copyOfRange(inorder, 0, i);
        int inRight[] = Arrays.copyOfRange(inorder, i + 1, inorder.length);

        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        return root;

    }
}