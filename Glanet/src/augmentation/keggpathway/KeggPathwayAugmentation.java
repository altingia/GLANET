/**
 * @author Burcak Otlu
 * Sep 20, 2013
 * 10:34:15 AM
 * 2013
 *
 * 
 */
package augmentation.keggpathway;

import enumtypes.CommandLineArguments;
import gnu.trove.map.TIntObjectMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ui.GlanetRunner;
import augmentation.humangenes.HumanGenesAugmentation;
import auxiliary.FunctionalElement;

import common.Commons;

public class KeggPathwayAugmentation {
	
	private static Map<String, List<Integer>> KEGGPathwayEntry2GeneIdListMap = null;
	private static Map<Integer, List<String>> humanGeneId2RefSeqGeneNameListMap  = null;
	private static Map<String, List<String>> humanRefSeqGeneName2AlternateGeneNameListMap = null;
	
	
	//Singleton Pattern
	public static Map<String, List<Integer>> getKEGGPathwayEntry2GeneIdListMap(String dataFolder){
		
		if(KEGGPathwayEntry2GeneIdListMap == null) {
	    	  
			KEGGPathwayEntry2GeneIdListMap = new HashMap<String, List<Integer>>();
			KeggPathwayAugmentation.fillKeggPathwayEntry2GeneIdListMap( dataFolder, KEGGPathwayEntry2GeneIdListMap);
			
	      }
	      
	      return KEGGPathwayEntry2GeneIdListMap;
	}
	
	
	//Singleton Pattern
	public static Map<Integer, List<String>> getHumanGeneId2RefSeqGeneNameListMap(String dataFolder){
		
		if(humanGeneId2RefSeqGeneNameListMap == null) {
	    	  
			humanGeneId2RefSeqGeneNameListMap = new HashMap<Integer, List<String>>();
			HumanGenesAugmentation.fillHumanGeneId2ListofRefSeqRNANucleotideAccessionMap(dataFolder,humanGeneId2RefSeqGeneNameListMap);
			
	     }
	      
	      return humanGeneId2RefSeqGeneNameListMap;
	}
	
	
	//Singleton Pattern
	public static Map<String, List<String>> getHumanRefSeqGeneName2AlternateGeneNameListMap(String dataFolder){
		
		if (humanRefSeqGeneName2AlternateGeneNameListMap == null){
			humanRefSeqGeneName2AlternateGeneNameListMap = new HashMap<String, List<String>>();
			HumanGenesAugmentation.fillHumanRefSeqRNANucleotideAccession2ListofAlternateGeneNameMap(dataFolder,humanRefSeqGeneName2AlternateGeneNameListMap);

		}
		
		return humanRefSeqGeneName2AlternateGeneNameListMap;
	}
	
	
	
	public static void fillKeggPathwayEntry2NameMap( String dataFolder, Map<String, String> entry2Name) {

		FileReader fileReader;
		BufferedReader bufferedReader;
		String strLine;
		int indexofFirstTab;
		int indexofFirstColon;

		String entry;
		String name;

		try{
			fileReader = new FileReader( dataFolder + Commons.KEGG_PATHWAY_ENTRY_2_NAME_INPUT_FILE);
			bufferedReader = new BufferedReader( fileReader);

			while( ( strLine = bufferedReader.readLine()) != null){
				// path:hsa00010 Glycolysis / Gluconeogenesis - Homo sapiens
				// (human)

				indexofFirstTab = strLine.indexOf( '\t');
				indexofFirstColon = strLine.indexOf( ':');
				entry = strLine.substring( indexofFirstColon + 1, indexofFirstTab);
				name = strLine.substring( indexofFirstTab + 1);

				entry2Name.put( entry, name);

			}// End of While

			bufferedReader.close();

		}catch( FileNotFoundException e){
			e.printStackTrace();
		}catch( IOException e){
			e.printStackTrace();
		}

	}

