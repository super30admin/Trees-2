import java.util.Arrays;
import java.util.HashMap;
// Time Complexity : O(n)
// Space Complexity : O(n)
public class Problem106 {
    int idx;
    HashMap<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        if(postorder.length == 0){
            return null;
        }
        idx = postorder.length - 1;
        for(int i = 0; i < inorder.length ; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int begin, int end){
        if(begin > end){
            return null;
        }

        TreeNode root = new TreeNode(postorder[idx]);
        int rootIdx = inorderMap.get(root.val);
        idx--;

        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, begin, rootIdx - 1);
        return root;
    }

    public static void main(String[] args) {
        Problem106 problem=new Problem106();
        problem.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        problem.buildTreeRecursive(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});

    }

    public TreeNode buildTreeRecursive(int[] inorder, int[] postorder) {
        if(postorder.length==0)
            return null;
        int pLength=postorder.length;
        int iLength=inorder.length;
        int rootVal=postorder[pLength-1];
        int rootIdx=-1;

        TreeNode root=new TreeNode(rootVal);
        for(int i=0;i<iLength;i++){
            if(rootVal==inorder[i]){
                rootIdx=i;
                break;
            }
        }
        int[] inLeft= Arrays.copyOfRange(inorder,0,rootIdx);
        int[] inRight=Arrays.copyOfRange(inorder,rootIdx+1,iLength);
        int[] postLeft=Arrays.copyOfRange(postorder,0,inLeft.length);
        int[] postRight=Arrays.copyOfRange(postorder,inLeft.length,pLength-1);

        root.left=buildTreeRecursive(inLeft,postLeft);
        root.right=buildTreeRecursive(inRight,postRight);
        return root;
    }
}
