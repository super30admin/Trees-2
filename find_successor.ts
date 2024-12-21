import { help } from "yargs";

import {
  BinaryTree,
  constructBinaryTree,
  TreeData,
} from "../../helpers/binary_tree_helpers";

// TODO: Improve logic for other edge cases
export function findSuccessor(tree: BinaryTree, node: BinaryTree) {
  // Write your code here.
  let previous: BinaryTree | null = null;
  let successor: BinaryTree | null = null;
  function helper(root: BinaryTree | null, node: BinaryTree) {
    if (root == null || successor != null) return;

    helper(root.left, node);
    if (previous?.value == node.value) {
      successor = root;
      return;
    }
    previous = root;
    helper(root.right, node);
  }

  helper(tree, node);
  return successor;
}

describe("Find Successor", () => {
  it("Happy Path", () => {
    const treeData: TreeData = {
      nodes: [
        { id: "1", left: "2", parent: null, right: "3", value: 1 },
        { id: "2", left: "4", parent: "1", right: "5", value: 2 },
        { id: "3", left: null, parent: "1", right: null, value: 3 },
        { id: "4", left: null, parent: "2", right: null, value: 4 },
        { id: "5", left: "6", parent: "2", right: "7", value: 5 },
        { id: "6", left: null, parent: "5", right: null, value: 6 },
        { id: "7", left: "8", parent: "5", right: null, value: 7 },
        { id: "8", left: null, parent: "7", right: null, value: 8 },
      ],
      root: "1",
    };
    let root: BinaryTree = constructBinaryTree(treeData)!;
    expect(findSuccessor(root, root.left!.right!)).toStrictEqual(root);
  });
});
