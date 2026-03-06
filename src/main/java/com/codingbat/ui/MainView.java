package com.codingbat.ui;

import com.codingbat.engine.CodeRunner;
import com.codingbat.model.Problem;
import com.codingbat.problems.ProblemBank;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.fxmisc.richtext.InlineCssTextArea;

import java.util.List;

public class MainView {

    private final BorderPane root = new BorderPane();
    private final VBox sidebar = new VBox();
    private final VBox contentArea = new VBox();
    private final CodeRunner codeRunner = new CodeRunner();

    public MainView() {
        buildSidebar();
        buildContent();

        root.setLeft(sidebar);
        root.setCenter(contentArea);
        root.getStyleClass().add("root-pane");
    }

    private void buildSidebar() {
        sidebar.getStyleClass().add("sidebar");
        sidebar.setPrefWidth(220);
        sidebar.setSpacing(4);
        sidebar.setPadding(new Insets(16));

        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/com/codingbat/logo.png")));
        logo.setFitWidth(80);
        logo.setPreserveRatio(true);
        sidebar.getChildren().add(logo);

        Label title = new Label("CodingBat");
        title.getStyleClass().add("sidebar-title");
        sidebar.getChildren().add(title);

        Label subtitle = new Label("Offline Edition");
        subtitle.getStyleClass().add("sidebar-subtitle");
        VBox.setMargin(subtitle, new Insets(0, 0, 20, 0));
        sidebar.getChildren().add(subtitle);

        ScrollPane sidebarScroll = new ScrollPane();
        VBox sidebarContent = new VBox(4);
        sidebarScroll.setContent(sidebarContent);
        sidebarScroll.setFitToWidth(true);
        sidebarScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sidebarScroll.getStyleClass().add("sidebar-scroll");
        VBox.setVgrow(sidebarScroll, Priority.ALWAYS);

        for (String category : ProblemBank.getCategories()) {
            TitledPane categoryPane = new TitledPane();
            categoryPane.setText(category);
            categoryPane.getStyleClass().add("category-pane");
            categoryPane.setExpanded(false);

            VBox problemList = new VBox(2);
            for (Problem p : ProblemBank.getProblems(category)) {
                Button btn = new Button(p.name());
                btn.getStyleClass().add("problem-btn");
                btn.setMaxWidth(Double.MAX_VALUE);
                btn.setOnAction(e -> showProblem(p));
                problemList.getChildren().add(btn);
            }
            categoryPane.setContent(problemList);
            sidebarContent.getChildren().add(categoryPane);
        }

        // Documentation section
        Label docsHeader = new Label("Java Docs");
        docsHeader.getStyleClass().add("sidebar-title");
        docsHeader.setStyle("-fx-font-size: 16px; -fx-padding: 16 0 8 0;");
        sidebarContent.getChildren().add(docsHeader);

        for (String topic : DocsView.getAllDocs().keySet()) {
            Button btn = new Button(topic);
            btn.getStyleClass().add("problem-btn");
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setOnAction(e -> showDocs(topic));
            sidebarContent.getChildren().add(btn);
        }

        sidebar.getChildren().add(sidebarScroll);
    }

    private void buildContent() {
        contentArea.getStyleClass().add("content-area");
        contentArea.setPadding(new Insets(32));
        contentArea.setSpacing(16);
        contentArea.setAlignment(Pos.TOP_CENTER);

        Label welcome = new Label("Welcome to CodingBat Offline");
        welcome.getStyleClass().add("welcome-title");

        Label hint = new Label("Select a problem from the sidebar to get started.");
        hint.getStyleClass().add("welcome-hint");

        contentArea.getChildren().addAll(welcome, hint);
    }

    private void showProblem(Problem problem) {
        contentArea.getChildren().clear();

        // Header
        Label nameLabel = new Label(problem.name());
        nameLabel.getStyleClass().add("problem-title");

        Label categoryLabel = new Label(problem.category());
        categoryLabel.getStyleClass().add("problem-category");

        HBox header = new HBox(12, nameLabel, categoryLabel);
        header.setAlignment(Pos.CENTER_LEFT);

        // Description
        Text descText = new Text(problem.description());
        descText.getStyleClass().add("problem-desc");
        TextFlow descFlow = new TextFlow(descText);
        descFlow.getStyleClass().add("problem-desc-flow");

        // Method signature
        Label sigLabel = new Label(problem.methodSignature());
        sigLabel.getStyleClass().add("method-signature");

        // Code editor
        String displaySig = problem.methodSignature().replace("public static ", "public ");
        InlineCssTextArea codeEditor = SyntaxHighlighter.createCodeArea(displaySig + " {\n    \n}");
        codeEditor.setPrefHeight(200);
        VBox.setVgrow(codeEditor, Priority.SOMETIMES);

        // Run button
        Button runBtn = new Button("Run Tests");
        runBtn.getStyleClass().add("run-btn");

        // Results area
        VBox resultsBox = new VBox(6);
        resultsBox.getStyleClass().add("results-box");

        ScrollPane resultsScroll = new ScrollPane(resultsBox);
        resultsScroll.getStyleClass().add("results-scroll");
        resultsScroll.setFitToWidth(true);
        resultsScroll.setPrefHeight(200);
        VBox.setVgrow(resultsScroll, Priority.SOMETIMES);

        runBtn.setOnAction(e -> {
            resultsBox.getChildren().clear();
            List<CodeRunner.Result> results = codeRunner.run(problem, codeEditor.getText());
            int passed = 0;
            for (CodeRunner.Result r : results) {
                HBox row = new HBox(12);
                row.setAlignment(Pos.CENTER_LEFT);
                row.getStyleClass().add("result-row");
                row.getStyleClass().add(r.passed() ? "result-pass" : "result-fail");

                Label icon = new Label(r.passed() ? "PASS" : "FAIL");
                icon.getStyleClass().add(r.passed() ? "pass-label" : "fail-label");
                icon.setMinWidth(50);

                Label inputLabel = new Label(r.input().isEmpty() ? "" : problem.methodName() + "(" + r.input() + ")");
                inputLabel.getStyleClass().add("result-input");

                Label arrow = new Label(r.input().isEmpty() ? "" : "->");
                arrow.getStyleClass().add("result-arrow");

                Label actualLabel = new Label(r.actual());
                actualLabel.getStyleClass().add("result-actual");

                if (!r.passed() && !r.expected().isEmpty()) {
                    Label expectedLabel = new Label("expected: " + r.expected());
                    expectedLabel.getStyleClass().add("result-expected");
                    row.getChildren().addAll(icon, inputLabel, arrow, actualLabel, expectedLabel);
                } else {
                    row.getChildren().addAll(icon, inputLabel, arrow, actualLabel);
                }
                resultsBox.getChildren().add(row);
                if (r.passed()) passed++;
            }

            Label summary = new Label(passed + "/" + results.size() + " tests passed");
            summary.getStyleClass().add(passed == results.size() ? "summary-pass" : "summary-fail");
            resultsBox.getChildren().addFirst(summary);
        });

        contentArea.getChildren().addAll(header, descFlow, sigLabel, codeEditor, runBtn, resultsScroll);
    }

    private void showDocs(String topic) {
        contentArea.getChildren().clear();
        ScrollPane docsContent = DocsView.buildDocsContent(topic);
        VBox.setVgrow(docsContent, Priority.ALWAYS);
        contentArea.getChildren().add(docsContent);
    }

    public Parent getRoot() {
        return root;
    }
}
