//Time Complexity: O(n^2)
//Space Complexity: O(n)with recursive stack 
//Did it run on leetcode: yes
//Problems faced any: No


public class Problem45 {

    public int output=0;
    public int sumNumbers(TreeNode root) {

        findSum(root, 0);
        return output;
    }

    public void findSum(TreeNode node, int prev){
        if(node==null)
            return;

        int curr = prev*10 + node.val;

        //the below code means we are at the leaf node so we need to add this sum to the output
        if(node.left==null && node.right==null){
            output += curr;
            return;
        }

        //find sum on left and right paths
        findSum(node.left, curr);
        findSum(node.right, curr);


    }
}