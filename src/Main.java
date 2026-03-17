import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        students.put("12345", new Student("Aiperi", 4.0, 19));
        students.put("12346", new Student("Dilya", 3.9, 18));
        students.put("12347", new Student("Nazik", 3.9, 18));
        students.put("12348", new Student("Aibiyke", 3.0, 19));
        students.put("12349", new Student("Mirana", 3.0, 19));
        // Сделай минимум два студента с одинаковым GPA (для Task 3)

        // TODO: Напечатай всех студентов (ID + объект)
        for (Map.Entry<String, Student> u : students.entrySet()) {
            System.out.println(u.getKey() + " ----> " + u.getValue());
        }

        // TODO: Найди студента по ID и выведи его
        System.out.println(students.get("12345"));

        // TODO: Удали одного студента по ID
        students.remove("12347");

        // TODO: Обнови GPA у одного студента
        students.get("12346").setGpa(4.0);

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        List<Student> st = new ArrayList<>();
        for (Map.Entry<String, Student> i : students.entrySet()) {
            st.add(i.getValue());
        }

        for (Student j : st) {
            System.out.println(j);
        }

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        Collections.sort(st);

        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        Collections.sort(st, new NameComparator());

        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        List<Student> students2 = new ArrayList<>();
        students2.add(new Student("Aiperi", 4.0, 13));
        students2.add(new Student("Nazik", 3.5, 18));
        students2.add(new Student("Mirana", 3.6, 17));
        students2.add(new Student("Dilya", 3.9, 19));
        students2.add(new Student("Aibiyke", 3.8, 16));

        Collections.sort(students2, Collections.reverseOrder());

        for (int u = 0; u < 3; u++) {
            System.out.println(students2.get(u));
        }

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        HashMap<Double, List<String>> byGpa = new HashMap<>();
        for (Student f : students2) {
            byGpa.computeIfAbsent(f.getGpa(), k -> new ArrayList<>()).add(f.getName());
        }

        boolean found = false;

        for (Map.Entry<Double, List<String>> entry : byGpa.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("GPA : " + entry.getKey() + " : " + entry.getValue());
                found = true;
            }
        }

        if (!found) System.out.println("Dublicate gpas not found");


        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        Course c1 = new Course("Computer science");
        Course c2 = new Course("Software engineering");
        Course c3 = new Course("Programming language");
        Course c4 = new Course("English");

        List<Student> cs = new ArrayList<>();
        cs.add(new Student("Aiperi", 4.0, 19));
        cs.add(new Student("Bekzat", 3.7, 20));
        courseMap.put(c1, cs);

        List<Student> se = new ArrayList<>();
        se.add(new Student("Cholpon", 3.5, 21));
        se.add(new Student("Damir", 3.9, 22));
        courseMap.put(c2, se);

        List<Student> pl = new ArrayList<>();
        pl.add(new Student("Eldar", 3.2, 20));
        courseMap.put(c3, pl);

        List<Student> en = new ArrayList<>();
        en.add(new Student("Fatima", 3.6, 19));
        en.add(new Student("Aiperi", 4.0, 19)); // student in 2 courses
        courseMap.put(c4, en);

// Print all courses with their students
        for (Map.Entry<Course, List<Student>> entry : courseMap.entrySet()) {
            System.out.println("\n" + entry.getKey().getName() + ":");
            for (Student s : entry.getValue()) {
                System.out.println("  " + s);
            }
        }

// ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй

// Collect all students from courseMap into one list
        List<Student> allStudents = new ArrayList<>();
        for (List<Student> list : courseMap.values()) {
            allStudents.addAll(list);
        }

// Comparator: GPA descending → if equal, Name ascending
        allStudents.sort(
                Comparator.comparingDouble(Student::getGpa).reversed()
                        .thenComparing(Student::getName)
        );

        allStudents.forEach(System.out::println);
    }

}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}




