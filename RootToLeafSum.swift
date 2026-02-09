//
//  RootToLeafSum.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/15/26.
//

/*
 Whatever has gone into the stack will be out with the same values.
 */
class BinarySearchTree3 {
    
    var result: Int = 0
    
    init() {
        let node1 = TreeNode(val: 3, left: nil, right: nil)
        let node2 = TreeNode(val: 9, left: nil, right: nil)
        
//        let pathSum = sumNumbers(root: TreeNode(val: 5, left: node1, right: node2))
//        print("paths sum \(pathSum)")
    }
    
    func sumNumbers(_ root: TreeNode?) -> Int {
        let r = helper(root, currentNum: 0)
        print("r \(r)")
        return r
    }
    
    func helper(_ root: TreeNode?, currentNum: Int) -> Int {
        guard let root else {
            return 0
        }
        
        let curr = currentNum * 10 + root.val
        if (root.left == nil && root.right == nil) {
            return curr
        }
        let pathSumFromLeftSubtree = helper(root.left, currentNum: curr)
        let pathSumFromRightSubtree =  helper(root.right, currentNum: curr)
        return pathSumFromLeftSubtree + pathSumFromRightSubtree
    }
    
    
    func rootToLeafPathSum(root: TreeNode?, currentNum: Int) -> Int {
        
        guard let root = root else {
            return 0
        }
        
        let currentNum = currentNum * 10 + root.val
        if (root.left == nil && root.right == nil) {
            return currentNum
        }
        
        let leftSum = rootToLeafPathSum(root: root.left, currentNum: currentNum)
        let rightSum = rootToLeafPathSum(root: root.right, currentNum: currentNum)
        return leftSum + rightSum

    }
    
    //with global result parameter.
    func helper(root: TreeNode?, currentNum: Int) {
        
        var currentNum = currentNum
        //base
        guard let root else {
            return
        }
        //logic
        currentNum = currentNum * 10 + root.val
        //check if the current node is a leaf
        //action
        if (root.left == nil && root.right == nil) {
            result += currentNum
        }
        
        helper(root: root.left, currentNum: currentNum)
        helper(root: root.right, currentNum: currentNum)
    }
}
