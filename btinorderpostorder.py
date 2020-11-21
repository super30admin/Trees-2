# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time complexity - O(n)
# Space complexity - O(n+h) sliced lists and recursive stack space
# Did this solution run on leetcode? - yes
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        # base case
        if len(postorder)==0 or len(inorder)==0:
            return None
        
        # logic
        # root node is present in the end of the postorder
        root = TreeNode(postorder[-1])
        
        # find the position of element in the inorder traversed list.
        for i in range(len(inorder)):
            if postorder[-1] == inorder[i]:
                break
        
        root.left = self.buildTree(inorder[:i], postorder[:i])
        root.right = self.buildTree(inorder[i+1:], postorder[i:-1])
        
        return root
    
        
# Time complexity - O(n)
# Space complexity - O(n+h) dictionary and recursive stack space
# Did this solution run on leetcode? - yes
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.posindex = len(postorder)-1
        # InorderPos = dict() # store the mapping of the indices of inorder array
        # for i, elem in enumerate(inorder):
        #     InorderPos[elem] = i
        InorderPos = {val: idx for idx, val in enumerate(inorder)} # O(n)
        
        # O(n)
        def createTree(istart, iend):
            # base case
            if iend < istart or self.posindex == -1:
                return None
            
            # logic
            root = TreeNode(postorder[self.posindex]) # alternatively, can also pop the element.
            pos = InorderPos[root.val]
            self.posindex -= 1
            
            # traverse to the right  
            # since the last element in the postorder traversal will be the root.
            root.right = createTree(pos+1, iend)
            
            # traverse to the left
            root.left = createTree(istart, pos-1)
            
            return root
            
        
        return createTree(0, len(inorder)-1)
    
    