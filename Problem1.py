# Construct Binary Tree from Inorder and Postorder Traversal

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    rootIndex = 0
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.rootIndex = len(postorder)-1
        inOrderIndexMap = {}

        for i in range(0,len(inorder)):
            inOrderIndexMap[i] = inOrderIndexMap[i]

        return self.helper(inOrderIndexMap,postorder,0,len(inorder)-1)
    

    def helper(self, inOrderIndexMap, postorder, inOrderLeftIndex, inorderRightIndex):
        if inOrderLeftIndex>inorderRightIndex:
            return None
        rootVal = postorder[self.rootIndex]
        self.rootIndex-=1

        inOrderRootValIndex = inOrderIndexMap[rootVal]
        rootNode = TreeNode(rootVal)
        rootNode.right = self.helper(inOrderIndexMap,postorder,inOrderRootValIndex+1,inorderRightIndex)

        rootNode.left = self.helper(inOrderIndexMap,postorder,inOrderLeftIndex,inOrderRootValIndex-1)

        return rootNode