/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {

        StringBuilder sb = new StringBuilder();
       // sb.append(root.val);
        dfs(root, sb);
        return sum;
    }

    public void dfs(TreeNode root, StringBuilder number){
        
        number.append(root.val);
        //base cases
        System.out.println(number);

        if(root.left == null && root.right == null){

            sum += Integer.parseInt(number.toString());
            number.deleteCharAt(number.length() - 1);
            System.out.println("sum:"+sum);
            return;
        }
        

        

        if(root.left != null){
            dfs(root.left, number);
        }

        

        

        System.out.println(number);

        if(root.right != null){
            dfs(root.right, number);
        }

        number.deleteCharAt(number.length() - 1);


        

    }
}