package weka;

import java.util.ArrayList;
import java.util.Collections;

import weka.core.Instances;

public class Top5Artikel {
	private static String article;
	private static String[] articleA = null;
	private static ArrayList<Daten> top5  = new ArrayList();
	private String criteria;
	private int criteriaIndex;
	private Instances alleDaten;
	
	public Top5Artikel(Instances i) {
		alleDaten = i;
	}
	
	
	public void setCriteria(String c) {
		criteria = c;
		criteriaIndex = alleDaten.attribute(criteria).index();
	}
	
	
	public ArrayList analyzeCriteria() {
		String[] attributes = getAttributes(alleDaten.attribute(criteriaIndex).toString());
		ArrayList<String> analyse = new ArrayList();
		for(int i=0;i<attributes.length;i++) {
			analyse.add('"'+attributes[i]+'"'+ "||"+analyze(attributes[i]));
		}
		
		
		return analyse;
	}
	
	
	public static String[] getAttributes(String s) {	
		
		s = s.substring(s.indexOf("{")+1, s.indexOf("}"));
		if(s.contains("'")) {
			s= s.replace("'", "");
		}
		
		return s.split(",");
		
		
	}
	
	
	public String analyze(String criteria) {
		reset();
		
		
		for(int i = 7; i<alleDaten.numAttributes();i++) {
			
			article = alleDaten.attribute(i).toString();
			
			if(article.contains("'")) {
				articleA = article.split("'");
				
			}else {
				articleA = article.split(" ");
			}
			
			int counter=0;
			
			for(int j=0;j<alleDaten.numInstances();j++) {
				//System.out.println(j + " " +alleDaten.get(j).stringValue(criteriaIndex));
				
				if(criteria.equals("") || alleDaten.get(j).stringValue(criteriaIndex).equals(criteria)) {
					counter += alleDaten.get(j).value(i);
				}
					
			}
			
			//System.out.println(articleA[1]);
			//System.out.println("i"+i);
			//System.out.println(counter);
			top5.add(new Daten(articleA[1], counter));
			
		}
		
	
		
	
		Collections.sort(top5, Collections.reverseOrder());
	
		return toString();
	}

	
	public String toString() {
		String returnString;
		int size =0;
		
		
		if(top5.size()>5) {
			size = 5;
		}else {
			size = top5.size();
		}
		
		returnString = "[";
		for(int i = 0; i < size;i++) {
			returnString += '"' + top5.get(i).getInhalt() + '"'; 
			
			if(i < size-1) {
				returnString += ",";
			}else {
				returnString += "]";
			}
		}
		
		returnString += "|[";
		
		for(int i = 0; i <size;i++) {
			returnString += top5.get(i).getWert(); 
			
			if(i <size-1) {
				returnString += ",";
			}else {
				returnString += "]";
			}
		}
	
		return returnString;
	}
	
	public void reset() {
		top5.clear();
	}
	
	
}
