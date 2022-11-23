#Time complexity: O(n)
#Space compexity: O(h)

#Accepted on Leetcode

#Approach:
#Iteratively IO traverse and maintain a stack, use an object to keep track of the node as well as the 'running sum' till that node
#Whenever on popping we encounter a leaf node, add it's 'sum' to the totalSum
#Continue until entire tree traversed


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Node:
    def __init__(self, node, sumVal):
        self.node = node        
        self.sum = sumVal
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        result = 0
        stack = []
        curSum = 0
        while root != None or len(stack):
            while root!=None:
                curSum = curSum *10 + root.val
                stack.append(Node(root, curSum))
                root = root.left
            #root is now none
            poppedNode = stack.pop()
            root = poppedNode.node
            curSum = poppedNode.sum
            if root.left == None and root.right == None:
                print(curSum)
                result += curSum
            root = root.right

        return result

            
        