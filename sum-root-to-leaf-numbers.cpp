//Time complexity - O(n) n-number of nodes
//Space complexity - O(n) memory heap space

class Solution {
public:
    vector<int> nums;
    int sum = 0;
    int sumNumbers(TreeNode* root) {
        if(root == NULL) return 0;
        sumTheNumbers(root,root->val);
        return sum;
    }
    
    void sumTheNumbers(TreeNode* root, int n){
        if(root->left == NULL && root->right == NULL){
            cout<<n<<endl;
            sum+=n;
            return;
        }
        
        if(root->left){
            sumTheNumbers(root->left, n*10 + root->left->val);
        }
        if(root->right){
            sumTheNumbers(root->right, n*10 + root->right->val);
        }
    }
    
};