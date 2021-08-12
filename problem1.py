#construct binary tree from inorder and postorder traversal
#leetcode solutin accepted
# time complexity: O(n) where n is the nodes
#space compleixty : O(2n)->O(n)
#testing if working

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
   
        map_inorder = {} #initializing dict
        for i, val in enumerate(inorder): map_inorder[val] = i
        def recur(low, high): #helper function for recursion
            if low > high: return None
            x = TreeNode(postorder.pop())
            mid = map_inorder[x.val]
            x.right = recur(mid+1, high)
            x.left = recur(low, mid-1)
            return x
        return recur(0, len(inorder)-1)
