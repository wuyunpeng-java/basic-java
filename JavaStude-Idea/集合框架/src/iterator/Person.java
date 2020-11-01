package iterator;

/**
 * author:吴云鹏
 * Date:2020/4/11
 * Time:12:52
 */
public class Person implements Comparable{
    private String name;
    private int age;

    public Person(String tom) {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person P =(Person) o;
          return this.name.compareToIgnoreCase(P.name);
        }
        throw new ClassCastException("类型不一致，无法比较");
    }
}
