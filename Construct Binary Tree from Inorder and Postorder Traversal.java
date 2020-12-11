/*
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if inorder is None or len(inorder) == 0:
            return None
        
        self.idx = len(inorder) - 1
        self.map = {}
        
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
            
        return self.helper(postorder, inorder, 0, len(inorder)-1)
    
    def helper(self, postorder, inorder, start, end):
        if start > end:
            return None
        
        rootVal = postorder[self.idx]
        self.idx -= 1
        root = TreeNode(rootVal)
        rootIdx = self.map[rootVal]
        
        root.right = self.helper(postorder, inorder, rootIdx+1, end)
        root.left = self.helper(postorder, inorder, start, rootIdx-1)
        
        return root
*/

// Time Complexity : O(n) where n is height of tree which could be all nodes if tree is right or left skewed
// Space Complexity : O(n) because of hashmap
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Postorder will give us information about root and from inorder we can
// construct tree by maintaining start and end pointers

class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0){
            return null;
        }
        idx = inorder.length - 1;
        map = new HashMap<>();
        for (int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] postorder, int[] inorder, int start, int end){
        if (start > end){
            return null;
        }
        
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        
        root.right = helper(postorder, inorder, rootIdx+1, end);
        root.left = helper(postorder, inorder, start, rootIdx-1);
        
        return root;
    }
}
