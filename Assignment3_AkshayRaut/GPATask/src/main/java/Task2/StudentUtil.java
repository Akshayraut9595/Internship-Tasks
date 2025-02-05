package Task2;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentUtil {
    private static final HashMap<Character, Integer> GRADE_POINTS = new HashMap<>();

    static {
        GRADE_POINTS.put('A', 4);
        GRADE_POINTS.put('B', 3);
        GRADE_POINTS.put('C', 2);
    }

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {
        if (studentIdList.length != studentsGrades.length) {
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
        }

        int totalStudents = studentIdList.length;
        double[] gpaList = new double[totalStudents];

        for (int i = 0; i < totalStudents; i++) {
            char[] grades = studentsGrades[i];
            double sum = 0;
            for (char grade : grades) {
                if (grade == ' ') {
                    throw new MissingGradeException(studentIdList[i]);
                }
                sum += GRADE_POINTS.getOrDefault(grade, 0);
            }
            gpaList[i] = sum / grades.length;
        }
        return gpaList;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (studentIdList.length != studentsGrades.length) {
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
        }

        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        ArrayList<Integer> studentsInGPARange = new ArrayList<>();
        try {
            double[] gpaList = calculateGPA(studentIdList, studentsGrades);
            for (int i = 0; i < gpaList.length; i++) {
                if (gpaList[i] >= lower && gpaList[i] <= higher) {
                    studentsInGPARange.add(studentIdList[i]);
                }
            }
        } catch (MissingGradeException e) {
            System.err.println("Error: " + e.getMessage());
            return new int[0];
        }

        return studentsInGPARange.stream().mapToInt(Integer::intValue).toArray();
    }
}
