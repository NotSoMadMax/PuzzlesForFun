package Hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        serialize(sb, root);

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() < 1)
            return null;

        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(" ")));

        return deserialize(q);
    }

    // helper function for serialize
    private static void serialize(StringBuilder sb, TreeNode cur){
        if(cur == null)
        {
            sb.append("#");
            sb.append(" ");
            return;
        }

        sb.append(cur.val);
        sb.append(" ");

        serialize(sb, cur.left);
        serialize(sb, cur.right);
    }


    // helper function for deserialize
    private static TreeNode deserialize(Queue<String> q){
        if(q.isEmpty())
            return null;

        String cur = q.poll();
        if(cur.equals("#"))
            return null;

        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = deserialize(q);
        root.right = deserialize(q);

        return root;
    }
}
