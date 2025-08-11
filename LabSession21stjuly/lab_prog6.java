package demo;

abstract class Student {
    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    abstract String getGrade(double marks);
}

class EngineeringStudent extends Student {

    EngineeringStudent(String name, int rollNo) {
        super(name, rollNo);
    }

    String getGrade(double marks) {
        if (marks >= 85) return "A+";
        else if (marks >= 70) return "A";
        else if (marks >= 50) return "B";
        else return "Fail";
    }
}

class MedicalStudent extends Student {

    MedicalStudent(String name, int rollNo) {
        super(name, rollNo);
    }

    String getGrade(double marks) {
        if (marks >= 80) return "Distinction";
        else if (marks >= 65) return "First Class";
        else if (marks >= 50) return "Pass";
        else return "Fail";
    }
}

public class lab_prog6 {
    public static void main(String[] args) {
        Student eng = new EngineeringStudent("Ravi", 101);
        Student med = new MedicalStudent("Priya", 202);

        System.out.println("Engineering Student Grade: " + eng.getGrade(72));
        System.out.println("Medical Student Grade: " + med.getGrade(78));
    }
}
