// Time Complexity : O(N) N=number of elements  in  the TREE. 
// Space Complexity : O(N)  extra space used for storing in order values and indexes + recursion stack max(Depth).

// Any problem you faced while coding this :


// we traverse the tree recursively from right then after right is completed we traverse  left, 
//this order is to create the correct tree given the post order array.  .
// .
//Success
//Details 
//Runtime: 3 ms, faster than 46.91% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
//Memory Usage: 42.5 MB, less than 14.54% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal
   int postInd = -1;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // base case
        if (inorder == null ||inorder.length == 0 ||
                postorder==null || postorder.length==0) return null;
        // build root;
        postInd=postorder.length-1;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=recBuildTree(inorder, postorder,0,postorder.length-1,map);
        return root;
    }
    private TreeNode recBuildTree(int[] inOrder,int[] postOrder,int startInd,int endInd,Map<Integer,Integer> map){
        //base case
        if (postInd<0 || startInd>endInd)
            return null;
        TreeNode root=new TreeNode(postOrder[postInd--]);
        int index=map.get(root.val);
        root.right=recBuildTree(inOrder,postOrder,index+1,endInd,map);
        root.left=recBuildTree(inOrder,postOrder,startInd,index-1,map);
        return root;
    }
	
	
	
	
	//another solution
	
	class Solution {
     class Index{
        int index;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       if (inorder==null||postorder==null)
           return null;
       if (inorder.length!=postorder.length)
           return null;
       return buildTreeHelper(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart,int postEnd) {
       if (inStart>inEnd || postStart > postEnd)
          return null;

       TreeNode node = new TreeNode(postorder[postEnd]);

       if (inStart==inEnd)
           return node;

        int mid=findMid(inorder,inStart,inEnd,node.val);
        node.left=buildTreeHelper(inorder,postorder,inStart,mid-1,postStart,postStart+mid-(inStart+1));
        node.right=buildTreeHelper(inorder,postorder,mid+1,inEnd,postStart + mid - inStart,postEnd-1);
        return node;
    }

    private int findMid(int[] inorder, int startIn, int endIn, int key) {
       int i=0;
       for ( i = startIn; i <= endIn; i++) {
           if (inorder[i] == key) {
              break;
           }
        }
        return i;
    }
}