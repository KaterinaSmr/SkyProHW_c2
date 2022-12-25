import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TaskService {
    private Map<Integer, Task> taskManager;
    private Map<Integer, Task> archivedTasks;
//    private static int taskCount = 0;

    public TaskService() {
        this.taskManager = new HashMap<>();
        this.archivedTasks = new HashMap<>();
        this.addTask(new Task("Сделать курсовую", "Выполнить курсовую работу", TaskType.WORK,
                LocalDate.of(2022, 12, 23), Periodicity.SINGLE));
        this.addTask(new Task("Учеба", "Позаниматься учебой", TaskType.WORK,
                LocalDate.of(2022, 12, 23), Periodicity.DAILY));
        this.addTask(new Task("Заплатить за кв", "Заплатить за квартиру", TaskType.PERSONAL,
                LocalDate.of(2022,12, 2), Periodicity.MONTHLY));
        this.addTask(new Task("Встретить НГ", "Отпразновать наступление Нового года", TaskType.PERSONAL,
                LocalDate.of(2022, 12, 31), Periodicity.YEARLY));
        this.addTask(new Task("Отдых", "Устроить выходной", TaskType.PERSONAL,
                LocalDate.of(2022, 12, 24), Periodicity.WEEKLY));
    }

    public void addTask(Task task){
        taskManager.put(task.getId(), task);
    }

    public boolean removeTask(int id){
        Task taskToRemove = taskManager.remove(id);
        archivedTasks.put(id, taskToRemove);
        return taskToRemove != null;
    }

    public Map<Integer, Task> getArchivedTasks(){
        return archivedTasks;
    }

    public Task getTaskById(int id){
        return taskManager.get(id);
    }

    public Set<Task> getTasksForDate(LocalDate date){
        return getAllTasksGroupedByDate(date).get(date);
    }

    public Map<LocalDate, Set<Task>> getAllTasksGroupedByDate(LocalDate dateUntil) {
        Map<Task, Set<LocalDate>> datesForTasksUntil = taskManager.values().stream()
                .collect(Collectors.toMap(Function.identity(), task -> getAllDatesForTaskUntil(dateUntil, task)));

        Map<LocalDate, Set<Task>> result = datesForTasksUntil.values().stream()
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toMap(Function.identity(), date -> datesForTasksUntil.entrySet().stream()
                        .filter(entry -> entry.getValue().contains(date))
                        .map(Map.Entry::getKey).collect(Collectors.toSet())));
        return result;
    }

    private Set<LocalDate> getAllDatesForTaskUntil(LocalDate dateUntil, Task task){
        Periodicity periodicity = task.getPeriodicity();
        LocalDate date = task.getDate();
        Set<LocalDate> result = new HashSet<>();

        while (date.isBefore(dateUntil) || date.isEqual(dateUntil)){
            result.add(date);
            date = periodicity.getNextDueDate(date);
            if (periodicity.equals(Periodicity.SINGLE)){
                break;
            }
        }
        return result;
    }

    public void updateTask(int taskId, String newName, String newDescription) {
        Task task = taskManager.get(taskId);
        task.setTitle(newName);
        task.setDescription(newDescription);
    }
}
