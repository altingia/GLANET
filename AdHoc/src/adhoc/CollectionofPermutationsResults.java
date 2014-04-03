/**
 * @author Burcak Otlu
 * Feb 13, 2014
 * 1:15:47 PM
 * 2014
 *
 * 
 */
package adhoc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import multipletesting.BenjaminiandHochberg;
import augmentation.keggpathway.KeggPathwayAugmentation;
import auxiliary.FileOperations;
import auxiliary.FunctionalElement;
import auxiliary.NumberofComparisons;
import auxiliary.NumberofComparisonsforBonferroniCorrectionCalculation;

import common.Commons;




public class CollectionofPermutationsResults {
	
	public void collectPermutationResults(String dataFolder, String outputFolder,String fileName, String runName, int numberofRuns, int numberofRemainders, int numberofComparisons, float FDR, String enrichmentType){
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		String strLine;
		String tempRunName;
		
		int indexofTab;
		int indexofPipe;
		int indexofFormerComma;
		int indexofLatterComma;
		
		String elementName;
		int originalNumberofOverlaps;
		int permutationNumberofOverlaps;
		
		int numberofPermutationsHavingOverlapsGreaterThanorEqualto;
		float empiricalPValue;
		float bonferroniCorrectedEmpiricalPValue;
		
		FunctionalElement element;
	
		Map<String,FunctionalElement> elementName2ElementMap = new  HashMap<String,FunctionalElement>();
		
		DecimalFormat df = new DecimalFormat("0.######E0");
		
		int numberofPermutations;
		
		if (numberofRemainders>0){
			numberofPermutations = ((numberofRuns-1) * Commons.NUMBER_OF_PERMUTATIONS_IN_EACH_RUN) + numberofRemainders;
		}else{
			numberofPermutations = numberofRuns * Commons.NUMBER_OF_PERMUTATIONS_IN_EACH_RUN;	
		}
	
		try {
					
			for (int i=1; i<=numberofRuns; i++){
				
					tempRunName =  "_" + runName + i;
					
					fileReader = new FileReader(outputFolder + fileName + tempRunName  + ".txt" );
					bufferedReader = new BufferedReader(fileReader);
					
					while((strLine = bufferedReader.readLine())!=null){
						
						//Initialize numberofPermutationsHavingOverlapsGreaterThanorEqualto to zero
						numberofPermutationsHavingOverlapsGreaterThanorEqualto = 0;
						
						indexofTab = strLine.indexOf('\t');
						indexofPipe = strLine.indexOf('|');
						
						elementName = strLine.substring(0,indexofTab);
						originalNumberofOverlaps = Integer.parseInt(strLine.substring(indexofTab+1,indexofPipe));
						
						indexofFormerComma = indexofPipe;
						indexofLatterComma = strLine.indexOf(',', indexofFormerComma+1);
						
						while(indexofFormerComma!= -1 && indexofLatterComma!= -1){
							permutationNumberofOverlaps = Integer.parseInt(strLine.substring(indexofFormerComma+1, indexofLatterComma));
							
							if(permutationNumberofOverlaps >= originalNumberofOverlaps){
								numberofPermutationsHavingOverlapsGreaterThanorEqualto++;
							}
							
							indexofFormerComma = indexofLatterComma;
							indexofLatterComma = strLine.indexOf(',', indexofLatterComma+1);
							
						}// Inner while loop: all permutations, number of overlaps of an element
						
						//write numberofPermutationsHavingOverlapsGreaterThanorEqualto to map
						if(elementName2ElementMap.get(elementName)==null){
							element = new FunctionalElement();
							
							element.setName(elementName);
							element.setOriginalNumberofOverlaps(originalNumberofOverlaps);
							element.setNumberofPermutationsHavingOverlapsGreaterThanorEqualto(numberofPermutationsHavingOverlapsGreaterThanorEqualto);
							
							elementName2ElementMap.put(elementName, element);
						}else{
							
							element = elementName2ElementMap.get(elementName);
							
							element.setNumberofPermutationsHavingOverlapsGreaterThanorEqualto(element.getNumberofPermutationsHavingOverlapsGreaterThanorEqualto() + numberofPermutationsHavingOverlapsGreaterThanorEqualto );
							
						}
												
					}//Outer while loop: Read all lines of a run					
					
					//Close bufferedReader
					bufferedReader.close();
									
			}//End of for: each run
			
			
			
			
			//Now compute empirical pValue and Bonferroni Corrected pValue and write
			for(Map.Entry<String, FunctionalElement> entry: elementName2ElementMap.entrySet()){
				
				elementName = entry.getKey();
				element 	= entry.getValue();
				
				numberofPermutationsHavingOverlapsGreaterThanorEqualto = element.getNumberofPermutationsHavingOverlapsGreaterThanorEqualto();
				
				empiricalPValue = (numberofPermutationsHavingOverlapsGreaterThanorEqualto *1.0f)/numberofPermutations;
				bonferroniCorrectedEmpiricalPValue = ((numberofPermutationsHavingOverlapsGreaterThanorEqualto*1.0f)/numberofPermutations) * numberofComparisons;
				
				if (bonferroniCorrectedEmpiricalPValue>1.0f){
					bonferroniCorrectedEmpiricalPValue = 1.0f;
				}
										
				element.setEmpiricalPValue(empiricalPValue);
				element.setBonferroniCorrectedEmpiricalPValue(bonferroniCorrectedEmpiricalPValue);			
	
			}
			
			//convert map.values() into a list
			//sort w.r.t. empirical p value
			//before calculating BH FDR adjusted p values
			List<FunctionalElement> list = new ArrayList<FunctionalElement>(elementName2ElementMap.values());
			Collections.sort(list,FunctionalElement.EMPIRICAL_P_VALUE);
			BenjaminiandHochberg.calculateBenjaminiHochbergFDRAdjustedPValues(list, FDR);
			//sort w.r.t. Benjamini and Hochberg FDR
			Collections.sort(list,FunctionalElement.BENJAMINI_HOCHBERG_FDR_ADJUSTED_P_VALUE);
			
			//Augment with Kegg Pathway Information starts
			if (enrichmentType.equals(Commons.DO_KEGGPATHWAY_ENRICHMENT)){
				//Augment with Kegg Pathway Name starts
				KeggPathwayAugmentation.augmentKeggPathwayEntrywithKeggPathwayName(dataFolder,list,null,null);
				//Augment with Kegg Pathway Gene List and Alternate Gene Name List
				KeggPathwayAugmentation.augmentKeggPathwayEntrywithKeggPathwayGeneList(dataFolder,outputFolder,list,null,null);

			}else if (enrichmentType.equals(Commons.DO_TF_KEGGPATHWAY_ENRICHMENT)){
				KeggPathwayAugmentation.augmentTfNameKeggPathwayEntrywithKeggPathwayName(dataFolder,list,null,null);
				KeggPathwayAugmentation.augmentTfNameKeggPathwayEntrywithKeggPathwayGeneList(dataFolder,outputFolder,list,null,null);

			}else if (enrichmentType.equals(Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT)){
				KeggPathwayAugmentation.augmentTfNameCellLineNameKeggPathwayEntrywithKeggPathwayName(dataFolder,list,null,null);
				KeggPathwayAugmentation.augmentTfNameCellLineNameKeggPathwayEntrywithKeggPathwayGeneList(dataFolder,outputFolder,list,null,null);		

			}
			//Augment with Kegg Pathway Information ends


			
			//write the results to a output file starts		
			fileWriter = FileOperations.createFileWriter(outputFolder + fileName  + "_all.txt");
			bufferedWriter = new BufferedWriter(fileWriter);
			
			//header line in output file
			bufferedWriter.write("Element" + "\t" + "OriginalNumberofOverlaps" + "\t" + "NumberofPermutationsHavingNumberofOverlapsGreaterThanorEqualTo in " + numberofPermutations + " Permutations" + "\t"+ "Number of Permutations" + "\t" + "Number of comparisons" + "\t" + "empiricalPValue" + "\t" + "BonfCorrPVlaue: numberOfComparisons " + numberofComparisons + "\t" + "BH FDR Adjusted P Value" + "\t" + "Reject Null Hypothesis for an FDR of " + FDR +System.getProperty("line.separator"));

			Iterator<FunctionalElement> itr = list.iterator();
			
			while(itr.hasNext()){
				element = itr.next();
				
				
				if(	enrichmentType.equals(Commons.DO_KEGGPATHWAY_ENRICHMENT) ||
					enrichmentType.equals(Commons.DO_TF_KEGGPATHWAY_ENRICHMENT) ||
					enrichmentType.equals(Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT)){
					
					//line per element in output file
					bufferedWriter.write(element.getName() + "\t" +  element.getOriginalNumberofOverlaps() + "\t" + element.getNumberofPermutationsHavingOverlapsGreaterThanorEqualto() + "\t"+ numberofPermutations+ "\t" +numberofComparisons + "\t" + df.format(element.getEmpiricalPValue()) + "\t" + df.format(element.getBonferroniCorrectedEmpiricalPValue()) + "\t" + df.format(element.getBH_FDR_adjustedPValue()) + "\t" + element.isRejectNullHypothesis() +"\t");
					
					
					bufferedWriter.write(element.getKeggPathwayName()+"\t");
					
					
					if (element.getKeggPathwayGeneIdList().size()>=1){
						int i;
						//Write the gene ids of the kegg pathway
						for(i =0 ;i < element.getKeggPathwayGeneIdList().size()-1; i++){
							bufferedWriter.write(element.getKeggPathwayGeneIdList().get(i) + ", ");
						}
						bufferedWriter.write(element.getKeggPathwayGeneIdList().get(i) + "\t");
					}
					
					if(element.getKeggPathwayAlternateGeneNameList().size()>=1){
						int i;
						
						//Write the alternate gene names of the kegg pathway
						for(i =0 ;i < element.getKeggPathwayAlternateGeneNameList().size()-1; i++){
							bufferedWriter.write(element.getKeggPathwayAlternateGeneNameList().get(i) + ", ");
						}
						bufferedWriter.write(element.getKeggPathwayAlternateGeneNameList().get(i) + System.getProperty("line.separator"));			
					}	
			
				}else{
					//line per element in output file
					bufferedWriter.write(element.getName() + "\t" +  element.getOriginalNumberofOverlaps() + "\t" + element.getNumberofPermutationsHavingOverlapsGreaterThanorEqualto() + "\t"+ numberofPermutations+ "\t" +numberofComparisons + "\t" + df.format(element.getEmpiricalPValue()) + "\t" + df.format(element.getBonferroniCorrectedEmpiricalPValue()) + "\t" + df.format(element.getBH_FDR_adjustedPValue()) + "\t" + element.isRejectNullHypothesis() +System.getProperty("line.separator"));
					
				}
				
			
			}//End of while
			
			//close the file
			bufferedWriter.close();
			//write the results to a output file ends

		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}

	/**
	 * 
	 */
	public CollectionofPermutationsResults() {
		// TODO Auto-generated constructor stub
	}

	//args[0] must have input file name with folder
	//args[1] must have GLANET installation folder with "\\" at the end. This folder will be used for outputFolder and dataFolder.
	//args[2] must have Input File Format		
	//args[3] must have Number of Permutations	
	//args[4] must have False Discovery Rate (ex: 0.05)
	//args[5] must have Generate Random Data Mode (with GC and Mapability/without GC and Mapability)
	//args[6] must have writeGeneratedRandomDataMode checkBox
	//args[7] must have writePermutationBasedandParametricBasedAnnotationResultMode checkBox
	//args[8] must have writePermutationBasedAnnotationResultMode checkBox
	//args[9] must have Dnase Enrichment example: DO_DNASE_ENRICHMENT or DO_NOT_DNASE_ENRICHMENT
	//args[10] must have Histone Enrichment example : DO_HISTONE_ENRICHMENT or DO_NOT_HISTONE_ENRICHMENT
	//args[11] must have Tf and KeggPathway Enrichment example: DO_TF_KEGGPATHWAY_ENRICHMENT or DO_NOT_TF_KEGGPATHWAY_ENRICHMENT
	//args[12] must have Tf and CellLine and KeggPathway Enrichment example: DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT or DO_NOT_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT
	//args[13] must have a job name exampe: any_string 
	public static void main(String[] args) {
		
		String glanetFolder = args[1];
		String dataFolder 	= glanetFolder + System.getProperty("file.separator") + Commons.DATA + System.getProperty("file.separator") ;
		String outputFolder = glanetFolder + System.getProperty("file.separator") + Commons.OUTPUT + System.getProperty("file.separator") ;

		CollectionofPermutationsResults collectionofPermutationsResults = new CollectionofPermutationsResults();
		
		NumberofComparisons  numberofComparisons = new NumberofComparisons();
		NumberofComparisonsforBonferroniCorrectionCalculation.getNumberofComparisonsforBonferroniCorrection(outputFolder,numberofComparisons);
				
		int numberofPermutations = Integer.parseInt(args[3]);
		
		float FDR = Float.parseFloat(args[4]);

		String dnaseEnrichment = args[9];
		String histoneEnrichment  = args[10];
		String tfKeggPathwayEnrichment = args[11];
		String tfCellLineKeggPathwayEnrichment = args[12];
		
		//Run Name
		String runName = args[13] ;
		
		int numberofRuns = 0;
		int numberofRemainders = 0;
		
		numberofRuns = numberofPermutations / Commons.NUMBER_OF_PERMUTATIONS_IN_EACH_RUN;
		numberofRemainders = numberofPermutations % Commons.NUMBER_OF_PERMUTATIONS_IN_EACH_RUN;
		
		//Increase numberofRuns by 1 for remainder permutations less than 1000
		if (numberofRemainders> 0){
			numberofRuns += 1;
		}
				
		
		if(dnaseEnrichment.equals(Commons.DO_DNASE_ENRICHMENT)){
			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_DNASE_NUMBER_OF_OVERLAPS, runName,numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonsDnase(),FDR,dnaseEnrichment);
		}
		
		if (histoneEnrichment.equals(Commons.DO_HISTONE_ENRICHMENT)){
			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_HISTONE_NUMBER_OF_OVERLAPS, runName,numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonsHistone(),FDR,histoneEnrichment);
		}
		
