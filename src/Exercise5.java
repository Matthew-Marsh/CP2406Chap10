import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise5 {

    private static ScoreInfo[] scoreData = new ScoreInfo[] {
            new ScoreInfo("Smith","John",70),
            new ScoreInfo("Doe","Mary",85),
            new ScoreInfo("Page","Alice",82),
            new ScoreInfo("Cooper","Jill",97),
            new ScoreInfo("Flintstone","Fred",66),
            new ScoreInfo("Rubble","Barney",80),
            new ScoreInfo("Smith","Judy",48),
            new ScoreInfo("Dean","James",90),
            new ScoreInfo("Russ","Joe",55),
            new ScoreInfo("Wolfe","Bill",73),
            new ScoreInfo("Dart","Mary",54),
            new ScoreInfo("Rogers","Chris",78),
            new ScoreInfo("Toole","Pat",51),
            new ScoreInfo("Khan","Omar",93),
            new ScoreInfo("Smith","Ann",95)
    };

    static class ScoreInfo {
        String firstName;
        String lastName;
        int score;
        ScoreInfo( String lName, String fName, int s ) {
            firstName = fName;
            lastName = lName;
            score = s;
        }
    }

    public static void main(String[] args) {
        Stream<ScoreInfo> scoreStream = Arrays.stream(scoreData);
        int numberOfStudents = (int) scoreStream.count();
        System.out.println(numberOfStudents);

        System.out.println();
        scoreStream = Arrays.stream(scoreData);
        double averageScore;
        double scoreTotal = scoreStream.mapToInt(s -> s.score).sum();
        System.out.println("Score total " + scoreTotal);
        averageScore = scoreTotal / numberOfStudents;
        System.out.println("The average score of the students is: " + (int) averageScore);
        System.out.println();

        scoreStream = Arrays.stream(scoreData);
        int numberOfAStudents = (int) scoreStream.filter(scoreInfo -> (scoreInfo.score >= 90)).count();
        System.out.println("Number of A students: " + numberOfAStudents);
        System.out.println();

        scoreStream = Arrays.stream(scoreData);
        List<String> studentNames = (scoreStream
                .filter(scoreInfo -> (scoreInfo.score < 70))
                .map(scoreInfo -> (scoreInfo.firstName + " " + scoreInfo.lastName))
                .collect( Collectors.toList()));
        System.out.println("Students that are failing: ");
        for (String student : studentNames) {
            System.out.println(student);
        }
        System.out.println();

        scoreStream = Arrays.stream(scoreData);
        studentNames = (scoreStream
                .sorted(Comparator.comparing(studentOne -> studentOne.lastName))
                .map(scoreInfo -> (scoreInfo.lastName + " " + scoreInfo.firstName + " " + scoreInfo.score))
                .collect( Collectors.toList()));
        System.out.println("Students and scores sorted by Last name: ");
        for (String student : studentNames) {
            System.out.println(student);
        }

    }

}
