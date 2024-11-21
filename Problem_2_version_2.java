import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

public class Problem_2_version_2 {
	
	 public int sumNumbers(TreeNode root) {
	        
	        if(root == null){
	            return 0;
	        }
	        
	        int sum = 0;
	        Queue<Pair<TreeNode, Integer>> queue = new LinkedList();
	        queue.add(new Pair(root, 0));
	        
	        while(!queue.isEmpty()){
	            Pair<TreeNode, Integer> pair = queue.poll();
	            root = pair.getKey();
	            int value = pair.getValue();
	            
	            if(root != null){
	                value = value * 10 + root.val;
	                
	                if(root.left == null && root.right == null){
	                    sum = sum + value;
	                }
	                
	                queue.add(new Pair(root.left, value));
	                queue.add(new Pair(root.right, value));
	            }
	        }
	        return sum;
	    }

}
