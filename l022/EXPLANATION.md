# **22. Generate Parentheses**

---

## **Problem Statement**

Given `n` pairs of parentheses, generate all possible combinations of **well-formed** parentheses.

A combination is **well-formed** if:
1. Every opening parenthesis `(` has a corresponding closing parenthesis `)`.
2. Parentheses are **properly nested** (e.g., `"(())"` is valid, but `"(()"` is not).

---

## **Examples**

### **Example 1**
**Input**:
```plaintext
n = 3
```  
**Output**:
```plaintext
["((()))","(()())","(())()","()(())","()()()"]
```  

### **Example 2**
**Input**:
```plaintext
n = 1
```  
**Output**:
```plaintext
["()"]
```  

---

## **Constraints**
- `1 <= n <= 8`

---

## **Approach to Solve**

### **Backtracking (Recursive DFS)**
The most efficient way to generate all valid combinations is using **backtracking**:
1. **Track the number of open and close parentheses**:
    - `open`: Number of `(` used so far.
    - `close`: Number of `)` used so far.
2. **Recursive Rules**:
    - If `open < n`, we can add `(`.
    - If `close < open`, we can add `)` (ensures balance).
3. **Base Case**:
    - When the string length reaches `2n`, add it to the result.

### **Why Backtracking?**
- **Systematically explores all possibilities** without repetition.
- **Prunes invalid branches early** (e.g., stops if `close > open`).
- **Time Complexity**: **O(4? / ?n)** (Catalan number).

---

## **Algorithm Explanation**

1. **Initialize** an empty list `result` to store valid combinations.
2. **Define a recursive helper function**:
    - **Parameters**:
        - `current`: The current string being built.
        - `open`: Count of `(` used.
        - `close`: Count of `)` used.
    - **Base Case**: If `current.length() == 2n`, add to `result`.
    - **Recursive Cases**:
        - If `open < n`, add `(` and recurse.
        - If `close < open`, add `)` and recurse.
3. **Start the recursion** with `current = ""`, `open = 0`, `close = 0`.

---

## **Code Example**

### **Java Solution (Backtracking)**
```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == 2 * max) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
```

### **Optimized (StringBuilder for Mutable Strings)**
```java
public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(result, new StringBuilder(), 0, 0, n);
    return result;
}

private void backtrack(List<String> result, StringBuilder sb, int open, int close, int max) {
    if (sb.length() == 2 * max) {
        result.add(sb.toString());
        return;
    }

    if (open < max) {
        sb.append("(");
        backtrack(result, sb, open + 1, close, max);
        sb.deleteCharAt(sb.length() - 1); // Backtrack
    }
    if (close < open) {
        sb.append(")");
        backtrack(result, sb, open, close + 1, max);
        sb.deleteCharAt(sb.length() - 1); // Backtrack
    }
}
```

---

## **Complexity Analysis**

- **Time Complexity**: **O(4? / ?n)** (Catalan number growth).
- **Space Complexity**: **O(n)** (recursion stack depth).

---

## **Key Takeaways**

1. **Backtracking is optimal** for generating all combinations with constraints.
2. **Critical Conditions**:
    - Only add `)` if `close < open` (ensures validity).
    - Stop when the string length reaches `2n`.
3. **Optimizations**:
    - Using `StringBuilder` reduces string concatenation overhead.
    - Early pruning avoids invalid paths.

