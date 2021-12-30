import  java.util.*;

public class PostorderInorder {

    public class TreeNode {
        int val;
        PostorderInorder.TreeNode left;
        PostorderInorder.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, PreorderInorder.TreeNode left, PreorderInorder.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        /*
        TC:O(n^2)
        SC:O(n^2)

        */
        if(postorder==null || postorder.length==0||inorder==null || inorder.length==0){
            return null;
        }

        int rootVal=postorder[postorder.length-1];
        TreeNode root=new TreeNode(rootVal);
        int rootIdx=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                rootIdx=i;
                break;
            }
        }

        int inLeft[]=Arrays.copyOfRange(inorder,0,rootIdx);
        int inRight[]=Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
        int postLeft[]=Arrays.copyOfRange(postorder,0,rootIdx);
        int postRight[]=Arrays.copyOfRange(postorder,rootIdx,postorder.length-1);

        root.left=buildTree1(inLeft,postLeft);
        root.right=buildTree1(inRight,postRight);
        return root;
    }

    /*
    *
    * Approach 2 :Optimized
    *
    * */

    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /*
        TC:O(n)
        SC:O(n)

        */
        if(postorder==null || postorder.length==0||inorder==null || inorder.length==0){
            return null;
        }

        idx=postorder.length-1;
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,inorder.length-1);
    }

    private TreeNode helper(int postorder[],int start,int end) {
        if (start > end) {
            return null;
        }

        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);


        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);

        return root;
    }
}
