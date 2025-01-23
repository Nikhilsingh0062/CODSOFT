// TASK 4: QUIZ APPLICATION WITH NUMBER
import java.util.*;

public class QuizApplication {
    static class Question {
        String questionText;
        String[] options;
        int correctAnswerIndex;

        public Question(String questionText, String[] options, int correctAnswerIndex) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "Who is the prime minister of india of INDIA?",
                new String[]{"1. Nirmala sita raman", "2. Ashok gahlot", "3. Narendra modi", "4. Nitin gadkari"},
                3
        ));
        questions.add(new Question(
                "What is the currency of india?",
                new String[]{"1. Dinar", "2. Rupay", "3. Euro", "4. Bitcoin"},
                2
        ));
        questions.add(new Question(
                "Which is the most populous state in india?",
                new String[]{"1. Uttar pradesh", "2. Rajasthan", "3. Madhya pradesh", "4. Gujrat"},
                1
        ));
        questions.add(new Question(
                "Which is the largest state in India by area?",
                new String[]{"1. Uttar pradesh", "2. Gujrat", "3. Madhya pradesh", "4. Rajasthan"},
                4
        ));
        questions.add(new Question(
                "Which river is considered the holiest river in India?",
                new String[]{"1. Yamuna", "2. Ganga", "3. Brahmpurta", "4. Narmada"},
                2
        ));
        questions.add(new Question(
                "India's first satellite?",
                new String[]{"1. yatri", "2. Aryabhata", "3. namo", "4. first"},
                2
        ));
        questions.add(new Question(
                "Father of the Nation in India?",
                new String[]{"1. Subhas Chandra Bose", "2. Bhagat Singh", "3. Mahatma gandhi", "4. Jawaharlal Nehru"},
                3
        ));
        questions.add(new Question(
                "First Indian to win a Nobel Prize?",
                new String[]{"1. C.V. Raman", "2.  Rabindranath Tagore", "3. Subramanyan Chandrasekhar", "4. Mother Teresa"},
                2
        ));
        questions.add(new Question(
                "The only female ruler in Indian history",
                new String[]{"1. Rani Laxmibai", "2.  Razia Sultana", "3. Indira Gandhi", "4. Nur Jahan"},
                2
        ));
        questions.add(new Question(
                "The first train in India started in which year?",
                new String[]{"1. 1853", "2.  1947", "3. 1974", "4. 1980"},
                1
        ));
                
        int score = 0;
        int questionNumber = 1;

        
        for (Question question : questions) {
            System.out.println("\nQuestion " + questionNumber + ": " + question.questionText);
            for (String option : question.options) {
                System.out.println(option);
            }

            System.out.println("You have 10 seconds to answer.");
            long startTime = System.currentTimeMillis();
            long endTime = startTime + 10 * 1000; 

            boolean answered = false;
            int userAnswer = -1;

            
            while (System.currentTimeMillis() < endTime && !answered) {
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                    answered = true;
                }
            }

            if (!answered) {
                System.out.println("Time's up! Moving to the next question.");
            } else {
                if (userAnswer == question.correctAnswerIndex) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer was: " + question.correctAnswerIndex);
                }
            }

            questionNumber++;
        }

        
        System.out.println("\n--- Quiz Finished ---");
        System.out.println("Your final score is: " + score + " out of " + questions.size());

        scanner.close();
    }
}
