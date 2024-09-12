Recursive solution:

// Time Complexity : O(n)
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we do a BFS and store the node value and it corresponding equivalent number from the root.when we reach the leaf we add the value to a variable and we do this till all the leaf nodes are traversed.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.sumNumbers1(root,0)
    
    def sumNumbers1(self,root,num):
        if root==None:
            return 0
        if root.left==None and root.right==None:
            return num*10+root.val
            
        left=self.sumNumbers1(root.left,num*10+root.val)
        right=self.sumNumbers1(root.right,num*10+root.val)
        return left+right
        



using stack
// Time Complexity : O(n)
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root==None:
            return 0
        stack=[]
        out=0
        stack.append((root,0))
        while len(stack)!=0:
            root=stack.pop()
            if root[0]==None:
                continue
            value=root[1]*10+root[0].val
            if root[0].left==None and root[0].right==None:
                   out=out+value
            stack.append((root[0].left,value))
            stack.append((root[0].right,value))
        return out

using queue:
// Time Complexity : O(n)
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we used BFS to traverse the tree level wise and when storing the node value in the queue we also store the equivalent of its parent node from the root.In this manner we calculate the sum of all the resulting paths from root to the leaf.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root==None:
            return 0
        out=0
        d=deque([[root,0]])
        while len(d)!=0:
            root1=d.popleft()
            if root1[0]==None:
                continue
            value=root1[1]*10+root1[0].val
            if root1[0].left==None and root1[0].right==None:
                   out=out+value
            d.append([root1[0].left,value])
            d.append([root1[0].right,value])
        return out