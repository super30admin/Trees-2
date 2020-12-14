'''
Time complexity :O(N)
Space complexity :0(N)
'''


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder, postorder) -> TreeNode:
        def helper(in_left, in_right):
            if in_left > in_right:
                return None
            
            val = postorder.pop()
            root = TreeNode(val)
            index = idx_map[val]
            root.right = helper(index + 1, in_right)
            root.left = helper(in_left, index - 1)
            return root
        
        idx_map = {val:idx for idx, val in enumerate(inorder)} 
        return helper(0, len(inorder) - 1)