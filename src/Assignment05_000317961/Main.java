package Assignment05_000317961;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.util.Objects;

/**
 *
 * 
 * @author Thomas Coons, 000317961
 */
public class Main extends Application {
    private Label title2;
    private Label question;
    private Label correct;
    private Label incorrect;
    private Label score;
    private Button add, subtract, multiply, submitAnswer, reset;
    private TextField userInput;
    private Quiz quiz;

    private void additionButtonHandler(ActionEvent e){
        subtract.setDisable(true);
        multiply.setDisable(true);
        submitAnswer.setDisable(false);
        title2.setText("Addition");
        String additionQuestion = String.format("%d + %d =",quiz.getNum1(), quiz.getNum2());
        question.setText(additionQuestion);
        score.setText("");
    }

    private void subtractionButtonHandler(ActionEvent e){
        add.setDisable(true);
        multiply.setDisable(true);
        submitAnswer.setDisable(false);
        title2.setText("Subtraction");
        String subtractionQuestion = String.format("%d - %d =",quiz.getNum1(), quiz.getNum2());
        question.setText(subtractionQuestion);
        score.setText("");
    }

    private void multiplicationButtonHandler(ActionEvent e){
        add.setDisable(true);
        subtract.setDisable(true);
        submitAnswer.setDisable(false);
        title2.setText("Multiplication");
        String multiplicationQuestion = String.format("%d x %d =",quiz.getNum1(), quiz.getNum2());
        question.setText(multiplicationQuestion);
        score.setText("");
    }

    private void helper(){
        correct.setText(String.format("Correct: %d", quiz.getCorrect()));
        incorrect.setText(String.format("Incorrect: %d", quiz.getIncorrect()));
        userInput.clear();
    }

    private void submitAnswerButtonHandler(ActionEvent e){
        int userAnswer = Integer.parseInt(userInput.getText());
        reset.setDisable(false);

        if (!add.isDisable()){
            quiz.sumSolution(userAnswer);
            helper();
            String additionQuestion = String.format("%d + %d =",quiz.getNum1(), quiz.getNum2());
            question.setText(additionQuestion);
        }
        else if (!subtract.isDisable()){
            quiz.differenceSolution(userAnswer);
            helper();
            String subtractionQuestion = String.format("%d - %d =",quiz.getNum1(), quiz.getNum2());
            question.setText(subtractionQuestion);
        }
        else if (!multiply.isDisable()){
            quiz.productSolution(userAnswer);
            helper();
            String multiplicationQuestion = String.format("%d x %d =",quiz.getNum1(), quiz.getNum2());
            question.setText(multiplicationQuestion);
        }
    }

    private void resetButtonHandler(ActionEvent e){
        add.setDisable(false);
        subtract.setDisable(false);
        multiply.setDisable(false);
        submitAnswer.setDisable(true);
        question.setText("");
        title2.setText("Choose what you want to be tested on!");
        correct.setText("Correct: 0");
        incorrect.setText("Incorrect: 0");
        double scorePercent = quiz.calculateGrade();
        String scorePercentString = String.format("%.2f",scorePercent);
        score.setText("Score: "+scorePercentString+"%");
        quiz = new Quiz();
        reset.setDisable(true);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 320); // set the size here
        stage.setTitle("Assignment 5"); // set the window title here
        stage.setScene(scene);
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #ffffff 0%, #0d1b2a 99%);");

        // 1. Create the model
        quiz = new Quiz();

        // 2. Create the GUI components
        Label title = new Label("Arithmetic Quiz");
        VBox vbox = new VBox();
        VBox vbox2 = new VBox();
        VBox vbox3 = new VBox();
        HBox hbox = new HBox();
        HBox hbox2 = new HBox();
        HBox hbox3 = new HBox();
        title2 = new Label("Choose what you want to be tested on!");
        add = new Button("Addition");
        subtract = new Button("Subtract");
        multiply = new Button("Multiply");
        question = new Label("");
        userInput = new TextField("");
        submitAnswer = new Button("Submit Answer");
        correct = new Label("Correct: 0");
        incorrect = new Label("Incorrect: 0");
        reset = new Button("View Score");
        score = new Label("");

        // 3. Add components to the root
        hbox.getChildren().addAll(add,subtract,multiply);
        hbox2.getChildren().addAll(question,userInput,submitAnswer);
        vbox2.getChildren().addAll(correct,incorrect);
        hbox3.getChildren().addAll(vbox2,reset);
        vbox3.getChildren().addAll(score);
        vbox.getChildren().addAll(title,title2, hbox, hbox2, hbox3, vbox3);
        root.getChildren().addAll(vbox);

        // 4. Configure the components (colors, fonts, size, location)
        submitAnswer.setDisable(true);
        reset.setDisable(true);
        title.prefWidthProperty().bind(scene.widthProperty());
        title2.prefWidthProperty().bind(scene.widthProperty());
        hbox.prefWidthProperty().bind(scene.widthProperty());
        hbox2.prefWidthProperty().bind(scene.widthProperty());
        vbox3.prefWidthProperty().bind(scene.widthProperty());
        vbox.prefWidthProperty().bind(scene.widthProperty());
        stage.setResizable(false);
        submitAnswer.setPrefWidth(140);

        hbox.getStyleClass().add("hbox");
        hbox2.getStyleClass().add("hbox2");
        vbox.getStyleClass().add("vbox");
        vbox2.getStyleClass().add("vbox2");
        title.getStyleClass().add("title");
        title2.getStyleClass().add("title2");
        add.getStyleClass().add("buttons");
        subtract.getStyleClass().add("buttons");
        multiply.getStyleClass().add("buttons");
        question.getStyleClass().add("question");
        userInput.getStyleClass().add("input");
        submitAnswer.getStyleClass().add("submitAnswer");
        correct.getStyleClass().add("correct");
        incorrect.getStyleClass().add("correct");
        hbox3.getStyleClass().add("hbox3");
        reset.getStyleClass().add("reset");
        score.getStyleClass().add("score");
        vbox3.getStyleClass().add("vbox3");
        root.getStyleClass().add("root");
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/Assignment05_000317961/styles.css")).toExternalForm());

        // 5. Add Event Handlers and do final setup
        add.setOnAction(this::additionButtonHandler);
        subtract.setOnAction(this::subtractionButtonHandler);
        multiply.setOnAction(this::multiplicationButtonHandler);
        submitAnswer.setOnAction(this::submitAnswerButtonHandler);
        reset.setOnAction(this::resetButtonHandler);

        // 6. Show the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
