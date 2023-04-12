package OOP;

public class SectionA {
    public static void main(String[] args) {
        Student r1 = new Student();
        r1.setRollNumber(1);
        System.out.println("Roll no.: "+ getRollNumber());
    }
    static int getRollNumber(){
        return -1;
    }
    static void setRollNumber(int rollNumber){
        Student r2 = new Student();
        r2.setRollNumber(rollNumber);
    }

}
