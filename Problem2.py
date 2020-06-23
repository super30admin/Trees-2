"""

    Student : Shahreen Shahjahan Psyche
    Time :  O(N)
    Space: O(H) -> Stack Space

    This code ran successfully for all the test cases in Leetcode

"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        
        # edge case
        if not root:
            return 0
        
        # finding the sum
        def find_sum(root, temp_sum):
            
            nonlocal running_sum
            
            # if root is valid
            if root:
                temp_sum = temp_sum * 10 + root.val
                
                # checking the leaf node
                if not root.left and not root.right:
                    running_sum += temp_sum
                
                find_sum(root.left, temp_sum)
                find_sum(root.right, temp_sum)
            else:
                return
            
#             if root == None:
#                 running_sum += temp_sum
#                 return running_sum
            
#             temp_sum = temp_sum * 10 + root.val
            
#             r1 = find_sum(root.left, temp_sum, running_sum)
#             r2 = find_sum(root.right, temp_sum, running_sum)
            
#             running_sum += (r1 + r2)
            
#             return running_sum

        running_sum = 0
        temp_sum = 0
        find_sum(root, temp_sum)
        
        return running_sum
            
            
        