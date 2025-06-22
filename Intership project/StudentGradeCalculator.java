import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        
     Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of Subject");

      int numSubjects = sc.nextInt();

      int[] marks = new int[numSubjects];
      int totalMarks = 0;

      //input marks for each subject
 
      for(int i = 0; i < numSubjects; i++) {
        System.out.print("Enter marks for subjects"+ " "+(i+1) +" "+ "out of 100 \n");
        marks[i] = sc.nextInt();
        totalMarks += marks[i];

      }
      // Calculate percentage

    double average = (double) totalMarks/numSubjects;

      String grade;
      if (average >= 90){
        grade = "A+";
      }else if(average >= 80){
        grade = "A";
      }else if(average >= 70){
        grade = "B";
      }else if(average >= 60){
        grade = "C";
      }else if(average >= 50){
        grade = "D";
      }else {
        grade = "F (Fail)";
      }

      System.out.println("\n----- Report Card ------");
      System.out.println("Total Marks:"+ totalMarks);
      System.out.println("Average Percentage: \n" + average);
      System.out.println("Grade:" + grade);    
    }
    
}
