# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        idx=-1
        if postorder==None or len(postorder)==0 or len(inorder)==0:
            return None
        
        root=TreeNode(postorder[len(postorder)-1])
        # print(root.val)
        for i in range(0,len(inorder)):
            if inorder[i]==root.val:
                idx=i

        inleft=inorder[0:idx]
        inright=inorder[idx+1:len(inorder)]
        postleft=postorder[0:len(inleft)]
        postright=postorder[len(inleft):len(postorder)-1]
        # print(inleft,end=" ")
        # print(inright,end=" ")
        # print(postleft,end=" ")
        # print(postright,end=" ")
        # print()

        root.left=self.buildTree(inleft,postleft)
        root.right=self.buildTree(inright,postright)

        return root
        