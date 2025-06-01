class Solution {
    public Node sortedInsert(Node head, int data) {
        Node prev = null;
        Node node = head;

        do {
            prev = node;
            node = node.next;
        } while (node != head);

        while (node.data < data) {
            node = node.next;
            prev = prev.next;
            if (node == head) {
                break;
            }
        }

        Node newNode = new Node(data);
        prev.next = newNode;
        newNode.next = node;

        if (head.data > data) {
            return newNode;
        } else {
            return head;
        }
    }
}
