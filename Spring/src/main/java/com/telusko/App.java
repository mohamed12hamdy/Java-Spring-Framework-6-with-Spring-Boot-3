package com.telusko;

import com.telusko.Config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //ApplicationContext Context = new ClassPathXmlApplicationContext("beans.xml");
        //Computer x = Context.getBean(Computer.class);
        //x.Complie();

        ApplicationContext Context = new AnnotationConfigApplicationContext(AppConfig.class);
        DeskTop desktop = Context.getBean(DeskTop.class);  ///you are here pass the type
        desktop.Complie();
        DeskTop des =  Context.getBean(DeskTop.class);
        des.Complie();
        
    }
}
