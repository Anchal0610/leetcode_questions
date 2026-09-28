/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void mark_parent(TreeNode root, Map<TreeNode , TreeNode> parent_track, TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode current = q.remove();
            if(current.left != null){
                parent_track.put(current.left , current);
                q.add(current.left);
            }
            if(current.right != null){
                parent_track.put(current.right , current);
                q.add(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> parent_track = new HashMap<>();
        mark_parent(root , parent_track , root);
        Map<TreeNode , Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);
        visited.put(target , true);
        int curr_level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(curr_level == k){
                break;
            }
            curr_level++;
            for(int i=0 ; i<size ; i++){
                TreeNode curr = q.remove();
            
            if(curr.left != null && visited.get(curr.left) == null){
                q.add(curr.left);
                visited.put(curr.left , true);
            }
            if(curr.right != null && visited.get(curr.right) ==  null){
                q.add(curr.right);
                visited.put(curr.right , true);
            }
            if(parent_track.get(curr) != null && visited.get(parent_track.get(curr))== null){
                q.add(parent_track.get(curr));
                visited.put(parent_track.get(curr) , true);
            }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode current  = q.remove();
            ans.add(current.val);
        }
        return ans;
    }
}