import { stat } from "graceful-fs";
import { Tree } from "istanbul-lib-report";
import { help } from "yargs";
import { BinaryTree } from "../../helpers/binary_tree_helpers";

export function invertBinaryTree(tree: BinaryTree | null): BinaryTree | null {
  post_order_traversal(tree);
  return tree;
}

let post_order_traversal = function (root: BinaryTree | null) {
  if (root == null) {
    return;
  }

  post_order_traversal(root.left);
  post_order_traversal(root.right);

  let temp = root.left;
  root.left = root.right;
  root.right = temp;
  temp = null;
};

describe("Invert Binary Tree", () => {
  it("Happy Path", () => {
    let root = new BinaryTree(1);
    root.left = new BinaryTree(2);
    root.left.left = new BinaryTree(4);
    root.left.left.left = new BinaryTree(8);
    root.left.left.right = new BinaryTree(9);
    root.left.right = new BinaryTree(5);
    root.right = new BinaryTree(3);
    root.right.left = new BinaryTree(6);
    root.right.right = new BinaryTree(7);
    expect(invertBinaryTree(root)).toStrictEqual(true);
  });
});
