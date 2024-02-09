package com.devesh.restaurantlisting.config.aopConfig;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestaurantServiceAspect {
    //Every Method in this class is called an Advice

    //Point cut expression below which says that please before
    //All RestaurantService methods with any return types and any input arguments
//    @Before(value = "execution(* com.devesh.restaurantlisting.service.*(..))")
//    public void beforeAdviceForService(JoinPoint joinPoint) {
//        System.out.println("Request to Service layer " + joinPoint.getSignature() + "started at " + new Date());
//    }
//
//    @After(value = "execution(* com.devesh.restaurantlisting.service.*(..))")
//    public void afterAdviceForService(JoinPoint joinPoint) {
//        System.out.println("Request to Service layer " + joinPoint.getSignature() + "ended at " + new Date());
//    }
//
//    @AfterReturning(value = "execution(* com.devesh.restaurantlisting.service.createRestaurant(..))", returning = "restaurantDTO")
//    public void afterReturningAdviceForAddRestaurant(JoinPoint joinPoint, RestaurantDTO restaurantDTO) {
//        System.out.println("Save restaurant Logic ran successfully and saved restaurantDTO: " + restaurantDTO.getName());
//    }
//
//    @AfterThrowing(value = "execution(* com.devesh.restaurantlisting.service.createRestaurant(..))", throwing = "e")
//    public void afterThrowingAdviceForForAddRestaurant(JoinPoint joinPoint, Exception e) {
//        System.out.println("Save Restaurant service method threw exception: " + e.getMessage());
//    }
//
//    @Around(value = "execution(* com.devesh.restaurantlisting.service.createRestaurant(..))")
//    public RestaurantDTO aroundAdviceForCreateRestaurantService(ProceedingJoinPoint joinPoint){
//        System.out.println("Inside Around Advice in Aspect: Business Logic started to save Restaurant at " + new Date());
//        try{
//            return (RestaurantDTO) joinPoint.proceed();
//        }catch (Throwable e){
//            System.out.println("Inside Around Advice in Aspect: Exception thrown: " + e.getMessage());
//        }
//        System.out.println("Inside Around Advice in Aspect: Business Logic  to save Restaurant ended at " + new Date());
//        return null;
//    }

}