	public static void fillKeggPathwayEntry2GeneIdListMap( String dataFolder,
			Map<String, List<Integer>> keggPathwayEntry2GeneIdListMap) {

		String strLine;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		int indexofFirstTab = -1;
		int indexofSecondTab = -1;

		int indexofFirstColon = -1;
		int indexofSecondColon = -1;

		String keggPathwayEntry;
		Integer ncbiGeneId;

		List<Integer> existingNcbiGeneIdList = null;

		try{
			fileReader = new FileReader( dataFolder + Commons.KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE);
			bufferedReader = new BufferedReader( fileReader);

			while( ( strLine = bufferedReader.readLine()) != null){

				// example line
				// path:hsa00010 hsa:10327 reverse

				indexofFirstColon = strLine.indexOf( ':');
				indexofFirstTab = strLine.indexOf( '\t');

				keggPathwayEntry = strLine.substring( indexofFirstColon + 1, indexofFirstTab);

				indexofSecondColon = strLine.indexOf( ':', indexofFirstColon + 1);
				indexofSecondTab = strLine.indexOf( '\t', indexofFirstTab + 1);

				ncbiGeneId = Integer.parseInt( strLine.substring( indexofSecondColon + 1, indexofSecondTab));

				// Fill keggPathway2NcbiGeneIdHashMap
				// Hash Map does not contain this keggPathwayName
				if( keggPathwayEntry2GeneIdListMap.get( keggPathwayEntry) == null){

					List<Integer> ncbiGeneIdList = new ArrayList<Integer>();
					ncbiGeneIdList.add( ncbiGeneId);
					keggPathwayEntry2GeneIdListMap.put( keggPathwayEntry, ncbiGeneIdList);
				}
				// Hash Map contains this keggPathwayName
				else{
					existingNcbiGeneIdList = keggPathwayEntry2GeneIdListMap.get( keggPathwayEntry);

					if( !( existingNcbiGeneIdList.contains( ncbiGeneId))){
						existingNcbiGeneIdList.add( ncbiGeneId);
					}else{
						GlanetRunner.appendLog( "More than one ncbi gene ids for the same kegg pathway");
					}

				}

			}// End of While

			bufferedReader.close();

		}catch( FileNotFoundException e){
			e.printStackTrace();
		}catch( IOException e){
			e.printStackTrace();
		}

	}

	public static void augmentKeggPathwayNumberWithKeggPathwayEntry(
			TIntObjectMap<String> keggPathwayNumber2KeggPathwayEntryMap, List<FunctionalElement> list) {

		int keggPathwayNumber;
		String keggPathwayEntry;

		for( FunctionalElement element : list){

			keggPathwayNumber = element.getKeggPathwayNumber();
			keggPathwayEntry = keggPathwayNumber2KeggPathwayEntryMap.get( keggPathwayNumber);

			element.setKeggPathwayEntry( keggPathwayEntry);
		}

	}

	// example hsa05016
	// augment KeggPathwayEntry with KeggPathwayName
	public static void augmentKeggPathwayEntrywithKeggPathwayName( String dataFolder, List<FunctionalElement> list1,
			List<FunctionalElement> list2, List<FunctionalElement> list3) {

		Map<String, String> entry2NameMap = new HashMap<String, String>();

		String keggPathwayEntry;
		String keggPathwayName;

		List<List<FunctionalElement>> allList = new ArrayList<List<FunctionalElement>>();

		if( list1 != null){
			allList.add( list1);
		}

		if( list2 != null){
			allList.add( list2);
		}

		if( list3 != null){
			allList.add( list3);
		}

		fillKeggPathwayEntry2NameMap( dataFolder, entry2NameMap);

		for( List<FunctionalElement> list : allList){
			for( FunctionalElement element : list){

				keggPathwayEntry = element.getKeggPathwayEntry();

				keggPathwayName = entry2NameMap.get( keggPathwayEntry);
				element.setKeggPathwayName( keggPathwayName);
			}// For each element
		}// For each list
	}

