import {
  TreeNode,
  buildTreeFromPreOrder,
} from "../../helpers/binary_tree_helpers";
function getDirections(
  root: TreeNode | null,
  startValue: number,
  destValue: number
): string {
  let path: string[] = [];
  let foundStart = false;
  let foundDest = false;
  // FIND LCA
  function lca(node: TreeNode | null): TreeNode | null {
    if (node == null) return node;
    if (startValue < node.val && destValue < node.val) {
      return lca(node.left);
    } else if (startValue > node.val && destValue > node.val) {
      return lca(node.right);
    }
    return node;
  }
  let lcaNode: TreeNode | null = lca(root);
  function traverse(node: TreeNode | null) {
    if (node == null) {
      return;
    }
    console.log("Val: " + node.val);
    if (node.val == startValue) {
      console.log("Found Start");
      foundStart = true;
    }
    if (node.val == destValue) {
      console.log("Found End");
      foundDest = true;
    }
    if (node.left != null) {
      if (foundStart == true) {
        path.push("L");
      }
      traverse(node.left);
      path.pop();
    }
    if (node.right != null) {
      if (foundStart == true) {
        path.push("R");
      }
      traverse(node.right);
      path.pop();
    }
    path.push("U");
  }
  traverse(lcaNode);
  return path.join("");
}

describe("2096. Step-By-Step Directions From a Binary Tree Node to Another", () => {
  it("Happy Path", () => {
    let root = buildTreeFromPreOrder([5, 1, 2, 3, null, 6, 4])!;
    expect(getDirections(root, 3, 6)).toStrictEqual("UURL");
  });
});
