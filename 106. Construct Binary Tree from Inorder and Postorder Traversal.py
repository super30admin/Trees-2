# Time: O(n^2) 
# Space: O(n^2)

# do it similar to Inorder and Preorder
# from the last element of Postorder we will know the current root val
# search that root value in the inorder traversal and slice inorder accordingly for the next recursive call
# also slice the postorder as we need last element for the current rootVal
# the base case would be if the length or inorder is 0 then return

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        return self.helper(inorder,postorder)
    def helper(self,inorder,postorder):
        # base
        if len(inorder) == 0:
            return

        # logic
        rootVal = postorder[-1]
        root = TreeNode(rootVal)
        rootIdx = 0
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                rootIdx = i
                break

        in_left = inorder[:rootIdx]
        in_right = inorder[rootIdx+1:]

        post_left = postorder[:len(in_left)]
        post_right = postorder[len(in_left):-1]

        root.left = self.helper(in_left,post_left)
        root.right = self.helper(in_right,post_right)

        return root
    

# OPTIMISED SOLUTION

# Time: O(n) 
# Space: O(n)

# Have two pointers start and end to depict the deep copy of the array in inorder and keep 1 pointer to track the root values in postorder
# The postorder pointer should start from the back as last element is the rootVal
# Add all elements in inorder arr into the hashmap with their corresponding indexes
# Search for the root index and make the left and right recursive call accordingly
# we should do the right recursive call first as we are looping from behind on the post order array which would be left <- right <- root
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        start = 0
        end = len(inorder) - 1
        self.postIdx = len(postorder) - 1

        inMap = {}
        for i in range(len(inorder)):
            inMap[inorder[i]] = i
        
        return self.helper(inorder,postorder,start,end,inMap)
    def helper(self,inorder,postorder,start,end,inMap):
        # base
        if start > end:
            return None

        # logic
        rootVal = postorder[self.postIdx]
        root = TreeNode(rootVal)

        rootIdx = inMap.get(rootVal)
        self.postIdx -= 1

        root.right = self.helper(inorder,postorder,rootIdx+1,end,inMap)
        root.left = self.helper(inorder,postorder,start,rootIdx-1,inMap)

        return root