### 271. Encode and Decode Strings

---

Design an algorithm to encode a list of strings into a single string. The encoded string should be decodable back into
the original list of strings without any data loss.

---

### **Example**

#### Example 1

Input:

```plaintext
["leet", "code", "love", "you"]
```

Output:

```plaintext
["leet", "code", "love", "you"]
```

---

#### Example 2

Input:

```plaintext
["we", "say", ":", "yes"]
```

Output:

```plaintext
["we", "say", ":", "yes"]
```

---

### **Constraints**

1. \( 0 \leq \text{strs.length} < 100 \)
2. \( 0 \leq \text{strs}[i].\text{length} < 200 \)
3. \( \text{strs}[i] \) contains only UTF-8 characters.

---

### **Approach to Solve**

#### 1. **Encoding Strings with Length Prefix**

- Each string is prefixed with its length followed by a delimiter (e.g., `:`).
- This ensures no ambiguity during decoding, even if the strings contain special characters.

#### 2. **Decoding Strings Using Length Prefix**

- Traverse the encoded string, extracting the length of each string from the prefix and reading the corresponding number
  of characters.

---

### **Algorithm Explanation**

#### **Encoding**

1. Iterate through the list of strings.
2. For each string:
    - Calculate its length.
    - Append the length, a delimiter (`:`), and the string itself to the result.

#### **Decoding**

1. Start reading the encoded string from the beginning.
2. For each string:
    - Read characters until the delimiter to get the length.
    - Extract the string using the length.
    - Append the string to the result list.
3. Repeat until the entire encoded string is processed.

---

### **Code Example**

#### **Java Solution**

```java
import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append(":").append(str);
        }
        return encoded.toString();
    }

    // Decodes a single string back to a list of strings
    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // Find the delimiter to determine the length of the next string
            int colonIndex = str.indexOf(':', i);
            int length = Integer.parseInt(str.substring(i, colonIndex));
            i = colonIndex + 1; // Move past the colon
            // Extract the string of the given length
            decoded.add(str.substring(i, i + length));
            i += length; // Move to the next encoded string
        }

        return decoded;
    }
}
```

---

### **Why This Approach?**

- **No Data Loss**: The length prefix ensures even strings containing `:` are correctly encoded and decoded.
- **Efficient Decoding**: The delimiter and length prefix make decoding straightforward and reliable.
- **Space Efficiency**: No extra data structures are used apart from the encoded string.

---

### **Visualization**

#### Input: `["leet", "code", "love", "you"]`

**Encoding**:

1. `leet` ? `4:leet`
2. `code` ? `4:code`
3. `love` ? `4:love`
4. `you` ? `3:you`

**Encoded String**: `"4:leet4:code4:love3:you"`

**Decoding**:

1. Read `4`, extract `leet`.
2. Read `4`, extract `code`.
3. Read `4`, extract `love`.
4. Read `3`, extract `you`.

**Decoded List**: `["leet", "code", "love", "you"]`

---

### **Complexity Analysis**

1. **Time Complexity**:
    - Encoding: \( O(n) \), where \( n \) is the total length of all strings.
    - Decoding: \( O(n) \), where \( n \) is the length of the encoded string.

2. **Space Complexity**:
    - Encoding: \( O(n) \) for the resulting string.
    - Decoding: \( O(k) \), where \( k \) is the number of strings.

---

### **Example Outputs**

#### Example 1

Input:

```plaintext
["leet", "code", "love", "you"]
```

Output:

```plaintext
Encoded: "4:leet4:code4:love3:you"
Decoded: ["leet", "code", "love", "you"]
```

---

#### Example 2

Input:

```plaintext
["we", "say", ":", "yes"]
```

Output:

```plaintext
Encoded: "2:we3:say1::3:yes"
Decoded: ["we", "say", ":", "yes"]
```