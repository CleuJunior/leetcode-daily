### **3. Longest Substring Without Repeating Characters**

To solve this problem efficiently, we can use the **Sliding Window** technique with a HashSet to track unique characters
in the current window.

---

### **Approach**

1. **Sliding Window Technique**:
    - Use two pointers (`left` and `right`) to define a window.
    - Expand the `right` pointer to include characters until a duplicate is found.
    - When a duplicate is encountered, move the `left` pointer to shrink the window until all characters are unique
      again.

2. **Tracking Unique Characters**:
    - A **HashSet** is used to store the characters in the current window.
    - If a character is already in the HashSet, remove characters from the left until the duplicate is removed.

3. **Updating Maximum Length**:
    - Keep track of the longest substring found by updating `maxLength` whenever a larger unique substring is found.

---

### **Implementation**

Here?s the Java implementation:

```java
import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLength = 0;
        HashSet<Character> uniqueChars = new HashSet<>();

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            while (uniqueChars.contains(currentChar)) {
                uniqueChars.remove(s.charAt(left));
                left++;
            }
            uniqueChars.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
```

---

### **Explanation**

1. **Initialization**:
    - `left` and `right` pointers start at index `0`.
    - A `HashSet` keeps track of unique characters in the current window.

2. **Expanding the Window (`right` pointer)**:
    - If `s[right]` is **not in the HashSet**, add it and update `maxLength`.
    - If `s[right]` is **already in the HashSet**, move the `left` pointer forward and remove characters until
      `s[right]` becomes unique again.

3. **Updating `maxLength`**:
    - At every step, update `maxLength = max(maxLength, right - left + 1)`.

4. **Loop Until `right` Reaches End of String**:
    - Continue until `right` reaches the end of `s`.

---

### **Complexity Analysis**

1. **Time Complexity**:
    - Each character is processed at most **twice** (once when added, once when removed), so the time complexity is **O(
      n)**.

2. **Space Complexity**:
    - The `HashSet` stores at most **O(?)** characters, where `?` is the character set size (e.g., 26 for lowercase
      English letters).
    - In the worst case (`s` contains all unique characters), the space complexity is **O(n)**.

---

### **Example Walkthrough**

#### **Example 1**

**Input**:  
`s = "abcabcbb"`

**Steps**:

| Step | Left | Right | Window | Unique Characters                | Max Length |
|------|------|-------|--------|----------------------------------|------------|
| 1    | 0    | 0     | "a"    | {a}                              | 1          |
| 2    | 0    | 1     | "ab"   | {a, b}                           | 2          |
| 3    | 0    | 2     | "abc"  | {a, b, c}                        | 3          |
| 4    | 0    | 3     | "abca" | Duplicate 'a' ? Move `left` to 1 | 3          |
| ...  | ...  | ...   | ...    | ...                              | ...        |

**Output**: `3`

---

#### **Example 2**

**Input**:  
`s = "bbbbb"`

**Steps**:

| Step | Left | Right | Window | Unique Characters                | Max Length |
|------|------|-------|--------|----------------------------------|------------|
| 1    | 0    | 0     | "b"    | {b}                              | 1          |
| 2    | 0    | 1     | "bb"   | Duplicate 'b' ? Move `left` to 1 | 1          |
| 3    | 1    | 2     | "bb"   | Duplicate 'b' ? Move `left` to 2 | 1          |

**Output**: `1`

---

#### **Example 3**

**Input**:  
`s = "pwwkew"`

**Steps**:

| Step | Left | Right | Window | Unique Characters                | Max Length |
|------|------|-------|--------|----------------------------------|------------|
| 1    | 0    | 0     | "p"    | {p}                              | 1          |
| 2    | 0    | 1     | "pw"   | {p, w}                           | 2          |
| 3    | 0    | 2     | "pww"  | Duplicate 'w' ? Move `left` to 1 | 2          |
| 4    | 1    | 3     | "wk"   | {w, k}                           | 2          |
| 5    | 1    | 4     | "wke"  | {w, k, e}                        | 3          |

**Output**: `3`

---

### **Key Notes**

- The **Sliding Window** technique optimizes performance by avoiding unnecessary re-evaluation of previous characters.
- Using a **HashSet** ensures we only track unique characters efficiently.
- **Time Complexity is O(n), Space Complexity is O(n).**