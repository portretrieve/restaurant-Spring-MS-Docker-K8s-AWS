package com.devesh.restaurantlisting.config.aopConfig;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestaurantControllerAspect {

    //    @Before(value = "execution(* com.devesh.restaurantlisting.controller.*(..))")
//    public void beforeAdviceForController(JoinPoint joinPoint){
//        System.out.println("Request to controller layer " + joinPoint.getSignature() + "started at " + new Date());
//    }
//
//    @After(value = "execution(* com.devesh.restaurantlisting.controller.*(..))")
//    public void afterAdviceForController(JoinPoint joinPoint){
//        System.out.println("Request to controller layer " + joinPoint.getSignature() + "ended at " + new Date());
//    }

}
