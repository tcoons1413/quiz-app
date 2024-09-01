package Assignment05_000317961;

/**
 * The Quiz Object
 */
public class Quiz {
    private int num1 = (int) (Math.random() * 50);
    private int num2 = (int) (Math.random() * 50);
    private int correct = 0;
    private int incorrect = 0;
    private int totalQuestions = 0;
    private int sum = num1 + num2;
    private int difference = num1 - num2;
    private int product = num1 * num2;


    /**
     * Get total questions
     * @return totalQuestions
     */
    public int getTotalQuestions() {
        return totalQuestions;
    }

    /**
     * Get number 1
     * @return num1
     */
    public int getNum1() {
        return num1;
    }

    /**
     * Get number 2
     * @return num2
     */
    public int getNum2() {
        return num2;
    }

    /**
     * Get correct amount of questions solved
     * @return correct
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * Get incorrect amount of questions solved
     * @return incorrect
     */
    public int getIncorrect() {
        return incorrect;
    }

    /**
     * Calculate sum solution
     * @param userNum
     */
    public void sumSolution(int userNum){
        if (userNum == sum){
            totalQuestions += 1;
            correct += 1;
            num1 = (int) (Math.random() * 50);
            num2 = (int) (Math.random() * 50);
            sum = num1 + num2;
        }
        else{
            totalQuestions += 1;
            incorrect += 1;
            num1 = (int) (Math.random() * 50);
            num2 = (int) (Math.random() * 50);
            sum = num1 + num2;
        }
    }

    /**
     * Calculate difference solution
     * @param userNum
     */
    public void differenceSolution(int userNum){
        if (userNum == difference){
            totalQuestions += 1;
            correct += 1;
            num1 = (int) (Math.random() * 50);
            num2 = (int) (Math.random() * 50);
            difference = num1 - num2;
        }
        else{
            totalQuestions += 1;
            incorrect += 1;
            num1 = (int) (Math.random() * 50);
            num2 = (int) (Math.random() * 50);
            difference = num1 - num2;
        }
    }

    /**
     * Calculate product solution
     * @param userNum
     */
    public void productSolution(int userNum){
        if (userNum == product){
            totalQuestions += 1;
            correct += 1;
            num1 = (int) (Math.random() * 50);
            num2 = (int) (Math.random() * 50);
            product = num1 * num2;
        }
        else{
            totalQuestions += 1;
            incorrect += 1;
            num1 = (int) (Math.random() * 50);
            num2 = (int) (Math.random() * 50);
            product = num1 * num2;
        }
    }

    /**
     * Calculates the grade as a percent
     * @return grade
     */
    public double calculateGrade(){
        double returnTheScore = (double) correct / totalQuestions * 100;
        return returnTheScore;
    }
}

