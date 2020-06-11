import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@SupportedAnnotationTypes("HelloWorld")
public class HelloWorldProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations){
            Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
            for (Element element : annotatedElements){
                if (element instanceof TypeElement){
                    String className = ((TypeElement) element).getQualifiedName().toString();
                    try {
                        generateClass(className);
                    }
                    catch (Exception e){

                    }

                }
            }
        }
        return true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }


    private void generateClass(String className) throws IOException {
        String packageName = null;
        int lastDot = className.lastIndexOf('.');
        if (lastDot > 0) {
            packageName = className.substring(0, lastDot);
        }

        String simpleClassName = className.substring(lastDot + 1);
        String helloSimpleClassName = "Hello" + simpleClassName;
        String helloClassName = (packageName == null)?  helloSimpleClassName : packageName + helloSimpleClassName;

        JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(helloClassName);
        try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {
            if (packageName != null) {
                out.print("package ");
                out.print(packageName);
                out.println(";");
                out.println();
            }

            out.print("public class ");
            out.print(helloClassName);
            out.println(" {");
            out.println();

            //main方法，打印出：
            //Hello 类名！
            out.println("    public static void sayHello(){");
            out.print("    System.out.println(\"Hello ");
            out.print(simpleClassName);
            out.println("!\");");
            out.println("    }");

            out.println("}");
        }
    }
}
