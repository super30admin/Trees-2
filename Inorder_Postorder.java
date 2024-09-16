// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     int n = postorder.length;
        index=n-1;
        if(n==0)return null;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(0,n-1,postorder,map);
    }
    
   public TreeNode helper(int min, int max, int[] postorder, Map<Integer,Integer> map){
       if(min>max||index>=postorder.length)return null;
       TreeNode root = null;
       int nodeIndex = map.get(postorder[index]);
       if(nodeIndex<=max && nodeIndex>=min){
           root=new TreeNode(postorder[index]);
           index--;
           root.right = helper(nodeIndex+1,max,postorder,map);
           root.left = helper(min,nodeIndex-1,postorder,map);
       }
       return root;
   }
}