package Task3;

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
            throw new IllegalArgumentException("Mismatch between studentIdList and studentsGrades.");
        }

        double[] gpaList = new double[studentIdList.length];

        for (int i = 0; i < studentIdList.length; i++) {
            char[] grades = studentsGrades[i];
            double sum = 0;
            for (char grade : grades) {
                if (grade == ' ') {
                    throw new MissingGradeException(studentIdList[i]); // Checked Exception
                }
                sum += GRADE_POINTS.getOrDefault(grade, 0);
            }
            gpaList[i] = sum / grades.length;
        }
        return gpaList;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        if (studentIdList.length != studentsGrades.length) {
            throw new IllegalArgumentException("Mismatch between studentIdList and studentsGrades.");
        }

        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        try {
            double[] gpaList = calculateGPA(studentIdList, studentsGrades); // Can throw MissingGradeException
            ArrayList<Integer> studentsInGPARange = new ArrayList<>();

            for (int i = 0; i < gpaList.length; i++) {
                if (gpaList[i] >= lower && gpaList[i] <= higher) {
                    studentsInGPARange.add(studentIdList[i]);
                }
            }
            return studentsInGPARange.stream().mapToInt(Integer::intValue).toArray();
        } catch (MissingGradeException e) {
            throw new InvalidDataException("GPA calculation failed due to missing grades.", e);
        }
    }
}
