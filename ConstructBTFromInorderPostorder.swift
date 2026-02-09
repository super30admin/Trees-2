//
//  ConstructBinaryTreeFromInorderTraversal.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/19/26.
//

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init() { self.val = 0; self.left = nil; self.right = nil; }
 *     public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
 *     public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
 *         self.val = val
 *         self.left = left
 *         self.right = right
 *     }
 * }
 */
class BinaryTreeFromInorderAndPostorder {
    var postOrderIdx = 0
    func buildTree(_ inorder: [Int], _ postorder: [Int]) -> TreeNode? {
        postOrderIdx = postorder.count - 1
        var inMap = Dictionary<Int, Int>()
        for (index, element) in inorder.enumerated() {
            inMap[element] = index
        }
        return constructTree(postorder, inMap: inMap, inStart: 0, inEnd: inorder.count - 1)
    }

    func constructTree(_ postorder: [Int], inMap: Dictionary<Int, Int>, inStart: Int, inEnd: Int) -> TreeNode? {
        //base
        if (inStart > inEnd) {
            return nil
        }
        
        //logic
        let rootVal = postorder[postOrderIdx]
        postOrderIdx -= 1
        let root = TreeNode(val: rootVal, left: nil, right: nil)
        let rootIdx = inMap[rootVal]!

        //recurse
        root.right = constructTree(postorder, inMap: inMap, inStart: rootIdx + 1, inEnd: inEnd)
        root.left = constructTree(postorder, inMap: inMap, inStart: inStart, inEnd: rootIdx - 1)

        return root
    }
}
