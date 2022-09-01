package launcher;
import entity.City;
import entity.Edge;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Application {
    public static ArrayList<City> func (ArrayList<City> cities, String from, String to ) {
        City fromm = cities.get(0);
        City too = cities.get(0);

        ArrayList<Integer> val = new ArrayList<>();
        for (int i=0;i<cities.size();i++)
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
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<City> res = new ArrayList<>();
        int min1 = val.get(0), min2 = 0;
        ArrayList<City> way = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        int nextIndex =fromm.getNum()-1;

        for (int j = 0;j<cities.size()-1;j++) {
            way.add(fromm);
            for (int i = 0;i<fromm.getWays().size();i++)
                val.set(fromm.getWays().get(i).getTo()-1, fromm.getWays().get(i).getDistance() + min2);
            temp.add(val.get(too.getNum()-1));

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
            for (City i:cities)
                if (i.getNum()-1==nextIndex)
                    fromm = i;

        }
        int ttt = Collections.min(temp);
        int ind = temp.indexOf(ttt);
        for (int i =0;i<ind+1;i++) {
            res.add(way.get(i));
        }
        res.add(too);
        return res;
    }

    public static void main(String[] args)  {
        try (FileChannel channel = (FileChannel) Files.newByteChannel(Paths.get("data.txt"))) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            String from = "", to = "";

            int cityCount = Character.getNumericValue((char)buffer.get(0));
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



            ArrayList<City> res = func(cities, from, to);
            for (City c: res)
                System.out.println(c.getName());

        } catch (IOException exception) {
            System.out.println("Input/Output Exception!!!");
        }
    }
}