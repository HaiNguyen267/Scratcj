import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\NKcomputer\\IdeaProjects\\Scratcj\\src\\dataset_91069.txt");
        Scanner scanner = new Scanner(file);

        try (Scanner sc = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + "C:\\Users\\Eco-mart\\Downloads\\dataset_91069.txt");
        }


        ArrayList<Integer> yearArr = new ArrayList<Integer>();
        ArrayList<Long> populationArr = new ArrayList<Long>();

        while (scanner.hasNext()) {
            String s = scanner.nextLine().replace("\t", " ").replace(",", "");

            String[] arr = s.split(" ");
            yearArr.add(Integer.valueOf(arr[0]));
            populationArr.add(Long.valueOf(arr[1]));


        }


        System.out.println("YearArr: " + yearArr);
        System.out.println("PopulationArr: " + populationArr);
        long maxIncrease = Long.MIN_VALUE;
        int yearWithMaxIncrease = 0;

        for (int i = 1; i < yearArr.size(); i++) {
            long increase = populationArr.get(i) - populationArr.get(i - 1);

            if (increase > maxIncrease) {
                System.out.println("here");
                maxIncrease = increase;
                yearWithMaxIncrease = yearArr.get(i);
            }
        }

        System.out.println("year with max increase: " + yearWithMaxIncrease);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".\\src\\dataset_91069.txt");
        Scanner sc = new Scanner(file);
        sc.nextLine();

        List<Integer> years = new ArrayList<Integer>();
        List<Long> populations = new ArrayList<Long>();

        // starting from the second line of the file
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");

            int year = Integer.parseInt(parts[0]);
            long population = Long.parseLong(parts[1].replace(",", ""));

            years.add(year);
            populations.add(population);
        }
        long maxIncrease = Long.MIN_VALUE;
        int yearWithMaxIncrease = 0;

        for (int i = 1; i < years.size(); i++) {
            long increase = populations.get(i) - populations.get(i-1);
            if (increase > maxIncrease) {
                maxIncrease = increase;
                yearWithMaxIncrease = years.get(i);
            }

        }
        System.out.println(yearWithMaxIncrease);
        }
    }
    

