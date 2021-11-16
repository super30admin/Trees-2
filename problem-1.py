#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : yes
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        dict_inorder = {v:i for i, v in enumerate(inorder)}
        self.index = 1
        def build(idx_left, idx_right):
            if idx_left > idx_right:
                return None
            root = TreeNode(postorder[-self.index])
            self.index += 1
            idx_root = dict_inorder[root.val]
            root.right = build(idx_root+1, idx_right)
            root.left = build(idx_left, idx_root-1)
            return root
        return build(0, len(inorder)-1)
        