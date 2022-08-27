package org.example;
import java.text.ParseException;
import java.time.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Main {
    // first format check
    public static boolean isValid1 (String s) {
        if (s==null || !s.matches("\\d{4}/[01]\\d/[0-3]\\d"))
            return false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        df.setLenient(false);
        try {
            df.parse(s);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    //second format check
    public static boolean isValid2 (String s) {
        if (s==null || !s.matches("[0-3]\\d/[01]\\d/\\d{4}"))
            return false;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        try {
            df.parse(s);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    // third format check
    public static boolean isValid3 (String s) {
        if (s==null || !s.matches("[01]\\d-[0-3]\\d-\\d{4}"))
            return false;
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        df.setLenient(false);
        try {
            df.parse(s);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    // Function for creating ArrayList of LocalDate Objects
    // (also, to delete incorrect values from input list)
    public static String func (ArrayList<String> dates) {
        ArrayList<LocalDate> result = new ArrayList<>();
        String res = "";
        String[] buf1;
        for (int i = 0; i < dates.size(); i++) {
            if (isValid1(dates.get(i))) {
                buf1 = dates.get(i).split("/");
                result.add(LocalDate.of(Integer.parseInt(buf1[0]), Integer.parseInt(buf1[1]), Integer.parseInt(buf1[2])));
                continue;
            }
            if (isValid2(dates.get(i))) {
                buf1 = dates.get(i).split("/");
                result.add(LocalDate.of(Integer.parseInt(buf1[2]), Integer.parseInt(buf1[1]), Integer.parseInt(buf1[0])));
                continue;
            }
            if (isValid3(dates.get(i))) {
                buf1 = dates.get(i).split("-");
                result.add(LocalDate.of(Integer.parseInt(buf1[2]), Integer.parseInt(buf1[0]), Integer.parseInt(buf1[1])));
                continue;
            }
            dates.remove(i);
        }
        for (LocalDate i: result) {

            if ((i.getDayOfMonth() < 10))
                res+="0"+i.getDayOfMonth();
            else
                res+=i.getDayOfMonth();
            if (i.getMonthValue()<10)
                res+="0"+i.getMonthValue() ;
            else
                res+=i.getMonthValue() + "\n";
            res+=i.getYear()+" ";
        }
        return res;
    }

    public static void main(String[] args)  {
        ArrayList<String> dates = new ArrayList<>();

        dates.add("2022/04/05");
        dates.add("05/04/2022");
        dates.add("04-05-2022");
        dates.add("19-19-2010");
        System.out.println(dates);

        String res = func(dates);

        System.out.println("----------------------------------------");
        System.out.println(res);
        System.out.println("----------------------------------------");

    }
}