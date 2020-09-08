# Runtime : O(n)

# we follow a very similar approach to the one used in class
# for building a trr using inorder and pre-order. But in 
# this case we start building the tree from the right side.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        def helper(inorder):
            # print(postorder, inorder)
            if len(inorder) == 0:
                return None

            for i in range(len(inorder)):
                if inorder[i] == postorder[-1]:
                    left = inorder[:i]
                    right = inorder[i+1:]
                    break
            root = TreeNode(postorder[-1])
            postorder.pop()
            root.right = helper(right)
            root.left = helper(left)
            return root
        return helper(inorder)
                