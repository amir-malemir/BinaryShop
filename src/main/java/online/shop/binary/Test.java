package online.shop.binary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Test {

    private String name;

    public static void main(String[] args) {

        Test user = new Test();

        user.setName("Ali");

        System.out.println(user.getName());
    }
}

//package online.shop.binary;
//
//public class Test {
//
//    private String name;
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public static void main(String[] args) {
//        Test user = new Test();
//
//        user.setName("Ali");
//
//        System.out.println(user.getName());
//    }
//}