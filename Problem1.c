/* Problem Statement:
Verified on leetcode

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7


 *
 * Time Complexity : O(n) 
 * Space Complexity : O(n)
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
#include<math.h>
#include<limits.h>


/**
 * Definition for a binary tree node.
 */
 struct TreeNode {
     int val;
     struct TreeNode *left;
     struct TreeNode *right;
 };

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

#define HT_SIZE 20000

/* its a HashMap implementation for numbers */

int postorder_idx = 0;
struct hash_array
{
    int key;
    int value;
    bool valid;
    struct hash_array* next;
}hash_array[HT_SIZE];

/* Add entry in hash table. If entry exists, increment value
 *
 */
void add_entry_hash_table(int num, int val)
{
    int temp = abs(num % HT_SIZE);

    if(hash_array[temp].key==0) {
        hash_array[temp].key = num;
        hash_array[temp].value = val;
        hash_array[temp].valid = true;

    }else if(hash_array[temp].key==num) {
        hash_array[temp].value = val;
        hash_array[temp].valid = true;
    }else {

        struct hash_array *p = &hash_array[temp];

        while(p->key!=num&&p->next!=NULL) {
                p=p->next;
        }

        if(p->key==num){
                p->value = val;
        }
        else
        {
            p->next=(struct hash_array*)calloc(1, sizeof(struct hash_array));
            p = p->next;
            p->key = num;
            p->value = val;
            p->valid = true;
            p->next = NULL;
        }
    }
}

/* Check if entry is present in hash table for the key. If yes, then return the
 * value stored for that hash table in value and return 0 or 1 based on success/failure */
int is_present_hash_table(int num, int *value)
{

    int temp = abs(num % HT_SIZE);

    if(hash_array[temp].key==num && hash_array[temp].valid == true)
    {
        *value = hash_array[temp].value;
        return 1;
    }else
    {
        struct hash_array *p=&hash_array[temp];
        while((p->key != num) && (p->next != NULL)) {
                p = p->next;
        }
        if(p->key==num && p->valid == true) {
         *value = p->value;
            return 1;
        }
        else
        {
            return 0;
        }
    }
    return 0;
}

/* Check if entry is present in hash table for the key. If yes, then return the
 * value stored for that hash table in value and return 0 or 1 based on success/failure */
int remove_hash_table_entry (int num)
{
    struct hash_array *temp_ptr = NULL;
    int temp = abs(num % HT_SIZE);

    if(hash_array[temp].valid == true && hash_array[temp].key==num)
    {
            hash_array[temp].key = 0;
            hash_array[temp].valid = false;
        return 1;
    }else
    {
        struct hash_array *p=&hash_array[temp];
        struct hash_array *prev = NULL;
        while((p->key != num) && (p->next != NULL)) {
                prev = p;
                p = p->next;
        }
        if(p->key==num && p->valid == true) {
            temp_ptr = p;
            if (prev != NULL)
                prev->next = p->next;
                free(temp_ptr);
            return 1;
        }
        else
        {
            return 0;
        }
    }
    return 0;
}

void free_hash_table() {
    int idx = 0;

    struct hash_array *p = NULL;
    struct hash_array *temp_ptr = NULL;

    for (idx = 0; idx < HT_SIZE; idx++) {
        p = &hash_array[idx];
        p = p->next;
        while (p != NULL) {
            temp_ptr = p;
            p = p->next;
            free(temp_ptr);
        }
    }
}

struct TreeNode* buildTree_helper(int left_idx, int right_idx, int *postorder) {
    int inorder_idx = 0;
    int root_val = 0;
    struct TreeNode* root = NULL;
    
    if (postorder_idx == -1) {
        return NULL;
    }
    if (left_idx > right_idx) {
        return NULL;
    }
    
    root_val = postorder[postorder_idx--];
    root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    
    if (!root) {
        printf("Memory allocation failed\n");
        return NULL;
    }
    /* Add entry to root */
    root->val = root_val;
    root->left = NULL;
    root->right = NULL; 
    
    /* Search in HT and get inorder idx*/
    is_present_hash_table(root_val,&inorder_idx);
    
    /* Search for right tree first and then left tree as its postorder */
    root->right = buildTree_helper(inorder_idx + 1, right_idx, postorder);
    root->left = buildTree_helper(left_idx, inorder_idx - 1, postorder);
    return root;
}

struct TreeNode* buildTree(int* inorder, int inorderSize, int* postorder, int postorderSize){
    int idx = 0;
    if (!inorderSize || !postorderSize) {
        return NULL;
    }
    
    /* Prepare global HT for inputs */
    memset(hash_array, 0, sizeof(struct hash_array) * HT_SIZE);
    
    /* Add entries in hashmap */
    for (idx = 0; idx < inorderSize; idx++) {
        add_entry_hash_table(inorder[idx], idx);
    }
    /* initialize with postorder size.*/
    postorder_idx = postorderSize - 1;
    
    return buildTree_helper(0, inorderSize - 1, postorder);
}


void inorder_traversal(struct TreeNode *root) {

  if (!root) {
    return;
  }
  inorder_traversal(root->left);
  printf("%d ", root->val);
  inorder_traversal(root->right);
}

int main(int argc, char *argv[]) {

    struct TreeNode *root = NULL;
    int inorder[5] = {9,3,15,20,7};
    int postorder[5] = {9,15,7,20,3};

    root = buildTree(inorder,5,postorder,5);
    printf("\n");
    inorder_traversal(root);
    printf("\n");
    return 0;
}


