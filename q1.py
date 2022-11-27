from typing import List,Optional
# Time Complexity : O(n), Where n is number of nodes in the binary tree
# Space Complexity : O(n), Where n is number of nodes in the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothinh Specific

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def constructUniqueBinaryTree(self,poso: List[int],ino: List[int],posoindex1: int,posoindex2: int,inoindex1: int, inoindex2: int, hashmap: dict):
        if(posoindex1>posoindex2 or inoindex1>inoindex2):
            return None
        #Clearly rootvalue is present at the end of the postorder
        rootval=poso[posoindex2]
        root=TreeNode(rootval)
        #Let us find the rootval in the inorder
        i=hashmap.get(rootval)
        #Let us find length of nodes in the left subtree in inorder
        left=i-inoindex1
        root.left=self.constructUniqueBinaryTree(poso,ino,posoindex1,posoindex1+left-1,inoindex1,i-1,hashmap)
        root.right=self.constructUniqueBinaryTree(poso,ino,posoindex1+left,posoindex2-1,i+1,inoindex2,hashmap)
        return root
    
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        #This is an edge case
        if(len(inorder)==0 and len(postorder)==0):
            return None
        else:
            dic={}
            index=0
            #Let us create a hashmap which stores the index of all elements in the inoder traversal
            for i in inorder:
                dic[i]=index
                index+=1
            #print(dic)
            return self.constructUniqueBinaryTree(postorder,inorder,0,len(postorder)-1,0,len(inorder)-1,dic)
        