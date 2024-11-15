# TC: O(n)
# SC: O(1)


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right



def buildTree(inorder, postorder):
    def helper(inorder, postorder):
        if not inorder or not postorder:
            return None

        root = postorder[-1]
        root_idx = inorder.index(root)

        rootNode = TreeNode(root)
        
        rootNode.left = helper(inorder[:root_idx], postorder[:root_idx])
        rootNode.right = helper(inorder[root_idx+1:], postorder[root_idx:-1])
            

        return rootNode
    
    return helper(inorder, postorder)