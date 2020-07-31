# problem 1 : 106. Construct Binary Tree from Inorder and Postorder Traversal : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not postorder:
            return None
        indict = {val:ind for ind,val in enumerate(inorder)}
        def makeTree(l, r):
            if l > r:
                return None
            val = postorder.pop()
            node= TreeNode(val)
            ind = indict[val]
            node.right = makeTree(ind+1, r)
            node.left = makeTree(l, ind-1)
            return node
        return makeTree(0, len(inorder)-1)



# problem 2 : 129. Sum Root to Leaf Numbers : https://leetcode.com/problems/sum-root-to-leaf-numbers/
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        ## iterative way
        total = 0
        stack = [(root,0)]
        while stack:
            root, curr = stack.pop()
            if root:
                curr = curr * 10 + root.val
                if not root.left and not root.right:
                    total += curr
                else:
                    stack.append((root.left, curr))
                    stack.append((root.right, curr))
        return total
        
        ## simple way with strings
#         if not root:
#             return 0
#         self.total = 0
        
#         def getSum(node,num):
#             #print(num)
#             if not node.left and not node.right:
#                 self.total += int(num+str(node.val))
#                 return
#             if node.left:
#                 getSum(node.left, num+str(node.val))
#             if node.right:
#                 getSum(node.right, num+str(node.val))
#         getSum(root, '')
#         return self.total
               