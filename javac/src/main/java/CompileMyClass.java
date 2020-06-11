import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;


public class CompileMyClass {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        int result = compiler.run(null, null, null, "/Users/richard/Unreachable.java");
//        int result = compiler.run(null, null, null, "/Users/richard/MyClass3.java");

        //把需要编译的java文件放到你的工作目录下。
        int result = compiler.run(null, null, null, "ByteCode.java");

//        int result = compiler.run(null, null, null, "MyClass.java");
//        int result = compiler.run(null, null, null, "RefResolve.java");

//        int result = compiler.run(null, null, null, "ParamTypeInfer.java");
//        int result = compiler.run(null, null, null, "ConstFold.java");

        System.out.println("Compile result code = " + result);
    }
}
