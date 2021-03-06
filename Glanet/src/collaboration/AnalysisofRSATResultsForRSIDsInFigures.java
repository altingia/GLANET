/**
 * @author burcakotlu
 * @date Sep 25, 2014 
 * @time 11:23:36 AM
 */
package collaboration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class AnalysisofRSATResultsForRSIDsInFigures {

	public static void readRSIDs( String rsIdsInFiguresFileName, List<String> rsIDList) {

		String strLine = null;
		String rsID = null;

		int indexofFirstTab;

		try{
			FileReader fileReader = new FileReader( rsIdsInFiguresFileName);
			BufferedReader bufferedReader = new BufferedReader( fileReader);

			while( ( strLine = bufferedReader.readLine()) != null){

				indexofFirstTab = strLine.indexOf( '\t');

				if( indexofFirstTab >= 0){
					System.out.println( "There is a tab character in rsID input file");
					rsID = strLine.substring( 0, indexofFirstTab);
				}else{
					rsID = strLine;

				}
				System.out.println( rsID);
				rsIDList.add( rsID);

			}// End of while

			System.out.println( "Number of rsIDs in the list: " + rsIDList.size());

			bufferedReader.close();
			fileReader.close();

		}catch( FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch( IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void analyzeRSATResultsForGivenRSIDs( List<String> rsIDList, String RSATResults_InputFileName,
			String RSATResultsForRSIDsInFigures_OutputFileName) {

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		String strLine = null;
		int indexofRS;
		int indexofStarAfterRS;
		String rsID = null;

		List<String> commonRSIDList = new ArrayList<String>();

		try{
			fileReader = new FileReader( RSATResults_InputFileName);
			bufferedReader = new BufferedReader( fileReader);

			fileWriter = new FileWriter( RSATResultsForRSIDsInFigures_OutputFileName);
			bufferedWriter = new BufferedWriter( fileWriter);

			while( ( strLine = bufferedReader.readLine()) != null){

				if( strLine.contains( "rs") && !( strLine.contains( "Description"))){

					// get the rsID in the strLine
					indexofRS = strLine.indexOf( "rs");
					indexofStarAfterRS = strLine.indexOf( '*', indexofRS + 1);

					if( indexofRS >= 0 && indexofStarAfterRS >= 0){
						rsID = strLine.substring( indexofRS, indexofStarAfterRS);
						// System.out.println(strLine);
						// System.out.println(rsID);
					}else{
						System.out.println( strLine);
						System.out.println( "index of RS: " + indexofRS);
						System.out.println( "index of StarAfterRS: " + indexofStarAfterRS);
					}

					// check whether this rsID is in the rsIDList of Chen Yao
					if( rsIDList.contains( rsID)){

						// how many of these rsIDs are common between rsIDs in
						// RSAT results and Chen Yao's rsIDList in figures
						if( !commonRSIDList.contains( rsID)){
							commonRSIDList.add( rsID);
						}

						// Write this strLine to output File
						bufferedWriter.write( strLine + System.getProperty( "line.separator"));

						// read the next line
						strLine = bufferedReader.readLine();

						if( strLine.contains( "Description")){
							// Skip this strLine

							// Read 4 more lines from inputFile
							for( int i = 0; i < 4; i++){
								strLine = bufferedReader.readLine();
								bufferedWriter.write( strLine + System.getProperty( "line.separator"));
							}// End of FOR: read 4 lines
						}else{
							// write this strLine
							bufferedWriter.write( strLine + System.getProperty( "line.separator"));

							// Read 3 more lines from inputFile
							for( int i = 0; i < 3; i++){
								strLine = bufferedReader.readLine();
								bufferedWriter.write( strLine + System.getProperty( "line.separator"));
							}// End of FOR: read 4 lines

						}

					}// End of IF: rsID is in the rsIDList given by Chen Yao

				}// End of IF: read strLine contains rsID and does not contain
					// "Description"

			}// End of while

			bufferedWriter.close();
			bufferedReader.close();

			System.out.println( "how many of these rsIDs are common between rsIDs in RSAT results and Chen Yao's rsIDList in figures: " + commonRSIDList.size());
			System.out.println( "they are:");
			for( String commonRSID : commonRSIDList){
				System.out.println( commonRSID);
			}

		}catch( FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch( IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main( String[] args) {

		List<String> rsIDList = new ArrayList<String>();

		/***********************************************************************/
		/******************** Ad hoc file addresses starts ***********************/
		/***********************************************************************/
		String rsIdsInFiguresFileName = "C:\\Users\\burcakotlu\\Desktop\\ENCODE Collaboration\\BurcakOtlu\\rsIDs_in_figures.txt";

		String RSATResults_TF_ExonBasedKEGGPathway_InputFileName = "C:\\Users\\burcakotlu\\GLANET\\saved_Output_CVD_381_snps\\RegulatorySequenceAnalysis\\UsingRSAT\\RSAT_results_TF_ExonBasedKEGGPathway.txt";
		String RSATResults_TF_RegulationBasedKEGGPathway_InputFileName = "C:\\Users\\burcakotlu\\GLANET\\saved_Output_CVD_381_snps\\RegulatorySequenceAnalysis\\UsingRSAT\\RSAT_results_TF_RegulationBasedKEGGPathway.txt";
		String RSATResults_TF_AllBasedKEGGPathway_InputFileName = "C:\\Users\\burcakotlu\\GLANET\\saved_Output_CVD_381_snps\\RegulatorySequenceAnalysis\\UsingRSAT\\RSAT_results_TF_AllBasedKEGGPathway.txt";

		String RSATResults_TF_CellLine_AllBasedKEGGPathway_InputFileName = "C:\\Users\\burcakotlu\\GLANET\\saved_Output_CVD_381_snps\\RegulatorySequenceAnalysis\\UsingRSAT\\RSAT_results_TF_CellLine_AllBasedKEGGPathway.txt";

		String RSATResultsForRSIDsInFigures_TF_ExonBasedKEGGPathway_OutputFileName = "C:\\Users\\burcakotlu\\Desktop\\ENCODE Collaboration\\BurcakOtlu\\RSATResultsForRSIDsInFigures_TF_ExonBasedKEGGPathway.txt";
		String RSATResultsForRSIDsInFigures_TF_RegulationBasedKEGGPathway_OutputFileName = "C:\\Users\\burcakotlu\\Desktop\\ENCODE Collaboration\\BurcakOtlu\\RSATResultsForRSIDsInFigures_TF_RegulationBasedKEGGPathway.txt";
		String RSATResultsForRSIDsInFigures_TF_AllBasedKEGGPathway_OutputFileName = "C:\\Users\\burcakotlu\\Desktop\\ENCODE Collaboration\\BurcakOtlu\\RSATResultsForRSIDsInFigures_TF_AllBasedKEGGPathway.txt";

		String RSATResultsForRSIDsInFigures_TF_CellLine_AllBasedKEGGPathway_OutputFileName = "C:\\Users\\burcakotlu\\Desktop\\ENCODE Collaboration\\BurcakOtlu\\RSATResultsForRSIDsInFigures_TF_CellLine_AllBasedKEGGPathway.txt";
		/***********************************************************************/
		/******************** Ad hoc file addresses ends *************************/
		/***********************************************************************/

		/***********************************************************************/
		/**************************** Read RsIds starts **************************/
		/***********************************************************************/
		readRSIDs( rsIdsInFiguresFileName, rsIDList);
		/***********************************************************************/
		/**************************** Read RsIds ends ****************************/
		/***********************************************************************/

		/***********************************************************************/
		/************ Analyze RSAT Results for rsIds in Figures starts ***********/
		/********************* TF Exon Based KEGG Pathway ************************/
		/***********************************************************************/
		analyzeRSATResultsForGivenRSIDs( rsIDList, RSATResults_TF_ExonBasedKEGGPathway_InputFileName,
				RSATResultsForRSIDsInFigures_TF_ExonBasedKEGGPathway_OutputFileName);
		/***********************************************************************/
		/********************* TF Exon Based KEGG Pathway ************************/
		/************ Analyze RSAT Results for rsIds in Figures ends *************/
		/***********************************************************************/

		/***********************************************************************/
		/************ Analyze RSAT Results for rsIds in Figures starts ***********/
		/********************* TF Regulation Based KEGG Pathway ************************/
		/***********************************************************************/
		analyzeRSATResultsForGivenRSIDs( rsIDList, RSATResults_TF_RegulationBasedKEGGPathway_InputFileName,
				RSATResultsForRSIDsInFigures_TF_RegulationBasedKEGGPathway_OutputFileName);
		/***********************************************************************/
		/********************* TF Regulation Based KEGG Pathway ************************/
		/************ Analyze RSAT Results for rsIds in Figures ends *************/
		/***********************************************************************/

		/***********************************************************************/
		/************ Analyze RSAT Results for rsIds in Figures starts ***********/
		/********************* TF All Based KEGG Pathway ************************/
		/***********************************************************************/
		analyzeRSATResultsForGivenRSIDs( rsIDList, RSATResults_TF_AllBasedKEGGPathway_InputFileName,
				RSATResultsForRSIDsInFigures_TF_AllBasedKEGGPathway_OutputFileName);
		/***********************************************************************/
		/********************* TF All Based KEGG Pathway ************************/
		/************ Analyze RSAT Results for rsIds in Figures ends *************/
		/***********************************************************************/

		/***********************************************************************/
		/************ Analyze RSAT Results for rsIds in Figures starts ***********/
		/********************* TF CellLine All Based KEGG Pathway ***************/
		/***********************************************************************/
		analyzeRSATResultsForGivenRSIDs( rsIDList, RSATResults_TF_CellLine_AllBasedKEGGPathway_InputFileName,
				RSATResultsForRSIDsInFigures_TF_CellLine_AllBasedKEGGPathway_OutputFileName);
		/***********************************************************************/
		/********************* TF CellLine All Based KEGG Pathway ***************/
		/************ Analyze RSAT Results for rsIds in Figures ends *************/
		/***********************************************************************/

	}

}
