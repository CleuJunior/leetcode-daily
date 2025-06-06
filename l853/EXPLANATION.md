---

# 853. Car Fleet

---

## **Problem Statement**

Given `n` cars traveling toward a destination at mile `target`, you are provided two integer arrays `position` and
`speed`, both of length `n`, where `position[i]` is the starting mile of the `i`-th car, and `speed[i]` is its speed in
miles per hour. A car cannot pass another car but can catch up and travel at the slower car's speed as a fleet. A **car
fleet** is one or more cars driving together at the minimum speed of the fleet. If a car catches up to a fleet at the
`target`, it is part of that fleet. Return the number of car fleets that arrive at the destination.

---

## **Example**

**Example 1:**

**Input:**

```plaintext
target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
```

**Output:**

```plaintext
3
```

**Explanation:**

- Car at position 10 (speed 2) and car at position 8 (speed 4) meet at mile 12, forming a fleet (time = 1 hour).
- Car at position 0 (speed 1) reaches mile 12 alone (time = 12 hours), forming a separate fleet.
- Cars at position 5 (speed 1) and position 3 (speed 3) meet at mile 6 (time = 1 hour) and form a fleet that reaches
  mile 12 (time = 7 hours). Thus, there are 3 fleets.

**Example 2:**

**Input:**

```plaintext
target = 10, position = [3], speed = [3]
```

**Output:**

```plaintext
1
```

**Explanation:**

- Only one car exists, so there is one fleet.

**Example 3:**

**Input:**

```plaintext
target = 100, position = [0,2,4], speed = [4,2,1]
```

**Output:**

```plaintext
1
```

**Explanation:**

- Cars at position 0 (speed 4) and position 2 (speed 2) meet at mile 4 (time = 1 hour). The car at position 4 (speed 1)
  reaches mile 5, then joins the fleet at mile 6 (time = 2 hours). The fleet moves at speed 1 to mile 100, forming one
  fleet.

---

## **Constraints**

- `n == position.length == speed.length`
- `1 <= n <= 10^5`
- `0 < target <= 10^6`
- `0 <= position[i] < target`
- All values in `position` are unique.
- `0 < speed[i] <= 10^6`

---

## **Approach to Solve**

### **Brute Force**

- For each car, calculate the time to reach the target and check if it catches up with the car ahead, forming fleets.
  This requires iterating over cars and comparing their arrival times, which is inefficient.
- **Time Complexity**: O(n²) in the worst case, impractical for n up to 10^5.
- **Space Complexity**: O(1) (excluding output).

### **Optimized Approach Using Monotonic Stack**

- **Key Insight**: A car?s time to reach the target is `(target - position[i]) / speed[i]`. Cars closer to the target
  with shorter arrival times may form fleets with cars behind them if caught up.
- Sort cars by position in descending order (closest to target first) to process them from right to left.
- Use a **monotonic stack** to track arrival times of potential fleet leaders. If a car?s arrival time is greater than
  the top of the stack, it forms a new fleet (as it cannot catch up to the fleet ahead).
- **Time Complexity**: O(n log n) due to sorting; stack operations are O(n).
- **Space Complexity**: O(n) for the stack and output.

---

## **Algorithm Explanation with Monotonic Stack**

1. Create an array of pairs `(position[i], speed[i])` and sort it by position in descending order (closest to target
   first).
2. Initialize an empty stack to store arrival times of fleet leaders.
3. For each car (from closest to farthest):
    - Calculate its arrival time: `(target - position[i]) / speed[i]`.
    - While the stack is not empty and the current car?s arrival time is less than or equal to the stack?s top (meaning
      it catches up to the fleet ahead):
        - Pop the stack (the car joins the fleet).
    - Push the current car?s arrival time onto the stack (it becomes a potential fleet leader).
4. The size of the stack at the end is the number of fleets.

---

## **Code Example**

### **Java Solution**

```java
import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // Create array of [position, speed] pairs
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }
        // Sort by position in descending order
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();
        for (int[] car : cars) {
            // Calculate arrival time
            double time = (double) (target - car[0]) / car[1];
            // If stack is empty or current car can't catch up to the fleet ahead
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
```

---

## **Why Use a Monotonic Stack?**

- The stack maintains arrival times in increasing order, ensuring that only the slowest car in each fleet (the fleet
  leader) is kept.
- By processing cars from closest to farthest, we ensure that a car catches up to a fleet if its arrival time is less
  than or equal to the fleet?s leader time.
- Each car is pushed and popped at most once, making stack operations O(n).
- Sorting by position (O(n log n)) is necessary to process cars in the correct order.

---

## **Visualization**

**Input**: `target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]`

**Step-by-Step Process**:

1. **Sort by Position (descending)**:
    - Cars: `[(10,2), (8,4), (5,1), (3,3), (0,1)]`
2. **Calculate Arrival Times**:
    - Car at 10: `(12-10)/2 = 1.0`
    - Car at 8: `(12-8)/4 = 1.0`
    - Car at 5: `(12-5)/1 = 7.0`
    - Car at 3: `(12-3)/3 = 3.0`
    - Car at 0: `(12-0)/1 = 12.0`
3. **Stack Operations**:
    - Process (10,2): Stack empty, push 1.0. `stack = [1.0]`
    - Process (8,4): Time = 1.0 ? 1.0, skip (joins fleet). `stack = [1.0]`
    - Process (5,1): Time = 7.0 > 1.0, push 7.0. `stack = [1.0, 7.0]`
    - Process (3,3): Time = 3.0 ? 7.0, skip (joins fleet). `stack = [1.0, 7.0]`
    - Process (0,1): Time = 12.0 > 7.0, push 12.0. `stack = [1.0, 7.0, 12.0]`
4. **Result**: Stack size = 3 fleets.

**Output**: `3`

---

## **Time and Space Complexity**

- **Time Complexity**: O(n log n) due to sorting; stack operations are O(n).
- **Space Complexity**: O(n) for the stack and the array of car pairs.

---

## **Additional Notes**

- **Monotonic Stack**: The stack maintains increasing arrival times, ensuring each fleet is represented by its slowest
  car?s arrival time.
- **Floating-Point Precision**: Use `double` for arrival times to handle division accurately.
- **Edge Cases**: Single car (n=1) results in one fleet; all cars starting at the same position form one fleet.
- **Why Not Brute Force?**: O(n²) is too slow for n up to 10^5, making the stack-based approach necessary.

If you need further clarification or an alternative approach, let me know!

---
