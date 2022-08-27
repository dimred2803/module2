package launcher;
import entity.City;
import entity.Edge;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        try (FileChannel channel = (FileChannel) Files.newByteChannel(Paths.get("data.txt"))) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            int cityCount = Character.getNumericValue((char)buffer.get(0));
            System.out.println(cityCount);
            int j = 3;
            ArrayList<City> cities = new ArrayList<>();
            for (int i =1; i<=cityCount;i++) {
                String name = "";
                while (Character.isLetter((char)buffer.get(j))) {
                    String plus = String.valueOf((char)buffer.get(j));
                    name+=plus;
                    j++;
                }
                j+=2;
                int countNeighbours = Character.getNumericValue((char)buffer.get(j));
                j+=3;
                ArrayList<Edge> ways = new ArrayList<>();
                for (int k = 0; k < countNeighbours; k++) {
                    ways.add(new Edge(i,Character.getNumericValue((char)buffer.get(j)), Character.getNumericValue((char)buffer.get(j+2))));
                    j+=5;
                }
                cities.add(new City(name, countNeighbours, ways));
            }

        } catch (IOException exception) {
            System.out.println("Input/Output Exception!!!");
        }
    }
}
