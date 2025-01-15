### 191. Number of 1 Bits

### Explanation of Problem: **Number of One Bits**

The task is to count the number of `1` bits in the binary representation of a given unsigned integer \( n \).

---

### Key Requirements

1. **Binary Representation**:
    - \( n \) is a non-negative integer that fits within 32 bits.
2. **Return the Count of `1` Bits**:
    - Traverse the binary representation and count all `1`s.

---

### Solution Approaches

#### Approach 1: Bitwise Manipulation Using Right Shift

We can examine each bit of \( n \) by repeatedly shifting the bits to the right and checking if the least significant
bit (LSB) is `1`.

Steps:

1. Initialize a counter to `0`.
2. Use a loop to check each bit:
    - If the least significant bit (\( n \& 1 \)) is `1`, increment the counter.
    - Shift \( n \) one bit to the right (\( n \gg 1 \)).
3. Stop when \( n \) becomes `0`.

---

### Implementation

```java
public static int hammingWeight(int n) {
    int count = 0;

    while (n != 0) {
        count += n & 1; // Check if the least significant bit is 1
        n >>>= 1;       // Unsigned right shift
    }

    return count;
}
```

---

### Complexity Analysis

1. **Time Complexity**:
    - \( O(1) \): The loop runs at most 32 times since \( n \) is a 32-bit integer.

2. **Space Complexity**:
    - \( O(1) \): Uses a constant amount of extra space.

---

### Example Walkthroughs

#### Example 1:

Input: \( n = 00000000000000000000000000010111 \) (binary)

- Initial `count = 0`.
- Step-by-step:
    1. \( n \& 1 = 1 \) ? Increment `count = 1`.
    2. Shift \( n \): \( 00000000000000000000000000001011 \).
    3. \( n \& 1 = 1 \) ? Increment `count = 2`.
    4. Shift \( n \): \( 00000000000000000000000000000101 \).
    5. \( n \& 1 = 1 \) ? Increment `count = 3`.
    6. Shift \( n \): \( 00000000000000000000000000000010 \).
    7. \( n \& 1 = 0 \) ? `count = 3`.
    8. Shift \( n \): \( 00000000000000000000000000000001 \).
    9. \( n \& 1 = 1 \) ? Increment `count = 4`.
    10. \( n = 0 \): Exit loop.
- Output: `4`.

#### Example 2:

Input: \( n = 01111111111111111111111111111101 \)

- Step-by-step:
    - \( n \& 1 = 1 \): Increment for 30 `1` bits.
- Output: `30`.

---

### Alternative Approach: Using \( n \& (n-1) \)

This approach removes the least significant `1` in each iteration.

Steps:

1. Initialize a counter to `0`.
2. Use a loop:
    - Update \( n = n \& (n-1) \), which removes the lowest `1`.
    - Increment the counter.
3. Stop when \( n \) becomes `0`.

```java
public static int hammingWeight(int n) {
    int count = 0;

    while (n != 0) {
        n &= (n - 1); // Remove the lowest 1-bit
        count++;
    }

    return count;
}
```

#### Complexity:

- **Time**: \( O(k) \), where \( k \) is the number of `1` bits.
- **Space**: \( O(1) \).

This method is faster when \( n \) has a sparse number of `1`s.

---

Both approaches are efficient and meet the constraints, with slight differences in implementation and performance based
on \( n \)'s binary structure.