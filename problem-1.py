# Time Complexity : O(n)

# space complexity : O(h)

# Approach :

# use dfs
# create a hashmap and store the elements and indices of the inorder array
# keep iterating through the postorder array to find root from the end
# keep two iterators start and end . If start > end, it means its a leaf node
# keep a pointer which remains static for every recursive call so that we can find the new root in every recursion from postorder array


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        self.hashMap = dict()

        for i in range(len(inorder)):
            self.hashMap[inorder[i]] = i

        self.postOrderIndex = len(postorder) - 1
        result = self.checkTree(postorder, 0, self.postOrderIndex)
        return result

    def checkTree(self, postOrder, start, end):

        if (start > end):
            return None

        rootVal = postOrder[self.postOrderIndex]
        self.postOrderIndex = self.postOrderIndex - 1

        rootNode = TreeNode(rootVal)
        rootInorderIndex = self.hashMap[rootVal]

        rootNode.right = self.checkTree(postOrder, rootInorderIndex+1, end)
        rootNode.left = self.checkTree(postOrder, start, rootInorderIndex-1)

        return rootNode
