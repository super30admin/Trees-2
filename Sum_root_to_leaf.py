# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Using Iterative Preorder Traversal and storing node and sum for each node in the left and right subtree on stack
# If the node is the leaf node that is it doesnt have left or right child then add the sum to res
#Second Approach is recursive approach where I have used helper function to chekc if the node is leaf then return num else return sum of left + right

class Solution:
    def sumNumbers(self, root: TreeNode | None) -> int:
        if root is None:
            return 0

        def preorder(root):
            stack = [(root, 0)]
            res = 0
            while stack:
                node, num = stack.pop()
                if node:
                    num = num * 10 + node.val
                    if not node.left and not node.right:
                        res += num
                    if node.left:
                        stack.append((node.left, num))
                    if node.right:
                        stack.append((node.right, num))
            return res
        output = preorder(root)

        return output
'''Iterative solution using stack'''  

class Solution:
    def sumNumbers(self, root: TreeNode | node) -> int:
        if root is None:
            return 0
        return self.helper(root, 0)

    def helper(self, root, num):
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return num
        num = num * 10 + root.val

        return self.helper(root.left, num) + self.helper(root.right, num)
    

    
