"""
    Leetcode 129 - Sum Root to Leaf Numbers

    This class provides a method to calculate the total sum of all root-to-leaf
    numbers in a binary tree, where each path represents a number formed by concatenating
    node values from root to leaf.

    Attributes
    ----------
    result : int
        Accumulator to store the sum of all root-to-leaf numbers.

    Methods
    -------
    sumNumbers(root: TreeNode) -> int
        Initiates the recursive traversal and returns the final sum.

    helper(root: TreeNode, pathSum: int) -> None
        Recursively traverses the tree, updating the path sum at each step.
        Adds the complete path number to result when a leaf node is reached.

    Time Complexity: O(n)
        Each node is visited exactly once.

    Space Complexity: O(h)
        Where h is the height of the tree, due to recursive call stack.
"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.result = 0
    def sumNumbers(self, root):
        self.helper(root, 0)
        return self.result
    
    def helper(self, root, pathSum):
        if not root:
            return
        pathSum = pathSum * 10 + root.val
        if root.left == None and root.right == None:
            self.result += pathSum
        self.helper(root.left, pathSum)
        self.helper(root.right, pathSum)

# ---------- MAIN FUNCTION ----------
if __name__ == "__main__":
    # Example 1
    root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)
    sol1 = Solution()
    print("Sum of root-to-leaf numbers (Example 1):", sol1.sumNumbers(root1))  # Expected: 25

    # Example 2
    root2 = TreeNode(4)
    root2.left = TreeNode(9)
    root2.right = TreeNode(0)
    root2.left.left = TreeNode(5)
    root2.left.right = TreeNode(1)
    sol2 = Solution()
    print("Sum of root-to-leaf numbers (Example 2):", sol2.sumNumbers(root2))  # Expected: 1026
