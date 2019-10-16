package package5;

public class Student implements Comparable{
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "[" + name + " : " + score + "]";
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student)o;
        if (this.score > s.score) {
            return -1;
        } else if (this.score < s.score) {
            return 1;
        }
        return 0;
    }
}
