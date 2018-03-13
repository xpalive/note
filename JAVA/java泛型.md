### 泛型在静态方法和静态类中的问题

泛型类中的静态方法和静态变量不可以使用泛型类所声明的泛型类型参数
```text
public class Test2<T> {    
    public static T one;   //编译错误    
    public static  T show(T one){ //编译错误    
        return null;    
    }    
}    
```
>因为泛型类中的泛型参数的实例化是在定义对象的时候指定的，而静态变量和静态方法不需要使用对象来调用。对象都没有创建，如何确定这个泛型参数是何种类型，所以当然是错误的。

但是要注意区分下面的一种情况：
```text
public class Test2<T> {    
    
    public static <T >T show(T one){//这是正确的    
        return null;    
    }    
}    
```
因为这是一个泛型方法，在泛型方法中使用的T是自己在方法中定义的T，而不是泛型类中的T。