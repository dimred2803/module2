package org.example;
import java.text.ParseException;
import java.time.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.example.Formats;

public class Main {
    public static SimpleDateFormat isValid (String s) {
        if (s==null || !s.matches(Formats.first.toString()) &&
                !s.matches(Formats.second.toString()) &&
                !s.matches(Formats.third.toString())) return null;
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy/MM/dd"),
                    df2 = new SimpleDateFormat("dd/MM/yyyy"),
                    df3 = new SimpleDateFormat("MM-dd-yyyy");
        df1.setLenient(false); df2.setLenient(false); df3.setLenient(false);
        try {
            if (s.matches(Formats.first.toString())) {df1.parse(s); return df1;}
            if (s.matches(Formats.second.toString())) {df2.parse(s); return df2;}
            if (s.matches(Formats.third.toString())) {df3.parse(s); return df3;}
        } catch (ParseException ex) {
            return null;
        }
        return null;
    }

    public static String func (ArrayList<String> dates) {
        ArrayList<LocalDate> result = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        String[] buf1;
        for (int i = 0; i < dates.size(); i++) {
            if (isValid(dates.get(i))==null) {dates.remove(i); continue;}
            if (isValid(dates.get(i)).toPattern().equals("yyyy/MM/dd")) {
                buf1 = dates.get(i).split("/");
                result.add(LocalDate.of(Integer.parseInt(buf1[0]), Integer.parseInt(buf1[1]), Integer.parseInt(buf1[2])));
                continue;
            }
            if (isValid(dates.get(i)).toPattern().equals("dd/MM/yyyy")) {
                buf1 = dates.get(i).split("/");
                result.add(LocalDate.of(Integer.parseInt(buf1[2]), Integer.parseInt(buf1[1]), Integer.parseInt(buf1[0])));
                continue;
            }
            if (isValid(dates.get(i)).toPattern().equals("MM-dd-yyyy")) {
                buf1 = dates.get(i).split("-");
                result.add(LocalDate.of(Integer.parseInt(buf1[2]), Integer.parseInt(buf1[0]), Integer.parseInt(buf1[1])));
            }
        }
        for (LocalDate i: result) {
            res.append(((i.getDayOfMonth() < 10)) ? "0" + i.getDayOfMonth() : i.getDayOfMonth());
            res.append((i.getMonthValue() < 10) ? "0" + i.getMonthValue() : i.getMonthValue() + "\n");
            res.append(i.getYear()).append(" ");
        }
        return res.toString();
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