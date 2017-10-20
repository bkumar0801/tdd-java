import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LinkListTest {
    @Test
    public void shouldTestLinkListIsEmpty() {
        LinkList linkList = new LinkList();
        assertEquals(true, linkList.isEmpty());
    }
    @Test
    public void shouldTestNodeCreatedSuccessfully() {
        LinkList linkList = new LinkList();
        Node actual = linkList.CreateNode(10);
        assertNotEquals(null, actual);
    }
    @Test
    public void shouldTestLinkedListHasASingleNode() {
        LinkList linkList = new LinkList();
        assertEquals(true, linkList.isEmpty());
        linkList.Append(10);
        assertEquals(false, linkList.isEmpty());
        assertNotEquals(null, linkList.head);
        assertEquals(10, linkList.head.info);
        assertEquals(null, linkList.head.next);
    }

    @Test
    public void shouldTestLinkedListHasTwoNodes() {
        LinkList linkList = new LinkList();
        assertEquals(true, linkList.isEmpty());
        linkList.Append(10);
        assertEquals(false, linkList.isEmpty());
        linkList.Append(15);
        assertNotEquals(null, linkList.head);
        assertEquals(10, linkList.head.info);
        assertNotEquals(null, linkList.head.next);
        assertEquals(15, linkList.head.next.info);
        assertEquals(null, linkList.head.next.next);
    }
}
