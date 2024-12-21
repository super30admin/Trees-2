import { Tree } from "istanbul-lib-report";
import {
  TreeNode,
  buildTreeFromPreOrder,
} from "../../helpers/binary_tree_helpers";

function lowestCommonAncestor(
  root: TreeNode | null,
  p: TreeNode | null,
  q: TreeNode | null
): TreeNode | null {
  function dfs(current: TreeNode | null): TreeNode | null {
    if (current == null) return null;

    if (p!.val < current.val && q!.val < current.val) return dfs(current.left);
    else if (p!.val > current.val && q!.val > current.val)
      return dfs(current.right);
    else return current;
  }
  return dfs(root);
}

function lowestCommonAncestorIterative(
  root: TreeNode | null,
  p: TreeNode | null,
  q: TreeNode | null
): TreeNode | null {
  while (root != null) {
    if (p!.val < root.val && q!.val < root.val) root = root.left;
    else if (p!.val > root.val && q!.val > root.val) root = root.right;
    else return root;
  }
  return root;
}

function lowestCommonAncestorInBT(
  root: TreeNode | null,
  p: TreeNode | null,
  q: TreeNode | null
): TreeNode | null {
  let pathP: TreeNode[] = [];
  let pathQ: TreeNode[] = [];

  function traverse(node: TreeNode | null, path: TreeNode[]) {
    if (node == null) {
      return;
    }
    if (node == p) {
      pathP = [...path, node];
      pathP.push(node);
    } else if (node == q) {
      pathQ = [...path, node];
      pathQ.push(node);
    }
    path.push(node);
    traverse(node.left, path);
    traverse(node.right, path);
    path.pop();
  }
  traverse(root, []);

  for (let index = 0; index < pathP.length; index++) {
    if (pathP[index] != pathQ[index]) {
      return pathP[index - 1];
    }
  }
  return null;
}

function lowestCommonAncestorInBTBottomUp(
  root: TreeNode | null,
  p: TreeNode | null,
  q: TreeNode | null
): TreeNode | null {
  function traverse(node: TreeNode | null): TreeNode | null {
    if (node == null || node == p || node == q) {
      return node;
    }
    let left = traverse(node.left);
    let right = traverse(node.right);
    if (left == null && right == null) return null;
    else return left || right || node;
  }
  return traverse(root);
}

describe("235. Lowest Common Ancestor of a Binary Search Tree", () => {
  it("Happy Path", () => {
    let root = buildTreeFromPreOrder([6, 2, 8, 0, 4, 7, 9, null, null, 3, 5])!;
    expect(
      lowestCommonAncestor(root, root.left!.left, root.right!.left)
    ).toStrictEqual(root);
  });

  it("Happy Path - Iterative", () => {
    let root = buildTreeFromPreOrder([6, 2, 8, 0, 4, 7, 9, null, null, 3, 5])!;
    expect(
      lowestCommonAncestorIterative(root, root.left!.left, root.right!.left)
    ).toStrictEqual(root);
  });
});


describe("236. Lowest Common Ancestor of a Binary Tree", () => {
  it("Happy Path", () => {
    let root = buildTreeFromPreOrder([6, 2, 8, 0, 4, 7, 9, null, null, 3, 5])!;
    expect(
      lowestCommonAncestorInBT(root, root.left!.left, root.right!.left)
    ).toStrictEqual(root);
  });

  it("Happy Path - Iterative", () => {
    let root = buildTreeFromPreOrder([6, 2, 8, 0, 4, 7, 9, null, null, 3, 5])!;
    expect(
      lowestCommonAncestorInBTBottomUp(root, root.left!.left, root.right!.left)
    ).toStrictEqual(root);
  });
});
