# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to set a two pointer start and end and pop the element from postorder based on left, right, root traversal and limit the pointers in inorder.

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        d={}
        for i in range(0,len(inorder)):
            d[inorder[i]] = i
        print(d)
        return self.helper( postorder,d,0, len(inorder)-1)
    
    def helper(self, postorder,d,start, end ):
        print(start,end)
        if start>end:
            return None
        
        p=postorder[-1]
        root=TreeNode(postorder.pop(-1))
        rootidx=d[p]
        root.right=self.helper(postorder, d, rootidx+1, end)
        root.left=self.helper(postorder, d, start, rootidx-1)

        return root