---

# 84. Largest Rectangle in Histogram

---

## **Problem Statement**

Given an array of integers `heights` representing the heights of bars in a histogram, where each bar has a width of 1,
return the area of the largest rectangle that can be formed within the histogram.

---

## **Example**

**Example 1:**

**Input:**

```plaintext
heights = [2,1,5,6,2,3]
```

**Output:**

```plaintext
10
```

**Explanation:**

- The largest rectangle is formed by the bars with heights 5 and 6, spanning from index 2 to 3, with area = 5 * 2 = 10 (
  height = 5, width = 2).

**Example 2:**

**Input:**

```plaintext
heights = [2,4]
```

**Output:**

```plaintext
4
```

**Explanation:**

- The largest rectangle is the bar at index 1 with height 4 and width 1, so area = 4 * 1 = 4.

---

## **Constraints**

- `1 <= heights.length <= 10^5`
- `0 <= heights[i] <= 10^4`

---

## **Approach to Solve**

### **Brute Force**

- For each bar, extend left and right to find the widest rectangle with that bar?s height as the minimum. Compute the
  area and track the maximum.
- **Time Complexity**: O(n²), as each bar may require scanning the entire array.
- **Space Complexity**: O(1) (excluding output).
- **Issue**: Inefficient for large inputs (n up to 10^5).

### **Optimized Approach Using Monotonic Stack**

- Use a **monotonic stack** to efficiently find the leftmost and rightmost bars that are shorter than each bar, defining
  the boundaries of the rectangle with that bar?s height.
- Compute the area for each bar using its height and the width between its leftmost and rightmost boundaries.
- **Time Complexity**: O(n), as each bar is pushed and popped at most once.
- **Space Complexity**: O(n) for the stack and boundary arrays.

---

## **Algorithm Explanation with Monotonic Stack**

The provided code uses a monotonic stack to compute the largest rectangle area by finding, for each bar, the indices of
the nearest bars to the left and right that have a smaller height. These boundaries define the width of the rectangle
with the current bar?s height.

1. **Initialization**:
    - Create two arrays: `leftMost` (to store the index of the nearest bar to the left with a smaller height) and
      `rightMost` (to store the index of the nearest bar to the right with a smaller height).
    - Initialize `leftMost[i] = -1` (indicating no smaller bar to the left) and `rightMost[i] = n` (indicating no
      smaller bar to the right).
    - Use a stack to maintain indices of bars in increasing height order.

2. **Finding Left Boundaries**:
    - Iterate through the array from left to right (`i = 0` to `n-1`):
        - While the stack is not empty and the height at the stack?s top (`heights[stack.peek()]`) is greater than or
          equal to the current bar?s height (`heights[i]`), pop the stack (these bars cannot be the left boundary for
          `i`).
        - If the stack is not empty, set `leftMost[i] = stack.peek()` (the top of the stack is the nearest bar to the
          left with a smaller height).
        - Push the current index `i` onto the stack.
    - This ensures `leftMost[i]` holds the index of the nearest bar to the left with a height strictly less than
      `heights[i]`.

3. **Finding Right Boundaries**:
    - Clear the stack and iterate from right to left (`i = n-1` to `0`):
        - While the stack is not empty and the height at the stack?s top (`heights[stack.peek()]`) is greater than or
          equal to the current bar?s height (`heights[i]`), pop the stack.
        - If the stack is not empty, set `rightMost[i] = stack.peek()` (the top of the stack is the nearest bar to the
          right with a smaller height).
        - Push the current index `i` onto the stack.
    - This ensures `rightMost[i]` holds the index of the nearest bar to the right with a height strictly less than
      `heights[i]`.

4. **Calculating Areas**:
    - For each bar `i`, compute the width of the rectangle as `rightMost[i] - leftMost[i] - 1` (since `leftMost[i]` and
      `rightMost[i]` are the indices of bars just outside the rectangle).
    - Adjust indices: `leftMost[i] += 1` (to include the first bar in the rectangle) and `rightMost[i] -= 1` (to include
      the last bar in the rectangle).
    - Compute the area: `heights[i] * (rightMost[i] - leftMost[i] + 1)`.
    - Update the maximum area if the current area is larger.

5. **Return** the maximum area found.

---

## **Code Example**

### **Java Solution**

