# Time Complexity : O(n), n is the number of nodes
# Space Complexity : O(H), height of the tree (for recursive stack)
# The last element in post list is the root of the binary tree. 
# Use a hash map to get the index of root node in the inorder array in O(1) time. 
# In the Inorder array, the things to the left correspond to the left sub tree and things to the right correspond to the right sub tree.
# Recursively call the helper function on the left and right sub portion of the array

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        hashmap={}

        for i in range(len(inorder)): #hashmap to get rootval index in inorder in O(1)
            hashmap[inorder[i]]=i
        idx=len(postorder)-1

        def helper(postorder,start,end):
            nonlocal idx
            #base
            if start>end or idx<0: return 

            #logic
            rootval=postorder[idx] #get elements in the order of preorder to build next root at each level 
            idx-=1
            root=TreeNode(rootval) #build the tree 
            rootidx=hashmap[rootval] #get rootval index in inorder 
            #here, you need to go right first, as in post order, it's left-right-root and we are moving backwards in the post array
            root.left=helper(postorder,start,rootidx-1) #recruse left with start same and end at rootidx-1
            root.right=helper(postorder,rootidx+1,end)#recruse right with start end and root at rootidx+1

            return root
        return helper(postorder,0,len(inorder)-1)


        

