# **20. Valid Parentheses**

---

## **Problem Statement**

Given a string `s` containing only the characters `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`, determine if the input string is valid.

A string is considered valid if:
1. **Open brackets must be closed by the same type of brackets.**
2. **Open brackets must be closed in the correct order.**
3. **Every close bracket has a corresponding open bracket of the same type.**

---

## **Examples**

### **Example 1:**
**Input:**
```plaintext
s = "()"
```  
**Output:**
```plaintext
true
```  

### **Example 2:**
**Input:**
```plaintext
s = "()[]{}"
```  
**Output:**
```plaintext
true
```  

### **Example 3:**
**Input:**
```plaintext
s = "(]"
```  
**Output:**
```plaintext
false
```  

### **Example 4:**
**Input:**
```plaintext
s = "([])"
```  
**Output:**
```plaintext
true
```  

---

## **Constraints**
- `1 <= s.length <= 10?`
- `s` consists of parentheses only: `'()[]{}'`.

---

## **Approach to Solve**

### **Using a Stack**
1. **Initialize a stack** to keep track of opening brackets.
2. **Iterate through each character** in the string:
   - If it's an **opening bracket** (`(`, `{`, `[`), push it onto the stack.
   - If it's a **closing bracket** (`)`, `}`, `]`), check if the stack is **not empty** and the **top element matches** the corresponding opening bracket.
      - If it matches, **pop** the stack.
      - If it doesn't match, **return false** (invalid string).
3. **After processing all characters**, if the stack is **empty**, return `true` (valid). Otherwise, return `false` (invalid).

---

## **Algorithm Explanation**

1. **Use a stack** to track the order of opening brackets.
2. **For each closing bracket encountered**, check if the **last opening bracket matches**.
3. **If the stack is empty when a closing bracket appears**, it means there's no matching opening bracket ? invalid.
4. **At the end**, if the stack is empty, all brackets were matched correctly ? valid.

---

## **Code Example**

### **Java Solution (Using Stack)**
```java
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
```

### **Java Solution (Using Deque and Map - Optimized)**
```java
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Solution {
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> closeToOpen = Map.of(')', '(', ']', '[', '}', '{');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (stack.isEmpty() || closeToOpen.get(c) != stack.peek()) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
```

### **Alternative (Optimized for Readability)**
```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (c == '(') stack.push(')');
        else if (c == '{') stack.push('}');
        else if (c == '[') stack.push(']');
        else if (stack.isEmpty() || stack.pop() != c) {
            return false;
        }
    }
    return stack.isEmpty();
}
```

---

## **Complexity Analysis**

- **Time Complexity:** \(O(n)\) ? Each character is processed once.
- **Space Complexity:** \(O(n)\) ? In the worst case, the stack stores all opening brackets (e.g., `((((`).

---

## **Key Takeaway**

- **Stack is the optimal data structure** for matching nested structures.
- **Efficiency** comes from **LIFO (Last-In-First-Out)** property, ensuring correct order.
- **Using a `Map` for bracket matching** improves code clarity and maintainability.
- **Edge cases** (empty string, unmatched closing brackets, leftover opening brackets) must be handled.

This approach efficiently checks for balanced parentheses while maintaining optimal performance.