```java
import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            leftMost[i] = -1;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                leftMost[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            rightMost[i] = n;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rightMost[i] = stack.peek();
            }
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            leftMost[i] += 1;
            rightMost[i] -= 1;
            maxArea = Math.max(maxArea, heights[i] * (rightMost[i] - leftMost[i] + 1));
        }
        return maxArea;
    }
}
```

---

## **Why Use a Monotonic Stack?**

- The stack maintains indices of bars in increasing height order, allowing efficient identification of the nearest
  smaller bars to the left and right.
- By computing `leftMost` and `rightMost` arrays, we can directly calculate the width of the rectangle for each bar as
  `rightMost[i] - leftMost[i] + 1` after adjustments.
- Each bar is pushed and popped at most once, ensuring O(n) time complexity.

---

## **Visualization**

**Input**: `heights = [2,1,5,6,2,3]`

**Step-by-Step Process**:

1. **Initialize**: `leftMost = [-1,-1,-1,-1,-1,-1]`, `rightMost = [6,6,6,6,6,6]`, `stack = []`, `maxArea = 0`
2. **Left Boundaries (left to right)**:
    - `i=0 (2)`: Stack empty, `leftMost[0]=-1`, push 0. `stack=[0]`
    - `i=1 (1)`: 1 < 2, pop 0, `leftMost[1]=-1`, push 1. `stack=[1]`
    - `i=2 (5)`: 5 > 1, `leftMost[2]=1`, push 2. `stack=[1,2]`
    - `i=3 (6)`: 6 > 5, `leftMost[3]=2`, push 3. `stack=[1,2,3]`
    - `i=4 (2)`: 2 < 6, pop 3; 2 < 5, pop 2; `leftMost[4]=1`, push 4. `stack=[1,4]`
    - `i=5 (3)`: 3 > 2, `leftMost[5]=4`, push 5. `stack=[1,4,5]`
    - `leftMost = [-1, -1, 1, 2, 1, 4]`
3. **Right Boundaries (right to left)**:
    - `stack.clear()`, `stack = []`
    - `i=5 (3)`: Stack empty, `rightMost[5]=6`, push 5. `stack=[5]`
    - `i=4 (2)`: 2 < 3, pop 5, `rightMost[4]=6`, push 4. `stack=[4]`
    - `i=3 (6)`: 6 > 2, `rightMost[3]=4`, push 3. `stack=[4,3]`
    - `i=2 (5)`: 5 < 6, pop 3, `rightMost[2]=4`, push 2. `stack=[4,2]`
    - `i=1 (1)`: 1 < 5, pop 2; 1 < 2, pop 4; `rightMost[1]=6`, push 1. `stack=[1]`
    - `i=0 (2)`: 2 > 1, `rightMost[0]=1`, push 0. `stack=[1,0]`
    - `rightMost = [1, 6, 4, 4, 6, 6]`
4. **Adjust and Calculate Areas**:
    - Adjust: `leftMost = [0, 0, 2, 3, 2, 5]`, `rightMost = [0, 5, 3, 3, 5, 5]`
    - `i=0`: Area = 2 * (0-0+1) = 2, `maxArea = 2`
    - `i=1`: Area = 1 * (5-0+1) = 6, `maxArea = 6`
    - `i=2`: Area = 5 * (3-2+1) = 10, `maxArea = 10`
    - `i=3`: Area = 6 * (3-3+1) = 6, `maxArea = 10`
    - `i=4`: Area = 2 * (5-2+1) = 8, `maxArea = 10`
    - `i=5`: Area = 3 * (5-5+1) = 3, `maxArea = 10`
5. **Output**: `10`

---

## **Time and Space Complexity**

- **Time Complexity**: O(n), as each bar is pushed and popped at most once in both left and right passes.
- **Space Complexity**: O(n) for the stack and the `leftMost` and `rightMost` arrays.

---

## **Additional Notes**

- **Monotonic Stack**: The stack ensures increasing heights, allowing efficient computation of left and right boundaries
  for each bar.
- **Boundary Adjustment**: Adjusting `leftMost[i] += 1` and `rightMost[i] -= 1` ensures the width calculation includes
  the correct bars.
- **Edge Cases**: Single bar (e.g., `[2]`) yields area = 2 * 1; zero heights (e.g., `[0,0]`) yield area = 0.
- **Why Not Brute Force?**: O(n²) is infeasible for n up to 10^5, making the stack-based approach necessary.

If you need further clarification or an alternative approach, let me know!

---
