package com.codingbat.engine;

import com.codingbat.model.Problem;
import com.codingbat.model.TestCase;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeRunner {

    public record Result(String input, String expected, String actual, boolean passed) {}

    public List<Result> run(Problem problem, String userCode) {
        String className = "Solution";
        // Ensure the method is static so we can invoke without an instance
        String code = userCode;
        if (!code.contains("static")) {
            code = code.replaceFirst("public\\s+", "public static ");
        }
        String fullSource = "public class " + className + " {\n" + code + "\n}";

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            return List.of(new Result("", "", "Compiler not available. Make sure you're running with a JDK, not a JRE.", false));
        }

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        InMemoryFileManager fileManager = new InMemoryFileManager(
            compiler.getStandardFileManager(diagnostics, null, null)
        );

        JavaFileObject source = new InMemorySource(className, fullSource);
        JavaCompiler.CompilationTask task = compiler.getTask(
            null, fileManager, diagnostics, null, null, List.of(source)
        );

        if (!task.call()) {
            StringBuilder errors = new StringBuilder();
            for (Diagnostic<? extends JavaFileObject> d : diagnostics.getDiagnostics()) {
                long line = d.getLineNumber() - 1; // offset for wrapper class line
                errors.append("Line ").append(line).append(": ").append(d.getMessage(null)).append("\n");
            }
            return List.of(new Result("", "", errors.toString().trim(), false));
        }

        try {
            ClassLoader loader = fileManager.getClassLoader(null);
            Class<?> clazz = loader.loadClass(className);
            Method method = findMethod(clazz, problem.methodName());

            List<Result> results = new ArrayList<>();
            for (TestCase tc : problem.testCases()) {
                try {
                    Object[] args = parseArgs(method, tc.input());
                    Object result = method.invoke(null, args);
                    String actual = formatResult(result);
                    results.add(new Result(tc.input(), tc.expected(), actual, actual.equals(tc.expected())));
                } catch (Exception e) {
                    String msg = e.getCause() != null ? e.getCause().getMessage() : e.getMessage();
                    results.add(new Result(tc.input(), tc.expected(), "Error: " + msg, false));
                }
            }
            return results;
        } catch (Exception e) {
            return List.of(new Result("", "", "Runtime error: " + e.getMessage(), false));
        }
    }

    private Method findMethod(Class<?> clazz, String name) {
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.getName().equals(name)) return m;
        }
        throw new RuntimeException("Method '" + name + "' not found. Make sure your method name matches exactly.");
    }

    private Object[] parseArgs(Method method, String input) {
        Class<?>[] types = method.getParameterTypes();
        if (types.length == 0) return new Object[0];
        String[] parts = splitArgs(input);
        Object[] args = new Object[types.length];

        for (int i = 0; i < types.length; i++) {
            args[i] = parseValue(types[i], parts[i].trim());
        }
        return args;
    }

    private String[] splitArgs(String input) {
        List<String> args = new ArrayList<>();
        int depth = 0;
        boolean inString = false;
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '"' && (i == 0 || input.charAt(i - 1) != '\\')) {
                inString = !inString;
                current.append(c);
            } else if (!inString && (c == '{' || c == '[')) {
                depth++;
                current.append(c);
            } else if (!inString && (c == '}' || c == ']')) {
                depth--;
                current.append(c);
            } else if (!inString && c == ',' && depth == 0) {
                args.add(current.toString());
                current = new StringBuilder();
            } else {
                current.append(c);
            }
        }
        if (!current.isEmpty()) args.add(current.toString());
        return args.toArray(new String[0]);
    }

    private Object parseValue(Class<?> type, String value) {
        value = value.trim();
        if (type == int.class || type == Integer.class) return Integer.parseInt(value);
        if (type == long.class || type == Long.class) return Long.parseLong(value);
        if (type == boolean.class || type == Boolean.class) return Boolean.parseBoolean(value);
        if (type == double.class || type == Double.class) return Double.parseDouble(value);
        if (type == char.class || type == Character.class) {
            if (value.startsWith("'") && value.endsWith("'")) return value.charAt(1);
            return value.charAt(0);
        }
        if (type == String.class) {
            if (value.startsWith("\"") && value.endsWith("\"")) return value.substring(1, value.length() - 1);
            return value;
        }
        if (type == int[].class) return parseIntArray(value);
        if (type == boolean[].class) return parseBooleanArray(value);
        if (type == String[].class) return parseStringArray(value);
        if (type == char[].class) return parseCharArray(value);
        if (type == double[].class) return parseDoubleArray(value);
        throw new RuntimeException("Unsupported parameter type: " + type.getSimpleName());
    }

    private int[] parseIntArray(String value) {
        value = value.replaceAll("[{}\\[\\]]", "").trim();
        if (value.isEmpty()) return new int[0];
        String[] parts = value.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i].trim());
        return arr;
    }

    private boolean[] parseBooleanArray(String value) {
        value = value.replaceAll("[{}\\[\\]]", "").trim();
        if (value.isEmpty()) return new boolean[0];
        String[] parts = value.split(",");
        boolean[] arr = new boolean[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Boolean.parseBoolean(parts[i].trim());
        return arr;
    }

    private double[] parseDoubleArray(String value) {
        value = value.replaceAll("[{}\\[\\]]", "").trim();
        if (value.isEmpty()) return new double[0];
        String[] parts = value.split(",");
        double[] arr = new double[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Double.parseDouble(parts[i].trim());
        return arr;
    }

    private char[] parseCharArray(String value) {
        value = value.replaceAll("[{}\\[\\]]", "").trim();
        if (value.isEmpty()) return new char[0];
        String[] parts = value.split(",");
        char[] arr = new char[parts.length];
        for (int i = 0; i < parts.length; i++) {
            String p = parts[i].trim();
            if (p.startsWith("'") && p.endsWith("'")) arr[i] = p.charAt(1);
            else arr[i] = p.charAt(0);
        }
        return arr;
    }

    private String[] parseStringArray(String value) {
        value = value.replaceAll("[{}\\[\\]]", "").trim();
        if (value.isEmpty()) return new String[0];
        String[] parts = value.split(",");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
            if (parts[i].startsWith("\"") && parts[i].endsWith("\"")) {
                parts[i] = parts[i].substring(1, parts[i].length() - 1);
            }
        }
        return parts;
    }

    private String formatResult(Object result) {
        if (result == null) return "null";
        if (result instanceof int[] arr) {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < arr.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append(arr[i]);
            }
            return sb.append("}").toString();
        }
        if (result instanceof boolean[] arr) {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < arr.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append(arr[i]);
            }
            return sb.append("}").toString();
        }
        if (result instanceof double[] arr) {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < arr.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append(arr[i]);
            }
            return sb.append("}").toString();
        }
        if (result instanceof String[] arr) {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < arr.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append("\"").append(arr[i]).append("\"");
            }
            return sb.append("}").toString();
        }
        if (result instanceof List<?> list) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(formatResult(list.get(i)));
            }
            return sb.append("]").toString();
        }
        return String.valueOf(result);
    }

    // --- In-memory compilation helpers ---

    private static class InMemorySource extends SimpleJavaFileObject {
        private final String code;
        InMemorySource(String name, String code) {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.code = code;
        }
        @Override public CharSequence getCharContent(boolean ignoreEncodingErrors) { return code; }
    }

    private static class InMemoryClassFile extends SimpleJavaFileObject {
        private final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        InMemoryClassFile(String name) {
            super(URI.create("bytes:///" + name + Kind.CLASS.extension), Kind.CLASS);
        }
        @Override public OutputStream openOutputStream() { return bytes; }
        byte[] getBytes() { return bytes.toByteArray(); }
    }

    private static class InMemoryFileManager extends ForwardingJavaFileManager<StandardJavaFileManager> {
        private final Map<String, InMemoryClassFile> classes = new HashMap<>();
        InMemoryFileManager(StandardJavaFileManager delegate) { super(delegate); }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String className,
                JavaFileObject.Kind kind, FileObject sibling) {
            InMemoryClassFile file = new InMemoryClassFile(className);
            classes.put(className, file);
            return file;
        }

        @Override
        public ClassLoader getClassLoader(Location location) {
            return new ClassLoader() {
                @Override protected Class<?> findClass(String name) throws ClassNotFoundException {
                    InMemoryClassFile file = classes.get(name);
                    if (file == null) throw new ClassNotFoundException(name);
                    byte[] b = file.getBytes();
                    return defineClass(name, b, 0, b.length);
                }
            };
        }
    }
}
