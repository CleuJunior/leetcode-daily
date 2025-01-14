### 136. Single Number

### Explanation of Problem: **136. Single Number**

The task is to find the single unique number in an array where every other number appears **exactly twice**.

---

### Key Requirements

1. **Linear Runtime Complexity (\(O(n)\))**:
    - The solution must process the array in a single pass.
2. **Constant Extra Space (\(O(1)\))**:
    - No additional data structures like hash maps or arrays can be used.

---

### Observations

The key insight is that the XOR operation (^) has the following properties:

1. \( x ^ x = 0 \): Any number XORed with itself is 0.
2. \( x ^ 0 = x \): Any number XORed with 0 remains unchanged.
3. XOR is **commutative and associative**: The order of operations does not matter.

Using these properties:

- If we XOR all numbers in the array, pairs of identical numbers cancel out (\( x ^ x = 0 \)).
- The result will be the single number that appears only once.

---

### Implementation (Using XOR)

```java
public static int singleNumber(int[] nums) {
    int result = 0;

    // XOR all numbers
    for (int num : nums) {
        result ^= num;
    }

    return result; // The single number remains
}
```

---

### Complexity Analysis

1. **Time Complexity**:
    - \( O(n) \): The array is traversed once.

2. **Space Complexity**:
    - \( O(1) \): Only a single variable (`result`) is used.

---

### Example Walkthroughs

#### Example 1:

Input: `nums = [2, 2, 1]`

- Initial `result = 0`.
- Step-by-step XOR:
    - \( 0 ^ 2 = 2 \)
    - \( 2 ^ 2 = 0 \) (pair canceled)
    - \( 0 ^ 1 = 1 \)
- Output: `1`

#### Example 2:

Input: `nums = [4, 1, 2, 1, 2]`

- Initial `result = 0`.
- Step-by-step XOR:
    - \( 0 ^ 4 = 4 \)
    - \( 4 ^ 1 = 5 \)
    - \( 5 ^ 2 = 7 \)
    - \( 7 ^ 1 = 6 \)
    - \( 6 ^ 2 = 4 \)
- Output: `4`

#### Example 3:

Input: `nums = [1]`

- Initial `result = 0`.
- Step-by-step XOR:
    - \( 0 ^ 1 = 1 \)
- Output: `1`

---

### Why This Works

- XOR eliminates duplicate elements while preserving the unique number.
- The solution is efficient and meets the problem's constraints.

This approach leverages bitwise operations for optimal performance, making it ideal for interview scenarios.