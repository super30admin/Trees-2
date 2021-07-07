#passed leetcode
#time - o(n)
#space -  O(h) #h is height of the tree


class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.helper_func(root, 0)

    def helper_func(self, root, value):

        # base_case
        if root == None:
            return 0
        if root.left == None and root.right == None:
            return 10 * value + root.val
        left = self.helper_func(root.left, 10 * value + root.val)
        right = self.helper_func(root.right, 10 * value + root.val)
        return right + left