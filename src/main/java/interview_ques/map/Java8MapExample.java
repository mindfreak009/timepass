package interview_ques.map;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Student {
    private String studentName;
    private String studentAddress;
    private int studentMarks;

    public Student(String studentName, String studentAddress, int studentMarks) {
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentMarks = studentMarks;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public int getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(int studentMarks) {
        this.studentMarks = studentMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentMarks=" + studentMarks +
                '}';
    }
}

public class Java8MapExample {
    public static void main(String[] args) {
        //Student student = //new Student();

        List<Student> list = new ArrayList<>();
        list.add(new Student("Harry", "Pune", 15));
        list.add(new Student("Leo", "Bangalore", 20));
        list.add(new Student("Graham", "Delhi", 25));
        list.add(new Student("Harry", "Rishikesh", 30));
        list.add(new Student("Sunny", "Dehradun", 35));
        list.add(new Student("Elyssa", "Mussourie", 40));

        list.stream().mapToDouble(Student::getStudentMarks).forEach(System.out::println);
        DoubleSummaryStatistics doubleSummaryStatistics = list.stream().mapToDouble(Student::getStudentMarks).summaryStatistics();
        System.out.println("********************************************************");

        list.stream().map(Student::getStudentMarks).forEach(System.out::println);
        System.out.println("doubleSummaryStatistics ::::" +doubleSummaryStatistics);

        Map<String, List<Student>> grouping = list.stream().collect(Collectors.groupingBy(Student::getStudentName));
        grouping.forEach((name, student) -> {
            System.out.println(name);
            student.forEach(System.out::println);
        });
        System.out.println("********************************************************");

        List<Student> collect = list.stream()
                .sorted(Comparator.comparing(Student::getStudentMarks))
                .collect(Collectors.toList());
        System.out.println("collect :::" +collect);


        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10};
        Integer any = Arrays.stream(numbers)
                .filter(f -> f < 7)
                .findFirst()
                .get();
        System.out.println(any);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Mumbai");
        map.put(2, "Delhi");
        map.put(3, "Mumbai");
        map.put(4, "Jaipur");
        map.put(5, "Pune");
        map.put(6, "Delhi");
        map.put(7, "Mumbai");

        List<Map<Integer, String>> beforeFormatting = new ArrayList<>();
        beforeFormatting.add(map);

//        Map<List<String>, Integer> afterFormatting = beforeFormatting.stream()
//                .flatMap(m -> m.entrySet().stream())
//                .collect(Collectors.groupingBy(Map.Entry::getKey),
//                        Collectors.mapping(Map.Entry::getValue), Collectors.toList());


        String str = "Hello Manash";
        Map<Character,Long> hm = str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
        System.out.println(hm);

        System.out.println("=================================================");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 56,22, 10);
        List<Integer> collect1 = nums.stream().sorted().collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println("=================================================");
        System.out.println(nums.stream().reduce(0, Integer::sum));
        System.out.println("=================================================");
        IntStream.iterate(1, e-> e+2).limit(10).peek(System.out::println).sum();

        // ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext/user-bean-config.xml");




    }
}
