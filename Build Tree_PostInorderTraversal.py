
class TreeNode:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

# time = O(N*N), list.index() operation --> O(N) and all elements of preorder are visited once
# space = O(1),

class Solution:
    def buildTree(self, inorder, postorder):
        
        # EDGE CASE
        if len(postorder) == 0 or len(inorder) == 0:
            return None
        
        # LOGIC
        root = TreeNode(postorder[len(postorder)-1])
        k = inorder.index(root.key)
        # list.index() ==> O(N) as it has to do a for loop over all elements in list

        root.left = self.buildTree(inorder[:k], postorder[:k])
        root.right = self.buildTree(inorder[k+1:], postorder[k:len(postorder)-1])
        return root

obj = Solution()
print(obj.buildTree(postorder=[9,15,7,20,3], inorder=[9,3,15,20,7]))
