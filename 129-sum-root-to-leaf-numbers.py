
"""
129. Sum Root to Leaf Numbers
Medium
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
You are given the root of a binary tree containing digits from 0 to 9 only.
Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.

Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
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

 
Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 9
The depth of the tree will not exceed 10.


"""

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    """
    Accepted
    Time Complexity: O(n)
    Space Complexity: O(h) where h is the height of the tree
    Explanation: Traverse the tree in DFS fashion and keep track of the numbers in a list.
    When we reach a leaf node, we calculate the number by doing the % operation. Add it to the result.
    NOTE: The key point here is to get rid of the number from the list when we backtrack.
    
    """
    res = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        # res = 0
        num = 0
        numList = []
        def trav(root):
            if root is None:
                return
            numList.append(root.val) # inorder
            trav(root.left)
            trav(root.right)
            if root.left is None and root.right is None: # leaf node || just before the base case, we calculate the number
                mult = 1
                curr = 0
                for num in numList[::-1]:
                    curr += mult * num
                    mult *= 10
                self.res += curr
            numList.pop() #Backtrack. We need to remove the number from the list.
            return
        trav(root)
        return self.res

LeetCode(PROBLEM, Solution).check()
