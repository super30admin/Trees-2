# Time Complexity :O(n)
# Space Complexity : O(n)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right


# This is recursive Solution
class Solution:
    def __init__(self) -> None:
        self.idx = 0   # index in postorder for hashmap solution
        self.hashmapInorder = dict()  # create hashmap for hashmap solution

# Time Complexity :O(n^2)
# Space Complexity : O (n^2)
    def buildTree(self, inorder, postorder ):
        if len(postorder) == 0:
            return None
        
        rootVal = postorder[-1]
        rootIdx = -1  # idx of root in inorder
        n = len(inorder)
        
        for i in range(0,n + 1):
            if inorder[i-1] == rootVal:
                rootIdx = i-1
                
        inLeft = inorder[:rootIdx]
        postLeft = postorder[:rootIdx]  
        inRight = inorder[rootIdx+1:]  
        postRight = postorder[rootIdx:len(postorder)-1]
        root = TreeNode(rootVal)
        root.left = self.buildTree(inLeft,postLeft)
        root.right  = self.buildTree(inRight,postRight)
        return root


# Using Hashmap instead to itrates ove inorder and find a root --->
# time complexity : O(n)
# space complexity: O(n)
    def buildTree1(self, inorder, postorder):
        if len(postorder) == 0:
            return None
        
        n = len(inorder)
        for i in range(0,n+1):
            self.hashmapInorder[inorder[i-1]] = i-1
        return self.helper(postorder,0,n-1)

    def helper(self, preorder, start, end, ):
        if start > end:
            return None
        
        rootVal = preorder[self.idx]
        root = TreeNode(rootVal)
        self.idx = self.idx +1
        rootIdx = self.hashmapInorder[rootVal]  # idx of root in inorder
        root.left = self.helper(preorder, start, rootIdx - 1)
        root.right = self.helper(preorder, rootIdx + 1, end)
        return root



obj = Solution()
print(obj.buildTree([9,3,15,20,7],[9,15,7,20,3]))
                           