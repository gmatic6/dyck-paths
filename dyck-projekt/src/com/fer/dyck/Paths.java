package com.fer.dyck;

import java.util.Iterator;
import java.util.TreeSet;

public class Paths {

	public static TreeSet<String> set1 = new TreeSet<String>();
	public static TreeSet<String> set2 = new TreeSet<String>();
	public static Integer index;
	public static Integer naranaya;

	public static void start(Integer n, String txt, Boolean motzkin) {
		Integer kUlaz = Integer.parseInt(txt);
		index = 0;
		set1.clear();
		int x = 0;
		Integer k = 0;
		
		if (motzkin == false){
			generator("", 2*n, motzkin);
		} else {
			generator("", n, motzkin);
		}
		
		for (Iterator<String> i = set1.iterator(); i.hasNext();) {
			String element = i.next();
			for (int r = 0; r < element.length(); r++) {
				Character c = element.charAt(r);
				if (c == ')') {
					x--;
				} else if (c == '(') {
					x++;
				}
				if (x < 0)
					break;
			}
			if (x != 0) {
				i.remove();
				x = 0;
			}
		}
		//counting peaks
		if (kUlaz != 0) {
			set2.addAll(set1);
			set1.clear();
			for (Iterator<String> i = set2.iterator(); i.hasNext();) {
				String element = i.next();
				for (int r = 0; r < element.length() - 1; r++) {
					Character c1 = element.charAt(r);
					Character c2 = element.charAt(r + 1);
					if ((c1 == '(') && (c2 == ')')) {
						k++;
					}
				}
				if (k.equals(kUlaz)) {
					set1.add(element);
				}
				k = 0;
			}
			set2.clear();
			if (motzkin == false){
				naranaya = (int) (((binomial(n, kUlaz)*binomial(n, kUlaz-1)))/n);
			}
		}
	}

	private static long binomial(int n, int k){
        if (k > n-k) k = n-k;
        long b = 1;
        for (int i = 1, m = n; i <= k; i++, m--)
            b = b*m/i;
        return b;
    }
	
	private static void generator(String string, int length, Boolean motzkin){
		if (length <= 0){
			set1.add(string);
			return;
		}
		generator(string + "(", length-1, motzkin);
		generator(string + ")", length-1, motzkin);
		if (motzkin == true){
			generator(string + "-", length-1, motzkin);
		}
		
	}
}
