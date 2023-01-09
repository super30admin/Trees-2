#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: Yes
#traverse through post order array and create root nodes. For each root node, identifyb the left and right #children by identifying it from the left and right part of the inorder array. 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def construct(self,inorder,postorder,low,high,D):
        if(low>high):
            return None
        node=TreeNode()
        node.val=postorder[self.index]
        self.index-=1
        if(low==high):
            return node
        
        node.right=self.construct(inorder,postorder,D[node.val]+1,high,D)
        #self.index-=1
        node.left=self.construct(inorder,postorder,low,D[node.val]-1,D)
        return node


    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        D={}
        self.index=len(postorder)-1
        for i in range(len(inorder)):
            D[inorder[i]]=i
        return self.construct(inorder,postorder,0,len(postorder)-1,D)
