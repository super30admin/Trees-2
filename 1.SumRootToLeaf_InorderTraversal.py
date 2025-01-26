# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    """
    Time Complexity: 0(n)
    Space Complexity: 0(h)
    Approach:
        Using tree traversal -- reach the leaf node and form a number. Sum it in the constructor level defined variable
    """

    def __init__(self):
        self.totalSum = 0

    def __traversal(self, node:Optional[TreeNode], prevNum: int) -> None:

        # base-case
        if node == None:
            return

        # its a leaf
        if node.left == None and node.right == None:
            self.totalSum += (prevNum*10 + node.val)

        # logic-case
        # go-left
        self.__traversal(node.left, (prevNum*10 + node.val))
        
        # go-right
        self.__traversal(node.right, (prevNum*10 + node.val))
        
        return

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.__traversal(root, 0)

        return self.totalSum