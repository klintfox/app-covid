package com.servicio.world.meter;

import java.util.ArrayList;
import java.util.List;

public class FindObjects {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		 List<String> list = new ArrayList<>();
	        list.add("Java");
	        list.add("Kotlin");
	        list.add("Clojure");
	        list.add("Groovy");
	        list.add("Scala");

	        for (int i = 0; i < list.size(); i++) {
				if(list.get(i).toString().equals("Java"));
				list.remove(i);
				break;
			}

	        System.out.println(list.toString());

	}

}
