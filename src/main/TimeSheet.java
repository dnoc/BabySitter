public class TimeSheet {

    private int startHours;
    private int bedTimeHours;
    private int endHours;

    public TimeSheet(final int startHours, final int bedTimeHours, final int endHours) {
        this.startHours = startHours;
        this.bedTimeHours = bedTimeHours;
        this.endHours = endHours;
    }

    public static TimeSheet buildFromShiftTimes(final int startTime, final int bedTime, final int endTime) {
        final int startToBedHours;
        final int bedTimeHours;
        final int midnightToEndHours;

        if (bedTime < Times.MIDNIGHT && endTime <= Times.MIDNIGHT) {
            startToBedHours = bedTime - startTime;
            bedTimeHours = endTime - bedTime;
            midnightToEndHours = 0;
        } else if (bedTime >= Times.MIDNIGHT) {
            startToBedHours = Times.MIDNIGHT - startTime;
            bedTimeHours = 0;
            midnightToEndHours = endTime - Times.MIDNIGHT;
        } else if (startTime >= Times.MIDNIGHT) {
            startToBedHours = 0;
            bedTimeHours = 0;
            midnightToEndHours = endTime - startTime;
        } else {
            startToBedHours = bedTime - startTime;
            bedTimeHours = Times.MIDNIGHT - bedTime;
            midnightToEndHours = endTime - Times.MIDNIGHT;
        }

        return new TimeSheet(startToBedHours, bedTimeHours, midnightToEndHours);
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
