package org.testtask.alex;

public class NumberToExcelColumnTransformer {
    public static String numToExcel(int index) throws IllegalArgumentException{
        if (index<1) throw  new IllegalArgumentException("Index below 1");
        StringBuffer sb = new StringBuffer();
        while (index > 0) {
            //In this number system, after "9" there is not "10", but "11"
            //index decrement fixes this part
            index--;
            sb.append((char)((index % 26) + 65));
            index = index / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int[] testNumbers = {-1, 0, 1, 2, 26, 27, 53, 150, 5000, 18279};

        for (int i : testNumbers){
            try {
                String result = numToExcel(i);
                System.out.println(i+":"+result);
            }
            catch (Exception e) {
                System.out.println(i+":incorrect argument");
            }
        }
    }
}
