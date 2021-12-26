# // Time Complexity : O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    idx = 1
    indexes = {}
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        # self.idx = len(postorder) - 1
        for i in range(0,len(inorder)):
            self.indexes[inorder[i]] = i

        return self.buildLeftRight(postorder,inorder,0,len(postorder)-1)



    def buildLeftRight(self,postorder,inorder,start,end):
        if (start>end):
            return None
        else:
            retNode = TreeNode()

            retNode.val = postorder[-self.idx]
            print(-self.idx)
            print( postorder[-self.idx])
            self.idx += 1

            #get the index
            if retNode == None:
                return None
            elif start==end:
                return retNode
            else:
                idx_hashmap = self.indexes[retNode.val]
                remaining_nums = idx_hashmap - len(inorder)
                retNode.right = self.buildLeftRight(postorder,inorder,idx_hashmap+1,end)
                retNode.left = self.buildLeftRight(postorder,inorder,start,idx_hashmap-1)

                return retNode
