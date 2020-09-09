
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach 

class Solution(object):
    def buildTree(self, inorder, postorder):

        def helper(poS, poE, inS, inE, inorder, postorder):
            if poS > poE or inS > inE:
                return None
            
            index_root = TreeNode(postorder[poE])
            idx = - 1
            for i in range(inS, inE + 1):
                if inorder[i] == index_root.val:
                    idx = i
                    break
            offset = idx - inS
            index_root.left = helper(poS, poS + offset - 1,inS ,idx-1, inorder, postorder)
            index_root.right = helper(poS + offset, poE - 1, idx+1, inE, inorder, postorder)
            
            return index_root
        
        
        
        
        return helper(0, len(postorder)-1, 0, len(inorder)-1, inorder, postorder)
        