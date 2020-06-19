129. Sum Root to Leaf Numbers
#Time Complexity : O(n) 
#Space Complexity : O(h) height of the tree
#Did this code successfully run on Leetcode : Yes
#traverse from root to one one end of the tree ie leaf node and keep calculating the currentsum at each node . one we reach a leaf node we return current sum and start travesing the right node. Finally calculate sum on both left and right side and return.
#iterative
#class Solution:
#    def sumNumbers(self, root: TreeNode) -> int:
#        total = 0
#        stack = []
#        curr = 0
#        if not root:
#            return 0
#        while root or stack:
#            while root:
#                curr = curr * 10 + root.val
#                stack.append((root,curr))
#                root = root.left
#            node = stack.pop()
#            curr = node[1]
#            root = node[0]
#            if not root.left and not root.right:
#                total += curr
#            root = root.right
#        return total
#recursive		
class Solution:
    
    def helper(self, root, currsum):
        if not root:
            return 0
        if not root.left and not root.right:
            return currsum * 10 + root.val
        left = self.helper(root.left,currsum * 10 + root.val)
        right = self.helper(root.right,currsum * 10 + root.val)
        return left + right
    def sumNumbers(self, root: TreeNode) -> int:
        return self.helper(root,0)
            

