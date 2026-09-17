### **14. Longest Common Prefix**

---

### **Problem Statement**

Write a function to find the longest common prefix string amongst an array of strings. If there is no common
prefix, return an empty string `""`.

### **Example**

Input:

```plaintext
strs = ["flower", "flow", "flight"]
```

Output:

```plaintext
"fl"
```

Explanation:

- All three strings share `"fl"` as a starting substring, but diverge at the third character (`o` vs `i`).

Input:

```plaintext
strs = ["dog", "racecar", "car"]
```

Output:

```plaintext
""
```

Explanation:

- No common prefix exists among the input strings.

---

### **Constraints**

1. `1 <= strs.length <= 200`
2. `0 <= strs[i].length <= 200`
3. `strs[i]` consists of only lowercase English letters (when non-empty).

---

### **Approach to Solve**

1. **Horizontal Scanning**:
    - Treat `strs[0]` as the current prefix candidate.
    - Compare it against `strs[1]`, `strs[2]`, ... , shrinking the candidate from the end until it is a prefix of
      the current string being compared.
    - **Time Complexity**: \( O(S) \) where \( S \) is the sum of all characters in all strings (worst case).
    - **Space Complexity**: \( O(1) \) extra space.

2. **Vertical Scanning**:
    - Walk column by column (character index `0, 1, 2, ...`).
    - At each index, compare the character across every string in the array.
    - Stop as soon as a mismatch is found or the index goes out of bounds for any string.
    - **Time Complexity**: \( O(S) \) worst case, but often exits early when strings diverge quickly.
    - **Space Complexity**: \( O(1) \) extra space.

3. **Divide and Conquer**:
    - Split the array into two halves, recursively find the LCP of each half, then find the LCP between the two
      results.
    - **Time Complexity**: \( O(S) \).
    - **Space Complexity**: \( O(m \cdot \log n) \) for recursion stack, where \( m \) is the length of the
      longest string.

4. **Binary Search on Length**:
    - Binary search over candidate prefix lengths, from `0` to the length of the shortest string.
    - For each candidate length, check whether that prefix is common to all strings.
    - **Time Complexity**: \( O(S \cdot \log m) \), where \( m \) is the length of the shortest string.
    - **Space Complexity**: \( O(1) \) extra space.

---

### **Algorithm Explanation with Horizontal Scanning**

1. If the array is empty, return `""`.
2. Start with `prefix = strs[0]` as the candidate.
3. For each subsequent string `strs[i]`:
    - While `strs[i]` does not start with `prefix` (checked with `indexOf(prefix) != 0`), shrink `prefix` by
      removing its last character.
    - This repeats until `prefix` is either a valid prefix of `strs[i]` or becomes empty.
4. After checking every string, `prefix` holds the longest common prefix; return it.

---

### **Code Example**

#### **Java Solution**

```java
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }
}
```

### **Why Horizontal Scanning?**

It's straightforward: keep a single running candidate and shrink it whenever it fails to match the next string.
No need to track per-character indices across all strings at once — just compare whole strings with
`indexOf`/`substring` until convergence.

---

### **Visualization**

**Input Array**: `strs = ["flower", "flow", "flight"]`

**Iteration Process**:

1. **prefix = "flower"** (start).
2. **i = 1** (`"flow"`): `"flow".indexOf("flower")` != 0 → shrink: `"flowe"` → `"flow"`.
   `"flow".indexOf("flow") == 0` → stop shrinking. `prefix = "flow"`.
3. **i = 2** (`"flight"`): `"flight".indexOf("flow")` != 0 → shrink: `"flo"` → `"fl"`.
   `"flight".indexOf("fl") == 0` → stop shrinking. `prefix = "fl"`.
4. Loop ends. Return `"fl"`.
