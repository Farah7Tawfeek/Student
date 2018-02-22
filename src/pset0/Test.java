package pset0;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void groupByCity()
    {
         List<Student> studentList= new ArrayList<>();
         studentList =  createListFromFile();
         Map<String , Long> map = studentList.stream()
                            .map(e1 -> e1.getCity())
                 .collect(Collectors.groupingBy(e->e,Collectors.counting()));
        System.out.println(map);

        //map.entrySet().add(new Map.Entry("SS",8));
        map.entrySet().stream().forEach(line -> System.out.println(line));

        }


    public static void test1() {
        List<Student> studentList = new ArrayList<>();

        Student student = null;
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i <= 1; i++) {
            System.out.println("Please enter Student ");
            System.out.print("Please enter name ");
            String name = scan.next();
            System.out.print("Please enter id ");
            int id = scan.nextInt();
            System.out.print("Please enter gender ");
            int gender = scan.nextInt();
            System.out.println("Please enter city ");
            String city = scan.next();
            System.out.print("Please enter Age ");
            int age = scan.nextInt();
            int marks = 100;
            student = new Student(id, name, age, gender, city, marks);
            System.out.println(student.toString());
            studentList.add(student);
            System.out.println("---------------------------------------- ");
        }


        Optional<Student> any = studentList.stream()
                .findAny();
        System.out.println(any.get().getName());

        Optional<Student> first = studentList.stream()
                .findFirst();
        System.out.println(first.get().toString());

        studentList.stream()
                .forEach(e -> System.out.println(e.toString()));

    }

    public static void readfile() {
        try {
            String filePath = "src/pset0/data.txt";
            Path path = Paths.get(filePath);
            System.out.println(path.toAbsolutePath());

            List<String> lines = Files.readAllLines(path);
            List<Student> studentsList = new ArrayList<>();


            for (String line : lines) {
                String[] names = line.split(", ");
                Student student = new Student();

                student.setId(Integer.parseInt(names[0]));
                student.setName(names[1]);
                student.setGender(Integer.parseInt(names[2]));
                student.setAge(Integer.parseInt(names[3]));
                student.setCity(names[4]);
                student.setMarks(Integer.parseInt(names[5]));
                studentsList.add(student);
            }

            studentsList.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Farah took care of this. There is no such file");
            e.printStackTrace();
        }
    }


    public static void getStudentGender(int gender)
    {
        List<Student> studentsList = new ArrayList<>();

        studentsList  = createListFromFile();
        List<Student> Names = studentsList.stream()
                              .filter(e -> e.getGender() == gender )
                                .collect(Collectors.toList());
        Names.forEach(e -> System.out.println(e.toString()));


       /* List<Student> collect = studentsList.stream()
                    .filter( student -> student.getName().equals(name))
                    .peek(e -> System.out.print(e.getName()))
                    .collect(Collectors.toList());

                    collect.forEach(student -> student.toString());
*/    }

    public static void getallstudentName(){
        List<Student> studentsList = new ArrayList<>();
        studentsList  = createListFromFile();
        studentsList.stream()
                .map(e -> e.getName().toUpperCase())
                .limit(3)
                .peek(e -> System.out.println(e))
                .map(e -> e.toUpperCase())
                .forEach(e-> System.out.println(e));
        //.collect(Collectors.toList());
        //Names.forEach(e -> System.out.println(e.toString()));


    }


    public static void getsumMarks(){
        List<Student> studentsList = new ArrayList<>();
        studentsList  = createListFromFile();

        Optional<Integer> reduce = studentsList.stream()
                .map(e -> e.getMarks())
                .reduce((e1, e2) -> e1 + e2);
        if (reduce.isPresent()){
            System.out.println(reduce.get());
        }


        //.collect(Collectors.toList());
        //Names.forEach(e -> System.out.println(e.toString()));


    }



    public static void getallstudentNamewithforech(){
        List<Student> studentsList = new ArrayList<>();
        studentsList  = createListFromFile();
        List<String> names= studentsList.stream()
                .map(e -> e.getName().toUpperCase())
                .limit(3)
                .peek(e -> System.out.println(e))
                .map(e -> e.toUpperCase())
                .collect(Collectors.toList());
        names.forEach(e -> System.out.println(e.toString()));


    }

    public static void getStudent(String name)
    {
        List<Student> studentsList = new ArrayList<>();

        studentsList  = createListFromFile();
        String Names = studentsList.stream()
                                    .map(e -> e.getName())
                                    .filter(e -> e.equals(name))
                                    .collect(Collectors.joining(""));

        System.out.println(Names);


       /* List<Student> collect = studentsList.stream()
                    .filter( student -> student.getName().equals(name))
                    .peek(e -> System.out.print(e.getName()))
                    .collect(Collectors.toList());

                    collect.forEach(student -> student.toString());
*/    }

    public static List<Student> createListFromFile() {

        List<Student> studentsList = new ArrayList<>();

        try {
            String filePath = "src/pset0/data.txt";
            Path path = Paths.get(filePath);

            List<String> lines = Files.readAllLines(path);


            for (String line : lines) {
                String[] names = line.split(", ");
                Student student = new Student();


                student.setId(Integer.parseInt(names[0]));
                student.setName(names[1]);
                student.setGender(Integer.parseInt(names[2]));
                student.setAge(Integer.parseInt(names[3]));
                student.setCity(names[4]);
                student.setMarks(Integer.parseInt(names[5]));

                studentsList.add(student);
            }

          //  studentsList.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Farah took care of this. There is no such file");
            e.printStackTrace();
        }

        return studentsList;
    }


    public static void main(String[] args) {

        //readfile();

        getStudent("Wael");

        getStudentGender(1);
        System.out.println("_________________________________________________");
        getallstudentName();
        System.out.println("_________________________________________________");
        getallstudentNamewithforech();
        System.out.println("_________________________________________________");

        getsumMarks();
        System.out.println("_________________________________________________");

        groupByCity();
    }}
