#Space: O(n)
#Time: O(n)
import sys
sys.path.append('/path/to/custom_modules')

from tree import TreeNode

# Your code using TreeNode goes here

# Your code using TreeNode goes here


class Solution:
    def buildTree(self, inorder: list[int], postorder: list[int]) -> TreeNode:
        def helper(l,r):
            if l>r:
                return None
            val = postorder.pop()
            root = TreeNode(val)
            index = val_map[val]
            # print(val_map)
            # preorder_left_len = index
            # postorder_left = postorder[-1*len(inorder[index+1:]):]
            # postorder_right = postorder[-2:-1*len(inorder[index+1:])]
            # inorder_left = inorder[:index]
            # inorder_right = inorder[index+1:]
            root.right = helper(index+1,r)
            root.left = helper(l,index-1)
            return root
        # postorder = postorder.reverse()
        val_map = {val:index for index,val in enumerate(inorder)}
        # print(val_map)
        return helper(0,len(inorder)-1)