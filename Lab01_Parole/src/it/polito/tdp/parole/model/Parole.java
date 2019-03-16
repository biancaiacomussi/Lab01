package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Parole implements Comparator<String>{
	
	List <String > parole;
		
	public Parole() {
		parole = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public void cancellaParola(String p) {
		parole.remove(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);
		return parole;
	}
	
	public boolean presente(String p) {
		for(String s : parole) {
			if(s.equals(p))
				return true;

		}
		
		return false;
		
	}
	
	public String elencoAlfabetico() {
		
		String ris = "";
		Collections.sort(parole);
		for(String s : parole) {
			ris += s+"\n";
		}
		
		return ris;
		
	}
	
	public void reset() {
		parole.clear();
	}

	
	@Override
	public int compare(String s1, String s2) {
		
		return s1.compareTo(s2);
	}

}
