// Time Complexity: O(n)
// Space Complexity: O(n) 
class Solution {
    public int sumNumbers(TreeNode root) {
        return add(root,0);
    }
    public static int add(TreeNode root,int sum){
      if(root==null){
        return 0;
      }
            sum=sum*10+root.val;
      if(root.left==null && root.right==null){
        return sum;
      }

    int  ls=add(root.left,sum);
     int rs=add(root.right,sum);
      return ls+rs;
    }
}