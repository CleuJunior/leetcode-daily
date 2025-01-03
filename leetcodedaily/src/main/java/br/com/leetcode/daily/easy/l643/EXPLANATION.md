### 643. Maximum Average Subarray I

The problem requires finding a contiguous subarray of size `k` within an array `nums` that has the highest average
value. You need to return the maximum average value as a floating-point number.

---

### **Key Points**

1. **Contiguous Subarray**: A subarray means elements that are consecutive in the array. For example, `[12, -5, -6, 50]`
   is a subarray of `[1, 12, -5, -6, 50, 3]`.

2. **Fixed Length**: The length of the subarray is fixed at `k`. You cannot change the size of the subarray.

3. **Maximum Average**: You need to calculate the average for all subarrays of size `k` and find the maximum among them.

4. **Precision**: The result must be accurate to within \( 10^{-5} \).

---

### **Examples**

#### Example 1:

Input:

```plaintext
nums = [1, 12, -5, -6, 50, 3], k = 4
```

Steps:

- Compute the sum of each subarray of size 4:
    - Sum of `[1, 12, -5, -6]` = \( 1 + 12 - 5 - 6 = 2 \)
    - Sum of `[12, -5, -6, 50]` = \( 12 - 5 - 6 + 50 = 51 \)
    - Sum of `[-5, -6, 50, 3]` = \( -5 - 6 + 50 + 3 = 42 \)
- Find the maximum sum: \( 51 \)
- Compute the average: \( \frac{51}{4} = 12.75 \)

Output:

```plaintext
12.75000
```

#### Example 2:

Input:

```plaintext
nums = [5], k = 1
```

Steps:

- Since there?s only one element, the subarray is `[5]`.
- The average is \( \frac{5}{1} = 5.0 \).

Output:

```plaintext
5.00000
```

---

### **Constraints**

1. \( n = \text{nums.length} \), where \( 1 \leq k \leq n \leq 10^5 \).
2. Each element in `nums` lies between \( -10^4 \) and \( 10^4 \).

---

### **Optimized Solution: Sliding Window Technique**

To solve the problem efficiently, we use the **sliding window** approach to avoid recalculating the sum for every
subarray:

1. **Initialize**:
    - Compute the sum of the first `k` elements as the initial window sum.
    - Let this sum be the maximum initially.

2. **Slide the Window**:
    - Move the window one step to the right:
        - Subtract the element leaving the window.
        - Add the element entering the window.
    - Update the maximum sum if the current window sum is larger.

3. **Calculate Average**:
    - Divide the maximum sum by `k` to get the maximum average.

---

### **Algorithm**

1. Compute the sum of the first `k` elements.
2. Iterate through the array from index `k` to `n - 1`:
    - Update the window sum.
    - Track the maximum sum.
3. Compute and return the maximum average.

---

### **Code Implementation**

```java
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double windowSum = 0;

        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        
        double maxSum = windowSum;

        // Slide the window through the array
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        // Return the maximum average
        return maxSum / k;
    }
}
```

---

### **Complexity Analysis**

- **Time Complexity**: \( O(n) \)
    - Computing the sum of the first window takes \( O(k) \).
    - Sliding the window through the array takes \( O(n - k) \).
- **Space Complexity**: \( O(1) \)
    - No extra data structures are used.