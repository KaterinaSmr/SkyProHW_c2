import java.util.Arrays;

public enum TaskType {
    PERSONAL(1, "Личная"), WORK(2, "Рабочая");

    private final int taskTypeId;
    private final String ruName;

    TaskType(int taskTypeId, String ruName) {
        this.taskTypeId = taskTypeId;
        this.ruName = ruName;
    }

    public static TaskType valueOf(int id){
        return Arrays.stream(TaskType.values()).filter(t -> t.taskTypeId == id).findAny().orElse(null);
    }

    @Override
    public String toString() {
        return  taskTypeId + "-" + ruName;
    }

    public static String info(){
        TaskType[] allTaskTypes = TaskType.values();
        StringBuilder sb = new StringBuilder();
        for (TaskType t:allTaskTypes) {
            sb.append(t + ", ");
        }
        return sb.substring(0, sb.length()-2);
    }

    public String getRuName() {
        return ruName;
    }
}
