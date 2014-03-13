/**
 * @author Burcak Otlu
 * Jan 16, 2014
 * 4:28:36 PM
 * 2014
 *
 * 
 */
package augmentation.results;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.Commons;

public class EnrichedTfandKeggPathways {

	/**
	 * 
	 */
	public EnrichedTfandKeggPathways() {
	}
	
	//Read the empiricalpvalues\\output\\tobePolled  first
	//or 
	//Read the empiricalpvalues\\output\\ results
	//Augment it with annotate\\intervals\\parametric\\output results
	//Write augmented results
	//For Tf KeggPathway
	public void readTfKeggPathwayFileAugmentandWrite(String inputFileName, String outputFileName, String type){
		String strLine1;
		String strLine2;
		
		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;
		int indexofFourthTab;
		int indexofFifthTab;
		int indexofSixthTab;
		int indexofSeventhTab;
		int indexofEigthTab;
		int indexofNinethTab;
		int indexofTenthTab;
			
		int indexofFirstUnderscore;
		
		String tfName_keggPathwayName;
		String keggPathwayName;
		String keggPathwayDescription;
		Float bonCorrEmpPValue; 
		Float empiricalPValue;
		String keggPathwayNameandDescription;
		
		Float benjaminiHochbergFDR ;
		
		FileReader tfandKeggPathwayFileReader = null;
		BufferedReader tfandKeggPathwayBufferedReader;
		
		Map<String,List<String>> enrichedKeggPathways = new HashMap<String,List<String>>();
		List<String> lines;
				
		try {
			FileReader inputFileReader  = new FileReader(inputFileName);
			BufferedReader bufferedReader = new BufferedReader(inputFileReader);
			
			FileWriter outputFileWriter = new FileWriter(outputFileName);
			BufferedWriter bufferedWriter = new BufferedWriter(outputFileWriter);
			
			//skip headerLine
			//Name	OriginalNumberofOverlaps	AccumulatedNumberofOverlaps	NumberofPermutations	NumberofComparisons	BonfCorrEmpiricalPValue	EmpiricalPValue
			strLine1= bufferedReader.readLine();
			
			while ((strLine1= bufferedReader.readLine())!=null ){
			
				//example line
				//AP2GAMMA_hsa00532	1	2	10000	40081	1.00E+00	2.00E-04	9.00E-03	1	Glycosaminoglycan biosynthesis - chondroitin sulfate / dermatan sulfate - Homo sapiens (human)	10090, 11285, 113189, 126792, 166012, 22856, 26229, 29940, 337876, 50515, 51363, 54480, 55454, 55501, 55790, 56548, 64131, 64132, 79586, 9469	UST, B4GALT7, CHST14, B3GALT6, CHST13, CHSY1, B3GAT3, DSE, CHSY3, CHST11, CHST15, CHPF2, CSGALNACT2, CHST12, CSGALNACT1, CHST7, XYLT1, XYLT2, CHPF, CHST3
				//WHIP_hsa05016	0.00E+00	Huntington's disease - Homo sapiens (human)	100532726, 10105, 10126, 10476, 10488, 10540, 10891, 10975, 1173, 1175, 1211, 1212, 1213, 125965, 126328, 1327, 1329, 1337, 1339, 1340, 1345, 1346, 1347, 1349, 1350, 1351, 1385, 1387, 146754, 148327, 1537, 160, 161, 163, 1639, 170712, 1742, 2033, 23186, 23236, 246721, 25942, 25981, 27019, 27089, 27113, 2776, 2876, 2902, 2904, 291, 2915, 292, 293, 29796, 3064, 3065, 3066, 3092, 317, 341947, 3708, 374291, 387332, 440567, 4508, 4509, 4512, 4513, 4514, 4519, 4694, 4695, 4696, 4697, 4698, 4700, 4701, 4702, 4704, 4705, 4706, 4707, 4708, 4709, 4710, 4711, 4712, 4713, 4714, 4715, 4716, 4717, 4718, 4719, 4720, 4722, 4723, 4724, 4725, 4726, 4728, 4729, 4731, 4899, 498, 506, 509, 51079, 51164, 513, 514, 515, 516, 517, 518, 522, 5330, 5331, 5332, 539, 54205, 5430, 5431, 5432, 5433, 5434, 5435, 5436, 5437, 5438, 5439, 5440, 5441, 54539, 5468, 548644, 55081, 55567, 55967, 56901, 581, 5978, 627, 6389, 6390, 6391, 6392, 64446, 64764, 6647, 6648, 6667, 6874, 6875, 6908, 7019, 7052, 7157, 7350, 7381, 7384, 7385, 7386, 7388, 7416, 7417, 7419, 7802, 8218, 83447, 83544, 836, 841, 842, 84699, 84701, 9001, 90993, 9167, 9377, 9519, 9586	NDUFC2-KCTD14, PPIF, DNAL4, ATP5H, CREB3, DCTN2, PPARGC1A, UQCR11, AP2M1, AP2S1, CLTA, CLTB, CLTC, COX6B2, NDUFA11, COX4I1, COX5B, COX6A1, COX6A2, COX6B1, COX6C, COX7A1, COX7A2, COX7B, COX7C, COX8A, CREB1, CREBBP, DNAH2, CREB3L4, CYC1, AP2A1, AP2A2, AP2B1, DCTN1, COX7B2, DLG4, EP300, RCOR1, PLCB1, POLR2J2, SIN3A, DNAH1, DNAI1, UQCRQ, BBC3, GNAQ, GPX1, GRIN1, GRIN2B, SLC25A4, GRM5, SLC25A5, SLC25A6, UQCR10, HTT, HDAC1, HDAC2, HIP1, APAF1, COX8C, ITPR1, NDUFS7, TBPL2, UQCRHL, NDUFA1, NDUFA2, NDUFA3, NDUFA4, NDUFA5, NDUFA6, NDUFA7, NDUFA8, NDUFA9, NDUFA10, NDUFAB1, NDUFB1, NDUFB2, NDUFB3, NDUFB4, NDUFB5, NDUFB6, NDUFB7, NDUFB8, NDUFB9, NDUFB10, NDUFC1, NDUFC2, NDUFS1, NDUFS2, NDUFS3, NDUFV1, NDUFS4, NDUFS5, NDUFS6, NDUFS8, NDUFV2, NDUFV3, NRF1, ATP5A1, ATP5B, ATP5C1, NDUFA13, DCTN4, ATP5D, ATP5E, ATP5F1, ATP5G1, ATP5G2, ATP5G3, ATP5J, PLCB2, PLCB3, PLCB4, ATP5O, CYCS, POLR2A, POLR2B, POLR2C, POLR2D, POLR2E, POLR2F, POLR2G, POLR2H, POLR2I, POLR2J, POLR2K, POLR2L, NDUFB11, PPARG, POLR2J3, IFT57, DNAH3, NDUFA12, NDUFA4L2, BAX, REST, BDNF, SDHA, SDHB, SDHC, SDHD, DNAI2, CREB3L2, SOD1, SOD2, SP1, TAF4, TAF4B, TBP, TFAM, TGM2, TP53, UCP1, UQCRB, UQCRC1, UQCRC2, UQCRFS1, UQCRH, VDAC1, VDAC2, VDAC3, DNALI1, CLTCL1, SLC25A31, DNAL1, CASP3, CASP8, CASP9, CREB3L3, COX4I2, HAP1, CREB3L1, COX7A2L, COX5A, TBPL1, CREB5

//				new example line
//				JUND_hsa05164	4	0	10000	40081	0.00E+00	0.00E+00	0.00E+00	TRUE

				
				indexofFirstTab 	= strLine1.indexOf('\t');
				indexofSecondTab 	= strLine1.indexOf('\t',indexofFirstTab+1);
				indexofThirdTab 	= strLine1.indexOf('\t',indexofSecondTab+1);
				indexofFourthTab 	= strLine1.indexOf('\t',indexofThirdTab+1);
				indexofFifthTab 	= strLine1.indexOf('\t',indexofFourthTab+1);
				indexofSixthTab 	= strLine1.indexOf('\t',indexofFifthTab+1);
				indexofSeventhTab	= strLine1.indexOf('\t',indexofSixthTab+1);
				indexofEigthTab 	= strLine1.indexOf('\t',indexofSeventhTab+1);
				indexofNinethTab 	= strLine1.indexOf('\t',indexofEigthTab+1);
				indexofTenthTab 	= strLine1.indexOf('\t',indexofNinethTab+1);
					
				tfName_keggPathwayName = strLine1.substring(0, indexofFirstTab);
				
				indexofFirstUnderscore = tfName_keggPathwayName.indexOf('_');
				keggPathwayName = tfName_keggPathwayName.substring(indexofFirstUnderscore+1,indexofFirstTab);
				
				
				//Pay attention to the order
				empiricalPValue = Float.parseFloat(strLine1.substring(indexofFifthTab+1, indexofSixthTab));
				bonCorrEmpPValue= Float.parseFloat(strLine1.substring(indexofSixthTab+1, indexofSeventhTab));
				benjaminiHochbergFDR = Float.parseFloat(strLine1.substring(indexofSeventhTab+1, indexofEigthTab));
				
				keggPathwayDescription = strLine1.substring(indexofNinethTab+1, indexofTenthTab);
				
				//change selection criteria
				if (bonCorrEmpPValue <= 0.05f){
					
					lines = enrichedKeggPathways.get(keggPathwayName + " " + keggPathwayDescription);
	
					if (lines==null){
						lines = new ArrayList<String>();
						lines.add(strLine1);
						enrichedKeggPathways.put(keggPathwayName+ " " +keggPathwayDescription, lines);
					}else{
						lines.add(strLine1);
					}			
				}
					
			}//end of while : reading enriched tf and kegg Pathway file line by line.
			
			
			
			for(Map.Entry<String,List<String>> entry: enrichedKeggPathways.entrySet()){
				keggPathwayNameandDescription = entry.getKey();
				lines = entry.getValue();
				
				bufferedWriter.write("**************\t" + keggPathwayNameandDescription + "\t**************" + "\n");
							
				for(String strLine: lines){
					indexofFirstTab = strLine.indexOf('\t');
					tfName_keggPathwayName = strLine.substring(0,indexofFirstTab);
					
					if(Commons.TF_EXON_BASED_KEGG_PATHWAY.equals(type)){
						tfandKeggPathwayFileReader = new FileReader(Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_EXON_BASED_KEGG_PATHWAY + "_" + tfName_keggPathwayName + ".txt");						
					}else if (Commons.TF_REGULATION_BASED_KEGG_PATHWAY.equals(type)){
						tfandKeggPathwayFileReader = new FileReader(Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_REGULATION_BASED_KEGG_PATHWAY + "_" + tfName_keggPathwayName + ".txt");						
					}else if (Commons.TF_ALL_BASED_KEGG_PATHWAY.equals(type)){
						tfandKeggPathwayFileReader = new FileReader(Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_ALL_BASED_KEGG_PATHWAY + "_" + tfName_keggPathwayName + ".txt");					
					}
					
					tfandKeggPathwayBufferedReader = new BufferedReader(tfandKeggPathwayFileReader);
							
					//Get all the lines of the original data annotation for the enriched Tf and KeggPathway 
					//Write them to the file
					while((strLine2 = tfandKeggPathwayBufferedReader.readLine())!=null){
						bufferedWriter.write(tfName_keggPathwayName + "\t" +strLine2 + "\n");
					}
					
				}
			}//End of for	
				
		
			bufferedReader.close();
			bufferedWriter.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Read the empiricalpvalues\\output\\ results
	//Augment it with annotate\\intervals\\parametric\\output results
	//Write augmented results
	//For Tf CellLine KeggPathway
	
	//ExampleLine
	//POL24H8_HCT116_hsa05020	0.00E+00	Prion diseases - Homo sapiens (human)	100506742, 10963, 1958, 2002, 2534, 3303, 3309, 3552, 3553, 3569, 3915, 4684, 4685, 4851, 5566, 5567, 5568, 5594, 5595, 5604, 5605, 5613, 5621, 581, 6352, 6647, 712, 713, 714, 727, 729, 730, 731, 732, 733, 735	CASP12, STIP1, EGR1, ELK1, FYN, HSPA1A, HSPA5, IL1A, IL1B, IL6, LAMC1, NCAM1, NCAM2, NOTCH1, PRKACA, PRKACB, PRKACG, MAPK1, MAPK3, MAP2K1, MAP2K2, PRKX, PRNP, BAX, CCL5, SOD1, C1QA, C1QB, C1QC, C5, C6, C7, C8A, C8B, C8G, C9
	public void readTfCellLineKeggPathwayFileAugmentandWrite(String inputFileName, String outputFileName, String type){
		String strLine1;
		String strLine2;
		
		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;
		int indexofFourthTab;
		int indexofFifthTab;
		int indexofSixthTab;
		int indexofSeventhTab;
		int indexofEigthTab;
		int indexofNinethTab;
		int indexofTenthTab;
		
		
		int indexofFirstUnderscore;
		int indexofSecondUnderscore;
		
		String tfName_cellLineName_keggPathwayName;
		String keggPathwayName;
		Float bonCorrEmpPValue; 
		Float empiricalPValue;
		Float bhFDRAdjustedPValue;
		String keggPathwayDescription;
		String keggPathwayNameandDescription;
		
		FileReader tfandKeggPathwayFileReader = null;
		BufferedReader tfandKeggPathwayBufferedReader;
		
		Map<String,List<String>> enrichedKeggPathways = new HashMap<String,List<String>>();
		List<String> lines;
		
		try {
			FileReader inputFileReader  = new FileReader(inputFileName);
			BufferedReader bufferedReader = new BufferedReader(inputFileReader);
			
			FileWriter outputFileWriter = new FileWriter(outputFileName);
			BufferedWriter bufferedWriter = new BufferedWriter(outputFileWriter);
			
			//Skip header line
			//Name	OriginalNumberofOverlaps	AccumulatedNumberofOverlaps	NumberofPermutations	NumberofComparisons	BonfCorrEmpiricalPValue	EmpiricalPValue
			strLine1= bufferedReader.readLine();
			
			while ((strLine1= bufferedReader.readLine())!=null ){
			
				//example line
				//AP2GAMMA_HELAS3_hsa00532	1	4	10000	109214	1E0	4E-4	Glycosaminoglycan biosynthesis - chondroitin sulfate / dermatan sulfate - Homo sapiens (human)	10090, 11285, 113189, 126792, 166012, 22856, 26229, 29940, 337876, 50515, 51363, 54480, 55454, 55501, 55790, 56548, 64131, 64132, 79586, 9469	UST, B4GALT7, CHST14, B3GALT6, CHST13, CHSY1, B3GAT3, DSE, CHSY3, CHST11, CHST15, CHPF2, CSGALNACT2, CHST12, CSGALNACT1, CHST7, XYLT1, XYLT2, CHPF, CHST3
				
//				new example line			
//				HEY1_K562_hsa05166	5	0	10000	109214	0.00E+00	0.00E+00	0.00E+00	TRUE

				indexofFirstTab = strLine1.indexOf('\t');
				indexofSecondTab = strLine1.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine1.indexOf('\t',indexofSecondTab+1);
				indexofFourthTab 	= strLine1.indexOf('\t',indexofThirdTab+1);
				indexofFifthTab 	= strLine1.indexOf('\t',indexofFourthTab+1);
				indexofSixthTab 	= strLine1.indexOf('\t',indexofFifthTab+1);
				indexofSeventhTab	= strLine1.indexOf('\t',indexofSixthTab+1);
				indexofEigthTab 	= strLine1.indexOf('\t',indexofSeventhTab+1);
				indexofNinethTab 	= strLine1.indexOf('\t',indexofEigthTab+1);
				indexofTenthTab 	= strLine1.indexOf('\t',indexofNinethTab+1);
				
				
				tfName_cellLineName_keggPathwayName = strLine1.substring(0, indexofFirstTab);
				
				indexofFirstUnderscore = tfName_cellLineName_keggPathwayName.indexOf('_');
				indexofSecondUnderscore = tfName_cellLineName_keggPathwayName.indexOf('_',indexofFirstUnderscore+1);
				keggPathwayName = tfName_cellLineName_keggPathwayName.substring(indexofSecondUnderscore+1,indexofFirstTab);
				
				//Pay attention order is important
				
				empiricalPValue = Float.parseFloat(strLine1.substring(indexofFifthTab+1, indexofSixthTab));
				bonCorrEmpPValue= Float.parseFloat(strLine1.substring(indexofSixthTab+1, indexofSeventhTab));
				bhFDRAdjustedPValue = Float.parseFloat(strLine1.substring(indexofSeventhTab+1, indexofEigthTab));
	
				
				keggPathwayDescription = strLine1.substring(indexofNinethTab+1, indexofTenthTab);
					
					if (bonCorrEmpPValue < 0.05){
					
					lines = enrichedKeggPathways.get(keggPathwayName + " " + keggPathwayDescription);
					
					if (lines==null){
						lines = new ArrayList<String>();
						lines.add(strLine1);
						enrichedKeggPathways.put(keggPathwayName+ " " +keggPathwayDescription, lines);
					}else{
						lines.add(strLine1);
					}
					
				}
					
			}//End of while : reading Tf CellLine KeggPathway input file line by line
			
			
			
			for(Map.Entry<String,List<String>> entry: enrichedKeggPathways.entrySet()){
				keggPathwayNameandDescription = entry.getKey();
				lines = entry.getValue();
				
				bufferedWriter.write("**************\t" + keggPathwayNameandDescription + "\t**************" + "\n");
								
				for(String strLine: lines){
					indexofFirstTab = strLine.indexOf('\t');
					tfName_cellLineName_keggPathwayName = strLine.substring(0,indexofFirstTab);
					
					//Get the original data annotation results
					if(Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY.equals(type)){
						tfandKeggPathwayFileReader = new FileReader(Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY + "_" + tfName_cellLineName_keggPathwayName + ".txt");
						
					}else if (Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY.equals(type)){
						tfandKeggPathwayFileReader = new FileReader(Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY + "_" + tfName_cellLineName_keggPathwayName + ".txt");
						
					}else if (Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY.equals(type)){
						tfandKeggPathwayFileReader = new FileReader(Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY + "_" + tfName_cellLineName_keggPathwayName + ".txt");
						
					}
					
					tfandKeggPathwayBufferedReader = new BufferedReader(tfandKeggPathwayFileReader);
					
					//Add the original data annotation results
					//Get all the lines of the original data annotation for the enriched Tf and KeggPathway 
					//Write them to the file
					while((strLine2 = tfandKeggPathwayBufferedReader.readLine())!=null){
						bufferedWriter.write(tfName_cellLineName_keggPathwayName + "\t" +strLine2 + "\n");	
					}
					
				}
			}	
				
		
			bufferedReader.close();
			bufferedWriter.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void readandWriteFiles(){
		
	    String level = "0.01";
	    
		readTfKeggPathwayFileAugmentandWrite(Commons.TO_BE_POLLED_TF_EXON_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS  + "_all.txt", Commons.AUGMENTED_TF_EXON_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_EXON_BASED_KEGG_PATHWAY);
		readTfKeggPathwayFileAugmentandWrite(Commons.TO_BE_POLLED_TF_REGULATION_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS + "_all.txt", Commons.AUGMENTED_TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_REGULATION_BASED_KEGG_PATHWAY);
		readTfKeggPathwayFileAugmentandWrite(Commons.TO_BE_POLLED_TF_ALL_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS +"_all.txt", Commons.AUGMENTED_TF_ALL_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_ALL_BASED_KEGG_PATHWAY);
		
		readTfCellLineKeggPathwayFileAugmentandWrite(Commons.TO_BE_POLLED_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS + "_all.txt", Commons.AUGMENTED_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY);
		readTfCellLineKeggPathwayFileAugmentandWrite(Commons.TO_BE_POLLED_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS + "_all.txt", Commons.AUGMENTED_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY);
		readTfCellLineKeggPathwayFileAugmentandWrite(Commons.TO_BE_POLLED_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS+ "_all.txt", Commons.AUGMENTED_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY);

	    
//		readTfKeggPathwayFileAugmentandWrite(Commons.TF_EXON_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION  + "_OCD_withGCMap_"  + "1"+ "Rep_" + "5000" + "Perm.txt", Commons.AUGMENTED_TF_EXON_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_EXON_BASED_KEGG_PATHWAY);
//		readTfKeggPathwayFileAugmentandWrite(Commons.TF_REGULATION_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION + "_OCD_withGCMap_"  + "1"+ "Rep_" + "5000" + "Perm.txt", Commons.AUGMENTED_TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_REGULATION_BASED_KEGG_PATHWAY);
//		readTfKeggPathwayFileAugmentandWrite(Commons.TF_ALL_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION  + "_OCD_withGCMap_"  + "1"+ "Rep_" + "5000" + "Perm.txt", Commons.AUGMENTED_TF_ALL_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_ALL_BASED_KEGG_PATHWAY);
//		
//		readTfCellLineKeggPathwayFileAugmentandWrite(Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR  + "_Level_" + level + "_HIV1_withGCMap_"  + "1"+ "Rep_" + "10000" + "Perm.txt", Commons.AUGMENTED_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY);
//		readTfCellLineKeggPathwayFileAugmentandWrite(Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR  + "_Level_" + level + "_HIV1_withGCMap_"  + "1"+ "Rep_" + "10000" + "Perm.txt", Commons.AUGMENTED_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY);
//		readTfCellLineKeggPathwayFileAugmentandWrite(Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR + "_Level_" + level  + "_HIV1_withGCMap_"  + "1"+ "Rep_" + "10000" + "Perm.txt", Commons.AUGMENTED_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		//Delete old Files
//		FileDeletion.deleteOldFiles(Commons.ENRICH_OUTPUT_FOLDER);
					
		EnrichedTfandKeggPathways enrich = new EnrichedTfandKeggPathways();
		
		enrich.readandWriteFiles();
		

	}

}
//