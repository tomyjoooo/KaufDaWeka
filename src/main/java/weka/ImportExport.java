package weka;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

public class ImportExport {
	Gson gson = new Gson();
	
	public Instances loadCSV() throws IOException {
		// Eigenen Dateipfad eintragen, nicht meinen nehmen ;-)
		String path = "C:/Users/User1/Documents/Studiengänge/Semester4/SPM/";
		String roh = path + "kd.csv";
		//String arffDat = path + "kd.arff";
		//String dateiMod = path + "kd.model.txt";
		Instances alleDaten;

		// CSV-Datei laden
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File(roh));
		alleDaten = loader.getDataSet();
		
		return alleDaten;
	}
	
	
	public String jsonExport(ArrayList daten) {
		String json = gson.toJson(daten);
		
		return json;
		
	}
	
	
	
	public ArrayList jsonImport(String json) {
		Type collectionType = new TypeToken<ArrayList<Daten>>() {}.getType();
		

		ArrayList<Daten> daten = gson.fromJson(json, collectionType);
		
		return daten;
		
	}
	
}
