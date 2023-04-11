class Solution {
    // TC - O(n)
    // SC - O(1)
public:
    int sum =0;
    int sumNumbers(TreeNode* root) {
        calculateSumNumbers(root);
        return sum;
    }
    void calculateSumNumbers(TreeNode* root) {
        if(root->left == NULL && root -> right == NULL){
            sum = sum + root ->val;
           cout<< sum<<endl;
            return;
        }
        if(root -> left){
            (root->left)->val =  (root->left)->val +((root->val)*10);
            calculateSumNumbers(root->left);
        }
        if(root -> right){
            (root->right)->val =  (root->right)->val +((root->val)*10);
            calculateSumNumbers(root->right);
        }

    }

}