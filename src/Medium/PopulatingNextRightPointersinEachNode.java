package medium;

class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
}

class PopulatingNextRightPointersinEachNode {

    private void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode cur = root;
        TreeLinkNode first_of_row = null;
        while(cur != null){
            if(first_of_row == null)
                first_of_row = cur.left;    // save the head of next level

            if(cur.left != null){
               cur.left.next = cur.right;
            } else {
              break;    // is a leaf
            }

            if(cur.next != null){
                cur.right.next = cur.next.left;
                cur = cur.next;
            } else {
                cur = first_of_row;
                first_of_row = null;
            }

        }

        return;
    }
}
