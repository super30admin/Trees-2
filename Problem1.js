// ## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

var buildTree = function(inorder, postorder) {
        //**Time Complexity : O(n) */
    //**Space Complexity : O(n) */
    let hashMap = new Map()
    for(let i =0;i<inorder.length;i++){
        hashMap.set(inorder[i],i)
    }
    let rootIdx = postorder.length-1

    function helper(start,end){
        if(start > end) return null
        let rootVal = postorder[rootIdx];
        let root = new TreeNode(rootVal)
        let rootInInorder = hashMap.get(rootVal)
        rootIdx-=1
        root.right = helper(rootInInorder+1,end)
        root.left = helper(start,rootInInorder-1)
        return root
    }   

    return helper(0,inorder.length-1)

};

// var buildTree = function(inorder, postorder) {
//     //*Time Complexity : O(n^2)
//     //**Space Complexity : O(n) // create a subArray half(ing) it but still its O(n)
//     if(!inorder.length || !postorder.length){
//         return null
//     }
//     let rootVal = postorder[postorder.length-1]
//     let root = new TreeNode(rootVal)
//     let rootIndex = inorder.indexOf(rootVal)

//     let leftIn = inorder.slice(0,rootIndex)
//     let rightIn = inorder.slice(rootIndex+1)
//     let leftpost = postorder.slice(0,leftIn.length)
//     let rightpost = postorder.slice(leftIn.length, postorder.length - 1);

//     root.left = buildTree(leftIn,leftpost)
//     root.right = buildTree(rightIn,rightpost)
//     return root

// };