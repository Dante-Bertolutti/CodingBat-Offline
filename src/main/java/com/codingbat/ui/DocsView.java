package com.codingbat.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.fxmisc.richtext.InlineCssTextArea;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DocsView {

    public record DocSection(String title, String explanation, String code) {}

    private static final Map<String, List<DocSection>> DOCS = new LinkedHashMap<>();

    static {
        DOCS.put("Variables & Types", List.of(
            new DocSection("Declaring Variables",
                "Java is statically typed — every variable needs a type. The most common primitive types are int, double, boolean, and char. String is a reference type but used just as often.",
                """
                int age = 25;
                double price = 9.99;
                boolean isActive = true;
                char grade = 'A';
                String name = "Alice";
                """),
            new DocSection("Type Casting",
                "You can convert between types. Widening (int to double) is automatic. Narrowing (double to int) requires an explicit cast.",
                """
                int x = 10;
                double y = x;         // auto: 10.0
                double z = 9.7;
                int w = (int) z;      // explicit: 9
                """),
            new DocSection("Constants",
                "Use the final keyword to declare a constant that cannot be reassigned.",
                """
                final int MAX_SIZE = 100;
                final double PI = 3.14159;
                """)
        ));

        DOCS.put("Operators", List.of(
            new DocSection("Arithmetic",
                "Standard math operators work on numeric types. The % (modulo) operator returns the remainder of division — very useful for checking even/odd.",
                """
                int sum = 5 + 3;       // 8
                int diff = 10 - 4;     // 6
                int product = 6 * 7;   // 42
                int quotient = 17 / 5; // 3 (integer division!)
                int remainder = 17 % 5; // 2
                double exact = 17.0 / 5; // 3.4
                """),
            new DocSection("Comparison",
                "Comparison operators return a boolean. Use == for equality (not = which is assignment). For Strings, always use .equals() instead of ==.",
                """
                boolean a = (5 > 3);    // true
                boolean b = (5 >= 5);   // true
                boolean c = (5 == 5);   // true
                boolean d = (5 != 3);   // true
                // Strings — ALWAYS use .equals()
                String s = "hello";
                boolean e = s.equals("hello"); // true
                boolean f = (s == "hello");    // unreliable!
                """),
            new DocSection("Logical",
                "Combine boolean expressions with && (and), || (or), and ! (not). These short-circuit: && stops on the first false, || stops on the first true.",
                """
                boolean x = true && false;  // false
                boolean y = true || false;  // true
                boolean z = !true;          // false
                // Short-circuit example:
                // if str is null, .length() is never called
                if (str != null && str.length() > 0) { }
                """)
        ));

        DOCS.put("Strings", List.of(
            new DocSection("Common Methods",
                "Strings are immutable objects with many useful methods. They return new strings — the original is never modified.",
                """
                String s = "Hello World";
                int len = s.length();           // 11
                char c = s.charAt(0);           // 'H'
                String sub = s.substring(0, 5); // "Hello"
                String low = s.toLowerCase();   // "hello world"
                String up = s.toUpperCase();    // "HELLO WORLD"
                """),
            new DocSection("Searching",
                "Find characters or substrings within a string. indexOf returns -1 if not found.",
                """
                String s = "Hello World";
                int i = s.indexOf("World");    // 6
                int j = s.indexOf("xyz");      // -1
                boolean has = s.contains("lo"); // true
                boolean start = s.startsWith("He"); // true
                boolean end = s.endsWith("ld");     // true
                """),
            new DocSection("Modifying",
                "Since strings are immutable, these methods return new strings.",
                """
                String s = "  hello  ";
                String t = s.trim();            // "hello"
                String r = s.replace('l', 'r'); // "  herro  "
                String[] parts = "a,b,c".split(","); // {"a","b","c"}
                String joined = String.join("-", "a", "b"); // "a-b"
                """),
            new DocSection("Building Strings",
                "Use + to concatenate. For loops, StringBuilder is more efficient.",
                """
                // Simple concatenation
                String greeting = "Hello " + "World"; // "Hello World"
                String msg = "Age: " + 25;            // "Age: 25"

                // StringBuilder for loops
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 5; i++) {
                    sb.append(i).append(" ");
                }
                String result = sb.toString(); // "0 1 2 3 4 "
                """),
            new DocSection("Comparing Strings",
                "Never use == to compare string content. Use .equals() for exact match, .equalsIgnoreCase() for case-insensitive, and .compareTo() for ordering.",
                """
                String a = "hello";
                String b = "Hello";
                a.equals(b);            // false
                a.equalsIgnoreCase(b);  // true
                a.compareTo(b);         // positive (h > H)
                "apple".compareTo("banana"); // negative (a < b)
                """)
        ));

        DOCS.put("Arrays", List.of(
            new DocSection("Creating Arrays",
                "Arrays are fixed-size containers of a single type. Once created, their length cannot change.",
                """
                int[] nums = new int[5];          // [0,0,0,0,0]
                int[] vals = {1, 2, 3, 4, 5};     // initialized
                String[] names = {"Alice", "Bob"};
                int len = vals.length;             // 5 (no parentheses!)
                """),
            new DocSection("Accessing & Modifying",
                "Arrays are zero-indexed. Accessing an out-of-bounds index throws ArrayIndexOutOfBoundsException.",
                """
                int[] nums = {10, 20, 30};
                int first = nums[0];       // 10
                int last = nums[nums.length - 1]; // 30
                nums[1] = 99;              // {10, 99, 30}
                """),
            new DocSection("Iterating",
                "Use a standard for loop when you need the index, or a for-each loop when you just need values.",
                """
                int[] nums = {1, 2, 3, 4, 5};

                // Standard for loop
                for (int i = 0; i < nums.length; i++) {
                    System.out.println(nums[i]);
                }

                // For-each loop
                for (int n : nums) {
                    System.out.println(n);
                }
                """),
            new DocSection("Common Patterns",
                "Useful array operations you'll use frequently in CodingBat problems.",
                """
                int[] nums = {3, 1, 4, 1, 5};

                // Find max
                int max = nums[0];
                for (int n : nums) {
                    max = Math.max(max, n);
                }

                // Sum
                int sum = 0;
                for (int n : nums) {
                    sum += n;
                }

                // Count occurrences
                int count = 0;
                for (int n : nums) {
                    if (n == 1) count++;
                }
                """)
        ));

        DOCS.put("If / Else", List.of(
            new DocSection("Basic If-Else",
                "Conditional statements control flow based on boolean expressions.",
                """
                int x = 10;
                if (x > 0) {
                    // positive
                } else if (x < 0) {
                    // negative
                } else {
                    // zero
                }
                """),
            new DocSection("Ternary Operator",
                "A compact one-line if-else. Great for simple assignments.",
                """
                int x = 10;
                String sign = (x >= 0) ? "positive" : "negative";
                int abs = (x < 0) ? -x : x;
                int max = (a > b) ? a : b;
                """),
            new DocSection("Common Patterns",
                "Patterns you'll see often in CodingBat logic problems.",
                """
                // Range check
                boolean inRange = (x >= 10 && x <= 20);

                // Either-or
                boolean hasSpecial = (a == 10 || b == 10);

                // Clamp a value
                if (val < min) val = min;
                if (val > max) val = max;

                // Return early
                public boolean isValid(int n) {
                    if (n < 0) return false;
                    if (n > 100) return false;
                    return true;
                }
                """)
        ));

        DOCS.put("Loops", List.of(
            new DocSection("For Loop",
                "Use when you know how many iterations. The three parts are: init; condition; update.",
                """
                // Count 0 to 4
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                }

                // Count backwards
                for (int i = 10; i >= 0; i--) {
                    System.out.println(i);
                }

                // Step by 2
                for (int i = 0; i < 10; i += 2) {
                    System.out.println(i); // 0,2,4,6,8
                }
                """),
            new DocSection("While Loop",
                "Use when the number of iterations isn't known in advance.",
                """
                int n = 123;
                int digitSum = 0;
                while (n > 0) {
                    digitSum += n % 10;  // add last digit
                    n /= 10;            // remove last digit
                }
                // digitSum = 6
                """),
            new DocSection("Loop Control",
                "break exits the loop immediately. continue skips to the next iteration.",
                """
                // Find first negative
                int[] nums = {3, 1, -4, 1, 5};
                int firstNeg = 0;
                for (int n : nums) {
                    if (n < 0) {
                        firstNeg = n;
                        break;  // stop searching
                    }
                }

                // Sum only positives
                int sum = 0;
                for (int n : nums) {
                    if (n < 0) continue; // skip negatives
                    sum += n;
                }
                """)
        ));

        DOCS.put("Recursion", List.of(
            new DocSection("How Recursion Works",
                "A recursive method calls itself with a smaller input, plus has a base case that stops the recursion. Think: (1) what's the simplest case? (2) how do I reduce the problem?",
                """
                // Pattern:
                public int solve(int n) {
                    if (n <= 0) return 0;        // base case
                    return n + solve(n - 1);     // recursive case
                }
                // solve(3) = 3 + solve(2)
                //           = 3 + 2 + solve(1)
                //           = 3 + 2 + 1 + solve(0)
                //           = 3 + 2 + 1 + 0 = 6
                """),
            new DocSection("Factorial",
                "The classic example: n! = n * (n-1) * ... * 1",
                """
                public int factorial(int n) {
                    if (n <= 1) return 1;
                    return n * factorial(n - 1);
                }
                // factorial(4) = 4 * 3 * 2 * 1 = 24
                """),
            new DocSection("String Recursion",
                "Process strings by looking at the first character, then recursing on the rest.",
                """
                // Count 'x' in a string
                public int countX(String str) {
                    if (str.isEmpty()) return 0;
                    int count = (str.charAt(0) == 'x') ? 1 : 0;
                    return count + countX(str.substring(1));
                }

                // Remove all 'x' from a string
                public String noX(String str) {
                    if (str.isEmpty()) return "";
                    if (str.charAt(0) == 'x') {
                        return noX(str.substring(1));
                    }
                    return str.charAt(0) + noX(str.substring(1));
                }
                """),
            new DocSection("Backtracking",
                "Try a choice, recurse, and undo if it doesn't work. Used in Recursion-2 problems like groupSum.",
                """
                // Can we pick numbers from nums that sum to target?
                public boolean groupSum(int i, int[] nums, int target) {
                    if (i >= nums.length) return target == 0;
                    // Try including nums[i]
                    if (groupSum(i + 1, nums, target - nums[i]))
                        return true;
                    // Try excluding nums[i]
                    if (groupSum(i + 1, nums, target))
                        return true;
                    return false;
                }
                """)
        ));

        DOCS.put("Math Helpers", List.of(
            new DocSection("Math Class",
                "Java's Math class has static methods for common operations. No import needed.",
                """
                int a = Math.abs(-5);          // 5
                int mx = Math.max(3, 7);       // 7
                int mn = Math.min(3, 7);       // 3
                double pw = Math.pow(2, 10);   // 1024.0
                double sq = Math.sqrt(16);     // 4.0
                int rd = (int)(Math.random() * 10); // 0-9
                """),
            new DocSection("Integer Division & Modulo",
                "Integer division truncates. Modulo gives the remainder. These are essential for many problems.",
                """
                int a = 17 / 5;   // 3 (not 3.4)
                int b = 17 % 5;   // 2 (remainder)

                // Check even/odd
                boolean isEven = (n % 2 == 0);

                // Get last digit
                int lastDigit = n % 10;

                // Remove last digit
                int rest = n / 10;

                // Round to nearest 10
                int rounded = ((n + 5) / 10) * 10;
                """)
        ));

        DOCS.put("Tips & Tricks", List.of(
            new DocSection("Substring Safety",
                "Always check string length before calling substring or charAt to avoid IndexOutOfBoundsException.",
                """
                // Safe substring
                String front = str.length() >= 3
                    ? str.substring(0, 3)
                    : str;

                // Safe charAt
                if (str.length() > 0) {
                    char first = str.charAt(0);
                }
                """),
            new DocSection("Array Edge Cases",
                "Watch for empty arrays and single-element arrays in your solutions.",
                """
                // Safe array access
                if (nums.length == 0) return false;
                int first = nums[0];
                int last = nums[nums.length - 1];

                // Comparing adjacent elements
                for (int i = 0; i < nums.length - 1; i++) {
                    if (nums[i] == nums[i + 1]) { ... }
                }
                """),
            new DocSection("Boolean Simplification",
                "Don't compare booleans to true/false. Return boolean expressions directly.",
                """
                // BAD
                if (x > 0) {
                    return true;
                } else {
                    return false;
                }

                // GOOD
                return x > 0;

                // BAD
                if (flag == true) { ... }

                // GOOD
                if (flag) { ... }
                """),
            new DocSection("De Morgan's Laws",
                "Useful for simplifying negated conditions. !(A && B) = !A || !B and !(A || B) = !A && !B",
                """
                // These are equivalent:
                !(a && b)   ==   (!a || !b)
                !(a || b)   ==   (!a && !b)

                // Example: "not in range 1..10"
                // Instead of: !(n >= 1 && n <= 10)
                // Write:      n < 1 || n > 10
                """)
        ));
    }

    public static Map<String, List<DocSection>> getAllDocs() {
        return DOCS;
    }

    public static ScrollPane buildDocsContent(String topic) {
        List<DocSection> sections = DOCS.get(topic);
        VBox content = new VBox(20);
        content.setPadding(new Insets(32));
        content.getStyleClass().add("content-area");

        Label topicTitle = new Label(topic);
        topicTitle.getStyleClass().add("problem-title");
        content.getChildren().add(topicTitle);

        for (DocSection section : sections) {
            Label sectionTitle = new Label(section.title());
            sectionTitle.getStyleClass().add("doc-section-title");

            Text explanation = new Text(section.explanation());
            explanation.getStyleClass().add("problem-desc");
            TextFlow explanationFlow = new TextFlow(explanation);
            explanationFlow.getStyleClass().add("problem-desc-flow");

            InlineCssTextArea codeBlock = SyntaxHighlighter.createCodeArea(section.code().stripLeading().stripTrailing());
            codeBlock.setEditable(false);
            codeBlock.setPrefHeight(Math.min(300, section.code().lines().count() * 22 + 20));

            content.getChildren().addAll(sectionTitle, explanationFlow, codeBlock);
        }

        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToWidth(true);
        scrollPane.getStyleClass().add("results-scroll");
        return scrollPane;
    }
}
