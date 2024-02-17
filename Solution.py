class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        time: O(n)
        space: O(1)
        """
        ans = [0]
        def helper(t, cur_sum=0):
            if not t:
                return       
            cur_sum = cur_sum * 10 + t.val     
            if not t.left and not t.right:
                ans[0] += cur_sum           
            helper(t.left, cur_sum)
            helper(t.right, cur_sum)
        helper(root)
        return ans[0]

    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        time: O(n)
        space: O(1)
        """
        inorder_map = {inorder[i]: i for i in range(len(inorder))}
        def helper(root_idx, inorder_start, inorder_end):
            if inorder_start > inorder_end:
                return None
            root_val = postorder[root_idx]
            inorder_root_idx = inorder_map[root_val]
            right_subtree_size = inorder_end - inorder_root_idx
            right = helper(root_idx - 1, inorder_root_idx+1, inorder_end)
            left = helper(root_idx - right_subtree_size - 1, inorder_start, inorder_root_idx - 1)
            return TreeNode(root_val, left, right)
        return helper(len(postorder)-1, 0, len(inorder)-1)