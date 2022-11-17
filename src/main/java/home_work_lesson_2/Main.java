package home_work_lesson_2;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"1", "2", "3", "4"}, {"2", "2", "2", "1"}, {"3", "3", "3", "2"}, {"4", "4", "4", "3"}};
        try {
            try {
                int result = checkMethod(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println(e.getMessage());;
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Некорректные данные массива");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }

    }
    public static int checkMethod(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }
}
