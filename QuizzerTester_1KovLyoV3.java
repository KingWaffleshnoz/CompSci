import java.util.Scanner;
//import scanner

/**
 * Zachary Koverman, Jared Lyon
 * Loops-A6: Quizzer (Nov-Pair)
 * Hosts a 10 question quiz including 7 multiple choice and 3 short answer questions w/ username and scoring results
 */
public class QuizzerTester_1KovLyoV3 {
    public static void main(String[] args) {
        //main init
        Scanner inputName = new Scanner(System.in);
        String username = "";
        System.out.println("Welcome to the KovLyo Inc. National Intelligence Test!\nEnter name:");

        //get username and start quiz
        username = inputName.next();
        Quiz quiz = new Quiz(username);

        //quiz execution
        quiz.askQuestions();
        System.out.println(quiz.getScore());
    }
}

class Quiz {
    //variables + scanner
    private int score = 0;
    private boolean disgust = false;
    private String name;
    private String quip;
    Scanner input = new Scanner(System.in);

    //constructor
    public Quiz(String name) {
        this.name = name;
    }

    //mutator - questions
    public void askQuestions() {
        System.out.println("------\nWelcome, " + name + "! Beginning quiz now...");
        
        //Question 1
        System.out.println("Question 1: What is the capital city of Norway?");
        System.out.println("   A. Ulaanbataar\n   B. Oslo");
        System.out.println("   C. Guatemala City\n   D. Helsinki");
        boolean a1 = false;
        while (a1 == false) {
            String ans = input.next();
            if (ans.equals("B")) {
               score++;
               a1 = true;
            }
            else if (ans.equals("A") || ans.equals("C") || ans.equals("D")) {
               a1 = true;
            }
            else {
               System.out.println("Please enter either 'A', 'B', 'C', or 'D'");
               a1 = false;
            } 
        }
        
        //Question 2
        System.out.println("Question 2: Which is NOT one of the 4 chicken McNugget shapes?");
        System.out.println("   A. Boot\n   B. Ball");
        System.out.println("   C. Bone\n   D. Bell");
        boolean a2 = false;
        while (a2 == false) {
            String ans = input.next();
            if (ans.equals("C")) {
               score++;
               a2 = true;
            }
            else if (ans.equals("A") || ans.equals("B") || ans.equals("D")) {
               a2 = true;
            }
            else {
               System.out.println("Please enter either 'A', 'B', 'C', or 'D'");
               a2 = false;
            } 
        }
        
        //Question 3
        System.out.println("Question 3: How many people died of the Black Death?");
        System.out.println("   A. 200-250 million\n   B. 350-375 million");
        System.out.println("   C. 130-150 million\n   D. 75-80 million");
        boolean a3 = false;
        while (a3 == false) {
            String ans = input.next();
            if (ans.equals("B")) {
               score++;
               a3 = true;
            }
            else if (ans.equals("A") || ans.equals("C") || ans.equals("D")) {
               a3 = true;
            }
            else {
               System.out.println("Please enter either 'A', 'B', 'C', or 'D'");
               a3 = false;
            } 
        }

        //Question 4
        System.out.println("Question 4: How tall is Shrek?");
        System.out.println("   A. 9-10 feet\n   B. 5-6 feet");
        System.out.println("   C. 8-9 feet\n   D. 7-8 feet");
        boolean a4 = false;
        while (a4 == false) {
            String ans = input.next();
            if (ans.equals("D")) {
               score++;
               a4 = true;
            }
            else if (ans.equals("A") || ans.equals("C") || ans.equals("B")) {
               a4 = true;
            }
            else {
               System.out.println("Please enter either 'A', 'B', 'C', or 'D'");
               a4 = false;
            } 
        }

        //Question 5
        System.out.println("Question 5: What car did Takumi drive in Initial D?");
        System.out.println("   A. Toyota AE86\n   B. Nissan Leaf");
        System.out.println("   C. Subaru Impreza\n   D. Mazda Miata");
        boolean a5 = false;
        while (a5 == false) {
            String ans = input.next();
            if (ans.equals("A")) {
               score++;
               a5 = true;
            }
            else if (ans.equals("D") || ans.equals("C") || ans.equals("B")) {
               a5 = true;
            }
            else {
               System.out.println("Please enter either 'A', 'B', 'C', or 'D'");
               a5 = false;
            } 
        }
        
        //Question 6
        System.out.println("Question 6: Which is NOT a minor league baseball team?");
        System.out.println("   A. Montgomery Biscuits\n   B. New Orleans Baby Cakes");
        System.out.println("   C. Albuquerque Isotopes\n   D. Savannah Peaches");
        boolean a6 = false;
        while (a6 == false) {
            String ans = input.next();
            if (ans.equals("D")) {
               score++;
               a6 = true;
            }
            else if (ans.equals("A") || ans.equals("C") || ans.equals("B")) {
               a6 = true;
            }
            else {
               System.out.println("Please enter either 'A', 'B', 'C', or 'D'");
               a6 = false;
            } 
        }
        
        //Question 7
        System.out.println("Question 7: What is Jared drinking when writing this quiz?");
        System.out.println("   A. Lemon San Pellegrino\n   B. Lemon-Lime Gatorade");
        System.out.println("   C. Peet's Iced Mocha\n   D. Strawberry-Banana Chobani");
        boolean a7 = false;
        while (a7 == false) {
            String ans = input.next();
            if (ans.equals("A")) {
               score++;
               a7 = true;
            }
            else if (ans.equals("D") || ans.equals("C") || ans.equals("B")) {
               a7 = true;
            }
            else {
               System.out.println("Please enter either 'A', 'B', 'C', or 'D'");
               a7 = false;
            } 
        }
        
        //Question 8
        System.out.println("Question 8: Is a hot dog a sandwich? [Enter 'Yes' or 'No']");
        boolean a8 = false;
        while (a8 == false) {
            String ans = input.next();
            if (ans.equals("No")) {
               score++;
               a8 = true;
            }
            else if (ans.equals("Yes")) {
               disgust = true;
               a8 = true;
            }
            else {
               System.out.println("Please enter either 'Yes' or 'No'");
               a8 = false;
            } 
        }
        
        //Question 9
        System.out.println("Question 9: When was sliced bread invented?");
        System.out.println("Answer format: MM/DD/YYYY (Ex: 03/04/2004)");
        boolean a9 = false;
        while (a9 == false) {
            String ans = input.next();
            if (ans.equals("07/06/1928")) {
               score++;
            }
            a9 = true;
        }
        
        //Question 10
        System.out.println("Question 10: What number am I thinking of in a range of 1-20?");
        boolean a10 = false;
        while (a10 == false) {
            int ans = input.nextInt();
            if (ans == 19) {
               score++;
            }
            a10 = true;
        }
    } 

    //accessor
    public String getScore() {
        //determine scoring
        if (score == 10){
            quip = "Move over, Stephen Hawking!";
        }
        else if (score >= 8){
            quip = "Great job!";
        }
        else if (score >= 5){
            quip = "Pretty good.";
        }
        else if (score >= 3){
            quip = "Could be better.";
        }
        else if (score >= 1){
            quip = "That's a pretty bad score, not gonna lie.";
        } 
        else if (score == 0){
            quip = "Ouch.";
        }

        //tack on edgecase insult
        if (disgust == true) {
            quip += "\nAnd hot dogs are NOT sandwiches, you complete and utter ignoramus!";
        }

        //return numerical score + comment
        return "Score: " + score + "/10 \n" + quip;
    }
}