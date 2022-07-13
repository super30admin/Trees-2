# Time complexity: O(n)
# Space complexity:O(h)
# Approach: multiply the previous number by 10 and add it with root value
# if the node is leaf node, do the num * 10 with root val which is the latest value and add it to sum
# traverse to all nodes-left, right
# we are doing preorder since we want to visit the node first and add the left and right children to it.



class Solution:
    global sum
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        global sum
        sum = 0
        if root == None:
            return sum
        self.helper(root,0)
        return sum
    def helper(self,root,num):
        global sum
        #base case:
        if root == None:
            return
        
        #logic:
        if(root.left == None and root.right == None):
            sum = sum + ((num*10)+root.val)
            return 
        self.helper(root.left, (num*10)+root.val)
        self.helper(root.right, (num*10)+root.val)