// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        ans = list()
        def helper(node,num,nums):
            if not node:
                return nums.append("0")
            
            if not node.left and not node.right:
                num += str(node.val)
                nums.append(num)
                return
            num += str(node.val)
            
            helper(node.left,num,nums)
            helper(node.right,num,nums)
            
        helper(root,"",ans) 
        return int(reduce(lambda x,y:int(x)+int(y),ans))