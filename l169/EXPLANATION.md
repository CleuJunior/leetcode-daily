### 169. Majority Element

---

The problem asks us to find the **majority element** in an array. The majority element is defined as the element that
appears more than (n / 2) times.

---

### **Approach 1: HashMap (Counting Frequencies)**

We can use a `HashMap` to count the frequency of each element and return the one that appears more than \( n / 2 \)
times.

#### Implementation:

```java
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int majority = nums.length / 2;

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > majority) {
                return num;
            }
        }

        return -1; // This line won't be reached since a majority element is guaranteed.
    }
}
```

#### Time Complexity:

- \( O(n) \): Traverse the array once.

#### Space Complexity:

- \( O(n) \): Storing the frequency counts.

---

### **Approach 2: Boyer-Moore Voting Algorithm (Optimal)**

This algorithm works in \( O(n) \) time and \( O(1) \) space. It assumes that a majority element always exists and uses
a counter to determine the majority.

#### Steps:

1. Use a variable (`candidate`) to store the potential majority element.
2. Use a `count` variable to track the candidate's frequency:
    - Increment `count` if the current number equals `candidate`.
    - Decrement `count` otherwise.
    - If `count` becomes 0, update the `candidate` to the current number and reset `count`.

#### Implementation:

```java
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        // Step 1: Find the candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Step 2: Since the majority element always exists, return the candidate
        return candidate;
    }
}
```

#### Time Complexity:

- \( O(n) \): One pass through the array.

#### Space Complexity:

- \( O(1) \): Only uses constant space.

---

### **Approach 3: Sorting**

If we sort the array, the majority element will always be at the middle index.

#### Implementation:

```java
import java.util.Arrays;

public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
```

#### Time Complexity:

- \( O(n \log n) \): Sorting the array.

#### Space Complexity:

- \( O(1) \): In-place sorting (depends on the sorting algorithm).

---

### **Follow-Up**

The Boyer-Moore Voting Algorithm is the optimal approach, meeting the requirements of \( O(n) \) time and \( O(1) \)
space.