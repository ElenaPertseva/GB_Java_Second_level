package home_work_lesson_5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args)  {

        AppData data = new AppData();
        data.setHeader(new String[]{"Value2", "Value3", "Value4"});
        data.setData(new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
        System.out.println(data);
        data.save("test.csv");
        AppData appData = new AppData("test.csv");

        System.out.println(appData);
    }
}

