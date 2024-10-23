package data;

public abstract class Pet {
    protected String id;
    protected String owner;
    protected String color;
    protected double weight;

    //constructor
    public Pet(String id, String owner, String color, double weight) {
        this.id = id;
        this.owner = owner;
        this.color = color;
        this.weight = weight;
    }
    //getter

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
    //method show infor: tạo ra một cái chuỗi đẹp, 'IN' ra cái chuỗi đó 
    //con chó thì có necklace còn mèo thì có ribbon
    //tức là cách hiển thị thông tin sẽ khác nhau, nên pet k có công thức 
    //chung cho chúng
    public abstract void showInfor();
}
