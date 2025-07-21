#time complexity: O(n) as we are visiting all the nodes
#space complexity: O(h) as we are traversing to the end of the leaves 
                # And it is determined by the maximum depth of the recursive stack.
                #h - height of the tree  -worst case O(n^2) - where it is like linked list
                                        #best case is O(log(n)) - where th etree is equally distributed.



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(node, currentsum) -> int:
            #explain all the nodes
            #at a current node 
            if not node:
                return 0

            
            #when we reach the current node , and the current sum consists of predeccesors. so we multiply the sum by 10 and the current node value.
            
            currentsum = (currentsum * 10) + node.val

            #after calculating that present leaf node value only we have to return it 

            # if it is a leaf node
            if not node.left and not node.right:
                return currentsum
            

            #now that we have calculate the sum a node we need to proceed to it childs by going to left and right sub trees 
            #overall sum becomes the additioon of it.

            return dfs(node.left, currentsum) + dfs(node.right, currentsum)
        
        return dfs(root, 0)
