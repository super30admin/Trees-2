import { help } from "yargs";

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

//
function buildTree(postorder: number[], inorder: number[]): TreeNode | null {
  let root = helper(postorder, inorder);
  return null;
}

let helper = function (
  postorder: number[],
  inorder: number[]
): TreeNode | null {
  if (postorder.length == 0 && inorder.length == 0) return null;

  let root = new TreeNode(postorder[0]);

  let root_idx = 0;

  for (let index = 0; index < inorder.length; index++) {
    if (inorder[index] == root.val) {
      root_idx = index;
      break;
    }
  }
  let leftInorder: number[] = inorder.slice(0, root_idx);
  let rightInorder: number[] = inorder.slice(root_idx + 1, inorder.length);

  let leftpostorder: number[] = postorder.slice(1, leftInorder.length + 1);

  let rightpostorder: number[] = postorder.slice(
    leftpostorder.length + 1,
    postorder.length
  );

  root.left = helper(leftpostorder, leftInorder);
  root.right = helper(rightpostorder, rightInorder);

  return root;
};

let post_order_idx: number = 0;
let map = new Map<number, number>();
function buildTree_optimised(
  postorder: number[],
  inorder: number[]
): TreeNode | null {
  // Build Map
  for (let index = 0; index < inorder.length; index++) {
    map.set(inorder[index], index);
  }
  post_order_idx = postorder.length - 1;
  // Call The Helper
  let root = helper_optimised(postorder, 0, inorder.length - 1);
  return root;
}

let helper_optimised = (
  postorder: number[],
  start: number,
  end: number
): TreeNode | null => {
  if (start > end) return null;

  let root_val: number = postorder[post_order_idx];
  let root = new TreeNode(root_val);
  let root_idx_in_inorder: number = map.get(root_val)!;
  post_order_idx -= 1;

  root.right = helper_optimised(postorder, root_idx_in_inorder + 1, end);
  root.left = helper_optimised(postorder, start, root_idx_in_inorder - 1);

  return root;
};

describe("Find Max Profit", () => {
  it("Backtracking Happy Path", () => {
    expect(
      buildTree_optimised([9, 15, 7, 20, 3], [9, 3, 15, 20, 7])
    ).toStrictEqual([
      [5, 4, 11, 2],
      [5, 8, 4, 5],
    ]);
  });

  it("Backtracking Happy Path 02", () => {
    expect(buildTree_optimised([-1], [-1])).toStrictEqual([
      [5, 4, 11, 2],
      [5, 8, 4, 5],
    ]);
  });
});
