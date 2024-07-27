package com.example.todoSpring.demo;


import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {
  @Before("@annotation(TimeMonitor)")
    public void logtime(){
      System.out.println("Logging Time");
  }
}

