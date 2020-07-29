Executed in leetcode - Yes
Time Complexity-o(n)
 space complexity - o(n) for recursive stack

class Solution {
    public int sumNumbers(TreeNode root) {
             preOrderTraversalSum(root,calValue);
        return totalSum;
    }
    
     int calValue=0,totalSum=0;
    void preOrderTraversalSum(TreeNode node,int calValue){
        if(node==null) return;
        
        //  process  Node
        //Identify leaf and get the sum value
        if(node.left==null && node.right==null){
            totalSum+= calValue*10+node.val;
        }else{
            calValue=calValue*10+node.val;
        }
        preOrderTraversalSum(node.left,calValue);
        preOrderTraversalSum(node.right,calValue);
    }
}
