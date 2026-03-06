package com.codingbat.ui;

import org.fxmisc.richtext.InlineCssTextArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntaxHighlighter {

    private static final String[] KEYWORDS = {
        "abstract", "assert", "boolean", "break", "byte", "case", "catch",
        "char", "class", "const", "continue", "default", "do", "double",
        "else", "enum", "extends", "final", "finally", "float", "for",
        "goto", "if", "implements", "import", "instanceof", "int",
        "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static", "strictfp",
        "super", "switch", "synchronized", "this", "throw", "throws",
        "transient", "try", "var", "void", "volatile", "while"
    };

    private static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
    private static final String PAREN_PATTERN = "[()]";
    private static final String BRACE_PATTERN = "[{}]";
    private static final String BRACKET_PATTERN = "[\\[\\]]";
    private static final String SEMICOLON_PATTERN = ";";
    private static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    private static final String CHAR_PATTERN = "'([^'\\\\]|\\\\.)'";
    private static final String COMMENT_PATTERN = "//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/";
    private static final String NUMBER_PATTERN = "\\b\\d+(\\.\\d+)?[dDfFlL]?\\b";
    private static final String BOOLEAN_PATTERN = "\\b(true|false|null)\\b";
    private static final String ANNOTATION_PATTERN = "@\\w+";

    private static final Pattern PATTERN = Pattern.compile(
        "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
        + "|(?<PAREN>" + PAREN_PATTERN + ")"
        + "|(?<BRACE>" + BRACE_PATTERN + ")"
        + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
        + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
        + "|(?<STRING>" + STRING_PATTERN + ")"
        + "|(?<CHAR>" + CHAR_PATTERN + ")"
        + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
        + "|(?<NUMBER>" + NUMBER_PATTERN + ")"
        + "|(?<BOOLEAN>" + BOOLEAN_PATTERN + ")"
        + "|(?<ANNOTATION>" + ANNOTATION_PATTERN + ")"
    );

    // MDB-inspired syntax colors
    private static final String KEYWORD_STYLE    = "-fx-fill: #ff9900; -fx-font-weight: bold;";
    private static final String PAREN_STYLE      = "-fx-fill: #f87171;";
    private static final String BRACE_STYLE      = "-fx-fill: #f87171;";
    private static final String BRACKET_STYLE    = "-fx-fill: #60a5fa;";
    private static final String SEMICOLON_STYLE  = "-fx-fill: #555555;";
    private static final String STRING_STYLE     = "-fx-fill: #4ade80;";
    private static final String COMMENT_STYLE    = "-fx-fill: #555555; -fx-font-style: italic;";
    private static final String NUMBER_STYLE     = "-fx-fill: #c084fc;";
    private static final String BOOLEAN_STYLE    = "-fx-fill: #c084fc; -fx-font-weight: bold;";
    private static final String ANNOTATION_STYLE = "-fx-fill: #e68a00;";
    private static final String DEFAULT_STYLE    = "-fx-fill: #e5e7eb;";

    public static InlineCssTextArea createCodeArea(String initialText) {
        InlineCssTextArea codeArea = new InlineCssTextArea();
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        codeArea.getStyleClass().add("code-area");

        codeArea.textProperty().addListener((obs, oldText, newText) -> {
            applyHighlighting(codeArea);
        });

        codeArea.replaceText(initialText);
        return codeArea;
    }

    private static void applyHighlighting(InlineCssTextArea codeArea) {
        String text = codeArea.getText();
        StyleSpans<String> spans = computeHighlighting(text);
        codeArea.setStyleSpans(0, spans);
    }

    private static StyleSpans<String> computeHighlighting(String text) {
        Matcher matcher = PATTERN.matcher(text);
        int lastEnd = 0;
        StyleSpansBuilder<String> builder = new StyleSpansBuilder<>();

        while (matcher.find()) {
            String style =
                matcher.group("KEYWORD") != null    ? KEYWORD_STYLE :
                matcher.group("PAREN") != null       ? PAREN_STYLE :
                matcher.group("BRACE") != null       ? BRACE_STYLE :
                matcher.group("BRACKET") != null     ? BRACKET_STYLE :
                matcher.group("SEMICOLON") != null   ? SEMICOLON_STYLE :
                matcher.group("STRING") != null      ? STRING_STYLE :
                matcher.group("CHAR") != null        ? STRING_STYLE :
                matcher.group("COMMENT") != null     ? COMMENT_STYLE :
                matcher.group("NUMBER") != null      ? NUMBER_STYLE :
                matcher.group("BOOLEAN") != null     ? BOOLEAN_STYLE :
                matcher.group("ANNOTATION") != null  ? ANNOTATION_STYLE :
                DEFAULT_STYLE;

            builder.add(DEFAULT_STYLE, matcher.start() - lastEnd);
            builder.add(style, matcher.end() - matcher.start());
            lastEnd = matcher.end();
        }
        builder.add(DEFAULT_STYLE, text.length() - lastEnd);
        return builder.create();
    }
}
