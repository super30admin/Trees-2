// Time Complexity : O(N) O(N) for hashmap and O(N) for recursive visting of nodes which is equal to O(N)
// Space Complexity : O(N) if we dont consider the stack for recursive calls and take only the hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve prior to the class


// Your code here along with comments explaining your approach
//Use hashmap, right and left sizes to manipulate each side

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        //map values and index in inorder to find the rootValue
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return buildTree(inorder, 0, postorder, 0, postorder.length, map);
    }
    
    private TreeNode buildTree(int[] inorder, int i, int[] postorder, int p, int size, HashMap<Integer, Integer> map){
        
        if(size == 0) return null;
        
        if(size == 1) return new TreeNode(postorder[p]);
        
        //find the root from preorder last element
        int rootValue = postorder[p+size-1];
        
        TreeNode root = new TreeNode(rootValue);
        
        //find the corresponding index from inorder
        int rootIndex = map.get(rootValue);
        
        //find the sizes of left and right side (end - start + 1)
        int leftSize = rootIndex -1 - i + 1;
        int rightSize = size - (leftSize + 1);  
        
        root.left = buildTree(inorder, i, postorder, p, leftSize, map);
        root.right = buildTree(inorder, rootIndex+1, postorder, p + leftSize, rightSize, map);
        
        return root;
    }
}