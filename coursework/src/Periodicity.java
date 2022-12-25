import java.time.LocalDate;
import java.util.Arrays;

public enum Periodicity {
    SINGLE(1, "Однократная"), DAILY(2, "Ежедневная"),
    WEEKLY(3, "Еженедельная"), MONTHLY(4, "Ежемесячная"),
    YEARLY(5, "Ежегодная");

    private final int periodicityId;
    private final String ruName;

    Periodicity(int periodicityId, String ruName) {
        this.periodicityId = periodicityId;
        this.ruName = ruName;
    }

    public static Periodicity valueOf(int id) {
        return Arrays.stream(Periodicity.values()).filter(t -> t.periodicityId == id).findAny().orElse(null);
    }

    public LocalDate getNextDueDate(LocalDate prevDate){
        LocalDate nextDate = switch (this){
            case SINGLE -> prevDate;
            case DAILY -> prevDate.plusDays(1);
            case WEEKLY -> prevDate.plusWeeks(1);
            case MONTHLY -> prevDate.plusMonths(1);
            case YEARLY -> prevDate.plusYears(1);
        };
        return nextDate;
    }

    @Override
    public String toString() {
        return periodicityId + "-" + ruName;
    }

    public String getRuName() {
        return ruName;
    }

    public static String info(){
        Periodicity[] allPeriodicityTypes = Periodicity.values();
        StringBuilder sb = new StringBuilder();
        for (Periodicity p:allPeriodicityTypes) {
            sb.append(p + ", ");
        }
        return sb.substring(0, sb.length()-2);
    }

}
