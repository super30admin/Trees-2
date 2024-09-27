  ---------------------- Sum Numbers in Tree------------------------------------------------   
# Time Complexity : O(Log N) N is the number of nodes.
# Space Complexity : O(Log N) N is the number of nodes using dict
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here while I am iterating I am taking both left node and right node and iterating at same time. while I am iterating I am appending the string number of that node value to temp and appending to stack, 
#Once I reach the leaf node and converting it to int and adding to total value.

______________Iteratively______________________________
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        total = 0
        queue = [(root, str(root.val))]
        while queue:
            curr, temp= queue.pop()

            if not curr.left and not curr.right:
                total += int(temp)
            if curr.left:
                queue.append((curr.left, temp+str(curr.left.val)))
            if curr.right:
                queue.append((curr.right,temp+str(curr.right.val)))

        return total
        

  ---------------------- Sum Numbers in Tree----------------------------Recursively Approach--------------------   
# Time Complexity : O(Log N) N is the number of nodes.
# Space Complexity : O(Log N) N is the number of nodes using dict
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here while I am iterating I am appending the string number of that node value to temp, 
#Once I reach the leaf node and converting it to int and adding to total value.

     
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        def dfs(root, temp):
            if not root:
                return 
            else:
                if not root.left and not root.right:
                    self.res += int(temp)
                else:
                    if root.left:
                        dfs(root.left, temp+str(root.left.val)) 
                    if root.right:
                        dfs(root.right, temp+str(root.right.val))
        
        self.res = 0
        dfs(root, str(root.val))
        return self.res        