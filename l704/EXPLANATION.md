### 704. Binary Search

#### Problem: Binary Search (704)

The goal is to implement a binary search algorithm that efficiently finds the index of a target value in a sorted array or returns `-1` if the target is not present. The algorithm must have \( O(\log n) \) runtime complexity.

---

### **Approach: Binary Search**

Binary search works by dividing the search interval in half after each comparison. Start with the whole array and repeatedly reduce the interval by half until the target is found or the interval is empty.

---

### **Steps**:

1. Initialize two pointers:
  - `left` at the start of the array.
  - `right` at the end of the array.
2. Loop while `left <= right`:
  - Compute the middle index: `mid = left + (right - left) / 2`.
  - Compare the value at `mid` with `target`:
    - If `nums[mid] == target`, return `mid`.
    - If `nums[mid] < target`, move the left pointer: `left = mid + 1`.
    - If `nums[mid] > target`, move the right pointer: `right = mid - 1`.
3. If the loop ends without finding the target, return `-1`.

---

### **Implementation**:

```java
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoids overflow

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }
}
```

---

### **Complexity Analysis**:

1. **Time Complexity**: \( O(\log n) \)
  - Each iteration cuts the search space in half, resulting in logarithmic complexity.
2. **Space Complexity**: \( O(1) \)
  - Uses only a constant amount of extra space.

---

### **Example Walkthrough**:

#### Example 1:
- Input: `nums = [-1,0,3,5,9,12]`, `target = 9`
- Process:
  - Initial: `left = 0`, `right = 5`, `mid = 2`
  - `nums[mid] = 3 < 9`: Update `left = mid + 1 = 3`
  - New `mid = 4`, `nums[mid] = 9`: Target found at index `4`.
- Output: `4`

#### Example 2:
- Input: `nums = [-1,0,3,5,9,12]`, `target = 2`
- Process:
  - Initial: `left = 0`, `right = 5`, `mid = 2`
  - `nums[mid] = 3 > 2`: Update `right = mid - 1 = 1`
  - New `mid = 0`, `nums[mid] = -1 < 2`: Update `left = mid + 1 = 1`
  - New `mid = 1`, `nums[mid] = 0 < 2`: Update `left = mid + 1 = 2`
  - `left > right`: Exit loop, target not found.
- Output: `-1`

---

### **Key Points**:
- Binary search is efficient for sorted arrays due to its logarithmic complexity.
- The formula `mid = left + (right - left) / 2` avoids overflow issues.
- Handles both the presence and absence of the target gracefully.