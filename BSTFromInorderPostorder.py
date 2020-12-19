# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach: Recursive using pointers

# In this approach we are going take the advantage of the way postorder and inorder traversal is done. If we obesrver closely, we can see that out of the give lists, last element in postorder list is the root. Now the elements towards left of the index at which root (is present in inorder) makes up the left subtree and the elements towards the right of the root makes up the right tree.

# So at every recursive call we will find the left and right subtree elements in inorder and postorder and pass them as an argument. So the root's left would be the tree made up of left elements in postorder and inorder and same goes for the right subtree.

# In this one thing we have to be careful about is during recursive calls first contruct the right subtree becuase postorder stores the element in that fashion if we traverse the list in reverse direction

# Time complexity: O(n); n = length of the given list
# Space complexity: O(n); n = length of the given list
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.hmap = {}
        self.idx = len(postorder) - 1
        
        if inorder == None or len(inorder) == 0:
            return None
        
        for i in range(len(inorder)):
            self.hmap[inorder[i]] = i
            
        return self.helper(postorder, 0, len(inorder) - 1)
    
    def helper(self, postorder, start, end):
        if start > end:
            return None

        rootVal = postorder[self.idx]
        root = TreeNode(rootVal)
        self.idx -= 1
        
        rootIdx = self.hmap[rootVal]
        
        # Right tree is built first because we are traversing the postorder in a reverse fashion that traverses the elements in right first. That means we need to make right tree first
        root.right = self.helper(postorder, rootIdx + 1, end)
        root.left = self.helper(postorder, start, rootIdx - 1)
        return root