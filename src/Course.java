import java.util.Objects;

public class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // TODO: Task 4 — Обязательно переопредели (иначе HashMap не будет работать!)
    @Override
    public boolean equals(Object o) {
        return this.equals(o); // заглушка
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); // заглушка
    }

    @Override
    public String toString() {
        return "Course: " + name;
    }
}
