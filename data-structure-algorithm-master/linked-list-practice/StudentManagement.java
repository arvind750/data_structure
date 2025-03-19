import java.util.*;

class Node {
    int rollNumber;
    String name;
    int age;
    String grade;
    Node next;

    Node(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class Student {
    Node head;

    public void beginning(int rollNumber, String name, int age, String grade) {
        Node newStudent = new Node(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Node newStudent = new Node(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addAtPosition(int rollNumber, String name, int age, String grade, int position) {
        Node newStudent = new Node(rollNumber, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void delete(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Node temp = head, prev = null;
        while (temp != null && temp.rollNumber != rollNumber) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
            return;
        }
        prev.next = temp.next;
    }

    public Node search(int rollNumber) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void update(int rollNumber, String newGrade) {
        Node student = search(rollNumber);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated for Roll Number: " + rollNumber);
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Student studentList = new Student();

        // Adding students
        studentList.addAtEnd(101, "Alice", 20, "A");
        studentList.addAtEnd(102, "Bob", 21, "B");
        studentList.beginning(103, "Charlie", 22, "C");
        studentList.addAtPosition(104, "David", 19, "B", 2);

        System.out.println("Student Records:");
        studentList.display();

        // Searching for a student
        Node foundStudent = studentList.search(102);
        if (foundStudent != null) {
            System.out.println("Student Found: " + foundStudent.name);
        } else {
            System.out.println("Student not found.");
        }

        // Updating a student's grade
        studentList.update(101, "A+");

        // Deleting a student
        studentList.delete(103);

        System.out.println("\nUpdated Student Records:");
        studentList.display();
    }
}
