package medium;

class PopulatingNextRightPointersinEachNodeII {
    private void connect(TreeLinkNode root) {
        if(root == null)
            return;

        TreeLinkNode cur = root;
        TreeLinkNode last_visit = null;     // the last visited node
        TreeLinkNode next_head = null;

        while (cur != null){

            if (next_head == null){
                if (cur.left != null)       // store head of next level
                    next_head = cur.left;
                else if (cur.right != null)
                    next_head = cur.right;
            }

            if (cur.left != null){
                if (last_visit != null)
                    last_visit.next = cur.left;
                last_visit = cur.left;      // this level is still empty
            }

            if (cur.right != null){
                if (last_visit != null)
                    last_visit.next = cur.right;
                last_visit = cur.right;
            }

            if (cur.next != null){
                cur = cur.next;
            } else {
                cur = next_head;
                next_head = null;
                last_visit = null;
            }
        }

        return;
    }
}
