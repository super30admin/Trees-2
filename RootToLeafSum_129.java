/**
Time complexity: O(N) where N is number of nodes
Space complexity: O(H) stack space where H is height of the tree recursive DFS, O(N) for iterative
Algorithm:
=========
1. Update sum in every instance of recursive call from root to every leaf
2. If leaf node, return total sum * 10 + its own value
3. Add all the subtrees' sum to get total sum of entire tree
 */

//========================= Recursive DFS =====================================
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumTree(root, 0);
    }
    
    private int sumTree(TreeNode root, int sum) {
        //base case
        if(root == null) return 0;          // null check 
        if(root.left == null && root.right == null) return sum*10 + root.val; //leaf node
       
        //logic
        return sumTree(root.left, sum*10+root.val) + sumTree(root.right, sum*10 + root.val); //left and right recursive methods
    }
}

//========================= Iterative DFS =====================================
/**
        4
       / \
      9   0
     / \
    5   1
    
Algorithm:
=========
1. Create stack of pairs(node, value). Add root to stack first. Use 2 variables: one to keep track of sum in current path and other totalSum
2. While stack is not empty: 
    i. Keep popping nodes and updating currSum. 
    ii. Once updated, push right and left nodes with updated currsum. Note that it is RIGHT first in stack because we need to pop LEFT
    nodes first
    iii. Once leaf nodes are reached, add currSum*10+leafNodeValue to total Sum
 */
class Solution {
     class Pair {
        int sum; 
        TreeNode node;
        
        public Pair(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }
    
    public int sumNumbers(TreeNode root) {
    int sum = 0;
    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(root, 0));
        
    while (!stack.isEmpty()) {
        Pair p = stack.pop();
        TreeNode node = p.node;
        int value = p.sum;
        if (node != null) {
            value = value*10 + node.val;
            if (node.left == null && node.right == null) {
                sum += value;
            }
            stack.push(new Pair(node.right, value));                
            stack.push(new Pair(node.left, value));
        }
    }
    return sum;
}
}



//========================= BFS =====================================

/**
Algorithm:
==========
1. Create queue of pairs(node, value). Add root to queue first. Use 2 variables: one to keep track of sum in current path and other totalSum
2. While queue is not empty: 
    i. Keep polling nodes and updating currSum. 
    ii. Once updated, push left and right nodes with updated currsum
    iii. Once leaf nodes are reached, add currSum*10+leafNodeValue to total Sum
 */
class Solution {
    class Pair {
        int sum; 
        TreeNode node;
        
        public Pair(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }
    public int sumNumbers(TreeNode root) {
        if( root == null) return 0;
        
        Queue<Pair> bfs = new LinkedList<>();               
        bfs.add(new Pair(root, 0));                         // Add root to queue
        int sum = 0;
        
        while(!bfs.isEmpty()) {             
            Pair p = bfs.poll();                            // poll the node from queue
            TreeNode node = p.node;
            int soFar = p.sum;
            
            if(node != null) {                              
                int currSum = soFar*10 + node.val;          // update current sum
                if(node.left == null && node.right == null) 
                    sum += currSum;                         // If leaf node, update totalSum
                bfs.add(new Pair(node.left, currSum));      //Add left and right nodes to the queue to be processed similarly
                bfs.add(new Pair(node.right, currSum));
            }
        }
        return sum;
    }
}