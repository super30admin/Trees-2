import java.util.HashMap;

//T.C  : O(n)
//S.C : O(n)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
public class Problem1 {


    public class TreeNode {
        int val;
        Problem2.TreeNode left;
        Problem2.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Problem2.TreeNode left, Problem2.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int idx;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return Helper(preorder , 0, inorder.length-1);


    }
    private TreeNode Helper( int[] preorder ,int start,int end){

        if(start>end){
            return null;
        }

        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal);
        root.left = Helper(preorder,start,rootIdx-1);
        root.right=Helper(preorder,rootIdx+1,end);
        return root;
    }
}
