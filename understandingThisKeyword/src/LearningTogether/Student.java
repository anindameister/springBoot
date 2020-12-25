package LearningTogether;

public class Student {

    String UniversityRollNumber;
    String name;

    Student(String UniversityRollNumber, String name){
        this.UniversityRollNumber=UniversityRollNumber;
        this.name=name;

    }

    public String toString(){
        return UniversityRollNumber + name;
    }
}
