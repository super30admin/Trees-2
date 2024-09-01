# Trees-2

## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(inorder) == 0 or len(postorder) == 0:
            return None
        inorderMap={}
        for i in range(len(inorder)):
            inorderMap[inorder[i]]=i

        def helper(l,r):
            if l> r:
                return None
            root=TreeNode(postorder.pop())
            idx=inorderMap[root.val]
            root.right=helper(idx+1,r)
            root.left=helper(l,idx-1)

            return root
        root=helper(0,len(inorderMap)-1)
        return root

#TC = O(n), SC = O(n)


## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
   
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        stack = []
        num = []
        result = 0
        currNum = 0
        while root != None or len(stack) > 0:
            while root != None:
                stack.append(root)
                currNum = currNum * 10 + root.val
                num.append(currNum)
                root = root.left
            root = stack.pop()
            currNum = num.pop()
            if root.left == None and root.right == None:
                result = result + currNum
            root = root.right
        return result
#TC = O(n), SC = O(n)