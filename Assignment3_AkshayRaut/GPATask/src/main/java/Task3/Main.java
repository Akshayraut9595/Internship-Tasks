package Task3;

import Task3.StudentUtil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] studentIdList = {1001, 1002, 1003};
        char[][] studentsGrades = { {'A', 'A', 'A', 'B'}, {'A', 'B', 'B'}, {' '}};

        try {
            double[] gpaResults = Task3.StudentUtil.calculateGPA(studentIdList, studentsGrades);
            System.out.println("GPA List: " + Arrays.toString(gpaResults));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            int[] studentsInGPARange = StudentUtil.getStudentsByGPA(3.2, 3.5, studentIdList, studentsGrades);
            System.out.println("Students with GPA in range 3.2 - 3.5: " + Arrays.toString(studentsInGPARange));
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }
}
