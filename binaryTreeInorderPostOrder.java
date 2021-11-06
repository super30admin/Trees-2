// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    int p;
       public TreeNode buildTree(int[] inorder, int[] postorder) {
           p=postorder.length-1;
           HashMap<Integer,Integer> map=new HashMap<>();
           for(int i=0;i<inorder.length;i++){
               map.put(inorder[i],i);
           }
           return helper(postorder,0,postorder.length-1,map);
       }

       public TreeNode helper(int[] postorder, int start,int end,HashMap<Integer,Integer> map){
           if(start>end){
               return null;
           }

           TreeNode root=new TreeNode(postorder[p]);
           int inorderIndex=map.get(root.val);
           int count=end-inorderIndex;
           p--;
           root.right=helper(postorder,inorderIndex+1,end,map);
           root.left=helper(postorder,start,inorderIndex-1,map);

           return root;
       }
}