
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
*                           异   常
*一、异常的基本用法
* 1、捕获异常
        try{
         有可能出现异常的语句 ;
        }[catch (异常类型 异常对象) {
        } ... ]
        [finally {
         异常的出口
        }]
*
*   try 代码块中放的是可能出现异常的代码.
    catch 代码块中放的是出现异常后的处理行为.
    finally 代码块中的代码用于处理善后工作, 会在最后执行.
    其中 catch 和 finally 都可以根据情况选择加或者不加
*
    程序先执行 try 中的代码
    如果 try 中的代码出现异常, 就会结束 try 中的代码, 看和 catch 中的异常类型是否匹配.
    如果找到匹配的异常类型, 就会执行 catch 中的代码
    如果没有找到匹配的异常类型, 就会将异常向上传递到上层调用者.
    无论是否找到匹配的异常类型, finally 中的代码都会被执行到(在该方法结束之前执行).
    如果上层调用者也没有处理的了异常, 就继续向上传递.
    一直到 main 方法也没有合适的代码处理异常, 就会交给 JVM 来进行处理, 此时程序就会异常终止.
*
* 2、抛出异常
* 以使用 throws 关键字, 把可能抛出的异常显式的标注在方法定义的位置. 从而提醒调用者要注意捕获这些异常
    public static int divide(int x, int y) throws ArithmeticException {
     if (y == 0) {
     throw new ArithmeticException("抛出除 0 异常");
     }
     return x / y;
    }
   用 throw 关键字 手动抛出异常
    public static void main(String[] args) {
     System.out.println(divide(10, 0));
    }
    public static int divide(int x, int y) {
     if (y == 0) {
     throw new ArithmeticException("抛出除 0 异常");
     }
     return x / y;
    }

3、自定义异常
*   自定义异常通常会继承自 Exception 或者 RuntimeException
    继承自 Exception 的异常默认是受查异常
    继承自 RuntimeException 的异常默认是非受查异常.
* */




class Person implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

public class TestDome {

    public static void main(String[] args) {
        try {
            System.out.println(readFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String readFile() throws FileNotFoundException {
        // 尝试打开文件, 并读其中的一行.
        File file = new File("d:/test.txt");
        // 使用文件对象构造 Scanner 对象.
        Scanner sc = new Scanner(file);
        return sc.nextLine();
    }

    public static void func3(int x,int y) throws ArithmeticException{
        if(y == 0) {
            //程序员 想自己手动抛出异常--》一般情况：手动抛出的都是自定义异常
            throw new ArithmeticException("你给的y == 0 不能作为除数！");
        }
        System.out.println(x/y);
    }
    /**
     * 抛出异常：
     * @param args
     */
    public static void main6(String[] args) {
        try {
            func3(10,0);
        }catch (ArithmeticException e) {
            System.out.println("除数为0！");
        }
    }


    //throws   声明一个异常，告诉程序员 调用此方法 需要处理异常的
    public static void func2() throws ArrayIndexOutOfBoundsException{
        int[] array = {1,2,3,4,5,6};
        System.out.println(array[100]);
    }

    public static void main5(String[] args) {
        try {
            func2();
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界异常");
        }

    }


    public static int func() {
        try {
            int a = 10/0;
            return a;
        }catch (ArithmeticException e) {
            System.out.println("捕获数组越界异常！");
            return 80;
        }finally {
            System.out.println("finally被执行了！");
            return 19;
        }
    }
    /**
     * finally的注意事项：
     *   特性：finally当中的代码是肯定会被执行的
     *   1、finally当中的代码是肯定会被执行的 不管是否发生异常
     *   2、finally当中千万不要写 return语句
     *   3、用于资源的释放
     *
     * @param args
     */
    public static void main4(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(n);
        } catch (InputMismatchException e) {
            System.out.println("输入参数不匹配！");
        }
        /*int ret = func();
        System.out.println(ret);*/
    }

    public static void main3(String[] args) {
        try {
            int[] array = {1,2,3,4,5,6};
            System.out.println(array[1]);
            System.out.println("after");
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获数组越界异常！");
        }finally {
            System.out.println("finally被执行了！");
        }
        System.out.println("异常处理完了");
    }


    public static void main2(String[] args) {
        try {
            int[] array = {1,2,3,4,5,6};
            //array = null;
            System.out.println(array[1000]);
            System.out.println("gaobo");
        }catch (Exception e) {
            e.printStackTrace();
        }
        /*catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            //e.printStackTrace();
            System.out.println("捕获了NullPointerException 异常!");
        }*//*catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获数组越界异常！");
        }*/
        System.out.println("===========================");
    }

    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person2 = (Person) person.clone();
    }
}