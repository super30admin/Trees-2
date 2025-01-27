public class Problem1 {
    // Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

    //The approach is same as preorder and inorder the diff is how the traversal is in post order its L-R-Root -> so we'll start from end index and go index-- and then right recursive call and then left
    HashMap<Integer,Integer> inOrderMap;
    int postOrderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder== null ||inorder.length == 0|| postorder.length ==0){
            return null;
        }
        postOrderIdx = postorder.length-1;
        inOrderMap = new HashMap<>();
        for(int i =0 ; i< inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }

        return createTree(postorder,0,inorder.length-1);
    }

    private TreeNode createTree(int[] postorder, int start, int end){
        //base
        if(start>end){
            return null;
        }
        //logic
        int rootVal = postorder[postOrderIdx];
        postOrderIdx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inOrderMap.get(rootVal);

        root.right = createTree(postorder,rootIdx+1,end);
        root.left = createTree(postorder,start,rootIdx-1);
        return root;
    }
}
