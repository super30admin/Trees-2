  ---------------------- Construct Binary Tree Inorder Preorder------------------------------------------------   
# Time Complexity : O(N) N is the number of nodes.
# Space Complexity : O(N) N is the number of nodes using dict
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here postorder is the order of nodes with root node at the last. Inorder is the order where root node will be in the middle. 
# In this sense, the nodes on the left indexes of element are its left nodes and right are its right nodes. Also the postorder will have all the root nodes in the last.
# So recursively , we will create a root with postorder last index element and find the index of the element in inorder using dict and assign the left elements to root.left and right elements to root.right.
# and we will call recursive function again with new preorder and inorder.
#In this solution I used start and end pointer to check the left nodes and right nodes from inorder list.

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        n = len(inorder)
        i = n-1
        d = {inorder[i]: i for i in range(n)}
        
        def dfs(start,end):
            nonlocal i
            
            if start>end:
                return None
            
            root = TreeNode(postorder[i])
            i -=1
            index = d[root.val]
            root.right = dfs(index+1,end)
            root.left = dfs(start,index-1)
            
            return root
        
        return dfs(0,n-1)
        
    
----------------------------Iteratively------------------------------------------------  
# Time Complexity : O(N) N is the number of nodes.
# Space Complexity : O(N) N is the number of nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# So we will create a node with postorder elements from last and check the position of that element with respect to the prev created node using stack.
# If it is greater the new node the prev node right is the new node element , else we will remove elements from stack untill we reach the left root of that node.

   def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        d = {inorder[i]: i for i in range(len(inorder))}
        
        stack = []
        root = None
        for i in range(len(postorder)-1, -1, -1):
            val = postorder[i]
            if not root:
                root = TreeNode(val)
                stack.append(root)
            else: 
                node = TreeNode(val)
                if d[val]>d[stack[-1].val]:
                    stack[-1].right = node
                else:
                    while stack and d[stack[-1].val]>d[val]:
                        u = stack.pop()
                    u.left =node
                stack.append(node)
        return root