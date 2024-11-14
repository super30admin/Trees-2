// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
TC : O(N)
SC : O(H) where H can range from O(logN) for balanced tree and O(N) for skewed tree
 */
class Problem2 {
    int sum=0;
    public int sumNumbers(TreeNode root) {

        //helper(root,0);
        //return this.sum;
        return helperIntBased(root,0);
    }

    public void helper(TreeNode node,int currSum){
        if(node== null ){
            return ;
        }

        currSum = currSum*10 + node.val; //1

        if(node.left == null && node.right == null){
            //its a leaf node
            this.sum += currSum; //12


        }
        helper(node.left,currSum);
        helper(node.right,currSum);

    }

    public int helperIntBased(TreeNode node,int currSum){
        if(node== null ){
            return 0;
        }

        currSum = currSum*10 + node.val; //1

        if(node.left == null && node.right == null){
            //its a leaf node
            return currSum;


        }
        int left =  helperIntBased(node.left,currSum);
        int right =  helperIntBased(node.right,currSum);

        return left+right;

    }
}