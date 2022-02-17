package modal;

public class StudentModel {

    private int id;
    private String studentName;
    private int rollNo;
    private int age;
    private String className;
    AddressModel addModel;

    public StudentModel() {
    }

    public StudentModel(int id, String studentName, int rollNo, int age, String className, AddressModel addModel) {
        this.id = id;
        this.studentName = studentName;
        this.rollNo = rollNo;
        this.age = age;
        this.className = className;
        this.addModel = addModel;
    }

    public StudentModel(String studentName, int rollNo, int age, String className, AddressModel addModel) {
        this.studentName = studentName;
        this.rollNo = rollNo;
        this.age = age;
        this.className = className;
        this.addModel = addModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int roll) {
        this.rollNo = rollNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public AddressModel getAddModel() {
        return addModel;
    }

    public void setAddModel(AddressModel addModel) {
        this.addModel = addModel;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", rollNo=" + rollNo +
                ", age=" + age +
                ", className='" + className + '\'' +
                ", addModel=" + addModel +
                '}';
    }
}
