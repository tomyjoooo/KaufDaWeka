package weka;


/* Beispielprogramm, um WeKa (Apriori) in eclipse zu verwenden.

 Die Rohdaten liegen im CSV-Format vor. WeKa benötigt das arff-Format.

 Die Rohdaten enthalten die folgenden 24 Attribute,
 0..4  Kundendaten
 5..6  Einkaufsverhalten
 7..23 gekaufte Waren

 Hier sind  nur ein paar Beispiele zu sehen, wie man die Assoziationsanalyse verwenden kann.
 Weitere Einstellungen (falls nötig) selbst recherchieren!
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import weka.associations.Apriori;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.classifiers.trees.RandomTree;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericCleaner;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.supervised.attribute.AttributeSelection;

public class KaufDa {
	public static void main(String[] args) throws Exception {
		ImportExport impexp = new ImportExport();
		Instances alleDaten = impexp.loadCSV();
		String article;
		String[] articleA = null;
		ArrayList<Daten> top5  = new ArrayList();
		
		Top5 top5k = new Top5(alleDaten);
		int count=0;
		for(int i = 7; i<alleDaten.numAttributes();i++) {
			System.out.println(alleDaten.attribute(i));
			article = alleDaten.attribute(i).toString();
			
			if(article.contains("'")) {
				articleA = article.split("'");
				
			}else {
				articleA = article.split(" ");
			}
			
			System.out.println(articleA[1]);
			
			for(int j=0;j<alleDaten.numInstances();j++) {
			
				
				
			}
			//System.out.println(articleA[0]);
			
			top5.add(new Daten(article, 0));
		}
	
		

		
	
		
		
		//System.out.println(alleDaten.get(1));
		
		//System.out.println(alleDaten.get(1));
		
		
		//System.out.println(alleDaten);
		/*	
		Top5 top5k = new Top5(alleDaten);
		top5k.setCriteria("Einkaufstag");
		top5k.getTop5();
		top5k.reset();
	
		System.out.println("----------");
		top5k.setCriteria("Einkaufsuhrzeit");
		top5k.getTop5();
		top5k.reset();
		System.out.println("----------");
		top5k.setCriteria("Alter");
		top5k.getTop5();
		top5k.reset();
		
		/*
		String[] options = new String[2];
		options[0] = "-R";                                    // "range"
		options[1] = "1";                                     // first attribute
		Remove remove = new Remove();                         // new instance of filter
		remove.setOptions(options);                           // set options
		remove.setInputFormat(alleDaten);                          // inform filter about dataset **AFTER** setting options
		Instances newData = Filter.useFilter(alleDaten, remove);   // apply filter
	
		System.out.println(newData);
		*/
	}

	
	
	
	

	
	
	

	

	
}
