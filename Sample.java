// Time Complexity :O(N)
// Space Complexity :O(1)+ recursion stack.
// Did this code successfully run on Leetcode :Yes.
// Any problem you faced while coding this :Nope.


// Your code here along with comments explaining your approach
class Solution2 {
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }
    public int sum(TreeNode root, int sum){
        if(null == root){return 0;}	// base case
        sum = ((sum*10) + root.val);
        if(null == root.left && null == root.right){return sum;}
        return sum(root.left,sum) + sum(root.right,sum);
    }
}

//Time Complexity :O(N)
//Space Complexity :O(1)+ recursion stack.
//Did this code successfully run on Leetcode :Yes.
//Any problem you faced while coding this :Yes, I tried to solve the problem like it was solved yesterday. But was unable to stop the edge case.


//Your code here along with comments explaining your approach

class Solution1 {
    int index = -1;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        index = postorder.length-1;
        return buildTree(inorder,postorder,map,0,inorder.length-1);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder, Map<Integer,Integer> map, int start, int end) {
        if(start > end){return null;}
        TreeNode root = new TreeNode(postorder[index]);
        int i = map.get(postorder[index]);
        index--;
        root.right = buildTree(inorder,postorder,map,i+1,end);
        root.left = buildTree(inorder,postorder,map,start,i-1);
        return root;
    }
}

/*
 * class Solution1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildTree(inorder,postorder,map);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder, Map<Integer,Integer> map) {
        if(null == postorder || 0 == postorder.length || null == inorder || 0 == inorder.length){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        if(1 != postorder.length){
            int index = map.get(postorder[postorder.length-1]);
            int[] leftIn = Arrays.copyOfRange(inorder,0,index); 
            int[] rightIn = (index<inorder.length)?Arrays.copyOfRange(inorder,index+1,inorder.length):new int[0];
            int[] leftPost = Arrays.copyOfRange(postorder,0,index);
            int[] rightPost = (index<inorder.length)?Arrays.copyOfRange(postorder,index,postorder.length-1):new int[0];
            root.left = buildTree(leftIn,leftPost,map);
            root.right = buildTree(rightIn,rightPost,map);
        }
        return root;
    }
}
 * 
 */