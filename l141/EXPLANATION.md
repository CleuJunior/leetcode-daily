### 141. Linked List Cycle

---

### **Problem Statement**

You are given the head of a linked list. Determine if the linked list contains a cycle. A cycle occurs if there is a node in the list that can be reached again by following the `next` pointer continuously. Return `true` if a cycle exists, otherwise return `false`.

---

### **Example**

#### Example 1

Input:

```plaintext
head = [3, 2, 0, -4], pos = 1
```

Output:

```plaintext
true
```

Explanation:

- The tail connects to the 1st node (0-indexed), forming a cycle.

---

#### Example 2

Input:

```plaintext
head = [1, 2], pos = 0
```

Output:

```plaintext
true
```

Explanation:

- The tail connects to the 0th node, forming a cycle.

---

#### Example 3

Input:

```plaintext
head = [1], pos = -1
```

Output:

```plaintext
false
```

Explanation:

- No cycle exists in the linked list.

---

### **Constraints**

1. The number of nodes in the list is in the range `[0, 10^4]`.
2. `-10^5 <= Node.val <= 10^5`.
3. `pos` is `-1` or a valid index in the linked list.

---

### **Approach to Solve**

#### 1. **Floyd's Cycle Detection Algorithm (Tortoise and Hare)**

- Use two pointers:
   - **Slow Pointer (Tortoise):** Moves one step at a time.
   - **Fast Pointer (Hare):** Moves two steps at a time.
- If there is a cycle, the two pointers will eventually meet inside the cycle.
- If the fast pointer reaches the end of the list (`null`), there is no cycle.

---

### **Algorithm Explanation**

1. **Initialization**:
   - If the list is empty (`head == null`) or has only one node (`head.next == null`), return `false`.

2. **Cycle Detection**:
   - Traverse the list with the slow and fast pointers.
   - If the two pointers meet, a cycle exists.
   - If the fast pointer reaches the end of the list, there is no cycle.

3. **Return Result**:
   - Return `true` if a cycle is detected.
   - Return `false` otherwise.

---

### **Code Example**

#### **Java Solution**

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer by 1 step
            fast = fast.next.next;  // Move fast pointer by 2 steps

            if (slow == fast) {
                return true; // Pointers meet, cycle detected
            }
        }

        return false; // No cycle detected
    }
}
```

---

### **Why Floyd's Algorithm?**

- It achieves **O(1)** space complexity because no extra data structures are used.
- The time complexity is **O(n)** since each pointer traverses the list at most once.

---

### **Visualization**

**Input Linked List**: `head = [3, 2, 0, -4], pos = 1`

**Traversal Process**:

1. **Initialization**:
   - Slow Pointer = Node 3
   - Fast Pointer = Node 3

2. **First Iteration**:
   - Slow Pointer moves to Node 2
   - Fast Pointer moves to Node 0

3. **Second Iteration**:
   - Slow Pointer moves to Node 0
   - Fast Pointer moves to Node 2

4. **Third Iteration**:
   - Slow Pointer moves to Node -4
   - Fast Pointer moves to Node -4

**Result**:
- Slow Pointer meets Fast Pointer at Node -4.
- A cycle is detected. Return `true`.