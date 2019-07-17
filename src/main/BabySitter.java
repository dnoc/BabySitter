public class BabySitter {

    private static int MIDNIGHT = 12;

    public static void main(String[] args) {

    }

    public static int calculateWage(final int startTime, final int bedTime, final int endTime) {

        if (startTime > 11 || startTime < 5) {
            return -1;
        }
        else if (endTime < startTime || endTime > 16) {
            return -1;
        }
        else if (startTime > bedTime || bedTime > endTime) {
            return -1;
        }

        final TimeSheet timeSheet = calculateTimeSheet(startTime, bedTime, endTime);
        return calculatePay(timeSheet);
    }

    private static TimeSheet calculateTimeSheet(final int startTime, final int bedTime, final int endTime) {
        final int startToBedHours;
        final int bedTimeHours;
        final int midnightToEndHours;

        if (bedTime < MIDNIGHT && endTime <= MIDNIGHT) {
            startToBedHours = bedTime - startTime;
            bedTimeHours = endTime - bedTime;
            midnightToEndHours = 0;
        } else if (bedTime >= MIDNIGHT) {
            startToBedHours = MIDNIGHT - startTime;
            bedTimeHours = 0;
            midnightToEndHours = endTime - MIDNIGHT;
        } else if (startTime >= MIDNIGHT) {
            startToBedHours = 0;
            bedTimeHours = 0;
            midnightToEndHours = endTime - startTime;
        } else {
            startToBedHours = bedTime - startTime;
            bedTimeHours = MIDNIGHT - bedTime;
            midnightToEndHours = endTime - MIDNIGHT;
        }

        return new TimeSheet(startToBedHours, bedTimeHours, midnightToEndHours);
    }

    private static int calculatePay(final TimeSheet timeSheet) {
        final int startPay = timeSheet.getStartHours() * PayRates.START_TO_BED;
        final int bedTimePay = timeSheet.getBedTimeHours() * PayRates.BED_TO_MIDNIGHT;
        final int endPay = timeSheet.getEndHours() * PayRates.MIDNIGHT_TO_END;

        return startPay + bedTimePay + endPay;
    }
}
