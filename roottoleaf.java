/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// time: O(n)
// space : O(n)
import javafx.util.Pair;
// through bfs we ading values and when we reach leaf, we return sum
class Solution {
    public int sumNumbers(TreeNode root) {
        int sum=0;
        if(root==null) return sum;
        Queue<Pair<TreeNode,Integer>> queue=new LinkedList<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty())
        {
            Pair<TreeNode,Integer> p=queue.poll();
            TreeNode curr=p.getKey();
            int val=p.getValue();
            if(curr!=null)
            {
                if(curr.left==null && curr.right==null)
                {
                    sum+=10*val+curr.val;
                }
                queue.add(new Pair(curr.left,10*val+curr.val));
                queue.add(new Pair(curr.right,10*val+curr.val));
            }
        }
        return sum;
    }
}