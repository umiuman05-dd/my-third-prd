
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("CAMPUSTRACK");

        System.out.print("Student ID: ");
        String id = sc.next();

        sc.nextLine();
        System.out.print("Student Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        while (age < 16 || age > 30) {
            System.out.print("Enter age 16-30: ");
            age = sc.nextInt();
        }

        System.out.println("1.BCA  2.B.Sc CS  3.B.E/B.Tech");
        System.out.print("Course: ");
        int c = sc.nextInt();
        while (c < 1 || c > 3) {
            System.out.print("Enter 1-3: ");
            c = sc.nextInt();
        }

        String course = "";
        double fee = 0;

        switch (c) {
            case 1:
                course = "BCA";
                fee = 30000;
                break;
            case 2:
                course = "B.Sc Computer Science";
                fee = 35000;
                break;
            case 3:
                course = "B.E/B.Tech";
                fee = 50000;
                break;
        }

        System.out.print("Java: ");
        int j = sc.nextInt();
        while (j < 0 || j > 100) {
            j = sc.nextInt();
        }

        System.out.print("SQL: ");
        int s = sc.nextInt();
        while (s < 0 || s > 100) {
            s = sc.nextInt();
        }

        System.out.print("Aptitude: ");
        int a = sc.nextInt();
        while (a < 0 || a > 100) {
            a = sc.nextInt();
        }

        int total = j + s + a;
        double avg = total / 3.0;

        String result = j >= 35 && s >= 35 && a >= 35
                ? "PASSED" : "FAILED";

        String grade;
        if (result.equals("FAILED")) {
            grade = "F"; 
        }else if (avg >= 75) {
            grade = "A"; 
        }else if (avg >= 60) {
            grade = "B"; 
        }else if (avg >= 50) {
            grade = "C"; 
        }else {
            grade = "D";
        }

        System.out.print("Attendance: ");
        double att = sc.nextDouble();
        while (att < 0 || att > 100) {
            att = sc.nextDouble();
        }

        String attStatus = att >= 75 ? "SUFFICIENT" : "SHORTAGE";

        System.out.print("Fee paid: ");
        double paid = sc.nextDouble();
        while (paid < 0 || paid > fee) {
            paid = sc.nextDouble();
        }

        double balance = fee - paid;
        String feeStatus = balance == 0 ? "CLEARED" : "PENDING";

        String finalStatus
                = result.equals("PASSED") && att >= 75 && balance == 0
                ? "SEMESTER CLEARED"
                : "SEMESTER NOT CLEARED";

        System.out.println("\n----- STUDENT REPORT -----");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("Java: " + j);
        System.out.println("SQL: " + s);
        System.out.println("Aptitude: " + a);
        System.out.println("Total: " + total);
        System.out.printf("Average: %.2f%n", avg);
        System.out.println("Result: " + result);
        System.out.println("Grade: " + grade);
        System.out.println("Attendance: " + att);
        System.out.println("Attendance Status: " + attStatus);
        System.out.println("Fee Balance: " + balance);
        System.out.println("Fee Status: " + feeStatus);
        System.out.println("Final Status: " + finalStatus);

        if (finalStatus.equals("SEMESTER NOT CLEARED")) {
            System.out.println("Reasons:");
            if (j < 35) {
                System.out.println("Java marks are below 35.");
            }
            if (s < 35) {
                System.out.println("SQL marks are below 35.");
            }
            if (a < 35) {
                System.out.println("Aptitude marks are below 35.");
            }
            if (att < 75) {
                System.out.println("Attendance is below 75%.");
            }
            if (balance > 0) {
                System.out.println("Semester fee is pending.");
            }
        }

        sc.close();
    }
}
