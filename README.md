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
Once you have written your first test case in any IDE, you would see three red code snippets (in short, the code is in non-compilable state).

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

