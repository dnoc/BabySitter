public class BabySitter {

    public static void main(String[] args) {

    }

    public static int calculateWage(final int startTime, final int bedTime, final int endTime)
            throws IllegalArgumentException {

        validateHourInputs(startTime, bedTime, endTime);

        final TimeSheet timeSheet = TimeSheet.buildFromShiftTimes(startTime, bedTime, endTime);

        return calculatePay(timeSheet);
    }

    private static void validateHourInputs(final int startTime, final int bedTime, final int endTime)
            throws IllegalArgumentException {

        if (startTime > 11 || startTime < 5) {
            throw new IllegalArgumentException("Invalid Start Time");
        }
        else if (startTime > bedTime || bedTime > endTime) {
            throw new IllegalArgumentException("Invalid Bed Time");
        }
        else if (endTime < startTime || endTime > 16) {
            throw new IllegalArgumentException("Invalid End Time");
        }
    }

    private static int calculatePay(final TimeSheet timeSheet) {
        final int startPay = timeSheet.getStartHours() * PayRates.START_TO_BED;
        final int bedTimePay = timeSheet.getBedTimeHours() * PayRates.BED_TO_MIDNIGHT;
        final int endPay = timeSheet.getEndHours() * PayRates.MIDNIGHT_TO_END;

        return startPay + bedTimePay + endPay;
    }
}
