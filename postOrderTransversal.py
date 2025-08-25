# Time Complexity : It is O(n) since we are iterating with all nodes.
# Space Complexity : It is O(h) considering the height of the tree in the stack.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(postorder)==0:
            return
        root = TreeNode(postorder[-1])
        idx=0
        for inOrderNode in inorder:
            if inOrderNode == postorder[-1]:
                break
            idx +=1

        inorderleft =inorder[:idx]
        inorderRight =inorder[idx+1:]
        postorderleft =postorder[:len(inorderleft)]
        postorderRight =postorder[len(inorderleft):-1]

        root.left=Solution.buildTree(self,inorderleft,postorderleft)
        root.right=Solution.buildTree(self,inorderRight,postorderRight)
        return root
        
