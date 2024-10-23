package utils;

import java.util.Scanner;

/*
Inputters là 1 cái khuông nhưng kh dùng để đúc ra objects
mà anh dùng để class này để lưu những hàm(method) hỗ trợ cho việc nhập

*/
public class Inputter {
    //props 
    public static Scanner sc = new Scanner(System.in);
    //những method hỗ trợ cho việc nhập
    //method ép người dùng nhập số nguyên chuẩn
    public static int getAnInteger(String inpMsg, String errMsg){
        System.out.println("");//hiển thị câu mời nhập
        while(true){
            try {
                int number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    //method ép nhập số nguyên chuẩn nhưng phải ở trong khoảng yêu cầu
    public static int getAnInteger(String inpMsg, String errMsg, int lowerBound, int upperBound){
        
        if(lowerBound > upperBound){
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        System.out.println(inpMsg);//hiển thị câu mời nhập
        while(true){
            try {
                int number = Integer.parseInt(sc.nextLine());
                if(number < lowerBound || number > upperBound){
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    //method ép người dùng nhập số thực
    public static double getADouble(String inpMsg, String errMsg){
        System.out.println("");//hiển thị câu mời nhập
        while(true){
            try {
                double number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    //method ép nhập số thực chuẩn nhưng phải ở trong khoảng yêu cầu
    public static double getADouble(String inpMsg, String errMsg, double lowerBound, double upperBound){
        
        if(lowerBound > upperBound){
            double tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        System.out.println(inpMsg);//hiển thị câu mời nhập
        while(true){
            try {
                double number = Double.parseDouble(sc.nextLine());
                if(number < lowerBound || number > upperBound){
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    //Nhập chuỗi không được bỏ trống
    public static String getString(String inpMsg, String errMsg){
        System.out.println(inpMsg);
        while (true) {
            try {
                String str = sc.nextLine();
                if(str.isEmpty()){
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    //nhập chuỗi kh được để trống và đúng regex
    public static String getString(String inpMsg, String errMsg, String regex){
        System.out.println(inpMsg);
        while (true) {
            try {
                String str = sc.nextLine();
                if(str.isEmpty() || !str.matches(regex)){
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    //hàm nhập ngày tháng năm theo format
    
}
