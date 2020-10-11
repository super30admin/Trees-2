# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        def helper(left, right):
            if left > right:
                return None
            
            root_val = postorder.pop()
            root = TreeNode(root_val)
            
            index = imap[root_val]
            
            root.right = helper(index+1, right)
            root.left = helper(left, index-1)
            return root
        
        imap = {val:idx for idx,val in enumerate(inorder)}
        # for idx, val in enumerate(inorder):
        #     imap[val] = idx
        return helper(0, len(inorder)-1)
