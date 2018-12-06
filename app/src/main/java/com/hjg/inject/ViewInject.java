package com.hjg.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author houjiguo
 * @data 2018/12/5 11:10
 * @description 注解
 * @Target 用于指定该注解可以声明在哪些成员上，常见的值有ElementType.FIELD和method
 * 注意：如果target值不设置，则默认可以添加在任何元素上，不推荐这么写
 * 取值	                    注解使用范围
 * METHOD	                可用于方法上
 * TYPE	                    可用于类或者接口上
 * ANNOTATION_TYPE	        可用于注解类型上（被@interface修饰的类型）
 * CONSTRUCTOR	            可用于构造方法上
 * FIELD	                可用于域上
 * LOCAL_VARIABLE	        可用于局部变量上
 * PACKAGE	                用于记录java文件的package信息
 * PARAMETER	            可用于参数上
 * @Retention 定义了该Annotation被保留的时间长短：某些Annotation仅出现在源代码中，而被编译器丢弃；
 * 而另一些却被编译在class文件中；编译在class文件中的Annotation可能会被虚拟机忽略，而另一些在class
 * 被装载时将被读取（请注意并不影响class的执行，因为Annotation与
 * class在使用上是被分离的）。使用这个meta-Annotation可以对 Annotation的“生命周期”限制。
 * 　　作用：表示需要在什么级别保存该注释信息，用于描述注解的生命周期（即：被描述的注解在什么范围内有效）
 * 　　取值（RetentionPoicy）有：
 * 　　　　1.SOURCE:在源文件中有效（即源文件保留）
 * 　　　　2.CLASS:在class文件中有效（即class保留）
 * 　　　　3.RUNTIME:在运行时有效（即运行时保留）
 * 　　Retention meta-annotation类型有唯一的value作为成员
 * @interface 是声明注解类的组合关键字
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewInject {
    public abstract int value();
}
