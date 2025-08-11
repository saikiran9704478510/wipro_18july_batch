package labsession24thJuly;

public abstract class Student {
	String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    // Abstract method
    abstract void getGrade();
}
//EngineeringStudent subclass
class EngineeringStudent extends Student {
 int marks;

 EngineeringStudent(String name, int rollNo, int marks) {
     super(name, rollNo);
     this.marks = marks;
 }

 @Override
 void getGrade() {
     System.out.println("Engineering Student");
     System.out.println("Name: " + name);
     System.out.println("Roll No: " + rollNo);
     System.out.println("Marks: " + marks);
     if (marks >= 85) {
         System.out.println("Grade: A");
     } else if (marks >= 70) {
         System.out.println("Grade: B");
     } else if (marks >= 50) {
         System.out.println("Grade: C");
     } else {
         System.out.println("Grade: Fail");
     }
     System.out.println("--------------------");
 }
}

class MedicalStudent extends Student {
    int marks;

    MedicalStudent(String name, int rollNo, int marks) {
        super(name, rollNo);
        this.marks = marks;
    }

    @Override
    void getGrade() {
        System.out.println("Medical Student");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
        if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 75) {
            System.out.println("Grade: B");
        } else if (marks >= 60) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: Fail");
        }
        System.out.println("--------------------");
    }
}