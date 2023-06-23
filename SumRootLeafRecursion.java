public class SumRootLeafRecursion {

    //global variable
    int sumTotal;

    public int sumNum(TreeNode root){

        //call sum method
        sum(root, 0);

        //output
        return sumTotal;

    }

    public void sum(TreeNode root, int currSum){

        //base case, retract if root is null
        if(root == null) return;

        // updating currSum
        currSum = currSum*10 + root.val;

        // if a leaf is reached, add sum to result
        if(root.left == null && root.right == null){

            sumTotal += currSum;
        }

        //traversing left and right subtrees
        sum(root.left, currSum);
        //st.pop() and currSum is updated

        sum(root.right, currSum);
        //st.pop() and currSum is updated
    }


}
