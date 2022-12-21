# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes

# Your code here along with comments explaining your approach: Traverse the IO list to store value and indec in dictionary for quick lookup. Identify the root node from PostOrder Tree.Then identify Left and Right bounds using the root value and recursively construct the tree


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    idx = 0

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        myMap = {}
        Solution.idx = len(postorder)-1
        if inorder == None or postorder == None or len(inorder) == 0:
            return None

        for i in range(len(inorder)):
            myMap[inorder[i]] = i

        return self.recurse(postorder, 0, len(inorder)-1, myMap)

    def recurse(self, postorder, start, end, indexMap):
        # base
        if start > end:
            return None

        rootVal = postorder[Solution.idx]
        root = TreeNode(rootVal)
        rootIdx = indexMap[rootVal]
        print(rootVal, root, rootIdx)
        Solution.idx -= 1
        root.right = self.recurse(postorder, rootIdx+1, end, indexMap)
        root.left = self.recurse(postorder, start, rootIdx-1, indexMap)

        return root
