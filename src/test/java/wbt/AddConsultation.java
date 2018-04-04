package wbt;

import controller.DoctorController;
import exceptions.PatientException;
import model.Patient;
import org.junit.Test;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddConsultation {
    @Test
    public void addConsultationMedsNull() {
        assertEquals(1, 1);
        List<String> str = new ArrayList<String>();
        str.add("vit c");
        str.add("nurofen");

        String patients = "FilePatientsTest.txt";
        String consultations = "FileConsultationsTest.txt";
        Repository repo = new Repository(patients, consultations);
        DoctorController ctrl = new DoctorController(repo);

        try {
            ctrl.addConsultation("0", "9999999999999", "this is diag", null, "01.01.2019");
            assertEquals("", "bau");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "meds is null");
        }
    }

    @Test
    public void addConsultationInvalidArgs() {
        assertEquals(1, 1);
        List<String> meds = new ArrayList<String>();
        meds.add("vit c");
        meds.add("nurofen");

        String patients = "FilePatientsTest.txt";
        String consultations = "FileConsultationsTest.txt";
        Repository repo = new Repository(patients, consultations);
        DoctorController ctrl = new DoctorController(repo);

        try {
            ctrl.addConsultation(null, "9999999999999", "this is diag", meds, "01.01.2019");
            assertEquals("", "bau");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "invalid arguments");
        }
    }

    @Test
    public void addValidConsultation() {
        assertEquals(1, 1);
        List<String> meds = new ArrayList<String>();
        meds.add("vit c");
        meds.add("nurofen");

        String patients = "FilePatientsTest.txt";
        String consultations = "FileConsultationsTest.txt";
        Repository repo = new Repository(patients, consultations);
        DoctorController ctrl = new DoctorController(repo);

        try {
            ctrl.addPatient(new Patient("name", "1112211122111", "adr"));
        } catch (PatientException e) {
            e.printStackTrace();
        }

        int nb = ctrl.getPatientBySSN("1112211122111").getConsNum();
        try {
            ctrl.addConsultation("unique_id", "1112211122111", "this is diag", meds, "01.01.2019");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "invalid arguments");
        }
        assertEquals(nb + 1, ctrl.getPatientBySSN("1112211122111").getConsNum());
    }

    @Test
    public void addConsultationWithWrongFileName() {
        try {
            assertEquals(1, 1);
            List<String> meds = new ArrayList<String>();
            meds.add("vit c");
            meds.add("nurofen");

            String patients = "FilePatien%10ts! Test.txt";
            String consultations = "FileConsultationsTest.txt";
            Repository repo = new Repository(patients, consultations);
            DoctorController ctrl = new DoctorController(repo);

            ctrl.addConsultation("xcvgbhnjk", "9999999999999", "this is diag", meds, "01.01.2019");
            assertEquals("", "bau");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "invalid arguments");
        }
    }

}
