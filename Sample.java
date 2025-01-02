//Problem 1
// Time Complexity : O(n)
// Space Complexity : O(n)

// inorder: left root right - will give you sense of left and right subtree
// predorder: root left right - will give you root

// Brute force (Time/Spce is O(n^2))
// maintain 4 lists inLeft, preLeft, inRight, preRight and recurse

// optimized
// make hashmap of inorder, two pointers on inorder(get start and end of subtree) and one pointer on preorder(main reference list)

class Solution:
    Idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        hashmap = {}
        for i in range(len(inorder)):
            hashmap[inorder[i]] = i
        #rootIdx => preorder
        def helper(in_start, in_end):
            if in_start > in_end: return None
            rootVal = preorder[self.Idx]
            rootIdx = hashmap[rootVal]
            self.Idx+=1
            root = TreeNode(rootVal)
            root.left = helper(in_start, rootIdx -1)
            root.right = helper(rootIdx + 1, in_end)
            return root

        return helper(0, len(inorder)-1)        

// Problem 2
// Time Complexity : O(n)
// Space Complexity : O(h)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        def dfs(node, current_path, current_sum):
            if(node==None): return
            current_path.append(node.val)
            current_sum+=node.val
            if node.left==None and node.right==None and current_sum==targetSum:
                result.append(list(current_path))
            dfs(node.left, current_path, current_sum)
            dfs(node.right, current_path, current_sum)
            current_path.pop()
        dfs(root, [], 0)
        return result
            
