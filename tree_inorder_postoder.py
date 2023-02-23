# Author: Naveen US
# Title: Construct Binary Tree from Inorder and Postorder Traversal


# Time complexity: O(n)
# Space complexity: O(n)
# Did the code run on leetcode: Yes
      
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        map_inorder = {}
        for i, val in enumerate(inorder): map_inorder[val] = i
        def recur(low, high):
            if low > high: return None
            x = TreeNode(postorder.pop())
            mid = map_inorder[x.val]
            x.right = recur(mid+1, high)
            x.left = recur(low, mid-1)
            return x
        return recur(0, len(inorder)-1)
