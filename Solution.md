# Problem 1
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes

## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
        class Solution:
            def sumNumbers(self, root: TreeNode) -> int:
                return self.helper(root,0)

            def helper(self,root, val1):
                #Base Case
                if (root==None):
                    return 0 
                if (root.left==None and root.right==None):
                    return val1*10+root.val
                #Logic
                return self.helper(root.left, val1*10+root.val)+self.helper(root.right,val1*10+root.val)

# Problem 2
## Time Complexity :
O(n*n)

## Space Complexity :
O(n*n)

## Did this code successfully run on Leetcode :
Yes

## Any problem you faced while coding this :
Yes. I couldn't implement an optimal solution. I tried referring a similar question using Preorder and Inorder Traversal. (Leetcode #105)

## Your code here along with comments explaining your approach
### Solution:
    class Solution:
        def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
            #Edge case
            if not postorder or not inorder:
                return None

            root = TreeNode(postorder.pop()) #Finding root value from postorder
            inorderIndex = inorder.index(root.val) #Finding index of root value in inorder
            #Logic
            root.right = self.buildTree(inorder[inorderIndex+1:], postorder)
            root.left = self.buildTree(inorder[:inorderIndex], postorder)

            return root
