/*
Time complexity : O(N) - where N is the length of the Inorder/Postorder list
Space complexity : O(N) - where N is the length of the Inorder list
*/

class Solution {
    int postorderindex;
    Map<Integer,Integer> map=new HashMap<>();
    int[] postorder;
    int[] inorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder=postorder;
        this.inorder=inorder;
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        postorderindex=postorder.length-1;
        TreeNode root=gettree(0,inorder.length-1);
        return root;
    }
    
    TreeNode gettree(int start, int end)
    {
        if(start>end)
            return null;
        TreeNode curr=new TreeNode(postorder[postorderindex--]);
        int index=map.get(curr.val);
        curr.right=gettree(index+1,end);
        curr.left=gettree(start,index-1);
        return curr;
    }
}
