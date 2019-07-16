public class TimeSheet {

    private int startHours;
    private int bedTimeHours;
    private int endHours;

    public TimeSheet(final int startHours, final int bedTimeHours, final int endHours) {
        this.startHours = startHours;
        this.bedTimeHours = bedTimeHours;
        this.endHours = endHours;
    }

    public int getStartHours() {
        return startHours;
    }

    public int getBedTimeHours() {
        return bedTimeHours;
    }

    public int getEndHours() {
        return endHours;
    }
}
