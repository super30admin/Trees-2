#Time complexity : O(n) i.e. n is the number of nodes in the tree
#Space complexity : O(n) i.e. n for storing elements in the hashmap
#Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #defining the index for the inorder array and it is global because it is changed in the recursion part
    index= 0
    #defining the hashmap for storing the index of the inorder
    inorderMap ={}
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        #root is at the last in postorder
        self.index = len(postorder)-1
        #null condition
        if len(postorder) == 0:
            return None
        #storing the value of inorder with there index in the hashmap
        for i in range(len(inorder)):
            val = inorder[i]
            self.inorderMap[val] = i
        """for index, val in enumerate(inorder):
                self.inorderMap[val]=index"""
        #calling the recursion for constructing the tree by sending the postorder list with the start and the end index
        return self.helper(postorder, 0,len(inorder)-1)

    def helper(self, postorder: List[int], startIndex : int, endIndex: int):
        #base conditon
        if startIndex > endIndex:
            return None
        #logic
        #taking the root value from the inorder index
        rootvalue = postorder[self.index]
        #print("Rootvalue", rootvalue)
        #decrementing postorder index everytime the recursion function is called
        self.index -=1
        #each time creating the new node to put the current root
        root = TreeNode(rootvalue)
        #f the index becomes less than 0 then return root
        if self.index<0:
            return root
        #fetching the index value of the rootvalue from the hashmap of the inorderMap
        rootIndex = self.inorderMap[root.val]
        #print("rootindex", rootIndex)
        #calling for the right part first because from taking the root values from postorder gives right side root first and then left side
        root.right = self.helper(postorder, rootIndex+1, endIndex)
        #print("root right: rootIndex+1" , rootIndex+1, " endIndex", endIndex)
        #calling for the left part
        root.left = self.helper(postorder, startIndex, rootIndex-1)
        #print("root left: startIndex+1" , startIndex, " rootIndex-1", rootIndex-1)
        return root
