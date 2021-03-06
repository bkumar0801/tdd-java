# Learn Test Driven Development Using JAVA
> I am going to explain you a very basic implementation of `Singly Linkedlist` making use of test driven development methodology. The whole idea is to help larger audience (irrespective of their experties and experience) understand `how it works?`. But feel free to choose another implementation and accordingly, write test cases to evolve code.

### What is TDD ?
> Its an approach where programmer must first write a failing unit test even without an implementation. Then, write just enough code to make that test pass. Once the test is passed, if needed programmer may refactor code to improve design or behavior.

### Advantages of TDD
- You have a better understanding of a feature you implement
- You have robust indicators of feature completeness
- Low maintenance cost
- 100% testable code
- Code is covered with tests and has less chance to be corrupted by fixes or new features

The cost of these advantages is pretty high. It’s a price of quality.

### Example: Singly LinkedList Implementation

#### Test Case – 1:
``` 
public class LinkListTest {
    @Test
    public void shouldTestEmptyLinkList() {
        LinkList linkList = new LinkList();
        assertEquals(true, linkList.isEmpty());
    }
}
```
Once you have written your first test case in any IDE, you would see three red symbols (in short, the code is in non-compilable state).

First red : `Linklist`
Second red : `Linklist()`
Third red: `isEmpty()`

The reason is very simple, we have no implementation yet : there is no class `Linklist` and method `isEmpty()`. You would have to introduce minimum code which would make the above code compilable and test passed.

#### Evolved code:
```
public class LinkList {
    public boolean isEmpty() {
        return true;
    }
}
```
> Skill to identify tests are crucial and key to be a successful XP engineer

#### Test Case - 2
```
public class LinkListTest {
    @Test
    public void shouldTestNodeCreatedSuccessfully() {
        LinkList linkList = new LinkList();
        Node actual = linkList.CreateNode(10);
        assertNotEquals(null, actual);
    }
}
```
Again two more symbols are red : `Node` and `CreateNode()`. Let's introduce minimum code to resolve these symbols : 
   - Another class `Node` and
   - `CreateNode` method in `LinkList` class with a parameter of `int` type 
   
These informations are very clear from the written test case. The test is `assertNotEquals(null, actual)`, it means, to make this test pass `CreateNode(int info)` should just return a valid `Node` object, and that's enough.

#### Evolved code
```
public class LinkList {
    public boolean isEmpty() {
        return true;
    }
    public Node CreateNode(int info) {
        return new Node(info);
    }
}

public class Node {
    public Node(int info) {
    }
}
```
#### Test Case – 3 
```
public class LinkListTest {
    @Test
    public void shouldTestLinkedListAppendASingleNode() {
        LinkList linkList = new LinkList();
	assertEquals(true, linkList.isEmpty());
        linkList.Append(10);
        assertEquals(false, linkList.isEmpty());
        assertNotEquals(null, linkList.head);
        assertEquals(10, linkList.head.info);
        assertEquals(null, linkList.head.next);
    }
}
```
Let's understand the test first: 
- First assert is `assertEquals(true, linkList.isEmpty())` : initially linklist is empty
- Then add one node using `Append` method. Here symbol `Append` is in red as no such method exist in class `LinkList`
- After adding a node, LinkList should not be empty, so second assert `assertEquals(false, linkList.isEmpty())`
- We know that in Singly Linklist we have a `head` pointer which always points to the first node. So the next assert (head shouldn't be null): `assertNotEquals(null, linkList.head)`. Since there is no such symbol `head` is present, this will be unresolved or in red
- We would also like to test, if the information is stored in the node. `assertEquals(10, linkList.head.info)` should ensure that information is stored in the node. But symbol `info` will is unresolved now.
- Finally, if linklist has only one node, first node's next should not point to other node. This will ensure there is only one node present : `assertEquals(null, linkList.head.next)`. Again, symbol `next` is unresolved.

Test case 3 has four more red or unresolved symbols : `Append`, `head`, `info` and `next`. Let's first resolve symbols by introducing them in the code : write `Append` method in `LinkList` class, `head` data member of `Node` type in the same class, `info` and `next` data members in `Node` class. 

#### Evolved Code
```
public class LinkList {
    public Node head;
    public boolean isEmpty() {
        return true;
    }
    public Node CreateNode(int info) {
        return new Node(info);
    }
    public void Append(int info) {
    }
}

public class Node {
    public int info;
    public Node next;
    public Node(int info) {
    }
}
```

Now, let's run this test.
Second test `assertEquals(false, linkList.isEmpty())` would fail. Let's look at the implementation of `isEmpty()`. 
```
public boolean isEmpty() {
        return true;
}
```
The reason for failure is, it always returns `true`. But our expectation is, when we `Append` a node, it should return `false` instead of `true` everytime. That means, we feel to refactor `isEmpty()` method.
Since this depends upon `Append`, so, empty check should be based on head pointer which points to first node in singly linkedlist. If head is null, it means, linkedlist is empty else its not.
```
public boolean isEmpty() {
        return head == null;
}
```
