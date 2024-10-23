/*
PetManagement: là 1 cái khuôn dùng để đúc ra anh quản lý danh sách thú cưng

vậy nên PetManagement: sẽ sở hữu một danh sách thú cưng (petlist) để quản lý
và thêm 1 đống method giúp xử lý danh sách này như: thêm, xóa, sửa, sắp xếp, tìm
kiếm, in,....Mình bỏ hết vào đây kh bỏ ở main nữa
*/
package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import utils.Inputter;

public class PetManagement {
    
    //PetManagement là anh quản lý danh sách, nên phải sở hữu danh sách
    ArrayList<Pet> petList = new ArrayList<>();
    //PetManagement còn lưu rất nhiều method hỗ trợ xử lý petList
    
    //method initData(); hàm nhét 2 chó 2 mèo vào petList để test code
    public void initData(){
        petList.add(new Dog("D001", "Tuấn", "red", 6.5, "I love du"));
        petList.add(new Dog("D002", "Toàn", "yellow", 2.6, "Yello"));
        petList.add(new Cat("C001", "Tùng", "nâu", 4.2, "Mỹ Diệu"));
        petList.add(new Cat("C002", "Thông", "Tím", 5.2, "Thông Tìm"));
    }
    
    //method showPetList(): hàm show danh sách thú cưng
    
    public void showPetList(){
        if(petList.isEmpty()){//nếu danh sách rỗng thì
            System.out.println("This list is empty!");//thông báo
            return;//dừng luôn
        }else{
            for (Pet item : petList) {
            item.showInfor();//in ra
            }
        }
    }
    
    //method sortPetListByWeight
    
    public void sortPetListByWeight(){
        //1. tạo ra anh trọng tài tên 'orderByWeight'
        Comparator orderByWeight = new Comparator<Pet>() {
            @Override
            public int compare(Pet t1, Pet t2) {
                //return t1.getWeight() > t2.getWeight() ? 1 : -1;
                return (int)(t1.getWeight() - t2.getWeight());
            }
        };
        //2. sau khi tạo anh trọng tài thì mình phải cài vào danh sách 
        //thông qua
        Collections.sort(petList, orderByWeight);
    }
    
//    + Hàm nhận vào id trả ra vị trí 
        public int searchPetIndexById(String keyId){
            for(int i = 0; i <= petList.size() - 1; i++){
                if(petList.get(i).getId().equals(keyId)) return i;
            }
            return -1;
        }
//    + Hàm nhận vào id trả ra pet
        public Pet searchPetById(String keyId){
            int pos = searchPetIndexById(keyId);//dùng keyId tìm vị trí
            return pos == -1 ? null : petList.get(pos);
        }
//    + Hàm xin id, thông báo kết quả (client)
    public void searchPetById(){
        //hàm đi xin keyId
        String keyId = Inputter.getString("Input petId you wanna find: ",
                                            "That field is required");
        //dựa vào keyId tìm con pet này
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet not exist");
        }else{
            System.out.println("The pet information");
            pet.showInfor();
        }
    }
    
    //hàm removePetById: hàm xin id, tìm pet và xóa
    public void removePetById(){
        //hàm đi xin keyId
        String keyId = Inputter.getString("Input petId you wanna remove: ",
                                            "That field is required");
        //dựa vào keyId tìm con pet này
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet not exist");
        }else{
            System.out.println("The pet information");
            pet.showInfor();
            petList.remove(pet);
            System.out.println("removing is successful!");
        }
    }
    
    //hàm updatePetById()
    public void updatePetById(){
        //hàm đi xin keyId
        String keyId = Inputter.getString("Input petId you wanna update: ",
                                            "That field is required");
        //dựa vào keyId tìm con pet này
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet not exist");
        }else{
            System.out.println("The pet information before updating");
            pet.showInfor();
            //cần cập nhật owner, id, weight
            System.out.println("Updating...");
            String newOwner = Inputter.getString("Input owner",
                                                    "that field is required");
            String newColor = Inputter.getString("Input color",
                                                    "that field is required");
            double newWeight = Inputter.getADouble("Input weight",
                                                    "that field is required", 1, 100);
            //dog thì có necklace, mèo thì có ribbon
            pet.setOwner(newOwner);
            pet.setColor(newColor);
            pet.setWeight(newWeight);
            if(pet instanceof Dog){
                String newNecklace = Inputter.getString("Input necklace",
                                                            "that field is required");
                ((Dog)pet).setNecklace(newNecklace);
            }else{
                String newRibbon = Inputter.getString("Input ribbon", 
                                                        "that field is required");
                ((Cat)pet).setRibbon(newRibbon);
            }
            System.out.println("Updating is successful");
        }
    }
    
    //method addNewDog(): thêm một con chó
    public void addNewDog(){
        //thu thập thông tin để đúc con chó
        boolean isDup;
        String id;
        do{
            isDup = false;//ban đầu in là không trùng
            id = Inputter.getString("Input yout dogId",
                                        "your id isn't mached DXXX!!",
                                        "[dD]\\d{3}").toUpperCase();
            Pet pet = searchPetById(id);
            if(pet != null){
                isDup = true;
                System.out.println("Id has been used");
            }
        }while(isDup);
        //nhập thông tin còn lại
        String owner = Inputter.getString("Input owner",
                                                    "that field is required");
        String color = Inputter.getString("Input color",
                                                    "that field is required");
        double weight = Inputter.getADouble("Input weight",
                                                    "that field is required", 1, 100);
        String necklace = Inputter.getString("Input necklace",
                                                    "that field is required");
        Dog nDog = new Dog(id, owner, color, weight, necklace);
        petList.add(nDog);
        System.out.println("Adding is successful");
            
    }
    
    public void addNewCat(){
        //thu thập thông tin để đúc con chó
        boolean isDup;
        String id;
        do{
            isDup = false;//ban đầu in là không trùng
            id = Inputter.getString("Input yout catId",
                                        "your id isn't mached DXXX!!",
                                        "[dD]\\d{3}".toUpperCase());
            Pet pet = searchPetById(id);
            if(pet != null){
                isDup = true;
                System.out.println("Id has been used");
            }
        }while(isDup);
        //nhập thông tin còn lại
        String owner = Inputter.getString("Input owner",
                                                    "that field is required");
        String color = Inputter.getString("Input color",
                                                    "that field is required");
        double weight = Inputter.getADouble("Input weight",
                                                    "that field is required", 1, 100);
        String ribbon = Inputter.getString("Input ribbon",
                                                    "that field is required");
        Cat nCat = new Cat(id, owner, color, weight, ribbon);
        petList.add(nCat);
        System.out.println("Adding is successful");              
    }
}

/*
//    1. in ra danh sách thú cưng
//    2. sắp xếp thú cưng theo trọng lượng
//    3. tìm kiếm thú cưng theo tên
          + Hàm nhận vào id trả ra vị trí 
          + Hàm nhận vào id trả ra pet
          + Hàm xin id, thông báo kết quả (client)
//    4. update thú cưng theo id
//    5. remove thú cưng theo id
//    6. Thêm mới 1 con cún
//    7. Thêm mới 1 con mèo
//    8. save file and quit
*/