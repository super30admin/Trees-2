package s30.trees.trees2;

import s30.trees.TreeNode;


//Time Complexity : O(n) n = number of nodes.
//Space Complexity: O(h) h = height of the tree.
public class SumRootToLeaf {

    public int sumNumbers(TreeNode root) {

        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int currNumber){

        //base
        if(node == null) return -1;


        currNumber = (currNumber * 10) + node.val;

        //recurse
        int left =  sumNumbers(node.left, currNumber);
        int right = sumNumbers(node.right, currNumber);

        if(left==-1  && right ==-1) return currNumber;
        if(left==-1) return right;
        if(right ==-1) return left;


        return left + right;

    }

    public static void main(String[] args) {

    }
}
