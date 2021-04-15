//Time Complexity : O(n);
//Space Complexity : O(n). O(n) for hashmap and O(h) for recursive stack. Here n > h hence the space complexity is O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
    int index;//index to get the index of the node from postorder array
    Map<Integer,Integer> map;// to get O(1) time for retriving the inorder index
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0||postorder==null){
            return null;
        }
        index = postorder.length-1;
        map = new HashMap<>();
        //add the inorder elements to map
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        //helper function to bulid the tree
        return helper(postorder,0,postorder.length-1);
    }
    
    private TreeNode helper(int postorder[],int start, int end){
        if(start>end){
            return null;
        }
        //get the root node from postorder
        TreeNode root = new TreeNode(postorder[index]);
        index--;
        //find this node's index in inorder
        int idx = map.get(root.val);
        //start with right child as the postorder contains root of suntrees starting from end
        //determine the node's left and right nodes
        root.right = helper(postorder,idx+1,end);
        root.left = helper(postorder,start,idx-1);
        
        return root;
    }
}