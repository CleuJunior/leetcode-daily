### 206. Reverse Linked List

---

### **Understanding the Problem**

A **singly linked list** is a data structure where each node contains:

1. **Data**: The value stored in the node.
2. **Next Pointer**: A reference (or pointer) to the next node in the sequence.

To reverse a singly linked list, we need to change the direction of the `next` pointers so that they point to the
previous node instead of the next node.

---

### **Steps to Reverse a Linked List**

1. **Iterative Method**:
    - Use three pointers: `prev`, `current`, and `next`.
    - Initially, set `prev` to `null` (end of the reversed list) and `current` to the head of the list.
    - Traverse the list and adjust the pointers:
        - Store the next node using `next = current.next`.
        - Reverse the `next` pointer of the `current` node to point to `prev`.
        - Move `prev` and `current` one step forward.
    - Continue until `current` becomes `null` (end of the original list).
    - Set the head of the list to `prev`.

2. **Recursive Method**:
    - Base Case: If the current node is `null` or its `next` is `null`, return the node as the new head.
    - Recursive Case:
        - Reverse the rest of the list starting from the `next` node.
        - Set the `next` pointer of the current node's next to the current node (reversing the link).
        - Set the current node?s `next` to `null` to break the original forward link.

---

### **Pseudocode**

#### **Iterative Method**

```plaintext
function reverseLinkedList(head):
    prev = null
    current = head
    while current is not null:
        next = current.next        // Save the next node
        current.next = prev        // Reverse the pointer
        prev = current             // Move prev one step forward
        current = next             // Move current one step forward
    return prev                    // New head of the reversed list
```

#### **Recursive Method**

```plaintext
function reverseLinkedListRecursive(head):
    if head is null or head.next is null:
        return head               // Base case: single node or end of list
    newHead = reverseLinkedListRecursive(head.next) // Reverse rest of list
    head.next.next = head         // Reverse the link for the current node
    head.next = null              // Break the original link
    return newHead                // New head of the reversed list
```

---

### **Code Examples**

#### **Iterative Solution in Java**

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    // Method to reverse the list
    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;  // Save the next node
            current.next = prev;      // Reverse the link
            prev = current;          // Move prev forward
            current = next;         // Move current forward
        }
        
        return prev;              // Return of the reverse linked list
    }
}
```

#### **Recursive Solution in Java**

```java
public class LinkedList {
    Node head;

    // Method to reverse the list recursively
    public Node reverseList(Node current) {
        if (current == null || current.next == null) {
            return current; // Base case
        }

        Node newHead = reverseList(current.next); // Reverse the rest
        current.next.next = current; // Reverse the link
        current.next = null; // Break the original link

        return newHead; // Return new head
    }
}
```

---

### **Complexity Analysis**

1. **Time Complexity**:
    - Both iterative and recursive methods traverse the list once.
    - **O(n)** where `n` is the number of nodes.

2. **Space Complexity**:
    - Iterative: **O(1)** (in-place reversal).
    - Recursive: **O(n)** due to the recursion stack.

---

### **Example Walkthrough**

#### Original List:

`10 -> 20 -> 30 -> 40 -> null`

#### Reversing Iteratively:

1. `prev = null`, `current = 10`, `next = 20`
    - Reverse link: `10 -> null`
    - Move forward: `prev = 10`, `current = 20`
2. `prev = 10`, `current = 20`, `next = 30`
    - Reverse link: `20 -> 10`
    - Move forward: `prev = 20`, `current = 30`
3. `prev = 20`, `current = 30`, `next = 40`
    - Reverse link: `30 -> 20`
    - Move forward: `prev = 30`, `current = 40`
4. `prev = 30`, `current = 40`, `next = null`
    - Reverse link: `40 -> 30`
    - Move forward: `prev = 40`, `current = null`

#### Reversed List:

`40 -> 30 -> 20 -> 10 -> null`