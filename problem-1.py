#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(postorder) == 0:
            return None
        # last element of postorder is the root
        root = TreeNode(postorder[-1])
        # find left hand side of inorder
        middle = 0
        while inorder[middle] != root.val:
            middle += 1
        left_inorder = inorder[:middle]
        right_inorder = inorder[middle+1:]
        left_postorder = postorder[:middle]
        right_postorder = postorder[middle:-1]
        root.left = self.buildTree(left_inorder, left_postorder)
        root.right = self.buildTree(right_inorder, right_postorder)
        return root