
# Time Complexity :
# O(n)


# Space Complexity :  
# O(n)    , due to creation of hashmap


# Approach:
# Use hashmap to build Inrder array's hashmap, for finding the indexes of the root under consideration from "postorder".
# Then build the left and right subtree recursively using inorderleft and inoderright subarrays alongwith
# root's value under consideration from "postorder"
# Build right subtree here first, because according to given "postorder", since we started from last element as root,
# the next element in reverse order would give us the right node.
# Then build left-subtree
# For both subtree recursive calls, adjust the start and end pointers based on rootIndex value from "inorder",
# and these pointeres serve to make left and right subtree form "inorder" array.



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    hashMap = {}
    idx = 0
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if not inorder or not postorder:
            return None
        
        # build hashMap
        for i in range(0, len(inorder)):
            self.hashMap[inorder[i]] = i
        
        # the root node will be last element in "postorder"
        self.idx = len(postorder)-1

        return self.recurseBuild(postorder, 0, len(inorder)-1)
        

    def recurseBuild(self, postorder, start, end):
        # base
        if start > end:
            return

        # logic
        rootVal = postorder[self.idx]
        # dec idx for next root, but that will build right subtree first
        self.idx = self.idx -1

        rootIdx = self.hashMap[rootVal]
        root = TreeNode(rootVal)
        print("Current Root value:", rootVal)

        # build right subtree
        root.right = self.recurseBuild(postorder, rootIdx+1, end)

        # build left subtree
        root.left = self.recurseBuild(postorder, start, rootIdx-1)


        return root