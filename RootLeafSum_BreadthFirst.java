//@Time Complexity - O(N)
//@Space Complexity - O(N)

package RootLeafSum_BreadthFirst;
import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair; 

//import jdk.internal.util.xml.impl.Pair;


public class RootLeafSum_BreadthFirst {
	public static class TreeNode {
	int val;
    TreeNode left;
   TreeNode right;
    TreeNode(int x) 
    { 
   	 val = x; 
     }
    
}

static TreeNode root; 
	public int sumNumbers(TreeNode root)
    {
        //Check for Edge cases
        int result = 0;
       
        if(root == null)
        {
            return 0;
        }
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));
        
        while(!queue.isEmpty())
        {
            Pair<TreeNode,Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int value = pair.getValue();
            
            if(node!=null)
            {
                value = value*10+node.val;
                
                if(node.left == null && node.right == null)
                {
                    result += value;
                }
                
                queue.offer(new Pair(node.left, value));
                queue.offer(new Pair(node.right, value));
            }
        }
        
        return result;
    }
	public static void main(String[] args) {
		RootLeafSum_BreadthFirst tree = new RootLeafSum_BreadthFirst(); 
        tree.root = new TreeNode(6); 
        tree.root.left = new TreeNode(3); 
        tree.root.right = new TreeNode(5); 
        tree.root.right.right = new TreeNode(4); 
        tree.root.left.left = new TreeNode(2); 
        tree.root.left.right = new TreeNode(5); 
        tree.root.left.right.right = new TreeNode(4); 
        tree.root.left.right.left = new TreeNode(7); 
           
        System.out.print("Sum of all paths is " +  
                                 tree.sumNumbers(root));  


	}

}
