// Time Complexity :O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root==null)return 0;
        int num=0;
        int sum=0;
        Stack<TreeNode> s=new Stack<>();
        Stack<Integer> nums=new Stack<>();
        while(root!=null || !s.isEmpty()){
            while(root!=null){
                s.push(root);
                num=num*10+root.val;
                nums.push(num);
                root=root.left;
            }
            root=s.pop();
            num=nums.pop();
            if(root.left == null && root.right==null){
                sum=sum+num;
            }
            root=root.right;
        }
        return sum;
    }
}