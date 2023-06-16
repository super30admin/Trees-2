#Time complexity is: O(n)
#Space complexity is: O(n)
#Code ran successfully on leet code
#No issues faced while coding the program

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        #initialising the index to last index since we are given with post order
        self.idx=len(inorder)-1
        #Creating a dictionary to store the keys and values
        self.map={}
        for i in range(0,len(inorder)):
            self.map[inorder[i]]=i
        #We will be calling helper function by sending the required parameters which returns the final tree
        return self.helper(postorder,inorder,0,len(inorder)-1)
    
    def helper(self,postorder,inorder,start,end):
        #Is the start exceeds the end, we will return nothing
        if(start>end):
            return None
        rootVal=postorder[self.idx]
        #We will be returnig the index value by 1 since we are taking post order
        self.idx-=1
        root=TreeNode(val=rootVal)
        rootIdx=self.map[rootVal]
        #Moving towards the right side of the tree
        root.right=self.helper(postorder,inorder,rootIdx+1,end)
        #moving towards the left side of the tree
        root.left=self.helper(postorder,inorder,start,rootIdx-1)
        #returning the final tree
        return root