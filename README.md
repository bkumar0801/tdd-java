# Learn Test Driven Development Using JAVA
> I am going to explain you a very basic implementation of `Singly Linkedlist` making use of test driven development methodology. The whole idea is to help larger audience (irrespective of their experties and experience) understand `how it works?`. But feel free to choose another implementation and accordingly, write test cases to evolve code.

### What is TDD ?
> Its an approach where programmer must first write a failing unit test even without an implementation. Then, write just enough code to make that test pass. Once the test is passed, if needed programmer may refactor code to improve design or behavior.

### Advantages of TDD
- Developing with TDD has valuable advantages:
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


