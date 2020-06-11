import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sugar {
    public static void main(String args[]) {
        List a = new ArrayList();
        String b = new String();
        List<String> names = new ArrayList<String>();
        names.add("john");
        names.add("richard");
        names.add("rose");

        for (String name:names)
            System.out.println(name);

    }
}

/*
class Sugar1 {
    public static void main(String args[]) {
        List names = new ArrayList();
        names.add("john");
        names.add("richard");
        names.add("rose");

        String name;
        for (Iterator iterator = names.iterator(); iterator.hasNext(); System.out.println(name))
            name = (String)iterator.next();
    }
}
*/