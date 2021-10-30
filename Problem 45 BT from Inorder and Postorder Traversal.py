# Did this code successfully run on Leetcode: Yes
# Time Complexity: O(n)
# Space Complexity: O(n)
# Logic: postorder dict last element is root then right elements & left elements. Inorder dict divides list into parts
# from root element. So, pick last element from postorder as root, search its index in inorder & provide index + 1 to
# end to right of root & start to index - 1 to left of root.

class Node:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, postorder, inorder):
        self.inorder_map = {key: value for value, key in enumerate(inorder)}
        self.p = len(postorder) - 1
        self.postorder = postorder

        def helper(start, end):
            if start > end:
                return None
            root_val = self.postorder[self.p]
            root = Node(root_val)
            self.p -= 1
            root.right = helper(self.inorder_map[root_val] + 1, end)
            root.left = helper(start, self.inorder_map[root_val] - 1)
            return root

        return helper(0, len(postorder) - 1)
