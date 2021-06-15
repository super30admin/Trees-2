'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 129. Sum Root to Leaf Numbers

# You are given the root of a binary tree containing digits from 0 to 9 only.

# Each root-to-leaf path in the tree represents a number.

# For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
# Return the total sum of all root-to-leaf numbers. Test cases are generated so 
# that the answer will fit in a 32-bit integer.

# A leaf node is a node with no children.

#-----------------
# Time Complexity: 
#-----------------
# O(N): Where N is the number of elements in the tree. Need to visit every element
#       at least once.

#------------------
# Space Complexity: 
#------------------
# O(H): Max size of the stack is equal to the height of the tree. 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  48 ms   (98.15 %ile)
# Space            :  18.3 MB (93.55 %ile)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        return self.sumNumbersUtil(root, 0)    
    
    def sumNumbersUtil(self, root:TreeNode, root_to_leaf_sum: int) -> int:
        if root is None:
            return 0
        else:
            root_to_leaf_sum = (root_to_leaf_sum * 10) + root.val
            if root.left is None and root.right is None:
                return root_to_leaf_sum
            
            return (self.sumNumbersUtil(root.left, root_to_leaf_sum)  + \
                    self.sumNumbersUtil(root.right, root_to_leaf_sum))