	// all lists start
	// example: hsa05016
	// augment KeggPathwayEntry with KeggPathwayGeneList
	// Why I have used three lists
	public static void augmentKeggPathwayEntrywithKeggPathwayGeneList(
			String dataFolder, 
			String outputFolder,
			List<FunctionalElement> list1, 
			List<FunctionalElement> list2, 
			List<FunctionalElement> list3) {

		List<List<FunctionalElement>> allLists = new ArrayList<List<FunctionalElement>>();

		if( list1 != null){
			allLists.add( list1);
		}

		if( list2 != null){
			allLists.add( list2);
		}

		if( list3 != null){
			allLists.add( list3);
		}

		
		String keggPathwayEntry;
		List<Integer> keggPathwayGeneIdList;
		List<String> keggPathwayRefSeqGeneNameList;
		List<String> keggPathwayAlternateGeneNameList;

		KEGGPathwayEntry2GeneIdListMap = getKEGGPathwayEntry2GeneIdListMap(dataFolder);
		humanGeneId2RefSeqGeneNameListMap = getHumanGeneId2RefSeqGeneNameListMap(dataFolder);
		humanRefSeqGeneName2AlternateGeneNameListMap = getHumanRefSeqGeneName2AlternateGeneNameListMap(dataFolder);
				

		for( List<FunctionalElement> list : allLists){
			for( FunctionalElement element : list){

				keggPathwayEntry = element.getKeggPathwayEntry();

				keggPathwayGeneIdList = KEGGPathwayEntry2GeneIdListMap.get( keggPathwayEntry);

				// Initialize the lists for each element
				keggPathwayRefSeqGeneNameList = new ArrayList<String>();
				keggPathwayAlternateGeneNameList = new ArrayList<String>();

				HumanGenesAugmentation.augmentGeneIdWithRefSeqRNANucleotideAccession( keggPathwayGeneIdList,
						keggPathwayRefSeqGeneNameList, humanGeneId2RefSeqGeneNameListMap);
				HumanGenesAugmentation.augmentRefSeqRNANucleotideAccessionwithAlternateGeneName(
						keggPathwayRefSeqGeneNameList, keggPathwayAlternateGeneNameList,
						humanRefSeqGeneName2AlternateGeneNameListMap);

				element.setKeggPathwayGeneIdList( keggPathwayGeneIdList);
				element.setKeggPathwayRefSeqGeneNameList( keggPathwayRefSeqGeneNameList);
				element.setKeggPathwayAlternateGeneNameList( keggPathwayAlternateGeneNameList);
			}// For each element
		}// For each list
	}

	// all lists end

	// all lists start
	// example: GABP_hsa05016
	// augment TfNameCellLineNameKeggPathwayEntry with KeggPathwayName
	public static void augmentTfNameKeggPathwayEntrywithKeggPathwayName( String dataFolder,
			List<FunctionalElement> list1, List<FunctionalElement> list2, List<FunctionalElement> list3) {

		Map<String, String> entry2NameMap = new HashMap<String, String>();

		String keggPathwayEntry;
		String keggPathwayName;

		List<List<FunctionalElement>> allList = new ArrayList<List<FunctionalElement>>();

		if( list1 != null){
			allList.add( list1);
		}

		if( list2 != null){
			allList.add( list2);
		}

		if( list3 != null){
			allList.add( list3);
		}

		String tfName_keggPathwayEntry;
		int indexofFirstUnderscore;

		fillKeggPathwayEntry2NameMap( dataFolder, entry2NameMap);

		for( List<FunctionalElement> list : allList){
			for( FunctionalElement element : list){

				tfName_keggPathwayEntry = element.getKeggPathwayEntry();
				indexofFirstUnderscore = tfName_keggPathwayEntry.indexOf( '_');
				keggPathwayEntry = tfName_keggPathwayEntry.substring( indexofFirstUnderscore + 1);

				keggPathwayName = entry2NameMap.get( keggPathwayEntry);
				element.setKeggPathwayName( keggPathwayName);
			}// For each element
		}// For each list
	}

	// all lists start

	// all lists start
	// example: GABP_HELAS3_hsa05016
	// augment TfNameCellLineNameKeggPathwayEntry with KeggPathwayName
	public static void augmentTfNameCellLineNameKeggPathwayEntrywithKeggPathwayName( String dataFolder,
			List<FunctionalElement> list1, List<FunctionalElement> list2, List<FunctionalElement> list3) {

		Map<String, String> entry2NameMap = new HashMap<String, String>();

		String keggPathwayEntry;
		String keggPathwayName;

		List<List<FunctionalElement>> allList = new ArrayList<List<FunctionalElement>>();

		if( list1 != null){
			allList.add( list1);
		}

		if( list2 != null){
			allList.add( list2);
		}

		if( list3 != null){
			allList.add( list3);
		}

		String tfName_cellLineName_keggPathwayEntry;
		int indexofFirstUnderscore;
		int indexofSecondUnderscore;

		fillKeggPathwayEntry2NameMap( dataFolder, entry2NameMap);

		for( List<FunctionalElement> list : allList){
			for( FunctionalElement element : list){

				tfName_cellLineName_keggPathwayEntry = element.getName();
				indexofFirstUnderscore = tfName_cellLineName_keggPathwayEntry.indexOf( '_');
				indexofSecondUnderscore = tfName_cellLineName_keggPathwayEntry.indexOf( '_', indexofFirstUnderscore + 1);
				keggPathwayEntry = tfName_cellLineName_keggPathwayEntry.substring( indexofSecondUnderscore + 1);

				keggPathwayName = entry2NameMap.get( keggPathwayEntry);
				element.setKeggPathwayName( keggPathwayName);
			}// For each element
		}// For each list
	}

	// all lists start

