"""
// Time Complexity : O(d) //d is depth of the tree
// Space Complexity : O(d) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
Algorithm explanation
DFS: Configuration A = [](holds list of all paths in the form of string), P = [](holds current path in form of string)
    1) We append the root
    2) If we approach the leaf then update A with stringify version of P's path
    3) Else
        recurse root.left
        recurse root.right
    4) P.pop() -> Bactracking to caller node to consider all paths
Main fn
1) Initialize sm = 0
2) ITerate over A
    Append int of number to sm
3) return sum

Alternative approach
- We update the sum at the leaf node by ompuating (current_Sm + root)* 10
and passing that recursively in left and right
- If we hit leaf, update current sum and global sum
- return global sum
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        P = []
        A = []
        
        def helper(root):
            if not root:
                return
            P.append(root.val)
            if not root.left and not root.right:
                A.append(''.join(map(str,P)))
            else:
                helper(root.left)
                helper(root.right)
            P.pop()
        helper(root)
        
        sm = 0
        for i in A:
            sm+=int(i)
        #print(A)
        return sm
        """
        Easier method - space optimal
        1. Tail recursion - obtaining the sum at leaf node
        2. Main computation - current_sm = (current_sm + root) * 10, Pass to left and right
        3. If node is leaf: udpdate current_sm and global sm
        """
        
        def helper(root,current_sm):
            if not root:
                return
            if not root.left and not root.right:
                current_sm += root.val
                self.global_sm +=current_sm
            val = (current_sm + root.val) * 10
            helper(root.left,val)
            helper(root.right,val)
        
        self.global_sm = 0
        helper(root,0)
        return self.global_sm