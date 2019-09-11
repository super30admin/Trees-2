# timecomplexity: O(n)
# LEttcode:accepted
# doubt: None


# explaination: there is a post order and inorder list so in post order, the last elements is the root.
# keep on poppoing the last element from the post order because they are the root()
# find the root in the inorder traversal, all the eleemtns in the left is the left subtree and the elements
# afer the root belongs to the right subtree.

# then check for root in postorder from the last, find the elemet in the inorder, the eleemts to wards the eft will become the
# left subree and the element toward the right will become right subtree.

# we are also building a hashmoa to get indexes of the elemetns from thenpostorder traersal. just so that we dont have to go through the
# hwhole arrray to find an element

# leftmost in index-1 will be everything in your left and index+1 to right wull be everythong on right:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        def helper(left, right):
            if (left > right):
                return None
            val = postorder.pop()
            root = TreeNode(val)
            rootindex = dict1[val]
            root.right = helper(rootindex + 1, right)
            root.left = helper(left, rootindex - 1)
            return root

        # creating an hashmap
        dict1 = {}
        for i in range(len(inorder)):
            dict1[inorder[i]] = i
        return helper(0, len(inorder) - 1)