//  129_Sum_Root_To_Leaf_Numbers

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

//Definition for a binary tree node.

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


class Pair{
    
    TreeNode* node;
    int sum;
    
public:
    Pair(): node(NULL), sum(0){};
    Pair(TreeNode* node, int sum): node(node), sum(sum){};
    
    TreeNode* getNode(){
        return node;
    }
    
    int getSum(){
        return sum;
    }

};


class Solution {
public:
    
    // Approach:  Iterative Peorder tarversal, push pair of node and current sum to stack. once we reach child node, extract the sum corresponding to child node and add it to result.
    // TC: O(N), N - number of nodes in a tree
    // SC: O(h+N) - height of the tree
    
    int sumNumbers(TreeNode* root) {
        if(root == NULL)
            return 0;
        int sum=0, result=0;
        stack<Pair> s;
        while(root!=NULL || s.empty() == false){
            while(root!=NULL){
                sum = sum * 10 + root->val;
                Pair obj(root, sum);
                s.push(obj);
                root=root->left;
            }
            Pair obj = s.top();
            s.pop();
            root=obj.getNode();
            sum=obj.getSum();
            if(root->left == NULL && root->right == NULL){
                result += sum;
            }
            root = root->right;
        }
     return result;
    }
    
    // Approach:  Recursive Peorder tarversal
    // TC: O(N), N - number of nodes in a tree,
    // SC: O(h) - height of the tree
    
    int sumNumbersRecursive(TreeNode* root) {
        int sum=0;
        return recursiveSolution(root,sum);
        
    }
    
    int recursiveSolution(TreeNode* root, int sum){
       if(root == NULL)
           return 0;
        
       if(root->left == NULL && root->right == NULL)
           return sum*10 + root->val;
        
        int left = recursiveSolution(root->left, sum*10 + root->val);
        int right = recursiveSolution(root->right, sum*10 + root->val);
        
        return left + right;
    }
};


int main(int argc, const char * argv[]) {
    TreeNode* node = new TreeNode(1);
    node->left = new TreeNode(2);
    node->right = new TreeNode(3);
    Solution s;
   // s.sumNumbers(node);
    cout << s.sumNumbersRecursive(node)<<"\n";
    return 0;
}
