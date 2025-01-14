### 19. Remove Nth Node From End of List

To solve the problem of removing the \( n \)-th node from the end of a linked list in **one pass**, you can use the
two-pointer technique. Here's the step-by-step explanation and implementation:

---

### Algorithm Explanation

1. **Initialize Two Pointers**:
    - Use two pointers, `first` and `second`, both starting at the dummy node (a dummy node is added to simplify edge
      cases like removing the first node).

2. **Advance the `first` Pointer**:
    - Move the `first` pointer \( n + 1 \) steps ahead. This ensures that when `first` reaches the end of the list, the
      `second` pointer will be one node before the node to be removed.

3. **Move Both Pointers**:
    - Move both `first` and `second` pointers one step at a time until `first` reaches the end of the list.

4. **Remove the Target Node**:
    - Adjust the `next` pointer of the `second` pointer to skip the target node.

5. **Return the Modified List**:
    - Return the list starting from the node after the dummy node.

---

### Java Implementation

```java
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Add a dummy node at the beginning
        ListNode dummy = new ListNode(0, head);

        // Initialize two pointers
        ListNode first = dummy;
        ListNode second = dummy;

        // Move `first` pointer n + 1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until `first` reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Skip the target node
        second.next = second.next.next;

        // Return the modified list
        return dummy.next;
    }
}
```

---

### Complexity Analysis

1. **Time Complexity**: \( O(n) \)
    - The list is traversed only once, where \( n \) is the number of nodes in the list.

2. **Space Complexity**: \( O(1) \)
    - Only a constant amount of extra space is used (pointers and dummy node).

---

### Example Walkthrough

#### Input: \( \text{head} = [1,2,3,4,5], n = 2 \)

- Initial list: \( 1 \to 2 \to 3 \to 4 \to 5 \)
- After moving `first` \( n+1 \) steps: `first` points to `null`, `second` points to node \( 3 \).
- Remove node \( 4 \): \( 1 \to 2 \to 3 \to 5 \).

#### Output: \( [1, 2, 3, 5] \)

This approach ensures an efficient, single-pass solution to the problem.