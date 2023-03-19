'''
TC: O(n) to traverse all nodes
SC: O(n) for recursive stack if all the nodes are present on the left of parent node or O(h) he is the height of binary tree
'''

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        sumTotal = 0
        def recursion(root, sumTotal):
            if not root:
                return 0
            sumTotal = sumTotal*10 + root.val
            if (not (root.left or root.right)): # determine if this is the last node
                return sumTotal
            return recursion(root.left, sumTotal) + recursion(root.right, sumTotal)
        
        return recursion(root, sumTotal)
        