#Time Complexity : O(N^2), N being the number of values in tree. 
#Space Complexity : O(h), h being the height of the tree, or O(logN).
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Had extreme difficulty with this one. Had to 
#look at the solution after many failed attempts. 

#Your code here along with comments explaining your approach in three sentences only
'''Using recursion, split the inorder and preorder arrays and recurse on the split arrays, 
while adding nodes to trees. 
'''
class Solution:
    def helper(self,preorder, inorder, root):
        if len(preorder)==0:
            return None
        else:
            #add to root 
            root = TreeNode(preorder[0])
            #find index of value in in order array. 
            index=-1
            for i in range(len(inorder)):
                if root.val==inorder[i]:
                    index=i
                    break      
            #split arrays 
            left_inorder = inorder[0:index]
            left_preorder = preorder[1:1+len(left_inorder)]
            right_inorder = inorder[index+1:len(inorder)]
            right_preorder = preorder[1+len(left_inorder):len(preorder)]
            root.left=self.helper(left_preorder, left_inorder, root.left)
            root.right=self.helper(right_preorder, right_inorder, root.right)
            
            return root

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:  
        root = None
        result = self.helper(preorder, inorder, root)
        return result
        