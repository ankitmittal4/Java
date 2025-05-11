class Emp{
    String Employee_name;
    float Employee_salary;

    void set(String n, float p) {
        Employee_name  = n;
        Employee_salary  = p;
    }

    void get() {
        System.out.println("Employee name is: " +Employee_name );
        System.out.println("Employee CTC is: " + Employee_salary);
    }
}

public class GFG {

    public static void main(String args[]) {
        Emp obj = new Emp();
        obj.set("Rathod Avinash", 10000.0f);
        obj.get();
    }
}
