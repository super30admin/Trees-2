#Time complexity: O(n)
#Space complexity: O(n)

#Accepted on leetcode

#Approach
#Use PO array to determine root at every recursive call
#Use IO array to determine LST and RST bounds, once root is found using PO, find the root's corresponding index in IO array - everything to it's left is it's LST and everything to it's right is it's RST
#Recursively construct the tree in this manner

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    index = 0
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        indexMap = {} # index in IO traversal - tells us the index of a given node in the IO arr
        Solution.index = len(postorder) - 1 #Leetcode reuses same class obj for all test cases so has to be set to 0 

        for i,x in enumerate(inorder):
            indexMap[x] = i
        
        return self.helper(postorder, 0, len(inorder) - 1, indexMap)
    
    #lb = left bount in IO
    #rb = right bound in IO
    #i = index in PO

    def helper(self, PO, lb, rb, indexMap):
        if lb > rb:
            return None
            
        rootElem = PO[Solution.index]
        rootIndex = indexMap[rootElem]
        root = TreeNode(rootElem)
        Solution.index = Solution.index - 1
        root.right = self.helper(PO, rootIndex + 1, rb, indexMap)
        root.left = self.helper(PO, lb, rootIndex - 1, indexMap)

        return root