package weka;

import java.util.ArrayList;
import java.util.Collections;

import general.*;
import weka.core.Instances;

public class Top5 {
	
	private String criteria;
	private int criteriaIndex;
	private static ArrayList<Daten> top5  = new ArrayList();
	private String[] attributes;
	private Instances alleDaten;
	
	public Top5(Instances i) {
		alleDaten = i;
	}
	
	public void setCriteria(String c) {
		criteria = c;
		criteriaIndex = alleDaten.attribute(criteria).index();
	}
	
	
	public void getTop5() {
		String[] attributes = getAttributes(alleDaten.attribute(criteriaIndex).toString());
		for(int i=0;i<attributes.length;i++) {
			top5.add(new Daten(attributes[i],0));
		}
		
		for(int i =0;i<alleDaten.size();i++) {
			checkData(alleDaten.get(i).stringValue(criteriaIndex));
		}
		
			
		Collections.sort(top5, Collections.reverseOrder());
		
		for(int i=0;i<5;i++) {
			System.out.println(top5.get(i).getInhalt() + ": " + top5.get(i).getWert());
		}
	}
	
	public static String[] getAttributes(String s) {	
		s = s.substring(s.indexOf("{")+1, s.indexOf("}"));
		if(s.contains("'")) {
			s= s.replace("'", "");
		}
		
		return s.split(",");
	}
	
	
	public void checkData(String data) {
		
		for(int i=0;i<top5.size();i++) {
			if (top5.get(i).getInhalt().equals(data)) {
				top5.get(i).setWert(top5.get(i).getWert() + 1); 
			}
		
		}
		
	}	
	
	
	public void reset() {
		top5.clear();
	}
	

}
