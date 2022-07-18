"""
Runtime Complexity:
O(n) - because we run through each node and add the sum until we reach all the leaf nodes.
Space Complexity:
O(h) - height/depth of the tree is the number of elements that goes into the stack.
"""
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        result_sum = 0
        stack = [(root,0)]
        
        while stack:
            root, current_num = stack.pop()
            if root is not None:
                current_num = current_num*10 + root.val
                if root.left is None and root.right is None:
                    result_sum+=current_num
                else:
                    stack.append((root.left,current_num))
                    stack.append((root.right,current_num))
        return result_sum


### Recursive approach
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def preorder(root,current_number):
            nonlocal result_sum
            if root:
                current_number = current_number*10 + root.val
                if not root.left and not root.right:
                    result_sum += current_number
                preorder(root.left,current_number)
                preorder(root.right,current_number)
        result_sum =0