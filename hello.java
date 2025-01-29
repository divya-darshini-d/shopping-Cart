import java.util.Scanner;

public class hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        int score = 0;

        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        System.out.println("Hello " + name + ", welcome to the web development quiz!");
        System.out.println("You will be asked 5 questions. Enter the number corresponding to the correct answer.");

        System.out.println("\nQuestion 1: What does HTML stand for?");
        System.out.println("1. HyperText Markup Language\n2. Hyper Transfer Markup Language\n3. Hyper Tool Markup Language\n4. HyperText Management Language");
        System.out.print("Enter your answer (1-4): ");
        int answer1 = scanner.nextInt();
        if (answer1 == 1) {
            score++;
        }

        System.out.println("\nQuestion 2: Which of the following is used to style a web page?");
        System.out.println("1. HTML\n2. CSS\n3. JavaScript\n4. PHP");
        System.out.print("Enter your answer (1-4): ");
        int answer2 = scanner.nextInt();
        if (answer2 == 2) {
            score++;
        }

        System.out.println("\nQuestion 3: Which tag is used to display an image in HTML?");
        System.out.println("1. <image>\n2. <img>\n3. <pic>\n4. <src>");
        System.out.print("Enter your answer (1-4): ");
        int answer3 = scanner.nextInt();
        if (answer3 == 2) {
            score++;
        }

        System.out.println("\nQuestion 4: What does CSS stand for?");
        System.out.println("1. Computer Style Sheets\n2. Creative Style Sheets\n3. Cascading Style Sheets\n4. Colorful Style Sheets");
        System.out.print("Enter your answer (1-4): ");
        int answer4 = scanner.nextInt();
        if (answer4 == 3) {
            score++;
        }

        System.out.println("\nQuestion 5: Which JavaScript method is used to access an HTML element by its id?");
        System.out.println("1. getElementById()\n2. getElementByClass()\n3. getElementByTag()\n4. querySelector()");
        System.out.print("Enter your answer (1-4): ");
        int answer5 = scanner.nextInt();
        if (answer5 == 1) {
            score++;
        }

        System.out.println("\n" + name + ", your total score is: " + score + " out of 5.");
        if (score == 5) {
            System.out.println("Excellent! You got all answers correct!");
        } else if (score >= 3) {
            System.out.println("Good job! You got most answers right.");
        } else {
            System.out.println("Better luck next time!");
        }

        scanner.close();
    }
}
