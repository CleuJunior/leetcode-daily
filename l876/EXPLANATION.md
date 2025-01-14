### 876. Middle of the Linked List

To solve the problem, we can use the **fast and slow pointer technique**, which is efficient and widely used in linked
list problems.

---

### **Approach**

1. **Fast and Slow Pointers**:
    - Use two pointers: a `slow` pointer and a `fast` pointer.
    - Move the `slow` pointer one step at a time, while the `fast` pointer moves two steps at a time.
    - When the `fast` pointer reaches the end of the list (or becomes `null`), the `slow` pointer will be at the middle
      of the list.

2. **Handling Even Number of Nodes**:
    - If there are two middle nodes (in the case of an even-length list), the `slow` pointer will naturally point to the
      second middle node due to the two-step movement of the `fast` pointer.

---

### **Implementation**

Here?s the Java implementation:

```java
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer twice as fast as the slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow pointer now points to the middle node
        return slow;
    }
}
```

---

### **Explanation**

1. **Initialization**:
    - `slow` and `fast` both start at the head of the list.

2. **Traverse the List**:
    - Move `slow` one step (`slow = slow.next`).
    - Move `fast` two steps (`fast = fast.next.next`).
    - Continue until `fast` is `null` or `fast.next` is `null`.

3. **Return the Middle Node**:
    - The `slow` pointer will point to the middle node when the loop ends.

---

### **Complexity Analysis**

1. **Time Complexity**:
    - Traversing the list takes \(O(n)\), where \(n\) is the number of nodes.

2. **Space Complexity**:
    - No additional space is used, so \(O(1)\).

---

### **Example Walkthrough**

#### **Example 1**

Input: `head = [1,2,3,4,5]`

1. Initial:
    - `slow = 1`, `fast = 1`

2. Iteration 1:
    - `slow = 2`, `fast = 3`

3. Iteration 2:
    - `slow = 3`, `fast = 5`

4. End:
    - `fast.next = null`, return `slow = 3`.

Output: `[3,4,5]`

---

#### **Example 2**

Input: `head = [1,2,3,4,5,6]`

1. Initial:
    - `slow = 1`, `fast = 1`

2. Iteration 1:
    - `slow = 2`, `fast = 3`

3. Iteration 2:
    - `slow = 3`, `fast = 5`

4. Iteration 3:
    - `slow = 4`, `fast = null`

5. End:
    - `fast = null`, return `slow = 4`.

Output: `[4,5,6]`

---

### **Key Notes**

- The fast and slow pointer technique ensures an \(O(n)\) solution with constant space.
- For even-length lists, this method naturally points to the second middle node, satisfying the problem constraints.