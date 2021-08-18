class Solution:

  def buildTree(self, inorder, postorder):

    map_inorder = dict()

    for index, val in enumerate(inorder):

      map_inorder[val] = index

    return self.helper(inorder, 0, len(inorder) - 1, postorder, 0, len(postorder) - 1, map_inorder)  def helper(self, inorder, instart, inend, postorder, poststart, postend, map_inorder):

    if instart > inend or poststart > postend:

      return None

    rootVal = postorder[postend]

    root = TreeNode(rootVal)

    rootidx = map_inorder[rootVal]

    formula = postend - (inend - rootidx)

    root.left = self.helper(inorder, instart, rootidx - 1, postorder, poststart, formula - 1, map_inorder)

    root.right = self.helper(inorder, rootidx + 1, inend, postorder, formula, postend - 1, map_inorder)

    return root   

% TC : O(n)
% SC : O(h)