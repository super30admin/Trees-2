# Time Complexity : O(n), n is no of nodes in the tree
# Space Complexity : O(h), where h is the height of the tree, since its a recursive solution, it uses stack implementation under the hood, and the no of elements in a stach at any time will at max be equal to the height of the tree (left subtree or right subtree)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# given - post and inorder traversal of a tree
# we are using post to find the root, it will be at the end
# then searching the root in inorder (using hashmap)
# then using two pointers - start and end to mark the start and end of left and right subtree
# from rootidx in inorder, start to rootidx - 1 is the left subtree
# and from rootidx + 1 to end is the right subtree
# then we move our idx (iterating over postorder) to the next element (decrementing)
# thus, we are picking root from postorder and adding its node in the tree
# then we check left and right roots from the inorder map, if both left and right of the current root are done
# then we move to the next element in postorder



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.map = {}
        self.idx = 0

    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: Optional[TreeNode]
        """
        # getting the root from end of the postorder traversal
        # root, then first we will take right subtree and then right
        # getting left and right subtrees from inorder
        # but we will have to linear search for every node in inorder to find its position
        # that is why we store all values and indices from inorder in hashmap

        if postorder is None or inorder is None:
            return None
        
        self.map = {}
        self.idx = len(postorder) - 1

        # putting indices of all elements from inorder in map
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        
        return self.createTree(postorder, 0, len(postorder) - 1)
    
    def createTree(self, postorder, start, end):
        if start > end:
            return None
        
        # idx is iterating the postorder list
        # rootval is the value of the current root we are processing, we get it from the end of postorder
        rootval = postorder[self.idx]
        # index moves to the next element
        self.idx -= 1
        # creating the root node with rootval
        root = TreeNode(rootval)
        # index of the root in inorder
        rootidx = self.map[rootval]
        # making right subtree first
        # because we are traversing postorder from behind, after root, we will find right elements first 
        root.right = self.createTree(postorder, rootidx + 1, end)
        # making left subtree
        root.left = self.createTree(postorder, start, rootidx - 1)


        return root


        