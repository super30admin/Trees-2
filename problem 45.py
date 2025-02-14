#  https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

# Time Complexity : O(n^2)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        return self.helper(inorder,postorder)

    def helper(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(postorder) == 0:
            return None
        
        mainroot = postorder[-1]
        root = TreeNode(mainroot)
        rootIdx = -1

        for i in range(len(inorder)):
            if mainroot == inorder[i]:
                rootIdx = i
                break

        inleft = inorder[0:rootIdx]
        inright = inorder[rootIdx+1:]

        postleft = postorder[0:len(inleft)]
        postright = postorder[len(inleft): -1]

        root.left = self.helper(inleft,postleft)
        root.right = self.helper(inright,postright)

        return root
    

# solution 2 with hashmap: TC: O(n) and SC: O(n)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.idx = 0
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        hm = {}
        for i in range(len(inorder)):
            hm[inorder[i]] = i
        self.idx = len(postorder) - 1

        return self.helper(postorder,hm,0,len(inorder)-1)
    
    def helper(self, postorder: List[int],hm,start,end) -> Optional[TreeNode]:
        if start > end or self.idx < 0:
            return None

        mainroot = postorder[self.idx]
        self.idx-=1
        root = TreeNode(mainroot)

        rootIdx = hm.get(mainroot)

        root.right = self.helper(postorder,hm,rootIdx+1,end)
        root.left = self.helper(postorder,hm,start,rootIdx-1)
        return root

        
        