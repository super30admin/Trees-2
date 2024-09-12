#Time Complexity:O(n^2)
#Space Complexity:O(n^2)
#Ran successfuly on Leetcode:Yes
#I will identify the root by taking last element from postorder and find its respective index in the inorder array. 
#Then I define left and right array of the postorder as well as right order and find out the root.left and root.right. 

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
             if not inorder or not postorder:
                    return None

             val=postorder[-1]
             root=TreeNode(val)
             index=0
             # index=inorder.index(val)
             for i in range(len(inorder)):
                    if inorder[i]==val:
                        index=i
                        break
             root.left=self.buildTree(inorder[:index],postorder[:index])
             root.right=self.buildTree(inorder[index+1:],postorder[index:-1])
             return root


                
        
