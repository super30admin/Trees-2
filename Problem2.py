# Time Complexity: O(n)
# Space Complexity: O(n)
# Works on leetcode: yes
# Approach: We use a stack to keep track of all nodes and its value in tree in preorder way. Since we have to form numbers
# we keep adding node left and right along with the popped value*10 added to the left/right node's value
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0
        stack, res = [(root, root.val)], 0
        while stack:
            node, val = stack.pop()
            if node:
                if not node.left and not node.right:
                    res += val
                if node.left:
                    stack.append((node.left, val*10+node.left.val))
                if node.right:
                    stack.append((node.right, val*10+node.right.val))
        return res
        