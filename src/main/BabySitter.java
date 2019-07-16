public class BabySitter {

    private static int MIDNIGHT = 12;
    private static int START_RATE = 12;
    private static int BED_TIME_RATE = 8;
    private static int END_RATE = 16;

    public static void main(String[] args) {

    }

    public int calculateWage(final int startTime, final int bedTime, final int endTime) {

        if (startTime > 11 || startTime < 5) {
            return -1;
        }
        else if (endTime < startTime || endTime > 16) {
            return -1;
        }
        else if (startTime > bedTime || bedTime > endTime) {
            return -1;
        }

        final int startToBedHours = bedTime - startTime;
        final int bedTimeHours = MIDNIGHT - bedTime;
        final int midnightToEndHours = endTime - MIDNIGHT;

        final int startPay = startToBedHours * START_RATE;
        final int bedTimePay = bedTimeHours * BED_TIME_RATE;
        final int endPay = midnightToEndHours * END_RATE;

        return startPay + bedTimePay + endPay;
    }
}
