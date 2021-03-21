package hackerrank.problemsolving.basic;

// string builder append = s.substring
//string builder str, start, end
public class TimeConversion {
    static String timeConversion(String s) {
        //07:05:45PM
        //07:05:45AM
        StringBuilder sb = new StringBuilder();

        int hour = Integer.parseInt(s.substring(0, 2));
        if (s.lastIndexOf("AM") > 0) {
            if (hour == 12) {
                sb.append("00");
                sb.append(s, 2, s.length() - 2);
                return sb.toString();
            } else
                return s.substring(0, 8);
        }

        if (hour == 12) return s.substring(0, 8);
        hour += 12;
        sb.append(hour);
        sb.append(s, 2, s.length() - 2);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(timeConversion("07:05:45PM"));
        System.out.println(timeConversion("12:05:45PM"));
        System.out.println(timeConversion("07:05:45AM"));
        System.out.println(timeConversion("00:05:45PM"));
    }
}
