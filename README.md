# Trees-2

## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
* from postorder take the rootVal & its idx bcz root will be at the end
* construct inLeft & inRight array using Arrays.copyOfRange function using that rootIdx
* construct postLeft & postRight arrays using the leftSize of inLeft;

## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
* Concept of local var & global var is imp here
* total sum will be global var, node level currSum will be local var
* currSum = currSum*10+ root.val
