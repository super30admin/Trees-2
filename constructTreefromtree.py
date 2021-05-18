# Definition for a binary tree node.
from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder: List[int], preorder: List[int]) -> TreeNode:
        if len(preorder)==0: return
        idx=-1

        rootval=preorder[0]
        for element in range(0,len(inorder)):
            if inorder[element] ==rootval:
                idx=element
                break
        root=TreeNode(rootval)
        inorderleft=inorder[0:idx]
        inorderright=inorder[idx+1,len(inorder)]
        preorderleft=preorder[1:idx+1]
        preorderright=preorder[idx+1,len(preorder)]
        root.left=self.buildTree(inorderleft,preorderleft)
        root.right=self.buildTree(inorderright,preorderright)

        return root
#timeO(n)
#spae:- O(nn)


if __name__ == '__main__':
    print(Solution().buildTree(inorder= [9,3,15,20,7],postorder=[9,15,7,20,3]))