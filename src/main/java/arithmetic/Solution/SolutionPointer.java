package arithmetic.Solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionPointer {

    static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

       public Node(int _val){
            val=_val;
       }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }

        @Override
        public String toString() {
            return  Integer.toString(this.val)+this.left.toString()+this.right+toString()+this.next.toString();

        }
    }


    public static void main(String[] args) {
        Node nodelef4=new Node(4);
        Node nodelef5=new Node(5);
        Node nodelef6=new Node(6);
        Node nodelef7=new Node(7);
        Node nodelef2=new Node(2,nodelef4,nodelef5,null);
        Node nodelef3=new Node(3,nodelef6,nodelef7,null);
        Node nodelef1=new Node(1,nodelef2,nodelef3,null);
        Node connect = Solution.connect(nodelef1);
        System.out.println(connect.toString());

    }
     static class Solution{
        private static Node[] nodes;
        private static int anInt=-1;

        public static Node connect(Node root){
           if (root==null) return null;
           nodes[root.val]=root;
           nodes[root.left.val]= root.left;
           nodes[root.right.val]=root.right;
           connect(nodes[root.left.val]);
           connect(nodes[root.right.val]);
           return root;
        }


    }
}
