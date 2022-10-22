#Time-Complexity: O(n)
#Space-Complexity: O(n^2)
#Ran on Leetcode: Yes

class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        dic = {}
        
        for idx, val in enumerate(inorder):
            dic[val] = idx
        
        def f(start, end):
            if start > end:
                return None
            node = TreeNode(postorder.pop())
            index = dic[node.val]
            node.right = f(index+1, end)
            node.left = f(start, index-1)
            return node

        return f(0, len(inorder)-1)