# **150. Evaluate Reverse Polish Notation**

---

## **Problem Statement**

Given an array of strings `tokens` representing an arithmetic expression in **Reverse Polish Notation (RPN)**, evaluate the expression and return the result as an integer.

### **Key Points**:
- **Operators**: `+`, `-`, `*`, `/`
- **Operands**: Can be integers or other expressions.
- **Division**: Truncates toward zero (e.g., `6 / -132 = 0`).
- **No division by zero**: Input is always valid.
- **32-bit integers**: All intermediate results fit in a 32-bit signed integer.

---

## **Examples**

### **Example 1**
**Input**:
```plaintext
tokens = ["2","1","+","3","*"]
```  
**Output**:
```plaintext
9
```  
**Explanation**:
- `2 + 1 = 3`
- `3 * 3 = 9`

### **Example 2**
**Input**:
```plaintext
tokens = ["4","13","5","/","+"]
```  
**Output**:
```plaintext
6
```  
**Explanation**:
- `13 / 5 = 2` (integer division truncates toward zero)
- `4 + 2 = 6`

### **Example 3**
**Input**:
```plaintext
tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
```  
**Output**:
```plaintext
22
```  
**Explanation**:
- `9 + 3 = 12`
- `12 * -11 = -132`
- `6 / -132 = 0` (truncated toward zero)
- `10 * 0 = 0`
- `0 + 17 = 17`
- `17 + 5 = 22`

---

## **Constraints**
- `1 <= tokens.length <= 10^4`
- `tokens[i]` is either `+`, `-`, `*`, `/`, or an integer in `[-200, 200]`.

---

## **Approach to Solve**

### **Reverse Polish Notation (RPN)**
- Also known as **postfix notation**, where operators follow their operands.
- **No parentheses** needed because the order of operations is unambiguous.
- **Evaluated using a stack**:
    1. Push operands onto the stack.
    2. When an operator is encountered, pop the top two operands, apply the operation, and push the result back.

### **Algorithm Steps**
1. **Initialize a stack** to store operands.
2. **Iterate through each token**:
    - If the token is a **number**, push it onto the stack.
    - If the token is an **operator**, pop the top two numbers, apply the operation, and push the result.
3. **Final result** is the only remaining element in the stack.

---

## **Code Example**

### **Java Solution**
```java
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;
                
                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                }
                
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}
```

### **Optimized Version (Using Deque and Early Checks)**
```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String token : tokens) {
            if (token.length() == 1 && !Character.isDigit(token.charAt(0))) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}
```

---

## **Complexity Analysis**

- **Time Complexity**: **O(n)** ? Each token is processed exactly once.
- **Space Complexity**: **O(n)** ? Worst case, the stack stores all operands before any operation (e.g., `["1","2","3","4","+","+","+"]`).

---

## **Key Takeaways**

1. **Stack is the natural choice** for evaluating RPN because it efficiently handles operand storage and retrieval.
2. **Order of operands matters**:
    - The **second popped** number is the **right operand** (e.g., `a - b` vs. `b - a`).
3. **Division truncates toward zero**:
    - `6 / -132 = 0` (not `-0.045...`).
4. **Edge Cases**:
    - Single operand (e.g., `["5"]` ? `5`).
    - Large expressions (handled efficiently due to O(n) time).

