# 155. Min Stack

---

## **Problem Statement**

Design a stack that supports the following operations in **constant time** (O(1)):
- `push(val)`: Pushes an element `val` onto the stack.
- `pop()`: Removes and returns the top element of the stack.
- `top()`: Returns the top element of the stack without removing it.
- `getMin()`: Retrieves the minimum element in the stack.

Implement the `MinStack` class with the following methods:
- `MinStack()`: Initializes an empty stack.
- `void push(int val)`: Adds `val` to the top of the stack.
- `void pop()`: Removes the top element from the stack.
- `int top()`: Returns the top element of the stack.
- `int getMin()`: Returns the minimum element in the stack.

All operations must have **O(1) time complexity**.

---

## **Example**

**Input:**

```plaintext
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
```

**Output:**

```plaintext
[null,null,null,null,-3,null,0,-2]
```

**Explanation:**

```java
MinStack minStack = new MinStack();
minStack.push(-2);    // Stack: [-2], Min: -2
minStack.push(0);     // Stack: [-2, 0], Min: -2
minStack.push(-3);    // Stack: [-2, 0, -3], Min: -3
minStack.getMin();    // Returns -3 (minimum element)
minStack.pop();       // Removes -3, Stack: [-2, 0], Min: -2
minStack.top();       // Returns 0 (top element)
minStack.getMin();    // Returns -2 (minimum element)
```

---

## **Constraints**

- `-2^31 <= val <= 2^31 - 1`
- Methods `pop`, `top`, and `getMin` will always be called on **non-empty stacks**.
- At most `3 * 10^4` calls will be made to `push`, `pop`, `top`, and `getMin`.

---

## **Approach to Solve**

### **Naive Approach**
One might consider using a single stack to store the elements and, for `getMin`, iterate through the stack to find the minimum. However:
- **Time Complexity**: `getMin` would take O(n) because it requires scanning the entire stack.
- **Problem**: This violates the requirement of O(1) time complexity for all operations.

### **Optimized Approach Using Two Stacks**
To achieve O(1) time complexity for all operations, we can use **two stacks**:
1. **Main Stack**: Stores all elements in the order they are pushed.
2. **Min Stack**: Keeps track of the minimum element at each push operation. Whenever we push an element to the main stack, we also push the current minimum to the min stack. When we pop an element, we pop from both stacks to keep them synchronized.

This ensures that:
- `push`, `pop`, `top`, and `getMin` all run in O(1).
- The min stack always has the minimum element at the top.

### **Alternative Approach Using One Stack with Pairs**
Another approach is to use a single stack where each element is a pair `(value, currentMin)`, where `value` is the pushed element and `currentMin` is the minimum value in the stack at the time of the push. This avoids the need for a second stack but still achieves O(1) for all operations.

However, the two-stack approach is often clearer and more intuitive, so we?ll focus on that.

---

## **Algorithm Explanation with Two Stacks**

1. **Initialization**:
   - Create two stacks: one for storing elements (`stack`) and one for tracking minimums (`minStack`).
   - Both stacks are initially empty.

2. **Push Operation**:
   - Push the value `val` onto `stack`.
   - Compare `val` with the current minimum (top of `minStack`):
      - If `minStack` is empty or `val` is less than or equal to the current minimum, push `val` onto `minStack`.
      - This ensures `minStack` always has the minimum value at the top.

3. **Pop Operation**:
   - Remove the top element from `stack`.
   - If the top element of `stack` equals the top element of `minStack`, also remove the top element from `minStack` to maintain synchronization.

4. **Top Operation**:
   - Return the top element of `stack` without removing it.

5. **GetMin Operation**:
   - Return the top element of `minStack`, which is the current minimum.

---

## **Code Example**

### **Java Solution**

```java
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;    // Main stack for elements
    private Stack<Integer> minStack; // Stack to track minimums

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // Push to minStack if it's empty or val is less than or equal to current min
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        // If the top element is the current minimum, pop from minStack too
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
```

---

## **Why Use Two Stacks?**

- **O(1) Time Complexity**: The `minStack` ensures that `getMin` is a simple peek operation, which is O(1). Similarly, `push`, `pop`, and `top` are standard stack operations, all O(1).
- **Space Efficiency**: While we use extra space for `minStack`, it only stores elements when necessary (when the new element is less than or equal to the current minimum). In the worst case (e.g., elements pushed in decreasing order), `minStack` could be as large as `stack`, but this is still O(n).

---

## **Visualization**

**Example Input**: `["MinStack","push","push","push","getMin","pop","top","getMin"]`, `[[],[-2],[0],[-3],[],[],[],[]]`

**Step-by-Step Process**:

1. **Initialize**: `stack = [], minStack = []`
2. **push(-2)**:
   - `stack = [-2]`
   - `minStack = [-2]` (since `minStack` is empty, push -2)
3. **push(0)**:
   - `stack = [-2, 0]`
   - `minStack = [-2]` (0 > -2, so don?t push to `minStack`)
4. **push(-3)**:
   - `stack = [-2, 0, -3]`
   - `minStack = [-2, -3]` (-3 ? -2, so push -3 to `minStack`)
5. **getMin()**: Returns `minStack.peek() = -3`
6. **pop()**:
   - `stack.peek() = -3`, `minStack.peek() = -3`, so pop from both:
   - `stack = [-2, 0]`
   - `minStack = [-2]`
7. **top()**: Returns `stack.peek() = 0`
8. **getMin()**: Returns `minStack.peek() = -2`

**Final Output**: `[null, null, null, null, -3, null, 0, -2]`

---

## **Time and Space Complexity**

- **Time Complexity**:
   - `push`: O(1)
   - `pop`: O(1)
   - `top`: O(1)
   - `getMin`: O(1)
- **Space Complexity**: O(n), where n is the number of elements in the stack. In the worst case, `minStack` may store as many elements as `stack` (e.g., if elements are pushed in decreasing order).

---

## **Additional Notes**

- **Why `val <= minStack.peek()` in `push`?**: We use `<=` to handle cases where the same minimum value is pushed multiple times. If we only used `<`, popping one instance of the minimum would incorrectly remove it from `minStack`, even if other instances remain.
- **Alternative with One Stack**: You could store pairs `(value, currentMin)` in a single stack, but this increases memory usage per element and may be less intuitive.
- **Edge Cases**: The constraints guarantee that `pop`, `top`, and `getMin` are called on non-empty stacks, so no additional checks are needed for empty stacks.
