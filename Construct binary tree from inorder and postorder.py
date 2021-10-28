# TC-O(n)
# SC-O(n+height)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if (len(inorder) or len(postorder) )==0:
            return []
        self.dic ={}
        for i in range(len(inorder)):
            self.dic[inorder[i] ] =i
        instart =0
        inend =len(inorder ) -1
        self.postinx =len(inorder ) -1
        return self.helper(inorder ,postorder ,instart ,inend)

    def helper(self ,inorder ,postorder ,instart ,inend):

        if instart >inend or self.postinx<0:
            return None

        root =TreeNode(postorder[self.postinx])
        self.postinx-=1
        index =self.dic[root.val]
        root.right= self.helper(inorder ,postorder ,index +1 ,inend)
        root.left =self.helper(inorder ,postorder ,instart ,index -1)
        return root