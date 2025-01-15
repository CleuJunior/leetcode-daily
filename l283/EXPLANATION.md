### 283. Move Zeroes

You are tasked with moving all zeros in an array to the end while keeping the relative order of the non-zero elements
intact. This operation must be done **in-place**, meaning the array should be modified without using extra storage for
another array.

---

### Examples

#### Example 1

Input:  
`nums = [0,1,0,3,12]`  
Output:  
`[1,3,12,0,0]`

Explanation:

- Move the non-zero elements `[1,3,12]` to the front.
- Fill the remaining positions with zeros.

#### Example 2

Input:  
`nums = [0]`  
Output:  
`[0]`

Explanation:

- There is only one element (zero), so the array remains unchanged.

---

### Constraints

- The array length is between 1 and \(10^4\).
- Each element of the array is a signed 32-bit integer.

---

### Implementation

#### Approach

1. **Two-Pointer Technique**:
    - Use one pointer (`lastNonZeroIndex`) to track the position where the next non-zero element should be placed.
    - Use another pointer (`current`) to iterate through the array.
    - When a non-zero element is found, swap it with the element at `lastNonZeroIndex` and increment `lastNonZeroIndex`.

2. **In-Place Update**:
    - No extra space is used, adhering to the problem's constraints.

---

### Code in Java

```java
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0; // Tracks where the next non-zero element should go

        // Step 1: Move all non-zero elements to the front
        for (int current = 0; current < nums.length; current++) {
            if (nums[current] != 0) {
                // Swap non-zero element with the element at lastNonZeroIndex
                int temp = nums[current];
                nums[current] = nums[lastNonZeroIndex];
                nums[lastNonZeroIndex] = temp;

                lastNonZeroIndex++;
            }
        }
    }
}
```

---

### How It Works

#### Example Walkthrough

For the input `nums = [0,1,0,3,12]`:

1. Start with `lastNonZeroIndex = 0` and iterate through `nums`:
    - `nums[0] = 0`: Skip (it's a zero).
    - `nums[1] = 1`: Swap `nums[1]` with `nums[0]`, resulting in `nums = [1,0,0,3,12]`. Increment `lastNonZeroIndex`.
    - `nums[2] = 0`: Skip.
    - `nums[3] = 3`: Swap `nums[3]` with `nums[1]`, resulting in `nums = [1,3,0,0,12]`. Increment `lastNonZeroIndex`.
    - `nums[4] = 12`: Swap `nums[4]` with `nums[2]`, resulting in `nums = [1,3,12,0,0]`. Increment `lastNonZeroIndex`.

2. The final array is `[1,3,12,0,0]`.

---

### Complexity Analysis

- **Time Complexity**: 0(n)
    - We iterate through the array once.
- **Space Complexity**: O(1)
    - No additional space is used, only a few variables for pointers.

---

### Key Points

- **In-Place**: The operation modifies the array directly without creating a new one.
- **Order Preserved**: The relative order of non-zero elements is maintained.
- **Optimal**: Both time and space complexity are minimal.

---

### Output Example

For the input `nums = [0,1,0,3,12]`:

```
Before: 
0 1 0 3 12 
After: 
1 3 12 0 0 
```