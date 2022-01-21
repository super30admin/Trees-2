# Definition for a binary tree node.

# TC :O(n) visiting all node
# SC :O(n) 
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        hashmap = dict()
        
        for i in range(len(inorder)):
            hashmap[inorder[i]] = i
            
        self.postIndex = len(postorder)-1
        
        def buildTreeHelper(inorder, preorder, instart, inend, hashmap):
            if instart > inend:
                return None
            # create new node from global preorder index
            curr = preorder[self.postIndex]
            self.postIndex -= 1
            currNode = TreeNode(curr)
            
            if inend == instart: # no children 
                return currNode
            
            inindex = hashmap[curr]
            currNode.right = buildTreeHelper( inorder, postorder, inindex + 1, inend , hashmap)
            currNode.left = buildTreeHelper( inorder, postorder, instart, inindex -1 , hashmap)
            
            return currNode 
                
            
            
        return buildTreeHelper(inorder, postorder, 0, len(inorder) - 1, hashmap )
        