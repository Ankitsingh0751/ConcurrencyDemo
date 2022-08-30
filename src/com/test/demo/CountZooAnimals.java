package com.test.demo;
import java.util.*;
    import java.util.concurrent.*;
    public class CountZooAnimals {
       public static int performCount(int animal) {
         return animal;
       }
       public static void printResults(Future<?> f) {
          try {
             System.out.println(f.get(1, TimeUnit.SECONDS)); // o1
          } catch (Exception e) {
             System.out.println("Exception!");
          }
       }
       public static void main(String[] args) throws Exception {
          ExecutorService s = null;
          final var r = new ArrayList<Future<?>>();
          try {
             s = Executors.newSingleThreadExecutor();
             for(int i = 0; i < 10; i++) {
                final int animal = i;
                r.add(s.submit(() -> performCount(animal))); // o2
             }
             r.forEach(f -> printResults(f));
          } finally {
             if(s != null) s.shutdown();
          } } }