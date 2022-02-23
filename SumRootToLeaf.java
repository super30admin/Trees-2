/*
Time Complexity: O(N)
Space Complexity: O(N)
Run on leetcode: yes
Any difficulties: no

Approach:
1. Recursively tracking all the values from the root to leaf and will make it a number
 */
public class SumRootToLeaf {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static int sumRootToLeafNumbers(TreeNode root){
        if(root == null){
            return 0;
        }
        return recurseTree(root,0,0 );
    }
    public static int recurseTree(TreeNode node, int num, int sum){
        if(node == null){
            return sum;
        }

        num = num*10+node.val;
        if(node.left == null && node.right == null){
            sum+=num;
            return sum;
        }
        sum = recurseTree(node.left, num, sum)+ recurseTree(node.right, num, sum);
        return sum;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Sum from root to leaf: "+ sumRootToLeafNumbers(root));
    }
}
