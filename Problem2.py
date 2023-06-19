# Time Complexity : O(n)
# Space Complexity : O(h) for recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here we have a global sum variable. As we perform the traversal of the tree, we accumulate the value at every node
# When we hit the leaf node, we add the accumulated value to the global sum.
class Solution:
    def __init__(self):
        self.s = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.s
    
    def helper(self, root, acc):
        if not root:
            return
        acc = acc*10 + root.val
        if not root.left and not root.right:
            self.s += acc
        self.helper(root.left, acc)
        self.helper(root.right, acc)
