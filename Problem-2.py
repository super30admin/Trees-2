class Solution:
    def sumNumbers(self, root: TreeNode) -> int:


        s = []
        result=0
        cursum =0
        while (root is not None or len(s)!=0):
            while root:
                cursum = cursum*10+root.val
                s.append((root,cursum))
                root=root.left

            pair = s.pop()
            root = pair[0]
            cursum = pair[1]
            if root.left is None and root.right is None:
                result+=cursum
            root=root.right

        return result
