//TC : O(n)
//TC: O(h) // height of tree
// works in leetcode
public class SumRootToLeaf {
    public static  int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private static int sumNumbers(TreeNode node, int pathSum){

        //base condition
        if(node==null){
            return 0;
        }
        pathSum = pathSum*10 + node.val;

        //if leaf return pathsum
        if(node.left==null && node.right==null){
            return pathSum;
        }

        return sumNumbers(node.left, pathSum)+ sumNumbers(node.right, pathSum);
    }

    public static void main(String [] args){

        TreeNode leaf1 = new TreeNode(0, null,null);
        TreeNode leaf2 = new TreeNode(5, null,null);
        TreeNode leaf3 = new TreeNode(1, null,null);

        TreeNode node1 = new TreeNode(9, leaf2, leaf3);
        TreeNode root = new TreeNode(4,node1,leaf1);

        System.out.println(sumNumbers(root));
    }
}
