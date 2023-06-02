class Solution {
    HashMap<Integer,Integer> map ;
    int idx;//index or pointer on postorder
    public TreeNode buildTree(int[] inorder,int [] postorder) {
       
        if(postorder == null || postorder.length == 0)return null;
        idx = postorder.length -1;
        
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
         map.put(inorder[i],i);   
        }
        return helper(postorder,0,inorder.length - 1);
    }
    private TreeNode helper(int [] postorder, int start,int end){//removing inorder from parameter because we never use it in recursion
        //base
        if(start > end)return null;

        //logic
        System.out.print(idx);
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        //root idx in my inorder arr
        int rootIdx = map.get(rootVal);
        root.right = helper(postorder,rootIdx + 1,end);
        root.left = helper(postorder,start,rootIdx - 1);
        
        return root;

    }
}

class Solution {
    public class Pair{
        TreeNode node;
        int value;
        public Pair(TreeNode node,int value){
            this.node = node;
            this.value = value;
        }
        public TreeNode getNode(){
            return this.node;
        }
        public int getValue(){
            return this.value;
        }
    }
    Stack<Pair> st;
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        st = new Stack<>();
        int num = 0;
        
        while(root != null || !st.isEmpty()){
            while(root != null){
            num = num*10 + root.val;
            System.out.print(""+num+",");
            Pair p = new Pair(root,num);
            st.push(p);
            root = root.left;
            }
            //st.pop
            Pair p = st.pop();
            root = p.getNode();
            num = p.getValue();

            if(root.left == null && root.right == null){
                //System.out.print("Sum"+p.getValue()+",");
                sum += num;    
            }

            root = root.right;
            }
        return sum;
    }
}
