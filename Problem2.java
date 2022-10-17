// Time Complexity : O(N), n is the number of nodes
// Space Complexity : O(h) //h is the height of tree in the stack
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
//Time and space would be same for both the approaches
/**
 *
 * In the iterative approach, we are creating two stacks one for the treenode and the other for maintianing the current sum value
 * first we are pushing the left node to the stack, add the value to the current sum and then moving towards the right side.
 * We will be moving to the right side only when we encounter a leaf node
 *
 */


/**
 * In the recursive approach, we are pushing each node with the current running sum and when we will encounter a leaf node
 * our current running sum would be added to our result. Commented approach is the recursive approach.
 */

/*int result;

public int sumNumbers(TreeNode root) {

        //passing root and initially current number would be 0
        helper(root, 0);

        return result;
        }

private void helper(TreeNode root, int curr){


        //base case
        if(root==null) return;

        curr = curr*10 + root.val;

        //logic
        if(root.left==null && root.right==null){

        result +=curr; //pushing number along with current running sum
        }


        helper(root.left, curr);

        helper(root.right, curr);

        } */


class Problem2 {


    public int sumNumbers(TreeNode root) {

        //taking two stacks to 1:1 mapping
        //one to store the treenode
        Stack<TreeNode> st1 = new Stack<>();

        //other stack to store the current sum
        Stack<Integer> st2 = new Stack<>();

        int currSum = 0;
        int result =0;

        //will go till leaf end or till the stack is not empty
        while(root!=null || !st1.isEmpty()){

            while(root!=null){
                currSum = currSum*10 + root.val;
                //pushing root to stack and currSum to number stack
                st1.push(root);
                st2.push(currSum);
                //updating the root
                root = root.left;

            }

            //POP will happen when left call is over
            root = st1.pop();

            currSum = st2.pop();

            //will add currSum to result if leaf node
            if(root.left ==null && root.right==null ){

                result += currSum;
            }

            //move to right
            root = root.right;
        }

        return result;

    }
}