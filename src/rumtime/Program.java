package rumtime;

import data.PetManagement;
import java.util.Scanner;
import ui.Menu;
import utils.Inputter;

public class Program {
    public static void main(String[] args) {

        PetManagement pm = new PetManagement();
        pm.initData();
            Menu menu = new Menu("Pet care system menu");
            menu.addNewOption("Add new Dog");
            menu.addNewOption("Add new Cat");
            menu.addNewOption("print pet list");
            menu.addNewOption("Search pet by id");
            menu.addNewOption("update pet by id");
            menu.addNewOption("remove pet by id");
            menu.addNewOption("sort pet order by weight");
            menu.addNewOption("save file and quit");
        
        int choice;
        while (true) {            
            menu.print();
            choice = menu.getChoice();
            switch(choice){
                case 1:{
                    pm.addNewDog();
                    break;
                }
                case 2:{
                    pm.addNewCat();
                    break;
                }
                case 3:{
                    pm.showPetList();
                    break;
                }
                case 4:{
                    pm.searchPetById();
                    break;
                }
                case 5:{
                    pm.updatePetById();
                    break;
                }
                case 6:{
                    pm.removePetById();
                    break;
                }
                case 7:{
                    pm.sortPetListByWeight();
                    break;
                }
                case 8:{
                    System.out.println("Bai bai");
                    return;
                }
                
            }
        }
        
    





























//        //test code
//        //tạo ra 1 petManagement để quản lý danh sách thú cưng
//        //nên kh cần tạo danh sách nữa
//        PetManagement pm = new PetManagement();
//        pm.initData();//nạp giá trị vào cho tao
//        pm.sortPetListByWeight();//sắp xếp đi rồi in
//        pm.showPetList();//thằng quản lí ơi, show danh sách
//        
//        //test hàm tìm kiếm vị trí
//        int pos = pm.searchPetIndexById("D003");//tìm và lưu vị trí tìm đc
//        System.out.println(pos);//in ra
//        
//        System.out.println(pm.searchPetById("D003"));
//        
//        //test search client
//        //pm.searchPetById();
//        
//        
//        //Nhập 1 số nguyên chuẩn
//          int age = Inputter.getAnInteger("Nhập tuổi nhé",
//                                            "M phải nhập tuổi chứ!", 1, 100);
//          
//          int yob = Inputter.getAnInteger("Nhập năm sinh nhé",
//                                            "M bt nhập số kh?");
//          
//          System.out.println("tuổi nè: " + age);
//          System.out.println("yob nè: " + yob);
//        
//        //method ép nhập số thực chuẩn nhưng phải ở trong khoảng yêu cầu
//        
//        
        
        
    }
}

  
    //      Viết 1 chương trình quản lý thú cưng (DOG | CAT)
//    1. Thêm mới 1 con cún
//    2. Thêm mới 1 con mèo
//    3. in ra danh sách thú cưng
//    4. tìm kiếm thú cưng theo tên
//    5. update thú cưng theo id
//    6. remove thú cưng theo id
//    7. sắp xếp thú cưng theo trọng lượng
//    8. save file and quit
//
//    khi thêm mới id của pet k được trùng với id ở trong danh sách
//    id của pet phải thỏa theo format "D001| C001"
//    một con Pet có nhửng thuộc tính owner , color, weight
//    
//    Dog: necklace
//    Cat: ribbon
//
//    yêu cầu chung: nhập chuẩn | nhập bậy bạ là chữi

