# // Time Complexity :O(n) for node traversal
# // Space Complexity :O(n) for recusive stack space and hashmap
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
# we need to think right to left, so recursion right will happen before recursion left

# // Your code here along with comments explaining your approach

class Solution:
    def buildTree(self, inorder: list[int], postorder: list[int]) -> Optional[TreeNode]:
        inorderIdx = {j:i for i,j in enumerate(inorder)}
        
        def helper(start,end):

            if start > end:                     # pointer crosses end
                return None
            
            root = TreeNode(postorder.pop())    # pop bottom element of preorder since last element is node
            idx = inorderIdx[root.val]          # find popped value index in hashmap

            
            root.right = helper(idx+1,end)      # recursion right first then
            root.left = helper(start,idx-1)     # recursion left
            return root

        return helper(0,len(inorder)-1)