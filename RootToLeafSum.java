class Solution {
    int sum=0;
    TreeNode prev;
    ArrayList<Integer> ll;
    public int sumNumbers(TreeNode root) {
        ll= new ArrayList<>();
        int index=0;
        prev= null;
        treeSum(root, 0);
        return sum;
    }
     public boolean treeSum(TreeNode root, int num){
         if(root== null) return true;
         if(root.right==null  && root.left==null){
             sum+=num*10+root.val;
         }
         boolean left= treeSum(root.left, num*10+root.val);
         prev=root;
         boolean right = treeSum(root.right, num*10+root.val);
         return left&& right;
     }
}
//Time complexity- O(n)
//Space Complexity- O(h) where h is the height of the tree