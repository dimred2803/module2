package launcher;
import entity.City;
import entity.Edge;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Application {
    public static void func (ArrayList<City> cities, ArrayList<Integer> val, City fromm, City too ) {
        ArrayList<Integer> temp = new ArrayList<>();
        int min1 = val.get(0), min2 = 0;
        ArrayList<City> way = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        int nextIndex =fromm.getNum()-1;

        for (int j = 0;j<cities.size()-1;j++) {
            way.add(fromm);

            for (int i = 0;i<fromm.getWays().size();i++)
                val.set(fromm.getWays().get(i).getTo()-1, fromm.getWays().get(i).getDistance() + min2);
            temp.add(val.get(too.getNum()-1));
            System.out.println(val);

            min1 = val.get(0);
            min2 = Integer.MAX_VALUE;
            for (int i =0;i<val.size();i++)
                if (val.get(i) < min1 ) {
                    min2 = min1;
                    min1 = val.get(i);

                } else if (val.get(i)< min2 && val.get(i) != min1)
                    min2 = val.get(i);

            nextIndex = val.indexOf(min2);
            indexes.add(nextIndex);
            System.out.println(min2 + " " + nextIndex);

            //System.out.println(nextIndex);
            for (City i:cities)
                if (i.getNum()-1==nextIndex) {
                    fromm = i;
                }


        }
        System.out.println(indexes);
        int ttt = Collections.min(temp);
        System.out.println(ttt);
        int ind = temp.indexOf(ttt);
        System.out.println(ind);
        //way.add(too);
        for (int i =0;i<ind+1;i++)
        {
            System.out.println(way.get(i).getName());
        }
        System.out.println(too.getName());



    }

    public static void main(String[] args)  {
        try (FileChannel channel = (FileChannel) Files.newByteChannel(Paths.get("data.txt"))) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            ArrayList<ArrayList<Integer>> finalWay = new ArrayList<>();
            String from = "", to = "";

            int cityCount = Character.getNumericValue((char)buffer.get(0));
            System.out.println(cityCount);
            int j = 3;

            ArrayList<City> cities = new ArrayList<>();
            for (int i =1; i<=cityCount;i++) {
                String name = "";
                while (Character.isLetter((char)buffer.get(j))) {
                    String plus = String.valueOf((char)buffer.get(j));
                    name+=plus;
                    j+=1;
                }
                j+=2;
                int countNeighbours = Character.getNumericValue((char)buffer.get(j));
                j+=3;
                ArrayList<Edge> ways = new ArrayList<>();
                for (int k = 0; k < countNeighbours; k++) {
                    ways.add(new Edge(i,Character.getNumericValue((char)buffer.get(j)),
                            Character.getNumericValue((char)buffer.get(j+2))));
                    j+=5;
                }
                if (i == cityCount) {
                    while (Character.isLetter((char)buffer.get(j))) {
                        String plus = String.valueOf((char)buffer.get(j));
                        from+=plus;
                        j+=1;
                    }
                    j+=1;
                    while (Character.isLetter((char)buffer.get(j))) {
                        String plus = String.valueOf((char)buffer.get(j));
                        to+=plus;
                        j+=1;
                    }
                }
                cities.add(new City(i, name, countNeighbours, ways));
            }

            City fromm = cities.get(0);
            City too = cities.get(0);

            ArrayList<Integer> val = new ArrayList<>();
            for (int i=0;i<cityCount;i++)
                val.add(10000);

            for (City a : cities){
                if (a.getName().equals(from)) {
                    fromm = a;
                    val.set(a.getNum()-1, 0);
                    a.setSum(0);
                }
                if (a.getName().equals(to))
                    too = a;
            }
            func(cities,val, fromm, too);

        } catch (IOException exception) {
            System.out.println("Input/Output Exception!!!");
        }

    }
}