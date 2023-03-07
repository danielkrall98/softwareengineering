package composite;

import java.io.File;
import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) throws Exception {

        ItemManager manager = new ItemManager();
        manager.readXml(new FileInputStream(new File("src\\test\\input.xml")));
        
        System.out.println(manager.getPrice("root"));
        System.out.println(manager.getPrice("B2"));

        
        System.out.println(manager.changePrice("B2", 200));
        System.out.println(manager.getPrice("B2"));

        
        System.out.println(manager.changePrice("B2", -200));
        System.out.println(manager.getPrice("B2"));

        
        System.out.println(manager.removeItem("B2"));
        System.out.println(manager.getPrice("B2"));
    }
}
