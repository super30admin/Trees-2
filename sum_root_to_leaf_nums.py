""" 
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

Time Complexity: O(n)
Space Complexity: O(h) = O(n) in worst case
"""


def sumNumbers(root):
    
    def helper(root, currSum):
        
        if not root:
            return 0
        
        currSum = currSum * 10 + root.val
        
        if not root.left and not root.right:
            return currSum
        
        return helper(root.left, currSum) + helper(root.right, currSum)
    
    return helper(root, 0)


