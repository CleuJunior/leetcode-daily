### 125. Valid Palindrome

The task is to determine if a given string \( s \) is a palindrome after:

1. Removing all non-alphanumeric characters.
2. Converting all uppercase letters to lowercase.

A **palindrome** is a string that reads the same forwards and backwards.

---

### Steps to Solve the Problem

1. **Preprocessing the String**:
    - Use a regular expression to remove all characters that are not letters or numbers.
    - Convert all remaining characters to lowercase to ensure case insensitivity.

2. **Check for Palindrome**:
    - Use two pointers, one starting from the beginning (\( left \)) and the other from the end (\( right \)).
    - Compare characters at the two pointers:
        - If they differ, the string is not a palindrome.
        - If they match, move the pointers closer to each other and continue.
    - Stop when the pointers cross.

---

### Implementation (Two-Pointer Approach with Regular Expression)

```java
public static boolean isPalindrome(String s) {
    // Preprocess: Remove non-alphanumeric characters and convert to lowercase
    s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    int left = 0;
    int right = s.length() - 1;

    // Two-pointer comparison
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false; // Characters mismatch, not a palindrome
        }
        left++;
        right--;
    }

    return true; // All characters match
}
```

---

### Complexity Analysis

1. **Time Complexity**:
    - O(n), where \( n \) is the length of the string:
        - The `replaceAll` and `toLowerCase` operations each process the string once.
        - The two-pointer comparison loop processes each character once.

2. **Space Complexity**:
    - O(n), as the cleaned string requires additional space.

---

### Example Walkthroughs

#### Example 1:

Input: `"A man, a plan, a canal: Panama"`

- **Preprocessing**: Remove non-alphanumeric characters and convert to lowercase.
    - Result: `"amanaplanacanalpanama"`
- **Two-pointer check**:
    - Compare: `a` and `a`, `m` and `m`, ... (all characters match).
- Output: `true`

#### Example 2:

Input: `"race a car"`

- **Preprocessing**: `"raceacar"`
- **Two-pointer check**:
    - Compare: `r` and `r`, `a` and `a`, `c` and `e` (mismatch).
- Output: `false`

#### Example 3:

Input: `" "`

- **Preprocessing**: `""` (empty string).
- **Two-pointer check**:
    - Loop doesn?t run as \( left \geq right \).
- Output: `true` (empty strings are palindromes).