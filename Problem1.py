# Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
# Time Complexity: O(n), We visit every node exactly once and each visit does constant work using dictionary lookup and a moving pointer
# Space Complexity: O(n), We use a dictionary of size n to store index positions and the recursion stack can go up to depth n in the worst case
# Approach: The last value in postorder is always the root of the current subtree so we read it using a pointer that moves backward
# We use a dictionary to instantly find where that root sits in inorder so we know how many nodes go to the left and right
# We always build the right subtree before the left subtree because reading postorder backward gives root then right side then left side

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # this dictionary will store the index of every value in inorder so we never have to search for it later
        self.map = {}       

        # this pointer starts at the last index of postorder and will move backward as we build each root
        self.postorder_index = len(postorder)-1

        # fill the dictionary once so lookups later take constant time
        for i in range(len(inorder)):
            self.map[inorder[i]]=i
        
        # start building the tree using the full range of inorder, from index 0 to the last index
        return self.helper(postorder,0,len(inorder)-1)
    
    def helper(self,postorder,start,end):
        # if start has gone past end it means there are no elements left in this range so there is nothing to build
        if start > end:
            return None
        
        # the value at our current pointer position in postorder is always the root of this subtree
        root_value = postorder[self.postorder_index]

        # look up where this root value sits in inorder so we know how to split left and right parts
        root_index = self.map[root_value]

        # move the pointer one step back so the next call reads the correct next value
        self.postorder_index -=1

        # create the node for this root value
        node = TreeNode(root_value)

        # build the right subtree first since reading postorder backward gives right side nodes before left side nodes
        node.right = self.helper(postorder,root_index+1, end)
        # only after the right subtree is fully built do we build the left subtree
        node.left = self.helper(postorder,start, root_index -1)

        return node