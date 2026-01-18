/**
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
  Intuition:
   In postorder, the last element is always the root.
   Using inorder, that root splits the tree into left and right subtrees.
   Since we traverse postorder backwards, we must build right subtree first, then left subtree.

   T.C: O(N), S.C: O(N)
 */
var buildTree = function (inorder, postorder) {
    let inOrderMap = new Map();
    for (let i = 0; i < inorder.length; i++) {
        inOrderMap.set(inorder[i], i);
    }
    let postIdx = postorder.length - 1;
    const helper = (start, end) => {
        // base case
        if (start > end) return null;
        // action
        const currRoot = postorder[postIdx];
        postIdx--;
        const rootIdx = inOrderMap.get(currRoot);
        // create node
        const root = new TreeNode(currRoot);
        // right subtree first
        root.right = helper(rootIdx + 1, end);
        // left subtree
        root.left = helper(start, rootIdx - 1);
        return root;
    }
    return helper(0, inorder.length - 1);
};