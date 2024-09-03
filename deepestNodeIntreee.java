// import java.util.*;
// class Solution {
//     static class TreeNode{
//         int val;
//         TreeNode left;
//         TreeNode right;
//         public TreeNode(int val)
//         {
//             this.val =val;
//             this.left = null;
//             this.right =null;
//         }
//     }
//     public int height(TreeNode root)
//     {

//         int left = height(root.left);
//         int right = height(root.right);


//         int max = left + right + 1;

//         return max;
//     }
//     public TreeNode subtreeWithAllDeepest(TreeNode root) {
    
//     ArrayList<Integer> list = new ArrayList<>();
//     if(root  == null)
//     return null;

//     if (height(root.left) > height(root.right)) {
        
//         if (height(root.left) == height(root.right)) {
//             list.add(root.val);
//             list.add(root.left.val);
//             list.add(root.right.val);
//         }
//     }
     
//     }
// }
