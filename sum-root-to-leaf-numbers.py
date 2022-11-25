#TC: O(n)
#SC: O(height of tree)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        #Helper Func
        def sumNumbersHelper(root,cur_num):
            cur_num=10*cur_num+root.val
            if root.left==None and root.right==None:
                nonlocal _sum
                _sum+=cur_num
                return
            if root.left: sumNumbersHelper(root.left,cur_num)
            if root.right: sumNumbersHelper(root.right,cur_num)
        #Call the helper
        _sum=0
        sumNumbersHelper(root,0)
        return _sum