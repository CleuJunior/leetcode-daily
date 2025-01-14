### 1. Two Sum

---

### **Problem Statement**

You are given an array of integers `nums` and an integer `target`. Your task is to find two distinct numbers in the
array that add up to the `target`. Return their indices as an array.

### **Example**

Input:

```plaintext
nums = [2, 7, 11, 15]
target = 9
```

Output:

```plaintext
[0, 1]
```

Explanation:

- `nums[0] + nums[1] = 2 + 7 = 9`, which is the `target`.

---

### **Constraints**

1. Each input will have exactly one solution.
2. You may not use the same element twice.

---

### **Approach to Solve**

1. **Brute Force (Nested Loops)**:
    - For every element in the array, check if there exists another element that sums up to the `target`.
    - **Time Complexity**: \( O(n^2) \) because of the nested loops.
    - **Space Complexity**: \( O(1) \) since no extra data structure is used.

2. **Optimized Approach Using HashMap**:
    - Use a hash map (dictionary) to store the complement of the current number (i.e., `target - nums[i]`) as a key and
      its index as a value.
    - For each element in the array, check if it exists in the hash map. If it does, return the indices.
    - **Time Complexity**: \( O(n) \) because we traverse the array once.
    - **Space Complexity**: \( O(n) \) due to the hash map storage.

---

### **Algorithm Explanation with HashMap**

1. Create an empty hash map, `map`, to store complements.
2. Loop through the array:
    - Calculate the complement: `complement = target - nums[i]`.
    - Check if the complement exists in the hash map:
        - If yes, return the indices of the complement and the current element.
        - If no, store the current number and its index in the hash map.
3. If the loop ends without finding a solution (though the problem guarantees a solution), return an empty array.

---

### **Code Example**

#### **Java Solution**

```java
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

       return new int[]{0};
    }
}
```

### **Why Use a HashMap?**

The hash map allows us to achieve constant-time lookups (\( O(1) \)), drastically reducing the time complexity of the
solution from \( O(n^2) \) (brute force) to \( O(n) \).

---

### **Visualization**

**Input Array**: `nums = [2, 7, 11, 15]`, `target = 9`

**Iteration Process**:

1. **i = 0**:
    - Current number = 2
    - Complement = \( 9 - 2 = 7 \)
    - HashMap = `{}` ? Add `2` with index `0`: `{2: 0}`
2. **i = 1**:
    - Current number = 7
    - Complement = \( 9 - 7 = 2 \)
    - HashMap = `{2: 0}` ? `2` is found! Return `[0, 1]`.