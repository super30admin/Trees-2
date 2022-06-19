import java.util.HashMap;

//Time Complexity=O(n)
//Space COmplexity=O(n)
public class ConstructTreesPostAndInOrder {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(postorder==null || postorder.length==0){
            return null;
        }
        idx=postorder.length-1;
        map=new HashMap();
        for(int i=0;i<inorder.length;i++){

            map.put(inorder[i],i);
        }
        return helper(postorder,0,inorder.length-1);
    }
    public TreeNode helper(int[] postorder,int start,int end){

        if(start>end) return null;
        int rootVal=postorder[idx];
        // System.out.println(rootVal);
        System.out.println(idx);
        idx--;

        TreeNode root=new TreeNode(rootVal);
        int rootIndex=map.get(rootVal);
        root.right=helper(postorder,rootIndex+1,end);
        root.left=helper(postorder,start,rootIndex-1);


        return root;
    }
}
