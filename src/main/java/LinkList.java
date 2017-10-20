
public class LinkList {
    public Node head;

    public boolean isEmpty() {
        return head == null;
    }
    public Node CreateNode(int info) {
        return new Node(info);
    }
    public void Append(int info) {
        if (isEmpty()) {
            head = CreateNode(info);
        } else {
            head.next = CreateNode(info);
        }
    }
}
