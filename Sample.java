//Problem 1: Inorder/Postorder to Binary Tree
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : right-> left recursive call flow. but got the issue


// Your code here along with comments explaining your approach
class Solution {
    // int idx;
    // HashMap<Integer, Integer> map;
    // public TreeNode buildTree(int[] inorder, int[] postorder) {
    //     if(inorder.length == 0){
    //         return null;
    //     }
    //     map = new HashMap<>();
    //     for(int i=0; i<inorder.length; i++){ //storing inorder in hashmap for O(1) search
    //         map.put(inorder[i], i);
    //     }
    //     idx = postorder.length-1; //last element of postorder will be root (left->right->root)
    //     return helper( postorder, 0, inorder.length-1, 0);       //recursive call  
    // }

    // private TreeNode helper(int[] postorder, int start, int end, int rootIdx){
    //     //base case
    //     if(start > end){
    //         return null;
    //     }
    //     //recurse
    //     int rootVal = postorder[idx];
    //     idx--; //next last element will be next root(basically right)
    //     rootIdx = map.get(rootVal);
    //     TreeNode root = new TreeNode(rootVal); //creating root
    //     root.right = helper(postorder, rootIdx+1, end, rootIdx); //left subtree recursive call
    //     root.left = helper( postorder, start, rootIdx-1, rootIdx); //right subtree recursive call
    //     return root;
    // }

    int idx;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null) return null;
        this.idx=postorder.length-1;
        this.map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(postorder, 0, inorder.length-1, 0);
    }

    private TreeNode helper(int[] postorder, int start, int end, int rootIdx){
        if(start>end) return null;

        int rootVal= postorder[idx--];
        TreeNode root= new TreeNode(rootVal);
        rootIdx=map.get(rootVal);
        root.right=helper(postorder,rootIdx+1, end, rootIdx);
        root.left=helper(postorder, start, rootIdx-1, rootIdx);
        return root;
    }
}

//Problem 2: Sum Root to Leaf Numbers
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no problem


// Your code here along with comments explaining your approach
class Solution {
    int result;
    //void based recursion
    // public int sumNumbers(TreeNode root) {
    //     helper(root, 0);
    //     return result;
    // }

    // private void helper(TreeNode root, int currNum){
    //     if(root==null) return;

    //     currNum=currNum*10+root.val;

    //     if(root.left==null && root.right==null)
    //         result+=currNum;
        
    //     helper(root.left, currNum);
    //     helper(root.right,currNum);

    // }

    //simple changes
    // public int sumNumbers(TreeNode root) {
    //     helper(root, 0);
    //     return result;
    // }

    // private void helper(TreeNode root, int currNum){
    //     if(root==null) return;

    //     if(root.left==null && root.right==null)
    //         result+=currNum*10 +root.val;
        
    //     helper(root.left, currNum*10 +root.val);
    //     helper(root.right,currNum*10 +root.val);
    // }

    //int based recursion
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int currNum){
        if(root==null) return 0;//base logic
        currNum=currNum*10 + root.val; //creating curNum according to question condition
        if(root.left==null && root.right==null) //leaf node
            return currNum;
        
        int left= helper(root.left, currNum); //calculate sum of leftSubTree
        int right= helper(root.right,currNum); // calculate sum of right SubTree
        return left+right; //any given nodeSum is sum of left+right
    }
}