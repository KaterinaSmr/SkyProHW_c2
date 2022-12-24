import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TaskService planner = new TaskService();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    scanner.nextLine();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, planner);
                            break;
                        case 2:
                            removeTask(scanner, planner);
                            break;
                        case 3:
                            showTasksForDate(scanner, planner);
                            break;
                        case 4:
                            updateTask(scanner, planner);
                            break;
                        case 5:
                            showAllTasksGroupedByDates(scanner, planner);
                            break;
                        case 6:
                            getArchivedTasks(planner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static int inputTaskId(Scanner scanner, TaskService planner) {
        while (true) {
            System.out.print("Введите номер задачи: ");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                if (planner.getTaskById(id) != null) {
                    return id;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("Нет задачи с таким номером");
        }
    }

    private static void inputTask(Scanner scanner, TaskService taskService) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.nextLine();
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.nextLine();

        TaskType taskType = inputTaskType(scanner);
        LocalDate taskDate = inputDate(scanner);
        Periodicity periodicity = inputPeriodicity(scanner);

        taskService.addTask(taskName, taskDescription, taskType, taskDate, periodicity);
    }

    private static Periodicity inputPeriodicity(Scanner scanner) {
        Periodicity periodicity;
        while (true) {
            System.out.print("Введите периодичность (" + Periodicity.info() + "): ");
            if (scanner.hasNextInt()) {
                int periodicityId = scanner.nextInt();
                periodicity = Periodicity.valueOf(periodicityId);
                if (periodicity != null) {
                    break;
                }
                continue;
            }
            scanner.next();
        }
        return periodicity;
    }

    private static TaskType inputTaskType(Scanner scanner) {
        TaskType taskType;
        while (true) {
            System.out.print("Введите тип задачи (" + TaskType.info() + "): ");
            if (scanner.hasNextInt()) {
                int taskTypeId = scanner.nextInt();
                taskType = TaskType.valueOf(taskTypeId);
                if (taskType != null) {
                    break;
                }
                continue;
            }
            scanner.next();
        }
        return taskType;
    }

    private static LocalDate inputDate(Scanner scanner) {
        System.out.print("Введите дату в формате ГГГГ-ММ-ДД: ");
        LocalDate taskDate;
        while (true) {
            String dateString = scanner.next();
            try {
                taskDate = LocalDate.parse(dateString);
                break;
            } catch (Exception e) {
                System.out.print("Введите дату в формате ГГГГ-ММ-ДД: ");
            }
        }
        return taskDate;
    }

    private static void updateTask(Scanner scanner, TaskService planner) {
        int taskId = inputTaskId(scanner, planner);
        System.out.print(planner.getTaskById(taskId));
        scanner.nextLine();
        System.out.print("Введите новое название задачи: ");
        String taskName = scanner.nextLine();
        System.out.print("Введите новое описание задачи: ");
        String taskDescription = scanner.nextLine();
        planner.updateTask(taskId, taskName, taskDescription);
        System.out.println("Задача обновлена");
    }

    private static void showAllTasksGroupedByDates(Scanner scanner, TaskService taskService) {
        System.out.println("До какой даты показать задачи?");
        LocalDate requiredDate = inputDate(scanner);
        System.out.println(taskService.getAllTasksGroupedByDate(requiredDate));
    }

    private static void showTasksForDate(Scanner scanner, TaskService taskService) {
        LocalDate requiredDate = inputDate(scanner);
        System.out.println("Задачи на " + requiredDate);
        System.out.println(taskService.getTasksForDate(requiredDate));
    }

    private static void removeTask(Scanner scanner, TaskService taskService) {
        int taskId = inputTaskId(scanner, taskService);
        if (taskService.removeTask(taskId)){
            System.out.println("Задача " + taskId + " перемещена в архив");
        } else {
            System.out.println("Что то пошло не так...");
        }
    }

    private static void getArchivedTasks(TaskService taskService) {
        System.out.println("Удаленные задачи: ");
        System.out.println(taskService.getArchivedTasks());
    }

    private static void printMenu() {
        System.out.println(
                """
                        
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачи на указанный день
                        4. Изменить задачу
                        5. Показать все задачи, сгруппированные по датам
                        6. Показать удаленные задачи
                        0. Выход
                        """
        );
    }
}