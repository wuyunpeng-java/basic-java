package bean;

/**
 * @ author:吴云鹏
 * Date:2020/4/12
 * Time:13:00
 * 定义成员变量name，age,birthday.其中birthday为MyDate类的对象引用；
 * 为每个变量定义get/set方法；
 * 重写toString()方法；
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private MyDate bitthday;
    private Status Status;

    public Employee() {
    }

    public Employee(String name, int age, MyDate bitthday, Employee.Status Status) {
        this.name = name;
        this.age = age;
        this.bitthday = bitthday;
        this.Status = Status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBitthday() {
        return bitthday;
    }

    public void setBitthday(MyDate bitthday) {
        this.bitthday = bitthday;
    }

    public Employee(String name, int age, MyDate bitthday) {
        this.name = name;
        this.age = age;
        this.bitthday = bitthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", bitthday=" + bitthday +
                ", status=" + Status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof Employee)) {return false;}

        Employee employee = (Employee) o;

        if (getAge() != employee.getAge()) {return false;}
        if (!getName().equals(employee.getName())) {return false;}
        return getBitthday().toString().equals(employee.getBitthday().toString());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + getBitthday().toString().hashCode();
        return result;
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
    public enum Status{
         FREE,
         BUSY,
         VOCATION;
    }
}

