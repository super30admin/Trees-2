//Time Complexity O(n)
//Space Complexity O(n)
//Leetcode tested

import java.util.HashMap;
import java.util.Map;

public class ConstructFromPostOrder {
    int[] inOrder;
    int[] postOrder;
    Map<Integer,Integer> hm = new HashMap<>();
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrder=inorder;
        postOrder=postorder;
        int n = inorder.length;
        index=n-1;

        for (int i = 0; i < n; i++) {
            hm.put(inorder[i],i);
        }
        TreeNode root = dfs(0,n-1);
        return root;
    }
    public TreeNode dfs(int s,int e){
        if(s>e) return null;
        int curVal= postOrder[index--];
        TreeNode cur = new TreeNode(curVal);
        int mid = hm.get(curVal);
        cur.right = dfs(mid+1,e);
        cur.left = dfs(s,mid-1);

        return cur;
    }
}
