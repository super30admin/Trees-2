# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.postOrderIndex = len(postorder)-1;
        self.inorderhash = {}
        for index,val in enumerate(inorder):
            self.inorderhash[val] = index
        return self.build(postorder,inorder,0,len(inorder)-1)
    def build(self, postorder: List[int], inorder: List[int],start,end):
        
        #base
        if start >end:
            return
        
        #rec
        val = postorder[self.postOrderIndex]
        index = self.inorderhash[val]
        self.postOrderIndex -= 1
        
        root = TreeNode(val)
        root.right = self.build(postorder,inorder,index+1,end)
        root.left = self.build(postorder,inorder,start,index-1)

        
        return root