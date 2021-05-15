# TC: O(N) since we are traversing all the nodes.
# SC: O(H) where H is the height of the tree.

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0 
        stack = []
        cumsum = 0
        result = 0
        while root or stack:
            while root:
                cumsum = (cumsum * 10) + root.val
                stack.append((root, cumsum)
                root = root.left
            curr, cumsum = stack.pop()
            if not curr.left and not curr.right:
                result += cumsum
            root = curr.right
        return result
