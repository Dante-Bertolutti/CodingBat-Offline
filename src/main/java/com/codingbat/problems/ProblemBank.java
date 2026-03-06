package com.codingbat.problems;

import com.codingbat.model.Problem;
import com.codingbat.model.TestCase;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProblemBank {

    private static final Map<String, List<Problem>> PROBLEMS = new LinkedHashMap<>();

    static {
        // ==================== WARMUP-1 ====================
        PROBLEMS.put("Warmup-1", List.of(
            new Problem("sleep_in", "Warmup-1", "sleepIn",
                "The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on vacation. We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in.",
                "public static boolean sleepIn(boolean weekday, boolean vacation)",
                "sleepIn",
                List.of(
                    new TestCase("false, false", "true"),
                    new TestCase("true, false", "false"),
                    new TestCase("false, true", "true"),
                    new TestCase("true, true", "true")
                )),
            new Problem("monkey_trouble", "Warmup-1", "monkeyTrouble",
                "We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling. We are in trouble if they are both smiling or neither of them is smiling. Return true if we are in trouble.",
                "public static boolean monkeyTrouble(boolean aSmile, boolean bSmile)",
                "monkeyTrouble",
                List.of(
                    new TestCase("true, true", "true"),
                    new TestCase("false, false", "true"),
                    new TestCase("true, false", "false"),
                    new TestCase("false, true", "false")
                )),
            new Problem("sum_double", "Warmup-1", "sumDouble",
                "Given two int values, return their sum. Unless the two values are the same, then return double their sum.",
                "public static int sumDouble(int a, int b)",
                "sumDouble",
                List.of(
                    new TestCase("1, 2", "3"),
                    new TestCase("3, 2", "5"),
                    new TestCase("2, 2", "8"),
                    new TestCase("-1, 0", "-1"),
                    new TestCase("0, 0", "0"),
                    new TestCase("3, 3", "12")
                )),
            new Problem("diff21", "Warmup-1", "diff21",
                "Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n is over 21.",
                "public static int diff21(int n)",
                "diff21",
                List.of(
                    new TestCase("19", "2"),
                    new TestCase("10", "11"),
                    new TestCase("21", "0"),
                    new TestCase("22", "2"),
                    new TestCase("25", "8"),
                    new TestCase("30", "18")
                )),
            new Problem("parrot_trouble", "Warmup-1", "parrotTrouble",
                "We have a loud talking parrot. The \"hour\" parameter is the current hour time in the range 0..23. We are in trouble if the parrot is talking and the hour is before 7 or after 20. Return true if we are in trouble.",
                "public static boolean parrotTrouble(boolean talking, int hour)",
                "parrotTrouble",
                List.of(
                    new TestCase("true, 6", "true"),
                    new TestCase("true, 7", "false"),
                    new TestCase("false, 6", "false"),
                    new TestCase("true, 21", "true"),
                    new TestCase("false, 21", "false"),
                    new TestCase("true, 20", "false"),
                    new TestCase("false, 0", "false"),
                    new TestCase("true, 23", "true")
                )),
            new Problem("makes10", "Warmup-1", "makes10",
                "Given 2 ints, a and b, return true if one of them is 10 or if their sum is 10.",
                "public static boolean makes10(int a, int b)",
                "makes10",
                List.of(
                    new TestCase("9, 10", "true"),
                    new TestCase("9, 9", "false"),
                    new TestCase("1, 9", "true"),
                    new TestCase("10, 1", "true"),
                    new TestCase("10, 10", "true"),
                    new TestCase("8, 3", "false"),
                    new TestCase("0, 10", "true")
                )),
            new Problem("near_hundred", "Warmup-1", "nearHundred",
                "Given an int n, return true if it is within 10 of 100 or 200. Note: Math.abs(num) computes the absolute value of a number.",
                "public static boolean nearHundred(int n)",
                "nearHundred",
                List.of(
                    new TestCase("93", "true"),
                    new TestCase("90", "true"),
                    new TestCase("89", "false"),
                    new TestCase("110", "true"),
                    new TestCase("111", "false"),
                    new TestCase("190", "true"),
                    new TestCase("209", "true"),
                    new TestCase("211", "false")
                )),
            new Problem("pos_neg", "Warmup-1", "posNeg",
                "Given 2 int values, return true if one is negative and one is positive. Except if the parameter \"negative\" is true, then return true only if both are negative.",
                "public static boolean posNeg(int a, int b, boolean negative)",
                "posNeg",
                List.of(
                    new TestCase("1, -1, false", "true"),
                    new TestCase("-1, 1, false", "true"),
                    new TestCase("-4, -5, true", "true"),
                    new TestCase("-4, -5, false", "false"),
                    new TestCase("-4, 5, false", "true"),
                    new TestCase("1, 1, false", "false"),
                    new TestCase("-1, -1, false", "false")
                )),
            new Problem("not_string", "Warmup-1", "notString",
                "Given a string, return a new string where \"not \" has been added to the front. However, if the string already begins with \"not\", return the string unchanged.",
                "public static String notString(String str)",
                "notString",
                List.of(
                    new TestCase("\"candy\"", "not candy"),
                    new TestCase("\"x\"", "not x"),
                    new TestCase("\"not bad\"", "not bad"),
                    new TestCase("\"bad\"", "not bad"),
                    new TestCase("\"not\"", "not"),
                    new TestCase("\"is not\"", "not is not")
                )),
            new Problem("missing_char", "Warmup-1", "missingChar",
                "Given a non-empty string and an int n, return a new string where the char at index n has been removed. The value of n will be a valid index of a char in the original string.",
                "public static String missingChar(String str, int n)",
                "missingChar",
                List.of(
                    new TestCase("\"kitten\", 1", "ktten"),
                    new TestCase("\"kitten\", 0", "itten"),
                    new TestCase("\"kitten\", 4", "kittn"),
                    new TestCase("\"Hi\", 0", "i"),
                    new TestCase("\"Hi\", 1", "H"),
                    new TestCase("\"code\", 0", "ode"),
                    new TestCase("\"code\", 3", "cod")
                )),
            new Problem("front_back", "Warmup-1", "frontBack",
                "Given a string, return a new string where the first and last chars have been exchanged.",
                "public static String frontBack(String str)",
                "frontBack",
                List.of(
                    new TestCase("\"code\"", "eodc"),
                    new TestCase("\"a\"", "a"),
                    new TestCase("\"ab\"", "ba"),
                    new TestCase("\"abc\"", "cba"),
                    new TestCase("\"\"", "")
                )),
            new Problem("front3", "Warmup-1", "front3",
                "Given a string, we'll say that the front is the first 3 chars of the string. If the string length is less than 3, the front is whatever is there. Return a new string which is 3 copies of the front.",
                "public static String front3(String str)",
                "front3",
                List.of(
                    new TestCase("\"Java\"", "JavJavJav"),
                    new TestCase("\"Chocolate\"", "ChoChoCho"),
                    new TestCase("\"abc\"", "abcabcabc"),
                    new TestCase("\"ab\"", "ababab"),
                    new TestCase("\"a\"", "aaa"),
                    new TestCase("\"\"", "")
                ))
        ));

        // ==================== WARMUP-2 ====================
        PROBLEMS.put("Warmup-2", List.of(
            new Problem("string_times", "Warmup-2", "stringTimes",
                "Given a string and a non-negative int n, return a larger string that is n copies of the original string.",
                "public static String stringTimes(String str, int n)",
                "stringTimes",
                List.of(
                    new TestCase("\"Hi\", 2", "HiHi"),
                    new TestCase("\"Hi\", 3", "HiHiHi"),
                    new TestCase("\"Hi\", 1", "Hi"),
                    new TestCase("\"Hi\", 0", ""),
                    new TestCase("\"Oh Boy!\", 2", "Oh Boy!Oh Boy!")
                )),
            new Problem("front_times", "Warmup-2", "frontTimes",
                "Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front.",
                "public static String frontTimes(String str, int n)",
                "frontTimes",
                List.of(
                    new TestCase("\"Chocolate\", 2", "ChoCho"),
                    new TestCase("\"Chocolate\", 3", "ChoChoCho"),
                    new TestCase("\"Abc\", 3", "AbcAbcAbc"),
                    new TestCase("\"Ab\", 4", "AbAbAbAb"),
                    new TestCase("\"A\", 4", "AAAA"),
                    new TestCase("\"\"", "")
                )),
            new Problem("count_xx", "Warmup-2", "countXX",
                "Count the number of \"xx\" in the given string. We'll say that overlapping is allowed, so \"xxx\" contains 2 \"xx\".",
                "public static int countXX(String str)",
                "countXX",
                List.of(
                    new TestCase("\"abcxx\"", "1"),
                    new TestCase("\"xxx\"", "2"),
                    new TestCase("\"xxxx\"", "3"),
                    new TestCase("\"abc\"", "0"),
                    new TestCase("\"\"", "0"),
                    new TestCase("\"xx\"", "1")
                )),
            new Problem("double_x", "Warmup-2", "doubleX",
                "Given a string, return true if the first instance of \"x\" in the string is immediately followed by another \"x\".",
                "public static boolean doubleX(String str)",
                "doubleX",
                List.of(
                    new TestCase("\"axxbb\"", "true"),
                    new TestCase("\"axaxax\"", "false"),
                    new TestCase("\"xxxxx\"", "true"),
                    new TestCase("\"xaxxx\"", "false"),
                    new TestCase("\"aaaax\"", "false"),
                    new TestCase("\"\"", "false")
                )),
            new Problem("string_bits", "Warmup-2", "stringBits",
                "Given a string, return a new string made of every other char starting with the first, so \"Hello\" yields \"Hlo\".",
                "public static String stringBits(String str)",
                "stringBits",
                List.of(
                    new TestCase("\"Hello\"", "Hlo"),
                    new TestCase("\"Hi\"", "H"),
                    new TestCase("\"Heeololeo\"", "Hoooe"),
                    new TestCase("\"HiHiHi\"", "HHH"),
                    new TestCase("\"\"", ""),
                    new TestCase("\"Greetings\"", "Geigs")
                )),
            new Problem("string_splosion", "Warmup-2", "stringSplosion",
                "Given a non-empty string like \"Code\" return a string like \"CCoCodCode\".",
                "public static String stringSplosion(String str)",
                "stringSplosion",
                List.of(
                    new TestCase("\"Code\"", "CCoCodCode"),
                    new TestCase("\"abc\"", "aababc"),
                    new TestCase("\"ab\"", "aab"),
                    new TestCase("\"x\"", "x"),
                    new TestCase("\"fade\"", "ffafadfade")
                )),
            new Problem("last2", "Warmup-2", "last2",
                "Given a string, return the count of the number of times that a substring length 2 appears in the string and also as the last 2 chars of the string, so \"hixxxhi\" yields 1 (we won't count the end substring).",
                "public static int last2(String str)",
                "last2",
                List.of(
                    new TestCase("\"hixxhi\"", "1"),
                    new TestCase("\"xaxxaxaxx\"", "1"),
                    new TestCase("\"axxxaaxx\"", "2"),
                    new TestCase("\"xxxx\"", "2"),
                    new TestCase("\"xx\"", "0"),
                    new TestCase("\"x\"", "0"),
                    new TestCase("\"\"", "0")
                )),
            new Problem("array_count9", "Warmup-2", "arrayCount9",
                "Given an array of ints, return the number of 9's in the array.",
                "public static int arrayCount9(int[] nums)",
                "arrayCount9",
                List.of(
                    new TestCase("{1, 2, 9}", "1"),
                    new TestCase("{1, 9, 9}", "2"),
                    new TestCase("{1, 9, 9, 3, 9}", "3"),
                    new TestCase("{1, 2, 3}", "0"),
                    new TestCase("{}", "0")
                )),
            new Problem("array_front9", "Warmup-2", "arrayFront9",
                "Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4.",
                "public static boolean arrayFront9(int[] nums)",
                "arrayFront9",
                List.of(
                    new TestCase("{1, 2, 9, 3, 4}", "true"),
                    new TestCase("{1, 2, 3, 4, 9}", "false"),
                    new TestCase("{1, 2, 3, 4, 5}", "false"),
                    new TestCase("{9, 2, 3}", "true"),
                    new TestCase("{1, 9, 9}", "true"),
                    new TestCase("{}", "false")
                )),
            new Problem("array123", "Warmup-2", "array123",
                "Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.",
                "public static boolean array123(int[] nums)",
                "array123",
                List.of(
                    new TestCase("{1, 1, 2, 3, 1}", "true"),
                    new TestCase("{1, 1, 2, 4, 1}", "false"),
                    new TestCase("{1, 1, 2, 1, 2, 3}", "true"),
                    new TestCase("{1, 2, 3}", "true"),
                    new TestCase("{1, 2}", "false"),
                    new TestCase("{}", "false")
                ))
        ));

        // ==================== STRING-1 ====================
        PROBLEMS.put("String-1", List.of(
            new Problem("hello_name", "String-1", "helloName",
                "Given a string name, e.g. \"Bob\", return a greeting of the form \"Hello Bob!\".",
                "public static String helloName(String name)",
                "helloName",
                List.of(
                    new TestCase("\"Bob\"", "Hello Bob!"),
                    new TestCase("\"Alice\"", "Hello Alice!"),
                    new TestCase("\"X\"", "Hello X!"),
                    new TestCase("\"Dolly\"", "Hello Dolly!"),
                    new TestCase("\"Alpha\"", "Hello Alpha!")
                )),
            new Problem("make_abba", "String-1", "makeAbba",
                "Given two strings, a and b, return the result of putting them together in the order \"aababba\", e.g. \"Hi\" and \"Bye\" returns \"HiByeByeHi\".",
                "public static String makeAbba(String a, String b)",
                "makeAbba",
                List.of(
                    new TestCase("\"Hi\", \"Bye\"", "HiByeByeHi"),
                    new TestCase("\"Yo\", \"Alice\"", "YoAliceAliceYo"),
                    new TestCase("\"What\", \"Up\"", "WhatUpUpWhat"),
                    new TestCase("\"aaa\", \"bbb\"", "aaabbbbbbaaa"),
                    new TestCase("\"x\", \"y\"", "xyyx")
                )),
            new Problem("make_tags", "String-1", "makeTags",
                "The web is built with HTML strings like \"<i>Yay</i>\" which draws Yay as italic text. In this example, the \"i\" tag makes <i> and </i> which surround the word \"Yay\". Given tag and word strings, create the HTML string with tags around the word.",
                "public static String makeTags(String tag, String word)",
                "makeTags",
                List.of(
                    new TestCase("\"i\", \"Yay\"", "<i>Yay</i>"),
                    new TestCase("\"i\", \"Hello\"", "<i>Hello</i>"),
                    new TestCase("\"cite\", \"Yay\"", "<cite>Yay</cite>"),
                    new TestCase("\"address\", \"here\"", "<address>here</address>"),
                    new TestCase("\"body\", \"Heart\"", "<body>Heart</body>")
                )),
            new Problem("make_out_word", "String-1", "makeOutWord",
                "Given an \"out\" string length 4, such as \"<<>>\", and a word, return a new string where the word is in the middle of the out string, e.g. \"<<word>>\".",
                "public static String makeOutWord(String out, String word)",
                "makeOutWord",
                List.of(
                    new TestCase("\"<<>>\", \"Yay\"", "<<Yay>>"),
                    new TestCase("\"<<>>\", \"WooHoo\"", "<<WooHoo>>"),
                    new TestCase("\"[[]]\", \"word\"", "[[word]]"),
                    new TestCase("\"AABB\", \"xx\"", "AAxxBB")
                )),
            new Problem("extra_end", "String-1", "extraEnd",
                "Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string length will be at least 2.",
                "public static String extraEnd(String str)",
                "extraEnd",
                List.of(
                    new TestCase("\"Hello\"", "lololo"),
                    new TestCase("\"ab\"", "ababab"),
                    new TestCase("\"Hi\"", "HiHiHi"),
                    new TestCase("\"Candy\"", "dydydy"),
                    new TestCase("\"Code\"", "dedede")
                )),
            new Problem("first_two", "String-1", "firstTwo",
                "Given a string, return the string made of its first two chars, so the String \"Hello\" yields \"He\". If the string is shorter than length 2, return whatever there is.",
                "public static String firstTwo(String str)",
                "firstTwo",
                List.of(
                    new TestCase("\"Hello\"", "He"),
                    new TestCase("\"abcdefg\"", "ab"),
                    new TestCase("\"ab\"", "ab"),
                    new TestCase("\"a\"", "a"),
                    new TestCase("\"\"", "")
                )),
            new Problem("first_half", "String-1", "firstHalf",
                "Given a string of even length, return the first half. So the string \"WooHoo\" yields \"Woo\".",
                "public static String firstHalf(String str)",
                "firstHalf",
                List.of(
                    new TestCase("\"WooHoo\"", "Woo"),
                    new TestCase("\"HelloThere\"", "Hello"),
                    new TestCase("\"abcdef\"", "abc"),
                    new TestCase("\"ab\"", "a")
                )),
            new Problem("without_end", "String-1", "withoutEnd",
                "Given a string, return a version without the first and last char, so \"Hello\" yields \"ell\". The string length will be at least 2.",
                "public static String withoutEnd(String str)",
                "withoutEnd",
                List.of(
                    new TestCase("\"Hello\"", "ell"),
                    new TestCase("\"java\"", "av"),
                    new TestCase("\"coding\"", "odin"),
                    new TestCase("\"code\"", "od"),
                    new TestCase("\"ab\"", "")
                )),
            new Problem("combo_string", "String-1", "comboString",
                "Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string on the outside and the longer string on the inside. The strings will not be the same length, but they may be empty (length 0).",
                "public static String comboString(String a, String b)",
                "comboString",
                List.of(
                    new TestCase("\"Hello\", \"hi\"", "hiHellohi"),
                    new TestCase("\"hi\", \"Hello\"", "hiHellohi"),
                    new TestCase("\"aaa\", \"b\"", "baaab"),
                    new TestCase("\"b\", \"aaa\"", "baaab"),
                    new TestCase("\"aaa\", \"\"", "aaa")
                )),
            new Problem("non_start", "String-1", "nonStart",
                "Given 2 strings, return their concatenation, except omit the first char of each. The strings will be at least length 1.",
                "public static String nonStart(String a, String b)",
                "nonStart",
                List.of(
                    new TestCase("\"Hello\", \"There\"", "ellohere"),
                    new TestCase("\"java\", \"code\"", "avaode"),
                    new TestCase("\"shotl\", \"java\"", "hotlava"),
                    new TestCase("\"ab\", \"cd\"", "bd")
                )),
            new Problem("left2", "String-1", "left2",
                "Given a string, return a \"rotated left 2\" version where the first 2 chars are moved to the end. The string length will be at least 2.",
                "public static String left2(String str)",
                "left2",
                List.of(
                    new TestCase("\"Hello\"", "lloHe"),
                    new TestCase("\"java\"", "vaja"),
                    new TestCase("\"Hi\"", "Hi"),
                    new TestCase("\"code\"", "deco")
                )),
            new Problem("right2", "String-1", "right2",
                "Given a string, return a \"rotated right 2\" version where the last 2 chars are moved to the start. The string length will be at least 2.",
                "public static String right2(String str)",
                "right2",
                List.of(
                    new TestCase("\"Hello\"", "loHel"),
                    new TestCase("\"java\"", "vaja"),
                    new TestCase("\"Hi\"", "Hi"),
                    new TestCase("\"code\"", "deco")
                )),
            new Problem("the_end", "String-1", "theEnd",
                "Given a string, return a string length 1 from its front, unless front is false, in which case return a string length 1 from its back. The string will be non-empty.",
                "public static String theEnd(String str, boolean front)",
                "theEnd",
                List.of(
                    new TestCase("\"Hello\", true", "H"),
                    new TestCase("\"Hello\", false", "o"),
                    new TestCase("\"oh\", true", "o"),
                    new TestCase("\"oh\", false", "h"),
                    new TestCase("\"x\", true", "x")
                )),
            new Problem("without_end2", "String-1", "withoutEnd2",
                "Given a string, return a version without both the first and last char of the string. The string may be any length, including 0.",
                "public static String withoutEnd2(String str)",
                "withoutEnd2",
                List.of(
                    new TestCase("\"Hello\"", "ell"),
                    new TestCase("\"abc\"", "b"),
                    new TestCase("\"ab\"", ""),
                    new TestCase("\"a\"", ""),
                    new TestCase("\"\"", "")
                )),
            new Problem("middle_two", "String-1", "middleTwo",
                "Given a string of even length, return its middle 2 chars, so the string \"string\" yields \"ri\". The string length will be at least 2.",
                "public static String middleTwo(String str)",
                "middleTwo",
                List.of(
                    new TestCase("\"string\"", "ri"),
                    new TestCase("\"code\"", "od"),
                    new TestCase("\"Practice\"", "ct"),
                    new TestCase("\"ab\"", "ab"),
                    new TestCase("\"0123456789\"", "45")
                ))
        ));

        // ==================== STRING-2 ====================
        PROBLEMS.put("String-2", List.of(
            new Problem("double_char", "String-2", "doubleChar",
                "Given a string, return a string where for every char in the original, there are two chars.",
                "public static String doubleChar(String str)",
                "doubleChar",
                List.of(
                    new TestCase("\"The\"", "TThhee"),
                    new TestCase("\"AAbb\"", "AAAAbbbb"),
                    new TestCase("\"Hi-There\"", "HHii--TThheerree"),
                    new TestCase("\"Word!\"", "WWoorrdd!!"),
                    new TestCase("\"\"", "")
                )),
            new Problem("count_hi", "String-2", "countHi",
                "Return the number of times that the string \"hi\" appears anywhere in the given string.",
                "public static int countHi(String str)",
                "countHi",
                List.of(
                    new TestCase("\"abc hi ho\"", "1"),
                    new TestCase("\"ABChi hi\"", "2"),
                    new TestCase("\"hihi\"", "2"),
                    new TestCase("\"hihih\"", "2"),
                    new TestCase("\"\"", "0"),
                    new TestCase("\"h\"", "0"),
                    new TestCase("\"hi\"", "1")
                )),
            new Problem("cat_dog", "String-2", "catDog",
                "Return true if the string \"cat\" and \"dog\" appear the same number of times in the given string.",
                "public static boolean catDog(String str)",
                "catDog",
                List.of(
                    new TestCase("\"catdog\"", "true"),
                    new TestCase("\"catcat\"", "false"),
                    new TestCase("\"1cat1cadodog\"", "true"),
                    new TestCase("\"catxxdogxxxdog\"", "false"),
                    new TestCase("\"\"", "true")
                )),
            new Problem("count_code", "String-2", "countCode",
                "Return the number of times that the string \"code\" appears anywhere in the given string, except we'll accept any letter for the 'd', so \"cope\" and \"coze\" count.",
                "public static int countCode(String str)",
                "countCode",
                List.of(
                    new TestCase("\"aaacodebbb\"", "1"),
                    new TestCase("\"codexxcode\"", "2"),
                    new TestCase("\"cozexxcope\"", "2"),
                    new TestCase("\"cozfxxcope\"", "1"),
                    new TestCase("\"xxcozeyycop\"", "1"),
                    new TestCase("\"\"", "0")
                )),
            new Problem("end_other", "String-2", "endOther",
                "Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences.",
                "public static boolean endOther(String a, String b)",
                "endOther",
                List.of(
                    new TestCase("\"Hiabc\", \"abc\"", "true"),
                    new TestCase("\"AbC\", \"HiaBc\"", "true"),
                    new TestCase("\"abc\", \"abXabc\"", "true"),
                    new TestCase("\"Hiabc\", \"abcd\"", "false"),
                    new TestCase("\"Hiabc\", \"bc\"", "true"),
                    new TestCase("\"ab\", \"ab\"", "true")
                )),
            new Problem("xyz_there", "String-2", "xyzThere",
                "Return true if the given string contains an appearance of \"xyz\" where the xyz is not directly preceded by a period (.). So \"xxyz\" counts but \"x.xyz\" does not.",
                "public static boolean xyzThere(String str)",
                "xyzThere",
                List.of(
                    new TestCase("\"abcxyz\"", "true"),
                    new TestCase("\"abc.xyz\"", "false"),
                    new TestCase("\"xyz.abc\"", "true"),
                    new TestCase("\"abcxy\"", "false"),
                    new TestCase("\"xyz\"", "true"),
                    new TestCase("\"xy\"", "false"),
                    new TestCase("\"x\"", "false"),
                    new TestCase("\"\"", "false"),
                    new TestCase("\"abc.xyzxyz\"", "true")
                ))
        ));

        // ==================== ARRAY-1 ====================
        PROBLEMS.put("Array-1", List.of(
            new Problem("first_last6", "Array-1", "firstLast6",
                "Given an array of ints, return true if 6 appears as either the first or last element in the array. The array will be length 1 or more.",
                "public static boolean firstLast6(int[] nums)",
                "firstLast6",
                List.of(
                    new TestCase("{1, 2, 6}", "true"),
                    new TestCase("{6, 1, 2, 3}", "true"),
                    new TestCase("{13, 6, 1, 2, 3}", "false"),
                    new TestCase("{3, 2, 1}", "false"),
                    new TestCase("{6}", "true")
                )),
            new Problem("same_first_last", "Array-1", "sameFirstLast",
                "Given an array of ints, return true if the array is length 1 or more, and the first element and the last element are equal.",
                "public static boolean sameFirstLast(int[] nums)",
                "sameFirstLast",
                List.of(
                    new TestCase("{1, 2, 3}", "false"),
                    new TestCase("{1, 2, 3, 1}", "true"),
                    new TestCase("{1, 2, 1}", "true"),
                    new TestCase("{7}", "true"),
                    new TestCase("{}", "false")
                )),
            new Problem("make_pi", "Array-1", "makePi",
                "Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}.",
                "public static int[] makePi()",
                "makePi",
                List.of(
                    new TestCase("", "{3, 1, 4}")
                )),
            new Problem("common_end", "Array-1", "commonEnd",
                "Given 2 arrays of ints, a and b, return true if they have the same first element or they have the same last element. Both arrays will be length 1 or more.",
                "public static boolean commonEnd(int[] a, int[] b)",
                "commonEnd",
                List.of(
                    new TestCase("{1, 2, 3}, {7, 3}", "true"),
                    new TestCase("{1, 2, 3}, {7, 3, 2}", "false"),
                    new TestCase("{1, 2, 3}, {1, 3}", "true")
                )),
            new Problem("sum3", "Array-1", "sum3",
                "Given an array of ints length 3, return the sum of all the elements.",
                "public static int sum3(int[] nums)",
                "sum3",
                List.of(
                    new TestCase("{1, 2, 3}", "6"),
                    new TestCase("{5, 11, 2}", "18"),
                    new TestCase("{7, 0, 0}", "7"),
                    new TestCase("{1, 2, 1}", "4"),
                    new TestCase("{0, 0, 0}", "0")
                )),
            new Problem("rotate_left3", "Array-1", "rotateLeft3",
                "Given an array of ints length 3, return an array with the elements \"rotated left\" so {1, 2, 3} yields {2, 3, 1}.",
                "public static int[] rotateLeft3(int[] nums)",
                "rotateLeft3",
                List.of(
                    new TestCase("{1, 2, 3}", "{2, 3, 1}"),
                    new TestCase("{5, 11, 9}", "{11, 9, 5}"),
                    new TestCase("{7, 0, 0}", "{0, 0, 7}")
                )),
            new Problem("reverse3", "Array-1", "reverse3",
                "Given an array of ints length 3, return a new array with the elements in reverse order, so {1, 2, 3} becomes {3, 2, 1}.",
                "public static int[] reverse3(int[] nums)",
                "reverse3",
                List.of(
                    new TestCase("{1, 2, 3}", "{3, 2, 1}"),
                    new TestCase("{5, 11, 9}", "{9, 11, 5}"),
                    new TestCase("{7, 0, 0}", "{0, 0, 7}"),
                    new TestCase("{2, 1, 2}", "{2, 1, 2}")
                )),
            new Problem("max_end3", "Array-1", "maxEnd3",
                "Given an array of ints length 3, figure out which is larger, the first or last element in the array, and set all the other elements to be that value. Return the changed array.",
                "public static int[] maxEnd3(int[] nums)",
                "maxEnd3",
                List.of(
                    new TestCase("{1, 2, 3}", "{3, 3, 3}"),
                    new TestCase("{11, 5, 9}", "{11, 11, 11}"),
                    new TestCase("{2, 11, 3}", "{3, 3, 3}")
                )),
            new Problem("sum2", "Array-1", "sum2",
                "Given 1 or more ints, return the sum of the first 2 elements from the array. If the array length is less than 2, just sum up the elements that exist, returning 0 for an empty array.",
                "public static int sum2(int[] nums)",
                "sum2",
                List.of(
                    new TestCase("{1, 2, 3}", "3"),
                    new TestCase("{1, 1}", "2"),
                    new TestCase("{1, 1, 1, 1}", "2"),
                    new TestCase("{1}", "1"),
                    new TestCase("{}", "0"),
                    new TestCase("{4, 5, 6}", "9")
                )),
            new Problem("middle_way", "Array-1", "middleWay",
                "Given 2 int arrays, a and b, each length 3, return a new array length 2 containing their middle elements.",
                "public static int[] middleWay(int[] a, int[] b)",
                "middleWay",
                List.of(
                    new TestCase("{1, 2, 3}, {4, 5, 6}", "{2, 5}"),
                    new TestCase("{7, 7, 7}, {3, 8, 0}", "{7, 8}"),
                    new TestCase("{5, 2, 9}, {1, 4, 5}", "{2, 4}")
                )),
            new Problem("has23", "Array-1", "has23",
                "Given an int array length 2, return true if it contains a 2 or a 3.",
                "public static boolean has23(int[] nums)",
                "has23",
                List.of(
                    new TestCase("{2, 5}", "true"),
                    new TestCase("{4, 3}", "true"),
                    new TestCase("{4, 5}", "false"),
                    new TestCase("{2, 2}", "true"),
                    new TestCase("{3, 2}", "true"),
                    new TestCase("{3, 3}", "true")
                ))
        ));

        // ==================== ARRAY-2 ====================
        PROBLEMS.put("Array-2", List.of(
            new Problem("count_evens", "Array-2", "countEvens",
                "Return the number of even ints in the given array. Note: the % \"mod\" operator computes the remainder, e.g. 5 % 2 is 1.",
                "public static int countEvens(int[] nums)",
                "countEvens",
                List.of(
                    new TestCase("{2, 1, 2, 3, 4}", "3"),
                    new TestCase("{2, 2, 0}", "3"),
                    new TestCase("{1, 3, 5}", "0"),
                    new TestCase("{}", "0"),
                    new TestCase("{11, 9, 0, 1}", "1")
                )),
            new Problem("big_diff", "Array-2", "bigDiff",
                "Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array.",
                "public static int bigDiff(int[] nums)",
                "bigDiff",
                List.of(
                    new TestCase("{10, 3, 5, 6}", "7"),
                    new TestCase("{7, 2, 10, 9}", "8"),
                    new TestCase("{2, 10, 7, 2}", "8"),
                    new TestCase("{2, 2}", "0"),
                    new TestCase("{5}", "0")
                )),
            new Problem("centered_average", "Array-2", "centeredAverage",
                "Return the \"centered\" average of an array of ints, which we'll say is the mean average of the values, except ignoring the largest and smallest values in the array. If there are multiple copies of the smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce the final average. You may assume that the array is length 3 or more.",
                "public static int centeredAverage(int[] nums)",
                "centeredAverage",
                List.of(
                    new TestCase("{1, 2, 3, 4, 100}", "3"),
                    new TestCase("{1, 1, 5, 5, 10, 8, 7}", "5"),
                    new TestCase("{-10, -4, -2, -4, -2, 0}", "-2"),
                    new TestCase("{5, 3, 4, 6, 2}", "4")
                )),
            new Problem("sum13", "Array-2", "sum13",
                "Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13 is very unlucky, so it does not count and numbers that come immediately after a 13 also do not count.",
                "public static int sum13(int[] nums)",
                "sum13",
                List.of(
                    new TestCase("{1, 2, 2, 1}", "6"),
                    new TestCase("{1, 1}", "2"),
                    new TestCase("{1, 2, 2, 1, 13}", "6"),
                    new TestCase("{1, 2, 13, 2, 1}", "4"),
                    new TestCase("{13, 1, 2, 13, 2, 1}", "3"),
                    new TestCase("{}", "0"),
                    new TestCase("{13}", "0"),
                    new TestCase("{13, 13}", "0")
                )),
            new Problem("sum67", "Array-2", "sum67",
                "Return the sum of the numbers in the array, except ignore sections of numbers starting with a 6 and extending to the next 7 (every 6 will be followed by at least one 7). Return 0 for no numbers.",
                "public static int sum67(int[] nums)",
                "sum67",
                List.of(
                    new TestCase("{1, 2, 2}", "5"),
                    new TestCase("{1, 2, 2, 6, 99, 99, 7}", "5"),
                    new TestCase("{1, 1, 6, 7, 2}", "4"),
                    new TestCase("{6, 7, 2}", "2"),
                    new TestCase("{6, 99, 7}", "0"),
                    new TestCase("{}", "0"),
                    new TestCase("{1, 6, 7, 7}", "8")
                )),
            new Problem("has22", "Array-2", "has22",
                "Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.",
                "public static boolean has22(int[] nums)",
                "has22",
                List.of(
                    new TestCase("{1, 2, 2}", "true"),
                    new TestCase("{1, 2, 1, 2}", "false"),
                    new TestCase("{2, 1, 2}", "false"),
                    new TestCase("{2, 2, 1}", "true"),
                    new TestCase("{1, 1}", "false"),
                    new TestCase("{2}", "false"),
                    new TestCase("{}", "false")
                ))
        ));

        // ==================== LOGIC-1 ====================
        PROBLEMS.put("Logic-1", List.of(
            new Problem("cigar_party", "Logic-1", "cigarParty",
                "When squirrels get together for a party, they can have a cigar if the number of cigars is between 40 and 60, inclusive. Unless it's the weekend, in which case there is no upper bound on the number of cigars. Return true if the party with the given values is successful, or false otherwise.",
                "public static boolean cigarParty(int cigars, boolean isWeekend)",
                "cigarParty",
                List.of(
                    new TestCase("30, false", "false"),
                    new TestCase("50, false", "true"),
                    new TestCase("70, true", "true"),
                    new TestCase("30, true", "false"),
                    new TestCase("40, false", "true"),
                    new TestCase("60, false", "true"),
                    new TestCase("61, false", "false"),
                    new TestCase("40, true", "true")
                )),
            new Problem("date_fashion", "Logic-1", "dateFashion",
                "You and your date are trying to get a table at a restaurant. The parameter \"you\" and \"date\" are the stylishness of your clothes, in the range 0..10. The result getting the table is encoded as an int value with 0=no, 1=maybe, 2=yes. If either of you is very stylish, 8 or more, the result is 2 (yes). With the exception that if either of you has style of 2 or less, the result is 0 (no). Otherwise the result is 1 (maybe).",
                "public static int dateFashion(int you, int date)",
                "dateFashion",
                List.of(
                    new TestCase("5, 10", "2"),
                    new TestCase("5, 2", "0"),
                    new TestCase("5, 5", "1"),
                    new TestCase("3, 3", "1"),
                    new TestCase("10, 2", "0"),
                    new TestCase("2, 9", "0"),
                    new TestCase("9, 9", "2")
                )),
            new Problem("squirrel_play", "Logic-1", "squirrelPlay",
                "The squirrels in Palo Alto spend most of the day playing. In particular, they play if the temperature is between 60 and 90 (inclusive). Unless it is summer, then the upper limit is 100 instead of 90. Given an int temperature and a boolean isSummer, return true if the squirrels play.",
                "public static boolean squirrelPlay(int temp, boolean isSummer)",
                "squirrelPlay",
                List.of(
                    new TestCase("70, false", "true"),
                    new TestCase("95, false", "false"),
                    new TestCase("95, true", "true"),
                    new TestCase("90, false", "true"),
                    new TestCase("90, true", "true"),
                    new TestCase("50, false", "false"),
                    new TestCase("100, true", "true"),
                    new TestCase("101, true", "false")
                )),
            new Problem("caught_speeding", "Logic-1", "caughtSpeeding",
                "You are driving a little too fast, and a police officer stops you. Write code to compute the result, encoded as an int value: 0=no ticket, 1=small ticket, 2=big ticket. If speed is 60 or less, the result is 0. If speed is between 61 and 80 inclusive, the result is 1. If speed is 81 or more, the result is 2. Unless it is your birthday -- on that day, your speed can be 5 higher in all cases.",
                "public static int caughtSpeeding(int speed, boolean isBirthday)",
                "caughtSpeeding",
                List.of(
                    new TestCase("60, false", "0"),
                    new TestCase("65, false", "1"),
                    new TestCase("65, true", "0"),
                    new TestCase("80, false", "1"),
                    new TestCase("85, false", "2"),
                    new TestCase("85, true", "1"),
                    new TestCase("70, false", "1"),
                    new TestCase("75, true", "1"),
                    new TestCase("86, true", "2")
                )),
            new Problem("sorta_sum", "Logic-1", "sortaSum",
                "Given 2 ints, a and b, return their sum. However, sums in the range 10..19 inclusive, are forbidden, so in that case just return 20.",
                "public static int sortaSum(int a, int b)",
                "sortaSum",
                List.of(
                    new TestCase("3, 4", "7"),
                    new TestCase("9, 4", "20"),
                    new TestCase("10, 11", "21"),
                    new TestCase("12, -3", "9"),
                    new TestCase("2, 13", "20"),
                    new TestCase("1, 9", "20")
                )),
            new Problem("alarm_clock", "Logic-1", "alarmClock",
                "Given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating if we are on vacation, return a string of the form \"7:00\" indicating when the alarm clock should ring. Weekdays, the alarm should be \"7:00\" and on the weekend it should be \"10:00\". Unless we are on vacation -- then on weekdays it should be \"10:00\" and weekends it should be \"off\".",
                "public static String alarmClock(int day, boolean vacation)",
                "alarmClock",
                List.of(
                    new TestCase("1, false", "7:00"),
                    new TestCase("5, false", "7:00"),
                    new TestCase("0, false", "10:00"),
                    new TestCase("6, false", "10:00"),
                    new TestCase("0, true", "off"),
                    new TestCase("6, true", "off"),
                    new TestCase("1, true", "10:00"),
                    new TestCase("5, true", "10:00")
                )),
            new Problem("love6", "Logic-1", "love6",
                "The number 6 is a truly great number. Given two int values, a and b, return true if either one is 6. Or if their sum or difference is 6.",
                "public static boolean love6(int a, int b)",
                "love6",
                List.of(
                    new TestCase("6, 4", "true"),
                    new TestCase("4, 5", "false"),
                    new TestCase("1, 5", "true"),
                    new TestCase("1, 6", "true"),
                    new TestCase("1, 8", "false"),
                    new TestCase("1, 7", "true"),
                    new TestCase("7, 5", "false"),
                    new TestCase("8, 2", "true")
                )),
            new Problem("in1to10", "Logic-1", "in1To10",
                "Given a number n, return true if n is in the range 1..10, inclusive. Unless outsideMode is true, in which case return true if the number is less or equal to 1, or greater or equal to 10.",
                "public static boolean in1To10(int n, boolean outsideMode)",
                "in1To10",
                List.of(
                    new TestCase("5, false", "true"),
                    new TestCase("11, false", "false"),
                    new TestCase("11, true", "true"),
                    new TestCase("10, false", "true"),
                    new TestCase("10, true", "true"),
                    new TestCase("9, true", "false"),
                    new TestCase("1, false", "true"),
                    new TestCase("0, true", "true"),
                    new TestCase("0, false", "false")
                ))
        ));

        // ==================== LOGIC-2 ====================
        PROBLEMS.put("Logic-2", List.of(
            new Problem("make_bricks", "Logic-2", "makeBricks",
                "We want to make a row of bricks that is goal inches long. We have a number of small bricks (1 inch each) and big bricks (5 inches each). Return true if it is possible to make the goal by choosing from the given bricks. This is a little harder than it looks and can be done without any loops.",
                "public static boolean makeBricks(int small, int big, int goal)",
                "makeBricks",
                List.of(
                    new TestCase("3, 1, 8", "true"),
                    new TestCase("3, 1, 9", "false"),
                    new TestCase("3, 2, 10", "true"),
                    new TestCase("3, 2, 8", "true"),
                    new TestCase("3, 2, 9", "false"),
                    new TestCase("6, 1, 11", "true"),
                    new TestCase("6, 0, 11", "false"),
                    new TestCase("1, 4, 11", "true"),
                    new TestCase("0, 3, 10", "true"),
                    new TestCase("1, 4, 12", "false")
                )),
            new Problem("lone_sum", "Logic-2", "loneSum",
                "Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values, it does not count towards the sum.",
                "public static int loneSum(int a, int b, int c)",
                "loneSum",
                List.of(
                    new TestCase("1, 2, 3", "6"),
                    new TestCase("3, 2, 3", "2"),
                    new TestCase("3, 3, 3", "0"),
                    new TestCase("9, 2, 2", "9"),
                    new TestCase("2, 2, 9", "9"),
                    new TestCase("2, 9, 2", "9"),
                    new TestCase("1, 3, 1", "3")
                )),
            new Problem("lucky_sum", "Logic-2", "luckySum",
                "Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it does not count towards the sum and values to its right do not count. So for example, if b is 13, then both b and c do not count.",
                "public static int luckySum(int a, int b, int c)",
                "luckySum",
                List.of(
                    new TestCase("1, 2, 3", "6"),
                    new TestCase("1, 2, 13", "3"),
                    new TestCase("1, 13, 3", "1"),
                    new TestCase("13, 2, 3", "0"),
                    new TestCase("13, 13, 13", "0")
                )),
            new Problem("no_teen_sum", "Logic-2", "noTeenSum",
                "Given 3 int values, a b c, return their sum. However, if any of the values is a teen -- in the range 13..19 inclusive -- then that value counts as 0, except 15 and 16 do not count as a teen.",
                "public static int noTeenSum(int a, int b, int c)",
                "noTeenSum",
                List.of(
                    new TestCase("1, 2, 3", "6"),
                    new TestCase("2, 13, 1", "3"),
                    new TestCase("2, 1, 14", "3"),
                    new TestCase("2, 1, 15", "18"),
                    new TestCase("2, 1, 16", "19"),
                    new TestCase("2, 1, 17", "3"),
                    new TestCase("17, 18, 19", "0"),
                    new TestCase("15, 16, 1", "32")
                )),
            new Problem("round_sum", "Logic-2", "roundSum",
                "For this problem, we'll round an int value up to the next multiple of 10 if its rightmost digit is 5 or more, so 15 rounds up to 20. Alternately, round down to the previous multiple of 10 if its rightmost digit is less than 5, so 12 rounds down to 10. Given 3 ints, return the sum of the rounded values.",
                "public static int roundSum(int a, int b, int c)",
                "roundSum",
                List.of(
                    new TestCase("16, 17, 18", "60"),
                    new TestCase("12, 13, 14", "30"),
                    new TestCase("6, 4, 4", "10"),
                    new TestCase("4, 6, 5", "20"),
                    new TestCase("11, 12, 14", "30"),
                    new TestCase("25, 24, 25", "80")
                )),
            new Problem("close_far", "Logic-2", "closeFar",
                "Given three ints, a b c, return true if one of b or c is \"close\" (differing from a by at most 1), while the other is \"far\", differing from both other values by 2 or more.",
                "public static boolean closeFar(int a, int b, int c)",
                "closeFar",
                List.of(
                    new TestCase("1, 2, 10", "true"),
                    new TestCase("1, 2, 3", "false"),
                    new TestCase("4, 1, 3", "true"),
                    new TestCase("4, 5, 3", "false"),
                    new TestCase("4, 3, 5", "false"),
                    new TestCase("-1, 10, 0", "true"),
                    new TestCase("0, -1, 10", "true")
                ))
        ));

        // ==================== RECURSION-1 ====================
        PROBLEMS.put("Recursion-1", List.of(
            new Problem("factorial", "Recursion-1", "factorial",
                "Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).",
                "public static int factorial(int n)",
                "factorial",
                List.of(
                    new TestCase("1", "1"),
                    new TestCase("2", "2"),
                    new TestCase("3", "6"),
                    new TestCase("4", "24"),
                    new TestCase("5", "120"),
                    new TestCase("8", "40320")
                )),
            new Problem("bunny_ears", "Recursion-1", "bunnyEars",
                "We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).",
                "public static int bunnyEars(int bunnies)",
                "bunnyEars",
                List.of(
                    new TestCase("0", "0"),
                    new TestCase("1", "2"),
                    new TestCase("2", "4"),
                    new TestCase("3", "6"),
                    new TestCase("10", "20")
                )),
            new Problem("fibonacci", "Recursion-1", "fibonacci",
                "The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition. The first two values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value is the sum of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.",
                "public static int fibonacci(int n)",
                "fibonacci",
                List.of(
                    new TestCase("0", "0"),
                    new TestCase("1", "1"),
                    new TestCase("2", "1"),
                    new TestCase("3", "2"),
                    new TestCase("4", "3"),
                    new TestCase("5", "5"),
                    new TestCase("6", "8")
                )),
            new Problem("bunny_ears2", "Recursion-1", "bunnyEars2",
                "We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of \"ears\" in the bunny line 1, 2, ... n (without loops or multiplication).",
                "public static int bunnyEars2(int bunnies)",
                "bunnyEars2",
                List.of(
                    new TestCase("0", "0"),
                    new TestCase("1", "2"),
                    new TestCase("2", "5"),
                    new TestCase("3", "7"),
                    new TestCase("4", "10"),
                    new TestCase("5", "12"),
                    new TestCase("10", "25")
                )),
            new Problem("triangle", "Recursion-1", "triangle",
                "We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.",
                "public static int triangle(int rows)",
                "triangle",
                List.of(
                    new TestCase("0", "0"),
                    new TestCase("1", "1"),
                    new TestCase("2", "3"),
                    new TestCase("3", "6"),
                    new TestCase("4", "10"),
                    new TestCase("5", "15")
                )),
            new Problem("sum_digits", "Recursion-1", "sumDigits",
                "Given a non-negative int n, return the sum of its digits recursively (no loops).",
                "public static int sumDigits(int n)",
                "sumDigits",
                List.of(
                    new TestCase("126", "9"),
                    new TestCase("49", "13"),
                    new TestCase("12", "3"),
                    new TestCase("10", "1"),
                    new TestCase("1", "1"),
                    new TestCase("0", "0"),
                    new TestCase("730", "10")
                )),
            new Problem("count7", "Recursion-1", "count7",
                "Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops).",
                "public static int count7(int n)",
                "count7",
                List.of(
                    new TestCase("717", "2"),
                    new TestCase("7", "1"),
                    new TestCase("123", "0"),
                    new TestCase("77", "2"),
                    new TestCase("7123", "1"),
                    new TestCase("771237", "3"),
                    new TestCase("0", "0")
                )),
            new Problem("count8", "Recursion-1", "count8",
                "Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit, except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4.",
                "public static int count8(int n)",
                "count8",
                List.of(
                    new TestCase("8", "1"),
                    new TestCase("818", "2"),
                    new TestCase("8818", "4"),
                    new TestCase("8088", "4"),
                    new TestCase("123", "0"),
                    new TestCase("81238", "2"),
                    new TestCase("88788", "6")
                )),
            new Problem("power_n", "Recursion-1", "powerN",
                "Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).",
                "public static int powerN(int base, int n)",
                "powerN",
                List.of(
                    new TestCase("3, 1", "3"),
                    new TestCase("3, 2", "9"),
                    new TestCase("3, 3", "27"),
                    new TestCase("2, 1", "2"),
                    new TestCase("2, 2", "4"),
                    new TestCase("2, 3", "8"),
                    new TestCase("2, 4", "16"),
                    new TestCase("10, 2", "100")
                )),
            new Problem("count_x", "Recursion-1", "countX",
                "Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.",
                "public static int countX(String str)",
                "countX",
                List.of(
                    new TestCase("\"xxhixx\"", "4"),
                    new TestCase("\"xhixhix\"", "3"),
                    new TestCase("\"hi\"", "0"),
                    new TestCase("\"x\"", "1"),
                    new TestCase("\"\"", "0"),
                    new TestCase("\"hihi\"", "0")
                )),
            new Problem("count_hi_rec", "Recursion-1", "countHi",
                "Given a string, compute recursively (no loops) the number of times lowercase \"hi\" appears in the string.",
                "public static int countHi(String str)",
                "countHi",
                List.of(
                    new TestCase("\"xxhixx\"", "1"),
                    new TestCase("\"xhixhix\"", "2"),
                    new TestCase("\"hi\"", "1"),
                    new TestCase("\"hihih\"", "2"),
                    new TestCase("\"\"", "0"),
                    new TestCase("\"h\"", "0")
                )),
            new Problem("change_xy", "Recursion-1", "changeXY",
                "Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.",
                "public static String changeXY(String str)",
                "changeXY",
                List.of(
                    new TestCase("\"codex\"", "codey"),
                    new TestCase("\"xxhixx\"", "yyhiyy"),
                    new TestCase("\"xhixhix\"", "yhiyhiy"),
                    new TestCase("\"\"", ""),
                    new TestCase("\"hi\"", "hi"),
                    new TestCase("\"x\"", "y")
                )),
            new Problem("change_pi", "Recursion-1", "changePi",
                "Given a string, compute recursively (no loops) a new string where all appearances of \"pi\" have been replaced by \"3.14\".",
                "public static String changePi(String str)",
                "changePi",
                List.of(
                    new TestCase("\"xpix\"", "x3.14x"),
                    new TestCase("\"pipi\"", "3.143.14"),
                    new TestCase("\"pip\"", "3.14p"),
                    new TestCase("\"pi\"", "3.14"),
                    new TestCase("\"hip\"", "hip"),
                    new TestCase("\"p\"", "p"),
                    new TestCase("\"x\"", "x"),
                    new TestCase("\"\"", "")
                )),
            new Problem("no_x", "Recursion-1", "noX",
                "Given a string, compute recursively a new string where all the 'x' chars have been removed.",
                "public static String noX(String str)",
                "noX",
                List.of(
                    new TestCase("\"xaxb\"", "ab"),
                    new TestCase("\"abc\"", "abc"),
                    new TestCase("\"xx\"", ""),
                    new TestCase("\"\"", ""),
                    new TestCase("\"axxbxx\"", "ab"),
                    new TestCase("\"xhixhix\"", "hihi")
                )),
            new Problem("all_star", "Recursion-1", "allStar",
                "Given a string, compute recursively a new string where all the adjacent chars are now separated by a \"*\".",
                "public static String allStar(String str)",
                "allStar",
                List.of(
                    new TestCase("\"hello\"", "h*e*l*l*o"),
                    new TestCase("\"abc\"", "a*b*c"),
                    new TestCase("\"ab\"", "a*b"),
                    new TestCase("\"a\"", "a"),
                    new TestCase("\"\"", "")
                ))
        ));

        // ==================== RECURSION-2 ====================
        PROBLEMS.put("Recursion-2", List.of(
            new Problem("group_sum", "Recursion-2", "groupSum",
                "Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target? This is a classic backtracking recursion problem. Once you understand the recursive backtracking strategy in this problem, you can use the same pattern for many problems to search a space of choices.",
                "public static boolean groupSum(int start, int[] nums, int target)",
                "groupSum",
                List.of(
                    new TestCase("0, {2, 4, 8}, 10", "true"),
                    new TestCase("0, {2, 4, 8}, 14", "true"),
                    new TestCase("0, {2, 4, 8}, 9", "false"),
                    new TestCase("0, {2, 4, 8}, 8", "true"),
                    new TestCase("0, {1}, 1", "true"),
                    new TestCase("0, {9}, 1", "false"),
                    new TestCase("0, {}, 0", "true")
                )),
            new Problem("group_sum6", "Recursion-2", "groupSum6",
                "Given an array of ints, is it possible to choose a group of some of the ints, beginning at the start index, such that the group sums to the given target? However, with the additional constraint that all 6's must be chosen.",
                "public static boolean groupSum6(int start, int[] nums, int target)",
                "groupSum6",
                List.of(
                    new TestCase("0, {5, 6, 2}, 8", "true"),
                    new TestCase("0, {5, 6, 2}, 9", "false"),
                    new TestCase("0, {5, 6, 2}, 7", "false"),
                    new TestCase("0, {1}, 1", "true"),
                    new TestCase("0, {9}, 1", "false"),
                    new TestCase("0, {6, 1}, 7", "true")
                )),
            new Problem("group_no_adj", "Recursion-2", "groupNoAdj",
                "Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with this additional constraint: If a value in the array is chosen to be in the group, the value immediately following it in the array must not be chosen. (No loops needed.)",
                "public static boolean groupNoAdj(int start, int[] nums, int target)",
                "groupNoAdj",
                List.of(
                    new TestCase("0, {2, 5, 10, 4}, 12", "true"),
                    new TestCase("0, {2, 5, 10, 4}, 14", "false"),
                    new TestCase("0, {2, 5, 10, 4}, 7", "false"),
                    new TestCase("0, {2, 5, 10, 4}, 4", "true"),
                    new TestCase("0, {2, 5, 10, 4, 2}, 4", "true")
                )),
            new Problem("split_array", "Recursion-2", "splitArray",
                "Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same. Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like, and make the initial call to your recursive helper from splitArray(). (No loops needed.)",
                "public static boolean splitArray(int[] nums)",
                "splitArray",
                List.of(
                    new TestCase("{2, 2}", "true"),
                    new TestCase("{2, 3}", "false"),
                    new TestCase("{5, 2, 3}", "true"),
                    new TestCase("{5, 2, 2}", "false"),
                    new TestCase("{1, 1, 1, 1, 1, 1}", "true"),
                    new TestCase("{}", "true")
                ))
        ));
    }

    public static Map<String, List<Problem>> getAllByCategory() {
        return PROBLEMS;
    }

    public static List<String> getCategories() {
        return List.copyOf(PROBLEMS.keySet());
    }

    public static List<Problem> getProblems(String category) {
        return PROBLEMS.getOrDefault(category, List.of());
    }
}
