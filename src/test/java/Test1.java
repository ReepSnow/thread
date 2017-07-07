import org.junit.Test;

/**
 * Created by Administrator on 2017/7/4.
 */
public class Test1 {

    @Test
    public void test1(){
        String foreignName = "Men's The Rail Graphic T-Shirt, Size XX-Large - Blue";
        String color = "Lavender festival 79 graphic";
        String isColor = foreignName.substring(foreignName.lastIndexOf("-")+1).trim();
        if(color.startsWith(isColor)){
            System.out.println(foreignName.substring(0,foreignName.lastIndexOf(isColor)).concat(color));
        }else {
            System.out.println(foreignName.concat(" "+color));
        }
    }
}
