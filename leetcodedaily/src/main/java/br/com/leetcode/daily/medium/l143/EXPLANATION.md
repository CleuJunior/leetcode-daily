### 143. Reorder List

To solve the Reorder List problem, we need to reorder a singly linked list so that nodes are rearranged in a
specific pattern. Here?s how we can approach the problem:

---

### **Steps to Solve**

1. **Find the Middle of the List**:  
   Use the fast and slow pointer technique to find the middle of the list. The slow pointer will point to the middle,
   and the fast pointer will reach the end.

2. **Reverse the Second Half of the List**:  
   Reverse the second half of the list starting from the middle.

3. **Merge Two Halves**:  
   Merge the first half and the reversed second half in the required order.

---

### **Implementation**

Here's the Java code for the solution:

```java
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Step 3: Merge the two halves
        ListNode first = head;
        ListNode second = prev;

        while (second.next != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
```

---

### **Explanation**

1. **Find the Middle**:
    - Use two pointers (`slow` and `fast`) to traverse the list. When `fast` reaches the end, `slow` will be at the
      middle.

2. **Reverse the Second Half**:
    - Starting from the middle, reverse the linked list. This helps in rearranging the list later.

3. **Merge the Lists**:
    - Start from the head and alternate nodes from the first half and the reversed second half until all nodes are
      merged.

---

### **Complexity Analysis**

1. **Time Complexity**:
    - Finding the middle: \(O(n)\)
    - Reversing the second half: \(O(n)\)
    - Merging the lists: \(O(n)\)  
      **Total**: \(O(n)\)

2. **Space Complexity**:
    - Since we are only using pointers and no extra space, the space complexity is \(O(1)\).

---

### **Example Walkthrough**

#### **Example 1**

Input: `head = [1,2,3,4]`

1. Find middle:
    - Middle is node `3`.

2. Reverse second half:
    - Second half: `[3,4] ? [4,3]`.

3. Merge:
    - `[1 ? 4 ? 2 ? 3]`.

Output: `[1,4,2,3]`.

#### **Example 2**

Input: `head = [1,2,3,4,5]`

1. Find middle:
    - Middle is node `3`.

2. Reverse second half:
    - Second half: `[4,5] ? [5,4]`.

3. Merge:
    - `[1 ? 5 ? 2 ? 4 ? 3]`.

Output: `[1,5,2,4,3]`.

---

This approach ensures the nodes are reordered without modifying their values or using additional memory, adhering to the
problem constraints.