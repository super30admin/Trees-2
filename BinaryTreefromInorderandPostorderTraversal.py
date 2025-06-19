# # Time Complexity:O(n^2), due to repeated slicing and linear search
# # Space Complexity:O(n^2), new lists created each recursive call
# # Take the last value in postorder as the root because postorder ends with root. Find this root’s index in inorder to divide into left and right subtrees. Then recursively build the left and right parts from those slices.
# class Solution:
#     def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
#         if not postorder:
#             return None
#         rootVal = postorder[-1]
#         rootIdx = -1
#         for i in range(len(inorder)):
#             if inorder[i] == rootVal:
#                 rootIdx = i
#                 break
#         inLeft = inorder[0:rootIdx]
#         inRight = inorder[rootIdx+1:]
#         postLeft = postorder[0:len(inLeft)]
#         postRight = postorder[len(inLeft):-1]
#         root = TreeNode(rootVal)
#         root.left = self.buildTree(inLeft, postLeft)
#         root.right = self.buildTree(inRight, postRight)
#         return root

# Hashmap
# Time Complexity:O(n)
# Space Complexity:O(n), single hashmap + recursion stack
# Recursively build right first, then left (since we’re moving backwards in postorder).
class Solution:
    def buildTree(self, inorder, postorder):
        self.map = {}
        self.postOrderIdx = len(postorder) - 1
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        return self.helper(postorder, 0, len(inorder) - 1)
    def helper(self, postorder, start, end):
        if start > end:
            return None
        rootVal = postorder[self.postOrderIdx]
        rootIdx = self.map[rootVal]
        self.postOrderIdx -= 1
        node = TreeNode(rootVal)
        node.right = self.helper(postorder, rootIdx + 1, end)
        node.left = self.helper(postorder, start, rootIdx - 1)
        return node