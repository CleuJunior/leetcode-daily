### 242. Valid Anagram

### Problem Explanation: **Valid Anagram**

The task is to determine if two strings \( s \) and \( t \) are anagrams. A string \( t \) is an anagram of string \(
s \) if it contains the same characters with the exact same frequencies, but possibly in a different order.

---

### Constraints and Notes:

1. \( 1 \leq s.length, t.length \leq 5 \times 10^4 \).
2. Both \( s \) and \( t \) consist of lowercase English letters.
3. **Follow-up**: Consider solutions that work for Unicode characters.

---

### Solution Approaches

#### Approach 1: Sort and Compare

- Sort both strings and compare them. If they are identical, \( t \) is an anagram of \( s \).

Steps:

1. Sort both \( s \) and \( t \).
2. Compare the sorted results.
3. Return `true` if they match, otherwise `false`.

#### Implementation:

```java
import java.util.Arrays;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }
}
```

**Time Complexity**: \( O(n \log n) \) (due to sorting).  
**Space Complexity**: \( O(n) \) (to store sorted arrays).

---

#### Approach 2: Frequency Count Using an Array

- Since the strings consist of only lowercase English letters, use an integer array of size 26 to track character
  counts.

Steps:

1. Create an array \( freq[26] \) initialized to 0.
2. Increment the count for characters in \( s \) and decrement the count for characters in \( t \).
3. If all counts in \( freq \) are 0, \( t \) is an anagram of \( s \).

#### Implementation:

```java
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
```

**Time Complexity**: \( O(n) \).  
**Space Complexity**: \( O(1) \) (fixed array size of 26).

---

#### Approach 3: Frequency Count with Two HashMaps (Unicode Support)

- This approach uses two separate `HashMap` objects to track the frequency of characters in both strings \( s \) and \( t \). At the end, the two maps are compared for equality.

---

### Steps:

1. Check if the lengths of \( s \) and \( t \) are different:
  - If so, immediately return `false` since anagrams must have the same length.
2. Create two `HashMap<Character, Integer>` objects, `mapS` and `mapT`, to store character frequencies for \( s \) and \( t \), respectively.
3. Iterate over the characters of \( s \) and \( t \) simultaneously:
  - Use `merge` to increment the frequency of each character in the corresponding map.
4. Compare the two maps:
  - If they are equal, the strings are anagrams; otherwise, they are not.

---

### Implementation:

```java
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        // Count the frequency of each character in both strings
        for (int i = 0; i < s.length(); i++) {
            mapS.merge(s.charAt(i), 1, Integer::sum);
            mapT.merge(t.charAt(i), 1, Integer::sum);
        }

        // Compare the two maps for equality
        return mapS.equals(mapT);
    }
}
```

---

### **Time Complexity**:
- \( O(n) \): Iterates over the characters of \( s \) and \( t \) once, where \( n \) is the length of the strings.

### **Space Complexity**:
- \( O(u) \): Requires additional space to store the frequency of characters, where \( u \) is the number of unique characters in \( s \) and \( t \).

---

### Follow-Up: Unicode Characters

- Use **Approach 3** (HashMap) to handle strings containing Unicode characters, as an array approach is limited to fixed
  alphabets (like ASCII).

---

### Example Walkthrough

#### Example 1:

Input: \( s = \text{"anagram"} \), \( t = \text{"nagaram"} \).

- Approach 2:
    - Frequency array: After processing \(
      s \): \([3, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\).
    - After processing \( t \): All counts return to 0.

Output: `true`.

#### Example 2:

Input: \( s = \text{"rat"} \), \( t = \text{"car"} \).

- Approach 2:
    - Frequency array does not return to 0.

Output: `false`.

### Summary Note for Approach:

"Check if two strings are anagrams by comparing sorted characters or counting character frequencies with a fixed array (
ASCII) or HashMap (Unicode support)."