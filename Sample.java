// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Problem 1 105. Construct Binary Tree from Preorder and Inorder Traversal
//optimised solution using a hashmap
// Time complexity - O(n)
// Space complexity - O(1)
class Solution {
    int preIdx = 0;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        map = new HashMap<>();
        //save inorder node-indices in a map
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int startIdx, int endIdx){
        
       if(startIdx > endIdx) return null;
       
        int currval = preorder[preIdx++];
        TreeNode root = new TreeNode(currval);
        int idx = map.get(currval);
        
        root.left = helper(preorder, inorder, startIdx, idx - 1);
        root.right = helper(preorder, inorder, idx + 1,  endIdx);
            
        return root;
    }
    
    
}

// Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

// Approach 1: using BFS
// using BFS - Time complexity - O(n) space complexity - O(n)
class Solution {
    
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        HashMap<TreeNode, Integer> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parentMap.put(root, 0);
        queue.offer(root);
        
        int sum = 0;
        while(!queue.isEmpty()){
            int num = 0;
            TreeNode curr = queue.poll();
            num = parentMap.get(curr) * 10 + curr.val;
            
            //if leaf node
            if(curr.left == null && curr.right == null){
                sum += num;
            }else{
                if(curr.left != null){
                    parentMap.put(curr.left, num);
                    queue.offer(curr.left);
                }
                    
                if(curr.right != null){
                    parentMap.put(curr.right, num);
                    queue.offer(curr.right);
                }
            }
            
        }
        
        
        return sum;
    }
}

// Approach 2: using DFS - recursive
// using DFS recursive - Time complexity - O(n) space complexity - O(height of the tree)
class Solution {
    
    public int sumNumbers(TreeNode root) {
       return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int parentval){
        if(root == null)
            return 0;
        int num = 0;
        num = parentval * 10 + root.val;
        //Leaf node
        if(root.left == null && root.right == null){
            return parentval * 10 + root.val;
        }
        
        return dfs(root.left, num) + dfs(root.right, num);
    }
}
