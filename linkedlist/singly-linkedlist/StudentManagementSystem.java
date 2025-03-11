

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        
        // Adding students
        list.addStudent(101, "Vishwas", 20, 'A', 0);
        list.addStudent(102, "Deepak", 21, 'B', 1);
        list.addStudent(103, "Kamal", 22, 'C', 2);
        
        // Display all students
        System.out.println("Student Records:");
        list.displayStudents();
        
        // Search for a student
        System.out.println("\nSearching for Roll Number 102:");
        list.searchStudent(102);
        
        // Update a student's grade
        System.out.println("\nUpdating grade for Roll Number 101 to 'A+':");
        list.updateGrade(101, 'A');
        list.displayStudents();
        
        // Delete a student
        System.out.println("\nDeleting student with Roll Number 103:");
        list.deleteStudent(103);
        list.displayStudents();
    }
}

class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    // Constructor to initialize student details
    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    private Student head;

    // Constructor to initialize an empty list
    public StudentList() {
        head = null;
    }

    // Method to add a student at a specific position
    public void addStudent(int rollNumber, String name, int age, char grade, int position) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 0 || head == null) { // Insert at the beginning
            newStudent.next = head;
            head = newStudent;
        } else {
            Student temp = head;
            int index = 0;
            while (temp.next != null && index < position - 1) {
                temp = temp.next;
                index++;
            }
            newStudent.next = temp.next;
            temp.next = newStudent;
        }
    }

    // Method to delete a student by Roll Number
    public void deleteStudent(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) { // Remove head
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Method to search for a student by Roll Number
    public void searchStudent(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println(temp.rollNumber + " | " + temp.name + " | " + temp.age + " | " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Method to update a student's grade by Roll Number
    public void updateGrade(int rollNumber, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
    }

    // Method to display all student records
    public void displayStudents() {
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.rollNumber + " | " + temp.name + " | " + temp.age + " | " + temp.grade);
            temp = temp.next;
        }
    }
}
