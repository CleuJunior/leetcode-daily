### 21. Merge Two Sorted Lists

---

### **Problem Statement**

You are given the heads of two sorted linked lists, `list1` and `list2`. Merge these two lists into one sorted linked
list by splicing together the nodes of the first two lists.

The function should return the head of the merged linked list.

---

### **Examples**

#### Example 1:

Input:

```plaintext
list1 = [1,2,4], list2 = [1,3,4]
```

Output:

```plaintext
[1,1,2,3,4,4]
```

#### Example 2:

Input:

```plaintext
list1 = [], list2 = []
```

Output:

```plaintext
[]
```

#### Example 3:

Input:

```plaintext
list1 = [], list2 = [0]
```

Output:

```plaintext
[0]
```

---

### **Constraints**

1. The number of nodes in both lists is in the range \([0, 50]\).
2. \(-100 \leq \text{Node.val} \leq 100\)
3. Both `list1` and `list2` are sorted in non-decreasing order.

---

### **Approach to Solve**

1. **Iterative Solution**:
    - Create a dummy node to serve as the starting point for the merged list.
    - Use a pointer (`current`) to build the new list.
    - Compare the nodes of `list1` and `list2`:
        - Append the smaller node to `current` and move the pointer of the chosen list forward.
    - Once one of the lists is fully traversed, append the remaining nodes of the other list.
    - Return the merged list starting from `dummy.next`.

2. **Recursive Solution**:
    - Compare the heads of `list1` and `list2` recursively:
        - The smaller node becomes the next node of the merged list.
        - Recursively merge the rest of the lists.

---

### **Algorithm Explanation**

#### Iterative Solution:

1. Initialize a `dummy` node and set a `current` pointer to it.
2. Traverse `list1` and `list2` until one of them is null:
    - Compare the current nodes of both lists.
    - Add the smaller node to the `current.next`.
    - Move the pointer of the list from which the node was taken.
3. Add the remaining nodes of the non-empty list to `current.next`.
4. Return `dummy.next` as the merged list's head.

#### Recursive Solution:

1. Base Case:
    - If either `list1` or `list2` is null, return the other list.
2. Compare `list1.val` and `list2.val`:
    - The smaller value becomes the head of the merged list.
    - Recursively merge the remaining nodes of the lists.

---

### **Code Example**

#### **Java Iterative Solution**

```java
 public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode();
    ListNode current = dummy;

   // Traverse both lists until one of them is fully processed
   while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
            current.next = list1;
            current = list1;
           // Move the list1 pointer to the next node
           list1 = list1.next;
   
        } else {
            current.next = list2;
            current = list2;
           // Move the list2 pointer to the next node
           list2 = list2.next;
        }
    }

   // Attach the remaining nodes of the non-empty list (if any)
   current.next = list1 != null ? list1 : list2;
   
   // Return the merged list starting from the first real node (dummy.next)
   return dummy.next;
}
```

---

#### **Java Recursive Solution**

```java
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
   // Base case: If one list is empty, return the other
   if (list1 == null) {
      return list2;
   } else if (list2 == null) {
      return list1;
   }

   // Compare the current nodes of both lists
   if (list1.val <= list2.val) {
      // If list1's value is smaller, it becomes the next node in the merged list
      list1.next = mergeTwoLists(list1.next, list2);
      return list1; // Return the head of the merged list
   } else {
      // If list2's value is smaller, it becomes the next node in the merged list
      list2.next = mergeTwoLists(list1, list2.next);
      return list2; // Return the head of the merged list
   }
}

```

---

### **Complexity Analysis**

1. **Time Complexity**:  
   \( O(n + m) \), where \( n \) and \( m \) are the lengths of `list1` and `list2`.  
   This is because each node is processed once.

2. **Space Complexity**:
    - Iterative Solution: \( O(1) \) (constant space).
    - Recursive Solution: \( O(n + m) \) due to the recursion stack.

---

### **Key Takeaway**

The iterative approach is more space-efficient because it does not use recursion, making it suitable for large inputs.
However, the recursive approach provides a cleaner and more concise implementation. Both methods effectively merge the
lists while maintaining the order.