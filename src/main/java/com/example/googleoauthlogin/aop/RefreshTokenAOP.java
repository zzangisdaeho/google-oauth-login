package com.example.googleoauthlogin.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class RefreshTokenAOP {

    @AfterThrowing("@annotation(RefreshTokenAnnotation)")
    public void getRefreshToken(JoinPoint joinPoint){
        System.out.println("======================AOP 들어옴===================");
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        Class[] objects = Arrays.stream(args).map(i -> i.getClass()).collect(Collectors.toList()).toArray(Class[]::new);


        Class targetClass = joinPoint.getTarget().getClass();

//        ========

        //refresh logic


//        ---------

        Method[] declaredMethods = targetClass.getDeclaredMethods();


        Method method = null;
        try {
            method = targetClass.getMethod(methodName, objects);
            System.out.println("=================");
            TokenRefreshService tokenRefreshService = new TokenRefreshService();
            method.invoke(tokenRefreshService, 3, "3");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
