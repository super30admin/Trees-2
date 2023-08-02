# Time Complexity :O(N)
# Space Complexity :O(LogN + N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach



class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if(len(postorder)==0):
            return None
        ind=-1
        root=TreeNode (postorder[-1])
        n=len(postorder)
        
        for i in range(len(inorder)):
            if(inorder[i]==root.val):
                ind=i
                break
        # return self.helper(preorder, 0, len(preorder), inorder, 0, len(inorder))
        root.left=self.buildTree(inorder[:ind], postorder[:ind])
        root.right=self.buildTree(inorder[ind+1:], postorder[ind:n-1])
        return root
