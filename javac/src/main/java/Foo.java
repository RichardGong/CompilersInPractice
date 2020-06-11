/**
 * 测试HelloWold注解。
 * HelloFoo是在处理完注解以后才生成的。
 */
@HelloWorld
public class Foo {
    static HelloFoo helloFoo = new HelloFoo();
    public static void main(String args[]){
        helloFoo.sayHello(); //HelloFoo类是处理完注解后才生成的。
    }
}
