package ui;

import java.util.ArrayList;
import utils.Inputter;

/*
menu: là 1 cái khuôn chuyên tạo ra các anh quản lý menu
có: danh sách các lựa chọn 'optionList'
có: tên của menu 'tittle'
có: những hàm thao tác với optionList
// thêm 1 option vào optionList
// hiển thị danh sách optionList
// hàm thu thập lựa chọn của người dùng

*/
public class Menu {
    //mảng lưu các lựa chọn
    public ArrayList<String> optionList = new ArrayList<>();
    public String tittle;// tên của menu
    //constructor

    public Menu(String tittle) {
        this.tittle = tittle;
    }
    //hàm addNewOption: thêm 1 option cho danh sách options
    public void addNewOption(String newOption){
        optionList.add(newOption);
    }
    //hàm print: hiển thị danh sách options kèm số phía trước
    public void print(){
        int count = 1;
        System.out.println("_____________"+tittle+"_____________");
        for (String op : optionList) {
            System.out.println(count + "." + op);
            count++;
        }
    }
    
    //hàm getChoice: thu thập lựa chọn của người dùng cho anh
    public int getChoice(){
        int choice = Inputter.getAnInteger("Input your choice: ", 
                         "Your choice must between 1 and " + optionList.size(),
                         1, optionList.size());
        return choice;
    }
    
    
    
}
