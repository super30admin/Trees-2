# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: Optional[TreeNode]
        """
        if not inorder or not postorder:
            return None

        self.idxMap = dict()

        for i in range(len(inorder)):
            self.idxMap[inorder[i]] = i

        #postorder array. tree root will be the last.
        self.treeRootIdx = len(postorder) - 1

        def helper(postorder, start, end):
            if start > end:
                return None
            
            rootVal = postorder[self.treeRootIdx]
            self.treeRootIdx -= 1
            rootIdx = self.idxMap[rootVal]

            root = TreeNode(rootVal)

            # Populate right and left children recursively.
            # why right? because we are using postorder array
            # to determine the next root.
            root.right = helper(postorder, rootIdx + 1, end)

            root.left = helper(postorder, start, rootIdx - 1)

            return root
        
        return helper(postorder, 0 , len(inorder)-1)


#TC : O(n)
#SC : O(n)