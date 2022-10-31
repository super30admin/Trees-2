# Did it run successfully on LC? YES

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder, postorder):
        if not inorder:
            return None
        idx = inorder.index(postorder.pop())
        root = TreeNode(inorder[idx])
        root.left = self.buildTree(inorder[:idx], postorder[:idx])
        root.right = self.buildTree(inorder[idx+1:], postorder[idx:])
        return root
    
    def buildTree(self, inorder, postorder):   
        if inorder:
            ind = inorder.index(postorder.pop())
            root = TreeNode(inorder[ind])
            root.right = self.buildTree(inorder[ind+1:], postorder)
            root.left = self.buildTree(inorder[:ind], postorder)
            return root

if __name__ == "__main__":
    s = Solution()
    inorder = [9,3,15,20,7]
    postorder = [9,15,7,20,3]
    print(s.buildTree(inorder, postorder))
