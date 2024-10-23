package data;


public class Cat extends Pet{
    private String ribbon;
    //constructor

    public Cat(String id, String owner,
            String color, double weight, String ribbon) {
        super(id, owner, color, weight);
        this.ribbon = ribbon;
    }
    

    public String getRibbon() {
        return ribbon;
    }

    public void setRibbon(String ribbon) {
        this.ribbon = ribbon;
    }
    
    
    
    @Override
    public void showInfor() {
        String str = String.format("%4s|%-12s|%-12s|%6.2f|%s", id, owner,
                                color, weight, ribbon);
        System.out.println(str);
    }
    
    //.toString():ném chuỗi đẹp ra bên ngoài, ai thích thì xài tùy ý

    @Override
    public String toString() {
        String str = String.format("%4s|%-12s|%-12s|%6.2f|%s", id, owner,
                                color, weight, ribbon);
        return str;
    }
    
}
