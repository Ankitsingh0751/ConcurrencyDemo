package com.test.demo;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParellelDemo {
	private static int someData(int num) {
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException ie) {
			System.out.println("interrupted");
		}
		return num;
	}
public static void main(String[] args) {
	long startTime = System.currentTimeMillis();
	Stream<Integer> s1 = List.of(1,2,3,4).stream();
	Stream<Integer> s2 =s1.parallel();
	
	
	//calling parallelStream  directly on Collection object
	
	Stream s3= List.of(1,2,3,4,5).parallelStream();
	System.out.println(s1.isParallel());
	
List.of(2,4,6,8).parallelStream().map(a->someData(a))
.forEach(p->System.out.print(p+""));
	
System.out.println();
	long endTime = System.currentTimeMillis();
	System.out.println("Time taken ="+(endTime - startTime)/1000+"seconds");
	
	System.out.println(List.of(10,20,30).stream().unordered().skip(1).findAny().get());
	
	System.out.println(List.of(4,5,6,7).parallelStream().findFirst().get());
	
	System.out.println(List.of(1,2,30,4,5,6,7).parallelStream().reduce(0, (a,b)->a+b));
	
	System.out.println(List.of('a','l','e','x').parallelStream().reduce("",
			(m,n)->{
		System.out.println("mn"+m+n);
		return m+n;
		},
			(q,r)->{System.out.println("qr"+q+r);
			
			return q+r;}
			));
			
	
	
System.out.println(List.of("a","l","e","x").parallelStream().reduce("***",String::concat));

System.out.println(List.of("a","l","e","x").stream().reduce("***",String::concat));

Stream<String> names  = List.of("mitali","hema","sanjay").parallelStream();

ConcurrentMap<Integer,String> map= names.collect(Collectors.toConcurrentMap
		(String::length,
				val->val,
				(s7,s8)->s7+""+s8));

System.out.println(map);
Stream<String> names2  = List.of("mitali","hema","sanjay").parallelStream();

ConcurrentMap<Integer,List<String>> map2 = names2.collect(
		
		Collectors.groupingByConcurrent(String::length));
		System.out.println(map2);

}}

