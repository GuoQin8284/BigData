package Demo17_myClassLoader;

public class Students {
    public String name;
    private String age;
    private String StuId;

    public Students() {
    }

    private Students(String name, String age, String stuId) {
        this.name = name;
        this.age = age;
        StuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    private void setAge(String age) {
        this.age = age;
    }

    public String getStuId() {
        return StuId;
    }

    public void setStuId(String stuId) {
        StuId = stuId;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", StuId='" + StuId + '\'' +
                '}';
    }
}
