//Run on Leetcode? No Still WIP

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
 
        if(root == null)
            return null;
        
               int Countsum=0;
        List <List<Integer>> ret = new ArrayList<>();
         List <Integer> path = new ArrayList<>();
        Stack <TreeNode>stack = new Stack();
        TreeNode cur = root;
        TreeNode pre = null;
        
        stack.push(root);
        path.add(root.val);
        Countsum = root.val;
        
        while(!stack.isEmpty() || cur!=null)
        {
        
            while(cur!=null)
            {
        stack.push(cur);
        path.add(cur.val);
        cur = cur.left; 
        Countsum = root.val;
            }
            
            cur = stack.peek();
            if(cur.right!=null && cur.right!=pre)
            {
                cur = cur.right;
                continue;
            }
        if(root.right==null && root.left==null && sum==Countsum)
        {
            ret.add(path);
        }
            
            pre=cur;
            stack.pop();
            path.remove(path.size()-1);
            Countsum-=cur.val;
            cur=null;
    }
        return ret;
    }
}
