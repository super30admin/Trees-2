"""
Leetcode - https://leetcode.com/problems/sum-root-to-leaf-numbers/ (submitted)
TC- O(N), SC- O(1)


You are given the root of a binary tree containing digits from 0 to 9 only.
Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit
integer.

A leaf node is a node with no children.

Example 1:
Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:
Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
Lecture- NA

Constraints:
The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 9
The depth of the tree will not exceed 10.
"""

'''
Ideation- Traversal
Any traversal, save path (since path is a string it goes into recursion stack as value and not reference). If you hit
leaf, add the int(path) to final sum
'''
class Solution:
    def sumNumbers(self, root):
        self.sumPath = 0
        if root is None:
            return None
        self.helper(root, '')
        return self.sumPath

    def helper(self, root, path):
        if root is None:
            return

        path += str(root.val)
        if root.left is None and root.right is None:
            self.sumPath += int(path)

        self.helper(root.left, path)
        self.helper(root.right, path)