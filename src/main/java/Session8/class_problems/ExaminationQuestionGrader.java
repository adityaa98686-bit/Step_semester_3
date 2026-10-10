package Session8.class_problems;

import java.util.*;

abstract class Question {
    String text, correct, student;
    double points;

    Question(String text, String correct,
             String student, double points) {
        this.text = text;
        this.correct = correct;
        this.student = student;
        this.points = points;
    }

    abstract double grade();

    abstract String getType();
}

class MCQ extends Question {
    MCQ(String t, String c, String s, double p) {
        super(t, c, s, p);
    }

    double grade() {
        return student.equals(correct) ? points : 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TF extends Question {
    TF(String t, String c, String s, double p) {
        super(t, c, s, p);
    }

    double grade() {
        return student.equals(correct) ? points : 0;
    }

    String getType() {
        return "TF";
    }
}

class Essay extends Question {
    Essay(String t, String c, String s, double p) {
        super(t, c, s, p);
    }

    double grade() {
        String[] keywords = correct.split(",");
        int matched = 0;

        for (String keyword : keywords) {
            if (student.toLowerCase().contains(
                    keyword.trim().toLowerCase())) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }

    String getType() {
        return "ESSAY";
    }
}

public class ExaminationQuestionGrader {
    static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        java.util.regex.Matcher m =
                java.util.regex.Pattern
                        .compile("\"([^\"]*)\"|(\\S+)")
                        .matcher(line);

        while (m.find()) {
            tokens.add(m.group(1) != null
                    ? m.group(1) : m.group(2));
        }

        return tokens;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Question[] questions = new Question[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            List<String> a = tokenize(sc.nextLine());

            String type = a.get(0);
            String text = a.get(1);
            String correct = a.get(2);
            String student = a.get(3);
            double points = Double.parseDouble(a.get(4));

            switch (type) {
                case "MCQ":
                    questions[i] =
                            new MCQ(text, correct, student, points);
                    break;
                case "TF":
                    questions[i] =
                            new TF(text, correct, student, points);
                    break;
                case "ESSAY":
                    questions[i] =
                            new Essay(text, correct, student, points);
                    break;
            }
        }

        for (Question q : questions) {
            double score = q.grade();
            System.out.printf("%s: %.2f%n", q.getType(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
