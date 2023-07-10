import java.io.*;
import java.util.*;

class Student {
    String name;
    int kor, eng, math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                '}';
    }
}

public class Main {

    public static int n;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            List<Student> studentList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] split = bufferedReader.readLine().split(" ");
                studentList.add(new Student(
                        split[0],
                        Integer.parseInt(split[1]),
                        Integer.parseInt(split[2]),
                        Integer.parseInt(split[3])
                ));
            }

            Collections.sort(studentList, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    if (o1.kor == o2.kor) {
                        if (o1.eng == o2.eng) {
                            if (o1.math == o2.math) {
                                return o1.name.compareTo(o2.name);
                            } else {
                                return o2.math - o1.math;
                            }
                        } else {
                            return o1.eng - o2.eng;
                        }
                    } else {
                        return o2.kor - o1.kor;
                    }
                }
            });
            for (Student st : studentList) {
                sb.append(st.name);
                sb.append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}