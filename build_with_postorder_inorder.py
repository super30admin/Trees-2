# Time Complexity: O(n)
# Space Complexity: O(n) 
# Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: Optional[TreeNode]
        """
        hmap={}
        self.rootindex=len(postorder)-1
        for i in range(len(inorder)):
            hmap[inorder[i]]=i

        def helper(in_st,in_end):
            if (in_st>in_end): 
                return None

            rootval=postorder[self.rootindex]
            in_root_idx=hmap[rootval]
            root = TreeNode(rootval)
            self.rootindex-=1
            root.right = helper(in_root_idx+1,in_end)
            root.left = helper(in_st,in_root_idx-1)

            return root


        return helper(0,len(postorder)-1)