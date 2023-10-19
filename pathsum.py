# Time Complexity : O(n)
# Space Complexity :O(height)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# did in both void-recursion and int-recursion. We will recursively iterate trhough left and right nodes of teh tree and add the values. 
# when we reach the leaf node, we add the curresnt sum we got till that leaf node to the final result
class Solution(object):
#    void recursion
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        def sumPath(root,currsum):
            if not root: return  
            print(root.val)
            currsum=currsum*10+root.val
            if (root.left==None and root.right==None):
                result[0]+=currsum
            sumPath(root.left,currsum)
            sumPath(root.right,currsum)
        
        # result=0
        result=[0]
        sumPath(root, 0)
        return result[0]
    
    # int recursion
    # def sumNumbers(self, root):
    #     def sumpath(root,currsum):
    #         if not root:
    #             return 0
    #         currsum=currsum*10+root.val
    #         if(root.left==None and root.right==None):
    #             return currsum
    #         left=sumpath(root.left,currsum)
    #         right=sumpath(root.right,currsum)
    #         return left+right
        
    #     return sumpath(root,0)