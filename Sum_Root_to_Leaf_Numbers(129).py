# Time Complexity: O(N)
# Space Complexity: O(N)->iterative, O(h)->Recursive
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # All approaches are good, go through all to understand better
    # Approach 1: Recursive with global variable
#     def __init__(self):
#         self.total = 0

#     def sumNumbers(self, root: Optional[TreeNode]) -> int:
#         self.dfsCheck(root,self.total)
#         return self.total

#     def dfsCheck(self,root,tsum):
#         if (root==None) or (root.left==None and root.right==None):
#             if root!=None:
#                 self.total+= tsum*10 + root.val
#             return
#         self.dfsCheck(root.left,tsum*10+root.val)
#         self.dfsCheck(root.right,tsum*10+root.val)


# Approach 2: returns the result in place of null
#     def sumNumbers(self, root: Optional[TreeNode]) -> int:
#         return self.dfsCheck(root,0)

#     def dfsCheck(self,root,num) -> int:
#         if (root==None) or (root.left==None and root.right==None):
#             if root!=None:
#                 return num*10 + root.val
#             return 0
#         left = self.dfsCheck(root.left,num*10+root.val)
#         right = self.dfsCheck(root.right,num*10+root.val)
#         return left+right

# Iterative Solution:
# Here we maintain 2 stacks
# nodes to store the nodes and sums to store the sum from root till the current node
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        nodes = list()
        sums = list()
        result = 0
        curr_sum = 0

        # At every iteration we add the node to the stack
        # and add it's sum to the curr_sum(sum from root till current node) and add it to the sums stack
        # we keep on going till the very left of every node

        while root!=None or len(nodes)!=0:
            while root!=None:
                nodes.append(root)
                curr_sum = curr_sum*10 + root.val
                sums.append(curr_sum)
                root = root.left
            # Once we exit the while loop it means that we have calculated the sum for
            # a total left path and hit a null node
            # so we pop from the sum stack and root stack
            # if the popped node is a leaf node we add the sum to the result
            # then move to the right of the node
            curr_sum = sums.pop()
            root = nodes.pop()
            if root.left==None and root.right==None:
                result += curr_sum
            root = root.right
        return result