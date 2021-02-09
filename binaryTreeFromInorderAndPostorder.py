#TimeComplexity:O(N) 
#SpaceComplexity: O(Depth)+O(N) for Hashmap
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(inorder)==0:
            return None        
        postIndex=len(postorder)-1
        dict={}
        for i in range(len(inorder)):
            dict[inorder[i]]=i
        print(dict.get(3))
        def buildNewTree(inorder,postorder,inStart,inEnd):
            if inStart>inEnd:
                return None
            nonlocal postIndex
            root=TreeNode(postorder[postIndex])
            postIndex-=1
            index=dict.get(root.val)
            
            root.right=buildNewTree(inorder,postorder,index+1,inEnd)
            root.left=buildNewTree(inorder,postorder,inStart,index-1)
            return root
        return buildNewTree(inorder,postorder,0,len(postorder)-1)
 
        '''
        if len(inorder)==0:
            return None
        rootVal=postorder[-1]
        root=TreeNode(rootVal)
        
        inLeft=inorder[:inorder.index(rootVal)]
        postLeft=postorder[:inorder.index(rootVal)]
        inRight=inorder[inorder.index(rootVal)+1:]
        postRight=postorder[inorder.index(rootVal):-1]
        
        root.left=self.buildTree(inLeft,postLeft)
        root.right=self.buildTree(inRight,postRight)
        
        return root
        '''