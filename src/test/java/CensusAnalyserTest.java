import com.bridgelabz.censusanalyser.CensusAnalyser;
import com.bridgelabz.censusanalyser.CensusAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {

    public static final String INDIAN_STATE_CENSUS_FILE = "C:\\Users\\nikhi\\IdeaProjects\\CensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusData.csv";
    public static final String WRONG_CSV_FILE = "C:\\Users\\nikhi\\IdeaProjects\\CensusAnalyserProblem\\src\\main\\resources\\IndiaState.csv";
    public static final String WRONG_CSV_FILE_TYPE = "C:\\Users\\nikhi\\IdeaProjects\\CensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusData.txt";
    public static final String WRONG_CSV_FILE_DELIMETER = "C:\\Users\\nikhi\\IdeaProjects\\CensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusDataDelimiter.csv";
    public static final String INDIAN_STATE_CODE_FILE = "C:\\Users\\nikhi\\IdeaProjects\\CensusAnalyserProblem\\src\\main\\resources\\IndiaStateCode.csv";


    @Test
    public void givenIndianStateCensusCSVFile_ReturnsCorrectRecords() {
        try {
            int count = CensusAnalyser.loadCensusData(INDIAN_STATE_CENSUS_FILE);
            System.out.println(count);
            Assert.assertEquals(29, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndiaStateCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser.loadCensusData(WRONG_CSV_FILE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.type);
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser.loadCensusData(WRONG_CSV_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.type);
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFileDelimeter_ShouldThrowException() {
        try {
            CensusAnalyser.loadCensusData(WRONG_CSV_FILE_DELIMETER);
        } catch (CensusAnalyserException e) {
            System.out.println(e.type);
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_DELIMETER, e.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFileHeader_ShouldThrowException() {
        try {
            CensusAnalyser.loadCensusData(INDIAN_STATE_CODE_FILE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.type);
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_HEADER, e.type);
        }
    }

    @Test
    public void givenIndianStateCodeCSVFile_ReturnsCorrectRecords() {
        try {
            int count = CensusAnalyser.loadCodeData(INDIAN_STATE_CODE_FILE);
            System.out.println(count);
            Assert.assertEquals(37, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
}
