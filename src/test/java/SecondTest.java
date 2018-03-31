import model.Patient;
import org.junit.Test;
import repository.Repository;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SecondTest {
    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() throws IOException {
        assertEquals(0, Math.min(10, 0));
        String patients = "FilePatients.txt";
        String consultations = "FileConsultations.txt";
        Repository repo = new Repository(patients, consultations);

        int initialSize = repo.getPatientList().size();
        repo.savePatientToFile(new Patient("dada", "1111111111111", "adr"));

    }
    
}
