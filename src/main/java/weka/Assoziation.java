package weka;

import java.util.ArrayList;

import weka.associations.Apriori;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericCleaner;
import weka.filters.unsupervised.attribute.NumericToNominal;

public class Assoziation {
	private Instances alleDaten, nurWaren;
	
	public Assoziation(Instances i) {
		alleDaten = i;
	}
	
	public String analyze() throws Exception {
		
		
		

	
		
		
		// 0 durch ? ersetzen, um für die Auswertung nur die Waren zu
		// berücksichtigen, die gekauft wurden
		NumericCleaner nc = new NumericCleaner();
		nc.setMinThreshold(1.0); // Schwellwert auf 1 setzen
		nc.setMinDefault(Double.NaN); // alles unter Schwellwert durch ?
										// ersetzen
		nc.setInputFormat(alleDaten);
		alleDaten = Filter.useFilter(alleDaten, nc); // Filter anwenden.


		// Die Daten als nominale und nicht als numerische Daten setzen
		NumericToNominal num2nom = new NumericToNominal();
		num2nom.setAttributeIndices("first-last");
		num2nom.setInputFormat(alleDaten);
		alleDaten = Filter.useFilter(alleDaten, num2nom);



		// Apriori anwenden

		// Kundendaten rausnehmen, nur Warenkörbe stehen lassen
		nurWaren = new Instances(alleDaten);
		for (int i = 0; i < 7; i++) {
			nurWaren.deleteAttributeAt(0); // ein einzelnes Attribut rausnehmen
		}

		
		Apriori model = new Apriori();
		Apriori warenModel = new Apriori();

		warenModel.setNumRules(5); // die besten drei Ergebnisse

		model.buildAssociations(alleDaten);
		warenModel.buildAssociations(nurWaren);
		
		//System.out.println(model);
		//System.out.println(warenModel);
		
		//System.out.println(warenModel.toString());
		return toString(warenModel.toString());

	}
	
	
	public String toString(String s) {
		String returnString="";
		
		s = s.substring(s.indexOf("1."), s.length());

		
		
		String[] zeilen = s.split("\n");
		returnString = "[";
		for(int i = 0; i<zeilen.length;i++) {
			zeilen[i]= zeilen[i].replace("=1", ",");
			zeilen[i]= zeilen[i].replace("==>", " , ");
			String wert = zeilen[i].substring(zeilen[i].indexOf("(")+3, zeilen[i].indexOf(")"));
			zeilen[i]  = zeilen[i].replace(zeilen[i].substring(zeilen[i].indexOf("<"), zeilen[i].length()), "");
			zeilen[i] = zeilen[i].replace(zeilen[i].substring(0,zeilen[i].indexOf(".")+1), "");
			zeilen[i] = zeilen[i].trim();
			
			zeilen[i] = zeilen[i] + " , " + wert;
			zeilen[i] = zeilen[i].replace(" ", "");
			
			
			returnString += zeilen[i];
			if(i <zeilen.length-1) {
				returnString += "|";
			}

		}
		
		
		returnString += "]";
		
		
		
		return returnString;
	}
}
