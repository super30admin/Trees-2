#iterative and recursive approach
#TC - O(n) - n is numberof nodes
#SC - O(h) - h is height

# recursive
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
       
        def dfs(cur,num):
            if not cur:
                return 0
            
            num = num * 10 + cur.val
            if not cur.left and not cur.right:
                return num
            return dfs(cur.left, num) + dfs(cur.right, num)
        return dfs(root,0)

#iterative
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        res = 0
        st = []
        if root:
            st.append(root)
        while st:
            node = st.pop()
            if not node.left and not node.right:
                res += node.val
            if node.right:
                node.right.val += node.val*10
                st.append(node.right)
            if node.left:
                node.left.val += node.val*10
                st.append(node.left)
        return res
        