	// all lists start
	// example: GABP_HELAS3_hsa05016
	// augment TfNameCellLineNameKeggPathwayEntry with KeggPathwayGeneList
	public static void augmentTfNameCellLineNameKeggPathwayEntrywithKeggPathwayGeneList( String dataFolder,
			String outputFolder, List<FunctionalElement> list1, List<FunctionalElement> list2,
			List<FunctionalElement> list3) {

		List<List<FunctionalElement>> allLists = new ArrayList<List<FunctionalElement>>();

		if( list1 != null){
			allLists.add( list1);
		}

		if( list2 != null){
			allLists.add( list2);
		}

		if( list3 != null){
			allLists.add( list3);
		}

		String keggPathwayEntry;
		List<Integer> keggPathwayGeneIdList;
		List<String> keggPathwayRefSeqGeneNameList;
		List<String> keggPathwayAlternateGeneNameList;

		String tfName_cellLineName_keggPathwayEntry;
		int indexofFirstUnderscore;
		int indexofSecondUnderscore;
		
		KEGGPathwayEntry2GeneIdListMap = getKEGGPathwayEntry2GeneIdListMap(dataFolder);
		humanGeneId2RefSeqGeneNameListMap = getHumanGeneId2RefSeqGeneNameListMap(dataFolder);
		humanRefSeqGeneName2AlternateGeneNameListMap = getHumanRefSeqGeneName2AlternateGeneNameListMap(dataFolder);


		for( List<FunctionalElement> list : allLists){
			for( FunctionalElement element : list){

				tfName_cellLineName_keggPathwayEntry = element.getName();
				indexofFirstUnderscore = tfName_cellLineName_keggPathwayEntry.indexOf( '_');
				indexofSecondUnderscore = tfName_cellLineName_keggPathwayEntry.indexOf( '_', indexofFirstUnderscore + 1);
				keggPathwayEntry = tfName_cellLineName_keggPathwayEntry.substring( indexofSecondUnderscore + 1);

				keggPathwayGeneIdList = KEGGPathwayEntry2GeneIdListMap.get( keggPathwayEntry);

				// Initialize the lists for each element
				keggPathwayRefSeqGeneNameList = new ArrayList<String>();
				keggPathwayAlternateGeneNameList = new ArrayList<String>();

				HumanGenesAugmentation.augmentGeneIdWithRefSeqRNANucleotideAccession( keggPathwayGeneIdList,
						keggPathwayRefSeqGeneNameList, humanGeneId2RefSeqGeneNameListMap);
				HumanGenesAugmentation.augmentRefSeqRNANucleotideAccessionwithAlternateGeneName(
						keggPathwayRefSeqGeneNameList, keggPathwayAlternateGeneNameList,
						humanRefSeqGeneName2AlternateGeneNameListMap);

				element.setKeggPathwayGeneIdList( keggPathwayGeneIdList);
				element.setKeggPathwayRefSeqGeneNameList( keggPathwayRefSeqGeneNameList);
				element.setKeggPathwayAlternateGeneNameList( keggPathwayAlternateGeneNameList);
			}
		}

	}

	// all lists end

	// all lists start
	// example: GABP_hsa05016
	// augment TfNameKeggPathwayEntry with KeggPathwayGeneList
	public static void augmentTfNameKeggPathwayEntrywithKeggPathwayGeneList( String dataFolder, String outputFolder,
			List<FunctionalElement> list1, List<FunctionalElement> list2, List<FunctionalElement> list3) {

		List<List<FunctionalElement>> allLists = new ArrayList<List<FunctionalElement>>();

		if( list1 != null){
			allLists.add( list1);
		}

		if( list2 != null){
			allLists.add( list2);
		}

		if( list3 != null){
			allLists.add( list3);
		}

		
		String keggPathwayEntry;
		List<Integer> keggPathwayGeneIdList;
		List<String> keggPathwayRefSeqGeneNameList;
		List<String> keggPathwayAlternateGeneNameList;

		KEGGPathwayEntry2GeneIdListMap = getKEGGPathwayEntry2GeneIdListMap(dataFolder);
		humanGeneId2RefSeqGeneNameListMap = getHumanGeneId2RefSeqGeneNameListMap(dataFolder);
		humanRefSeqGeneName2AlternateGeneNameListMap = getHumanRefSeqGeneName2AlternateGeneNameListMap(dataFolder);

		for( List<FunctionalElement> list : allLists){
			for( FunctionalElement element : list){

				keggPathwayEntry = element.getKeggPathwayEntry();

				keggPathwayGeneIdList = KEGGPathwayEntry2GeneIdListMap.get( keggPathwayEntry);

				// Initialise the lists for each element
				keggPathwayRefSeqGeneNameList = new ArrayList<String>();
				keggPathwayAlternateGeneNameList = new ArrayList<String>();

				HumanGenesAugmentation.augmentGeneIdWithRefSeqRNANucleotideAccession( keggPathwayGeneIdList,
						keggPathwayRefSeqGeneNameList, humanGeneId2RefSeqGeneNameListMap);
				HumanGenesAugmentation.augmentRefSeqRNANucleotideAccessionwithAlternateGeneName(
						keggPathwayRefSeqGeneNameList, keggPathwayAlternateGeneNameList,
						humanRefSeqGeneName2AlternateGeneNameListMap);

				element.setKeggPathwayGeneIdList( keggPathwayGeneIdList);
				element.setKeggPathwayRefSeqGeneNameList( keggPathwayRefSeqGeneNameList);
				element.setKeggPathwayAlternateGeneNameList( keggPathwayAlternateGeneNameList);
			}
		}

	}

