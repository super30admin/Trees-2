#recursion TC & SC - O(n^2)

# optimize --> hashmap TC & SC - O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        def helper(low,high):
            nonlocal idx
            if low > high:
                return None
            val = postorder[idx]
            idx -= 1
            
            root = TreeNode(val)
            mid = inorderMap[val]
            
            root.right = helper(mid+1,high)
            root.left = helper(low,mid-1)
            return root
        
        inorderMap = {}
        for idx,val in enumerate(inorder):
            inorderMap[val] = idx
        idx = len(inorder) - 1
        return helper(0,len(inorder)-1)




#recursion TC & SC - O(n^2)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not postorder or not inorder:
            return None
        
        val = postorder[-1]
        root = TreeNode(val)
        idx = inorder.index(val) #O(n)
        
        root.left = self.buildTree(inorder[:idx],postorder[:idx]) #O(n)
        root.right = self.buildTree(inorder[idx+1:],postorder[idx:-1]) #O(n)
        
        return root