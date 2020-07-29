class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        def helper(r,number):
            nonlocal total
            if r:
                number=number*10+r.val
                if r.left==None and r.right==None:
                    total+=number
                print(number)
                helper(r.left,number)
                helper(r.right,number)
        total=0
        helper(root,0)
        return total

#Time-Complexity:O(N)
#Space-Complexity: O(H)  H is the height of Tree