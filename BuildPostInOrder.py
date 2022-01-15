# Time Complexity : O(N)
# Space Complexity : O(H) ~> Recursio Stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

'''Recursive Solution
1. In Post Order. We have access to the elements of the right subtree before the left subtree. 
2. Hence, our recursive call should build the right before the left.
'''

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:        
        d = {}
        for i in range(len(inorder)):
            d[inorder[i]] = i

        def recur(left, right):
            if left > right:
                return None
            
            currVal = postorder.pop()
            currNode = TreeNode(currVal)
            
            mid = d[currVal]
            
            currNode.right = recur(mid + 1, right)
            currNode.left = recur(left, mid - 1)
            return currNode

        return recur(0, len(inorder) - 1)

