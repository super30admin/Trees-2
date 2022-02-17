# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def recur(left, right):
            nonlocal posIdx
            if left > right:
                return None
            
            val = preorder[posIdx]
            posIdx += 1
            mid = d[val]
            newNode = TreeNode(val)
            
            newNode.left = recur(left, mid - 1)
            newNode.right = recur(mid + 1, right)
            
            return newNode

        d = {}
        posIdx = 0
        for i in range(len(inorder)):
            d[inorder[i]] = i
        return recur(0, len(inorder) - 1)