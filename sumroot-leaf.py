'''
Problem: https://leetcode.com/problems/sum-root-to-leaf-numbers/

Approach: 
    1. Recursively traverse the tree and sum up the values of the leaf nodes.
    2. Multiply the sum by 10 and add the value of the current node.
    3. Return the sum if the current node is a leaf node. 
    4. Otherwise, recursively call the function with the left and right subtrees.
    5. Return the sum of the left and right subtrees.
    
Time Complexity: O(n) where n is the number of nodes in the tree.
Space Complexity: O(h) where h is the height of the tree.
'''

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        def solve(pathSum, node):
            if not node:
                return 0

            if not node.left and not node.right:
                return pathSum * 10 + node.val

            leftSum = solve(pathSum * 10 + node.val, node.left)
            rightSum = solve(pathSum * 10 + node.val, node.right)

            return leftSum + rightSum

        return solve(0, root)
