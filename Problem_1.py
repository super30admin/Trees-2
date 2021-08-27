# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:

    def __init__(self):
        self.hp = dict()
        self.idx = 0

    """
    TC - O(n^2)
    SC - O(n^2)
    """

    def approach1(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder == None or len(preorder) == 0:
            return None
        rootVal = preorder[0]
        root = TreeNode(rootVal)
        index = -1
        for i in range(len(inorder)):
            if rootVal == inorder[i]:
                index = i
                break
        inorderLeft = inorder[0:index]
        inorderRight = inorder[index + 1:]
        preorderLeft = preorder[1:index + 1]
        preorderRight = preorder[index + 1:]
        root.left = self.approach1(preorderLeft, inorderLeft)
        root.right = self.approach1(preorderRight, inorderRight)
        return root

    """
    TC - O(n)
    SC - O(n)
    """

    def approach2(self, preorder: List[int], inorder: List[int], start: int, end: int) -> Optional[TreeNode]:
        if start > end:
            return None

        rootVal = preorder[0]
        self.idx += 1
        root = TreeNode(rootVal)
        rootidx = self.hp[rootVal]
        root.left = self.approach2(preorder, inorder, start, rootidx - 1)
        root.right = self.approach2(preorder, inorder, rootidx + 1, end)
        return root

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder == None or len(preorder) == 0:
            return None
        for i in range(len(inorder)):
            self.hp[inorder[i]] = i
        return self.approach2(preorder, inorder, 0, len(preorder) - 1)
        # return self.approach1(preorder,inorder)
