import { Tree } from "istanbul-lib-report";

class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

// N = Number of nodes
// TC: O(N) SC: O(1)
function sumNumbers(root: TreeNode | null): number {
  // Global Variable
  let result = 0;

  // Recursive Function
  function helper(root: TreeNode | null, currentSum: number) {
    if (root == null) return;
    let newSum: number = currentSum * 10 + root.val;
    if (root.left == null && root.right == null) {
      result += newSum;
    }

    helper(root.left, newSum);
    helper(root.right, newSum);
  }

  // Main Code
  helper(root, result);
  return result;
}

describe("Find Max Profit", () => {
  it("Happy Path", () => {
    let root = new TreeNode(4);
    root.left = new TreeNode(9);
    root.right = new TreeNode(0);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(1);
    expect(sumNumbers(root)).toStrictEqual(1026);
  });
});
