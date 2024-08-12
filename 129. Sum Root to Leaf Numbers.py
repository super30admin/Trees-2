# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : Average : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    '''
    - Recursively form number for each nodes like dfs until leaf node is reached
    - When leaf node is reached, add the formed number to the sum
    '''
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def recurse(node, num):
            nonlocal sum
            if not node:
                return
            current_num = (num * 10) + node.val
            if node.left == None and node.right == None:
                sum += current_num
                return
            recurse(node.left, current_num)
            recurse(node.right, current_num)
        
        sum = 0
        recurse(root, 0)
        return sum