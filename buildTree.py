# // Time Complexity :O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
# https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

# // Your code here along with comments explaining your approach
# very tricy problem looks easy, firtly understand splits between root , left subtree an right sub tree and pass this splits recursively 
# 1.make new arrays everytime 
# 2. use pointer to know where to search elements


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        indices = {val:idx for idx, val in enumerate(inorder)} 
        self.idx = len(postorder)-1

        def explore(l, r):
            if l > r:
                return
            
            root_val = postorder[self.idx]
            self.idx-=1
            root = TreeNode(root_val)

            mid = indices[root_val]
            
            # [left_of_3, right_of_3, 3]

            root.right = explore(mid+1, r)
            root.left = explore(l, mid-1)
            

            return root
        
        return explore(0, len(postorder)-1)






######################################
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        def helper(inorder: List[int], postorder: List[int]):
            if len(postorder)==0 or len(inorder)==0:return None

            n=len(postorder)
            rootIdxpo=n-1
            
            # print(f"Looking for {postorder[n-1]} in inorder {inorder}")
            for i in range(n):
                if inorder[i]==postorder[n-1]:
                    rootIdxin=i

                    break
            leftsz= rootIdxin #0
            rightsz=n-rootIdxin-1
            root=TreeNode(postorder[-1])
            root.right=helper(inorder[rootIdxin+1:],postorder[leftsz:leftsz+rightsz])
            root.left=helper(inorder[:leftsz],postorder[:leftsz])
            
            return root
        return helper(inorder, postorder)
