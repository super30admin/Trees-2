# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Solution 1: Void function based Recursion
    - curr_path_sum : paramater of recursion, as it's a primitive data structure and it
                      preserves the state when recursion function returns at line of 
                      function call by doing one-to-one mapping
                      eg. (EXAMPLE 2), here when we reach 9, curr_path_sum is 4*10+9 
                      when we go to 5, it will become 49*10+5. however, when we return 
                      to 9, we need curr_path_sum to be 49 and not 495. 
    - answer : Global parameter. as it doesn't have to be mutated/overwritten. It needs
               to maintain it's value no matter where we traverse in the tree. if this
               set as parameter of recursion then, it enters recursion with value '0' 
               and after traversing left subtree, when it returns at 4, the answer 
               value be re-set to 0 (one-to-one mapping, primitive DS). 
    - Time Complexity: O(N) - visiting all nodes
    - Space Complexity: O(h) - recursive stack
'''
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.answer = 0
        self.helper(root, 0) # curr_root, curr_val

        return self.answer
    
    def helper(self,curr_node, curr_path_sum):
        # base
        if curr_node==None:
            return 

        # logic
        if curr_node.left==None and curr_node.right==None: # leaf node
            self.answer = self.answer + curr_path_sum*10+curr_node.val

        # left traverse
        self.helper(curr_node.left,curr_path_sum*10 + curr_node.val)
        # right traverse
        self.helper(curr_node.right,curr_path_sum*10 + curr_node.val)

'''
Solution 2: Int function based Recursion
    - Here answer will be return as a return of recursive calls.
    - curr_path_sum : paramater of recursion, as it's a primitive data structure and it
                      preserves the state when recursion function returns at line of 
                      function call by doing one-to-one mapping
                      eg. (EXAMPLE 2), here when we reach 9, curr_path_sum is 4*10+9 
                      when we go to 5, it will become 49*10+5. however, when we return 
                      to 9, we need curr_path_sum to be 49 and not 495. 
    - answer : Global parameter. as it doesn't have to be mutated/overwritten. It needs
               to maintain it's value no matter where we traverse in the tree. if this
               set as parameter of recursion then, it enters recursion with value '0' 
               and after traversing left subtree, when it returns at 4, the answer 
               value be re-set to 0 (one-to-one mapping, primitive DS). 
    - Time Complexity: O(N) - visiting all nodes
    - Space Complexity: O(h) - recursive stack
'''
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        return self.helper(root, 0) # curr_root, curr_val
    
    def helper(self,curr_node, curr_path_sum):
        # base
        if curr_node==None:
            return 0 

        # logic
        if curr_node.left==None and curr_node.right==None: # leaf node
            return curr_path_sum*10+curr_node.val

        # left traverse
        left_path_sum = self.helper(curr_node.left,curr_path_sum*10 + curr_node.val)
        # right traverse
        right_path_sum = self.helper(curr_node.right,curr_path_sum*10 + curr_node.val)

        return left_path_sum + right_path_sum