# Using hashmap
# TC & SC = O(n)
# Same as using preorder. Here the root is considered from the end- so we can traverse via postorder with simple pop. In order to not mutate the original array, use aux
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    post = []
    hashmap = {}
    def buildTree(self, inorder, postorder):
        if len(postorder) == 0: return None
        post = postorder
        self.hashmap = {val:idx for idx, val in enumerate(inorder)} 
        return self.helper(post, 0, len(inorder) - 1)
    
    def helper(self, post, in_left, in_right):
        if in_left > in_right: return None
        val = post.pop()
        root = TreeNode(val)
        index = self.hashmap[val]
        root.right = self.helper(post, index + 1, in_right)
        root.left = self.helper(post, in_left, index - 1)
        return root