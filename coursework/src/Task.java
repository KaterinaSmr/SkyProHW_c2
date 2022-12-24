import java.time.LocalDate;

public class Task {

    private int id;
    private String title;
    private String description;
    private TaskType taskType;
    private LocalDate date;
    private Periodicity periodicity;

    public Task(int id, String title, String description, TaskType taskType, LocalDate date, Periodicity periodicity) {
        if (title == null || description == null || taskType == null || periodicity == null){
            throw new IllegalArgumentException("Заголовок, описание, тип и признак повторяемости обязательны к заполнению");
        }
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskType = taskType;
        this.date = date == null ? LocalDate.now() : date;
        this.periodicity = periodicity;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public LocalDate getDate() {
        return date;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  id + " - " +
                taskType.getRuName() +" - " +
                date + " - " +
                periodicity.getRuName() + " - " +
                title + " - " +
                description + "\n";
    }

}
