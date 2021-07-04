''''

Did it run on leetcode: Yes
Problems faced: Same as yesterday's class. I just took an extra map, so that my find operation becomes 0(1) operation.

Time Complexity: 0(N)
- Traverse the tree
- find the index of root in inorder traversal

Space Complexity: 0(N)
- Stack is taking space
- Subarrays as well

Algorithm:
- In postorder traversal the last element is the root element
- Then we find number of elements in left and right of that root in the inorder traversal.
- Then we partition the postorder array with the number of elements on right and left and recursively call
build function.

'''



#
#  Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        
        if len(postorder)==0:
            return None
        
        inorderMap = {}
        for i in range(len(inorder)):
            inorderMap[inorder[i]] = i
        
        value = postorder[-1]
        rootNode = TreeNode(value)
        index = inorder.index(value)
        rootNode.left = self.buildTree(inorder[:index],postorder[0:index])
        rootNode.right = self.buildTree(inorder[index+1:],postorder[index:-1])
        
        return rootNode
    
    def buildTreeUtil(self,inorder,postorder,inorderMap):
        
        if len(postorder)==0:
            return None
        
        value = postorder[-1]
        rootNode = TreeNode(value)
        index = inorderMap[value]
        
        rootNode.left = self.buildTreeUtil(inorder[:index],postorder[0:index],inorderMap)
        rootNode.right = self.buildTreeUtil(inorder[index+1:],postorder[index:-1],inorderMap)