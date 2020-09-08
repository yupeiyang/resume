package reflect.domain;

public class Person {
    private String name;
    private int age;

    public String str1 = "王勃";
    public String str2 = "白居易";
    private String str3 = "杜甫";
    protected String str4 = "贺知章";

    public Person(){

    }

    public Person(String name,int age){
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

    public void info(String name,int age){
        System.out.println("某人信息:\t"+name+"\t"+age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
