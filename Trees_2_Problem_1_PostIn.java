//Time Complexity : O(n^2) (We can further reduce it by using a hashmap instead of finding the element in inorder array every time
//Space Complexity : O(n) (Height of the tree, in worst case would be n)
//Runs successfully on leetcode
//Problem : No problem

//Here we will be recursively calling the helper function to make the root node and its decendents (Same as preIn but indexes of postorder will be different)

public class Trees_2_Problem_1_PostIn {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return helper(postorder.length - 1,0,inorder.length-1,inorder,postorder);

    }
    public TreeNode helper(int postIndex, int inStart, int inEnd,int[] inorder,int[] postorder)
    {
        if(postIndex<0 || (inStart>inEnd))return null;

        TreeNode root = new TreeNode(postorder[postIndex]);
        int index = 0;
        for(int i = 0; i < inorder.length; i++)
        {
            if(inorder[i] == postorder[postIndex])
            {
                index = i;
                break;
            }
        }
        root.left = helper(postIndex - (inEnd - index + 1 ),inStart,index - 1,inorder,postorder);
        root.right= helper(postIndex-1, index + 1,inEnd,inorder,postorder);

        return root;

    }
}
