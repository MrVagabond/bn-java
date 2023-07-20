package mrzj.demo.annotation;

@MyAnnotation
public class AnnotationDemo {

    public static void main(String[] args) {
        MyAnnotation myAnnotation = AnnotationDemo.class.getDeclaredAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.value());
    }

}
