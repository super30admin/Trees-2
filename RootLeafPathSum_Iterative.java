import java.util.Stack;

public class RootLeafPathSum_Iterative {

    //ITERATIVE

        public int sumNumbers(TreeNode root) {

            Stack<TreeNode> rootSt = new Stack<>();
            Stack<Integer> currSumSt = new Stack<>();

            int currSum = 0;
            int result = 0;

            while(root != null || !rootSt.isEmpty()){

                while(root != null){

                    // update currSum
                    currSum = currSum*10 + root.val;

                    // add roots, currSums to stacks
                    rootSt.push(root);
                    currSumSt.push(currSum);

                    // go left for roots
                    root = root.left;
                }
                //if null end at Left is reached, pop from stacks
                root = rootSt.pop();

                currSum = currSumSt.pop();

                //leaf node
                if(root.left == null && root.right == null){

                    // add currSum at leaf to result
                    result += currSum;
                }
                //Once leaf in LST is reached, go right
                root = root.right;

            }
            return result ;
        }


/*
Time Complexity = O(n)
Space Complexity = O(n)
*/

}
