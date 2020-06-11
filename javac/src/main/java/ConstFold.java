//测试ConstFold
public class ConstFold {
    public String foo(){
        final int a = 2;          //int类型的常数
        final String b = "Hello "; //String类型的常数
        String c = b + a * 3;     //发生两次折叠
        return c;
    }
}
