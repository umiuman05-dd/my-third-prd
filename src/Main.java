
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("                 CAMPUSTRACK");
        System.out.println("==================================================");
        System.out.println("       Simple Student Result Management System");
        System.out.println("--------------------------------------------------");

        System.out.print("Enter student ID: ");
        String studentId = sc.next();

        sc.nextLine();
        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        while (age < 16 || age > 30) {
            System.out.println("Invalid age. Enter a value between 16 and 30.");
            System.out.print("Enter age: ");
            age = sc.nextInt();
        }

        System.out.println();
        System.out.println("Select Course");
        System.out.println("1. BCA");
        System.out.println("2. B.Sc Computer Science");
        System.out.println("3. B.E/B.Tech");

        System.out.print("Enter course choice: ");
        int choice = sc.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.println("Invalid course choice. Enter a value from 1 to 3.");
            System.out.print("Enter course choice: ");
            choice = sc.nextInt();
        }

        String course = "";
        double semesterFee = 0;

        switch (choice) {
            case 1:
                course = "BCA";
                semesterFee = 30000;
                break;
            case 2:
                course = "B.Sc Computer Science";
                semesterFee = 35000;
                break;
            case 3:
                course = "B.E/B.Tech";
                semesterFee = 50000;
                break;
        }

        System.out.print("Enter Java marks: ");
        int javaMarks = sc.nextInt();

        while (javaMarks < 0 || javaMarks > 100) {
            System.out.println("Invalid marks. Enter a value between 0 and 100.");
            System.out.print("Enter Java marks: ");
            javaMarks = sc.nextInt();
        }

        System.out.print("Enter SQL marks: ");
        int sqlMarks = sc.nextInt();

        while (sqlMarks < 0 || sqlMarks > 100) {
            System.out.println("Invalid marks. Enter a value between 0 and 100.");
            System.out.print("Enter SQL marks: ");
            sqlMarks = sc.nextInt();
        }

        System.out.print("Enter Aptitude marks: ");
        int aptitudeMarks = sc.nextInt();

        while (aptitudeMarks < 0 || aptitudeMarks > 100) {
            System.out.println("Invalid marks. Enter a value between 0 and 100.");
            System.out.print("Enter Aptitude marks: ");
            aptitudeMarks = sc.nextInt();
        }

        int totalMarks = javaMarks + sqlMarks + aptitudeMarks;
        double average = totalMarks / 3.0;

        String academicResult;

        if (javaMarks >= 35 && sqlMarks >= 35 && aptitudeMarks >= 35) {
            academicResult = "PASSED";
        } else {
            academicResult = "FAILED";
        }

        String grade;

        if (academicResult.equals("FAILED")) {
            grade = "F";
        } else if (average >= 75) {
            grade = "A";
        } else if (average >= 60) {
            grade = "B";
        } else if (average >= 50) {
            grade = "C";
        } else {
            grade = "D";
        }

        System.out.print("Enter attendance percentage: ");
        double attendance = sc.nextDouble();

        while (attendance < 0 || attendance > 100) {
            System.out.println("Invalid attendance. Enter a value between 0 and 100.");
            System.out.print("Enter attendance percentage: ");
            attendance = sc.nextDouble();
        }

        String attendanceStatus
                = attendance >= 75 ? "SUFFICIENT" : "SHORTAGE";

        System.out.print("Enter fee paid: ");
        double feePaid = sc.nextDouble();

        while (feePaid < 0 || feePaid > semesterFee) {
            System.out.println("Invalid fee. Enter a value between 0 and "
                    + semesterFee + ".");
            System.out.print("Enter fee paid: ");
            feePaid = sc.nextDouble();
        }

        double feeBalance = semesterFee - feePaid;

        String feeStatus
                = feeBalance == 0 ? "CLEARED" : "PENDING";

        String semesterStatus
                = academicResult.equals("PASSED")
                && attendance >= 75
                && feeBalance == 0
                        ? "SEMESTER CLEARED"
                        : "SEMESTER NOT CLEARED";

        System.out.println();
        System.out.println("==================================================");
        System.out.println("              STUDENT SEMESTER REPORT");
        System.out.println("==================================================");
        System.out.printf("Student ID          : %s%n", studentId);
        System.out.printf("Student Name        : %s%n", studentName);
        System.out.printf("Age                 : %d%n", age);
        System.out.printf("Course              : %s%n", course);

        System.out.println();
        System.out.println("--------------- ACADEMIC DETAILS -----------------");
        System.out.printf("Java Marks          : %d%n", javaMarks);
        System.out.printf("SQL Marks           : %d%n", sqlMarks);
        System.out.printf("Aptitude Marks      : %d%n", aptitudeMarks);
        System.out.printf("Total Marks         : %d/300%n", totalMarks);
        System.out.printf("Average             : %.2f%n", average);
        System.out.printf("Academic Result     : %s%n", academicResult);
        System.out.printf("Grade               : %s%n", grade);

        System.out.println();
        System.out.println("--------------- ATTENDANCE DETAILS ---------------");
        System.out.printf("Attendance          : %.2f%%%n", attendance);
        System.out.printf("Attendance Status   : %s%n", attendanceStatus);

        System.out.println();
        System.out.println("------------------ FEE DETAILS --------------------");
        System.out.printf("Semester Fee        : ₹%.2f%n", semesterFee);
        System.out.printf("Fee Paid            : ₹%.2f%n", feePaid);
        System.out.printf("Fee Balance         : ₹%.2f%n", feeBalance);
        System.out.printf("Fee Status          : %s%n", feeStatus);

        System.out.println();
        System.out.println("---------------- FINAL STATUS ---------------------");
        System.out.printf("Semester Status     : %s%n", semesterStatus);

        if (semesterStatus.equals("SEMESTER NOT CLEARED")) {
            System.out.println();
            System.out.println("Reasons:");

            if (javaMarks < 35) {
                System.out.println("- Java marks are below 35.");
            }

            if (sqlMarks < 35) {
                System.out.println("- SQL marks are below 35.");
            }

            if (aptitudeMarks < 35) {
                System.out.println("- Aptitude marks are below 35.");
            }

            if (attendance < 75) {
                System.out.println("- Attendance is below 75%.");
            }

            if (feeBalance > 0) {
                System.out.println("- Semester fee is pending.");
            }
        }

        System.out.println("==================================================");

        sc.close();
    }
}