		if(tfKeggPathwayEnrichment.equals(Commons.DO_TF_KEGGPATHWAY_ENRICHMENT)){
	
			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_TF_NUMBER_OF_OVERLAPS, runName,numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonsTfbs(),FDR,Commons.DO_TF_ENRICHMENT);

			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_EXON_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS, runName, numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonsExonBasedKeggPathway(),FDR,Commons.DO_KEGGPATHWAY_ENRICHMENT);
			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_REGULATION_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS,  runName,numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonsRegulationBasedKeggPathway(),FDR,Commons.DO_KEGGPATHWAY_ENRICHMENT);
			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_ALL_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS,  runName,numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonsAllBasedKeggPathway(),FDR,Commons.DO_KEGGPATHWAY_ENRICHMENT);

			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_TF_EXON_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS,  runName,numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonTfExonBasedKeggPathway(),FDR,Commons.DO_TF_KEGGPATHWAY_ENRICHMENT);
			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_TF_REGULATION_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS, runName,numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonTfRegulationBasedKeggPathway(),FDR,Commons.DO_TF_KEGGPATHWAY_ENRICHMENT);
			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_TF_ALL_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS,  runName,numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonTfAllBasedKeggPathway(),FDR,Commons.DO_TF_KEGGPATHWAY_ENRICHMENT);

		}
		
		if (tfCellLineKeggPathwayEnrichment.equals(Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT)){
			
			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_TF_NUMBER_OF_OVERLAPS,  runName,numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonsTfbs(),FDR,Commons.DO_TF_ENRICHMENT);

			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_EXON_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS,  runName,numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonsExonBasedKeggPathway(),FDR,Commons.DO_KEGGPATHWAY_ENRICHMENT);
			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_REGULATION_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS,  runName,numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonsRegulationBasedKeggPathway(),FDR,Commons.DO_KEGGPATHWAY_ENRICHMENT);
			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_ALL_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS,  runName,numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonsAllBasedKeggPathway(),FDR,Commons.DO_KEGGPATHWAY_ENRICHMENT);

			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS, runName, numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonTfCellLineExonBasedKeggPathway(),FDR,Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT);
			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS, runName, numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonTfCellLineRegulationBasedKeggPathway(),FDR,Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT);
			collectionofPermutationsResults.collectPermutationResults(dataFolder,outputFolder,Commons.TO_BE_COLLECTED_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS, runName, numberofRuns,numberofRemainders,numberofComparisons.getNumberofComparisonTfCellLineAllBasedKeggPathway(),FDR,Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT);

		}
		
	
	}

}
