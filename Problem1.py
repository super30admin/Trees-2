# Time Complexity: O(n)
# Space Complexity: O(n)
# Works on leetcode: yes
# Approach: We pop the last element from postorder and convert it into root. We use the root.val to find the index to split
# inorder in 2 parts and recursively find root.left and root.right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        mapping = {val:i for i,val in enumerate(inorder)}
        
        return self.helper(0, len(inorder)-1,  postorder, mapping)
    
    def helper(self,low,high, postorder, mapping):
        if high<low:
            return None
        root = TreeNode(postorder.pop())
        ind = mapping[root.val]
        root.right = self.helper(ind+1,high, postorder, mapping)
        root.left = self.helper(low, ind-1, postorder, mapping)
        return root
        