	// all lists end

	/**
	 * 
	 */
	public KeggPathwayAugmentation() {

		// TODO Auto-generated constructor stub
	}

	// args[0] must have input file name with folder
	// args[1] must have GLANET installation folder with "\\" at the end. This
	// folder will be used for outputFolder and dataFolder.
	// args[2] must have Input File Format
	// args[3] must have Number of Permutations
	// args[4] must have False Discovery Rate (ex: 0.05)
	// args[5] must have Generate Random Data Mode (with GC and
	// Mapability/without GC and Mapability)
	// args[6] must have writeGeneratedRandomDataMode checkBox
	// args[7] must have
	// writePermutationBasedandParametricBasedAnnotationResultMode checkBox
	// args[8] must have writePermutationBasedAnnotationResultMode checkBox
	// args[9] must have Dnase Enrichment example: DO_DNASE_ENRICHMENT or
	// DO_NOT_DNASE_ENRICHMENT
	// args[10] must have Histone Enrichment example : DO_HISTONE_ENRICHMENT or
	// DO_NOT_HISTONE_ENRICHMENT
	// args[11] must have Tf and KeggPathway Enrichment example:
	// DO_TF_KEGGPATHWAY_ENRICHMENT or DO_NOT_TF_KEGGPATHWAY_ENRICHMENT
	// args[12] must have Tf and CellLine and KeggPathway Enrichment example:
	// DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT or
	// DO_NOT_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT
	// args[13] must have a job name exampe: any_string
	public static void main( String[] args) {

		String glanetFolder = args[CommandLineArguments.GlanetFolder.value()];
		String dataFolder = glanetFolder + Commons.DATA + System.getProperty( "file.separator");
		String outputFolder = args[CommandLineArguments.OutputFolder.value()];

		// for testing purposes
		Map<String, List<Integer>> keggPathwayEntry2GeneIdListMap = new HashMap<String, List<Integer>>();
		Map<Integer, List<String>> humanGeneId2RefSeqGeneNameListMap = new HashMap<Integer, List<String>>();
		Map<String, List<String>> humanRefSeqGeneName2AlternateGeneNameListMap = new HashMap<String, List<String>>();

		List<Integer> keggPathwayGeneIdList;
		List<String> keggPathwayRefSeqGeneNameList = new ArrayList<String>();
		List<String> keggPathwayAlternateGeneNameList = new ArrayList<String>();

		KeggPathwayAugmentation.fillKeggPathwayEntry2GeneIdListMap( dataFolder, keggPathwayEntry2GeneIdListMap);
		HumanGenesAugmentation.fillHumanGeneId2ListofRefSeqRNANucleotideAccessionMap( outputFolder,humanGeneId2RefSeqGeneNameListMap);
		HumanGenesAugmentation.fillHumanRefSeqRNANucleotideAccession2ListofAlternateGeneNameMap( dataFolder,humanRefSeqGeneName2AlternateGeneNameListMap);

		keggPathwayGeneIdList = keggPathwayEntry2GeneIdListMap.get( "hsa00860");
		HumanGenesAugmentation.augmentGeneIdWithRefSeqRNANucleotideAccession( keggPathwayGeneIdList,keggPathwayRefSeqGeneNameList, humanGeneId2RefSeqGeneNameListMap);
		HumanGenesAugmentation.augmentRefSeqRNANucleotideAccessionwithAlternateGeneName( keggPathwayRefSeqGeneNameList,keggPathwayAlternateGeneNameList, humanRefSeqGeneName2AlternateGeneNameListMap);
	}
}
