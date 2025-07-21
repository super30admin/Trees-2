# Time Complexity: O(N)
# Space Complexity: O(H) where H is the height of the tree
# Were you able to solve this on your own? Yes
# Any problem you faced while coding this: No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        mapping = {}

        #create mappings of inorder 
        for i in range(len(inorder)):
            mapping[inorder[i]] = i


        # since we will be using postorder to build the tree
        # for each root, we will pop the last element from postorder

        def buildNodes(start, end) -> Optional[TreeNode]:
            # if start index is greater than end index, return None
            # this is the base case for recursion, this case is seen when a leaf node is reached
            if start>end:
                return None

            # pop the last element from postorder, this will be the root of the current subtree
            # and we will build the right and left subtrees from this root
            root = TreeNode(postorder.pop())

            # find the index of the root in inorder
            mid = mapping[root.val]    

            # recursively build the right and left subtrees starting with right subtree first and then left subtree
            # right subtree will be built from the elements after the root in inorder
            # left subtree will be built from the elements before the root in inorder
            
            root.right = buildNodes(mid+1, end)
            root.left = buildNodes(start, mid-1)
            
            
            return root

        return buildNodes(0, len(postorder)-1)
        