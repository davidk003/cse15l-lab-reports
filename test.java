import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;  
import java.util.Date;  

public class test {
    public static void main(String[] args) {
        ArrayList test = new ArrayList<>();
        test.add("test");
        test.add("test");
        test.add("test");
        test.add("test2");
        test.add("test1");
        test.add("test");
        int count = 0;
        //System.out.println(test);
        while(test.contains("test"))
        {
            test.remove("test");
            count++;
        }
        System.out.println(new Date(System.currentTimeMillis()));
        //System.out.println(count);
    }
}
