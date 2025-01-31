package Student;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] studentIdList = {1001, 1002, 1003};
        char[][] studentsGrades = { {'A', 'A', 'A', 'B'}, {'A', 'B', 'B'}, {'B', 'A'} };

        double[] gpaResults = StudentUtil.calculateGPA(studentIdList, studentsGrades);
        System.out.println("GPA List: " + Arrays.toString(gpaResults));

        int[] studentsInGPARange = StudentUtil.getStudentsByGPA(3.2, 3.5, studentIdList, studentsGrades);
        System.out.println("Students with GPA in range 3.2 - 3.5: " + Arrays.toString(studentsInGPARange));
    }
}
