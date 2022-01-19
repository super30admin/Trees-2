"""
// Time Complexity : O(n)
// Space Complexity : O(h) in the worst case it is  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

"""

    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        # global sum adds all the currsums and we return this in the end
        self.globalsum = 0
        self.helper(0, root)
        return self.globalsum
    def helper(self, currsum, root):
        if root == None:
            return None
        currsum = currsum * 10 + root.val
        self.helper(currsum, root.left)
        # at the leaf node we add the currsum to the global sum
        if root.left == None and root.right == None:
            self.globalsum += currsum
        self.helper(currsum, root.right)
