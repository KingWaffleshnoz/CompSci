import java.lang.Math;
import java.util.Scanner;

public class QuizzerTester_1KovLyo {
    public static void main(String[] args) {
        Scanner inputName = new Scanner(System.in);
        String username = "";
        System.out.println("Welcome to the KovLyo Inc. National Intelligence Test!\nEnter name:");
        username = inputName.next();
        Quiz quiz = new Quiz(username);
        quiz.askQuestions();
    }
}

class Quiz {
    private int score = 0;
    private String name;
    Scanner input = new Scanner(System.in);

    //constructor
    public Quiz(String name) {
        this.name = name;
    }

    //mutator - questions
    public void askQuestions() {
        System.out.println("------\nWelcome, " + name + "! Beginning quiz now...");
    }

    //accessor
    public String getScore() {
        return name + "'s current score: " + score;
    }
}