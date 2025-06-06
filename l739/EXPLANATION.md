---

# 739. Daily Temperatures

---

## **Problem Statement**

Given an array of integers `temperatures` representing daily temperatures, return an array `answer` where `answer[i]` is
the number of days after the `i`-th day until a warmer temperature occurs. If no future day has a warmer temperature,
set `answer[i] = 0`.

---

## **Example**

**Example 1:**

**Input:**

```plaintext
temperatures = [73,74,75,71,69,72,76,73]
```

**Output:**

```plaintext
[1,1,4,2,1,1,0,0]
```

**Explanation:**

- For `i=0` (73°F): Next warmer day is `i=1` (74°F), so `answer[0]=1`.
- For `i=1` (74°F): Next warmer day is `i=2` (75°F), so `answer[1]=1`.
- For `i=2` (75°F): Next warmer day is `i=6` (76°F), so `answer[2]=4`.
- For `i=3` (71°F): Next warmer day is `i=5` (72°F), so `answer[3]=2`.
- For `i=4` (69°F): Next warmer day is `i=5` (72°F), so `answer[4]=1`.
- For `i=5` (72°F): Next warmer day is `i=6` (76°F), so `answer[5]=1`.
- For `i=6` (76°F): No warmer day, so `answer[6]=0`.
- For `i=7` (73°F): No warmer day, so `answer[7]=0`.

**Example 2:**

**Input:**

```plaintext
temperatures = [30,40,50,60]
```

**Output:**

```plaintext
[1,1,1,0]
```

**Example 3:**

**Input:**

```plaintext
temperatures = [30,60,90]
```

**Output:**

```plaintext
[1,1,0]
```

---

## **Constraints**

- `1 <= temperatures.length <= 10^5`
- `30 <= temperatures[i] <= 100`

---

## **Approach to Solve**

### **Brute Force (Nested Loops)**

- For each day `i`, scan all future days `j` (where `j > i`) to find the first day where
  `temperatures[j] > temperatures[i]`.
- Compute `answer[i] = j - i` if found; otherwise, set `answer[i] = 0`.
- **Time Complexity**: O(n²), where n is the length of `temperatures`. This is inefficient for large inputs (up to
  10^5).
- **Space Complexity**: O(1) (excluding the output array).

### **Optimized Approach Using Monotonic Stack**

- Use a **stack** to maintain indices of days with temperatures in **decreasing order** (a monotonic stack).
- For each day, compare its temperature with the temperature of the day at the top of the stack:
    - If the current temperature is warmer, pop the stack and compute the difference in days for the popped index.
    - Push the current day?s index onto the stack.
- This approach ensures O(1) amortized time per element, as each index is pushed and popped at most once.
- **Time Complexity**: O(n), where n is the length of `temperatures`.
- **Space Complexity**: O(n) for the stack and output array.

---

## **Algorithm Explanation with Monotonic Stack**

1. Initialize an array `answer` of the same length as `temperatures`, filled with zeros.
2. Create an empty stack to store indices of days with temperatures in decreasing order.
3. Iterate through the array `temperatures`:
    - For each day `i`, while the stack is not empty and `temperatures[i] > temperatures[stack.peek()]`:
        - Pop the top index `prev` from the stack.
        - Set `answer[prev] = i - prev` (number of days between the current day and the popped day).
    - Push the current index `i` onto the stack.
4. Return the `answer` array.

---

## **Code Example**

### **Java Solution**

```java
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // While stack is not empty and current temp is warmer than temp at stack's top
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.push(i);
        }

        return answer;
    }
}
```

---

## **Why Use a Monotonic Stack?**

- The stack maintains indices of days with temperatures in **decreasing order**, ensuring that when a warmer day is
  found, we can efficiently calculate the number of days to wait for all previous days that were cooler.
- Each index is pushed and popped at most once, leading to an amortized O(1) time per element, making the overall time
  complexity O(n).
- The stack uses O(n) space in the worst case, which is acceptable given the constraints.

---

## **Visualization**

**Input**: `temperatures = [73,74,75,71,69,72,76,73]`

**Step-by-Step Process**:

1. Initialize: `answer = [0,0,0,0,0,0,0,0]`, `stack = []`
2. **i=0 (73)**: Stack empty, push 0. `stack = [0]`
3. **i=1 (74)**: 74 > 73, pop 0, `answer[0]=1-0=1`, push 1. `stack = [1]`
4. **i=2 (75)**: 75 > 74, pop 1, `answer[1]=2-1=1`, push 2. `stack = [2]`
5. **i=3 (71)**: 71 < 75, push 3. `stack = [2,3]`
6. **i=4 (69)**: 69 < 71, push 4. `stack = [2,3,4]`
7. **i=5 (72)**: 72 > 69, pop 4, `answer[4]=5-4=1`; 72 > 71, pop 3, `answer[3]=5-3=2`; push 5. `stack = [2,5]`
8. **i=6 (76)**: 76 > 72, pop 5, `answer[5]=6-5=1`; 76 > 75, pop 2, `answer[2]=6-2=4`; push 6. `stack = [6]`
9. **i=7 (73)**: 73 < 76, push 7. `stack = [6,7]`
10. End: `answer = [1,1,4,2,1,1,0,0]`

---

## **Time and Space Complexity**

- **Time Complexity**: O(n), where n is the length of `temperatures`. Each index is pushed and popped at most once.
- **Space Complexity**: O(n) for the stack and the output array `answer`.

---

## **Additional Notes**

- **Monotonic Stack**: The stack ensures a decreasing order of temperatures, making it efficient to find the next warmer
  day.
- **Edge Cases**: The constraints guarantee at least one day, and temperatures are within a reasonable range, so no
  special handling is needed for empty arrays.
- **Why Not Brute Force?**: The O(n²) approach is too slow for large inputs (up to 10^5), making the monotonic stack
  essential for performance.

If you need further clarification or an alternative approach (e.g., without a stack, though less efficient), let me
know!

---