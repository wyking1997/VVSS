package bbt;

import controller.DoctorController;
import exceptions.PatientException;
import model.Patient;
import org.junit.Assert;
import org.junit.Test;
import repository.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class AddPatientTest {
    private Repository repo;
    private DoctorController ctrl;
    private String patients = "FilePatientsTest.txt";
    private String consultations = "FileConsultationsTest.txt";

    @Test
    public void testWithValidData(){
        refreshContext();
        try {
            ctrl.addPatient(new Patient("name", "1111122222333", "address"));
            Assert.assertEquals(ctrl.getPatientList().size(), 1);
        } catch (PatientException e) {
            Assert.assertEquals("", "Error occured: " + e.getMessage());
        }
    }

    @Test
    public void testWithInvalidName1(){
        refreshContext();
        try {
            ctrl.addPatient(new Patient("*ana", "1111122222333", "address"));
            Assert.assertEquals(ctrl.getPatientList().size(), -1);
        } catch (PatientException e) {
            Assert.assertEquals("Fields with invalid format", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidName2(){
        refreshContext();
        try {
            ctrl.addPatient(new Patient("ann2na", "1111122222333", "address"));
            Assert.assertEquals(ctrl.getPatientList().size(), -1);
        } catch (PatientException e) {
            Assert.assertEquals("Fields with invalid format", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidName3(){
        refreshContext();
        try {
            ctrl.addPatient(new Patient("maria3", "1111122222333", "address"));
            Assert.assertEquals(ctrl.getPatientList().size(), -1);
        } catch (PatientException e) {
            Assert.assertEquals("Fields with invalid format", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidName4(){
        refreshContext();
        try {
            ctrl.addPatient(new Patient("832434234", "1111122222333", "address"));
            Assert.assertEquals(ctrl.getPatientList().size(), -1);
        } catch (PatientException e) {
            Assert.assertEquals("Fields with invalid format", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidName5(){
        refreshContext();
        try {
            ctrl.addPatient(new Patient("", "1111122222333", "address"));
            Assert.assertEquals(ctrl.getPatientList().size(), -1);
        } catch (PatientException e) {
            Assert.assertEquals("Null fields", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidSsn1(){
        refreshContext();
        try {
            ctrl.addPatient(new Patient("name", "111112222233f", "address"));
            Assert.assertEquals(ctrl.getPatientList().size(), -1);
        } catch (PatientException e) {
            Assert.assertEquals("Fields with invalid format", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidSsn2(){
        refreshContext();
        try {
            ctrl.addPatient(new Patient("name", "a111122222333", "address"));
            Assert.assertEquals(ctrl.getPatientList().size(), -1);
        } catch (PatientException e) {
            Assert.assertEquals("Fields with invalid format", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidSsn3(){
        refreshContext();
        try {
            ctrl.addPatient(new Patient("name", "11111ff222333", "address"));
            Assert.assertEquals(ctrl.getPatientList().size(), -1);
        } catch (PatientException e) {
            Assert.assertEquals("Fields with invalid format", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidSsn4(){
        refreshContext();
        try {
            ctrl.addPatient(new Patient("name", "11111ff22233", "address"));
            Assert.assertEquals(ctrl.getPatientList().size(), -1);
        } catch (PatientException e) {
            Assert.assertEquals("Fields with invalid format", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidSsn5(){
        refreshContext();
        try {
            ctrl.addPatient(new Patient("name", "11111ff2223333", "address"));
            Assert.assertEquals(ctrl.getPatientList().size(), -1);
        } catch (PatientException e) {
            Assert.assertEquals("Fields with invalid format", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidSsn6(){
        refreshContext();
        try {
            ctrl.addPatient(new Patient("name", "", "address"));
            Assert.assertEquals(ctrl.getPatientList().size(), -1);
        } catch (PatientException e) {
            Assert.assertEquals("Null fields", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidId1(){
        refreshContextWithElements();
        try {
            ctrl.addPatient(ctrl.getPatientList().get(ctrl.getPatientList().size() - 1));
            Assert.assertEquals(ctrl.getPatientList().size(), -1);
        } catch (PatientException e) {
            Assert.assertEquals("Not unique id", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidId2(){
        refreshContextWithElements();
        try {
            ctrl.addPatient(ctrl.getPatientList().get(0));
            Assert.assertEquals(ctrl.getPatientList().size(), -1);
        } catch (PatientException e) {
            Assert.assertEquals("Not unique id", e.getMessage());
        }
    }

    @Test
    public void testWithInvalidId3(){
        refreshContextWithElements();
        for (int i = 0; i < 100; i++) {
            try {
                ctrl.addPatient(ctrl.getPatientList().get(new Random().nextInt(ctrl.getPatientList().size() - 1)));
                Assert.assertEquals(ctrl.getPatientList().size(), -1);
            } catch (PatientException e) {
                Assert.assertEquals("Not unique id", e.getMessage());
            }
        }
    }


























    private void refreshContextWithElements(){
        refreshContext();
        try {
            ctrl.addPatient(new Patient("jony", "1112244455111", "some adr"));
            ctrl.addPatient(new Patient("jonzy", "1112244455112", "some adr"));
            ctrl.addPatient(new Patient("maria", "1112244455113", "some adr"));
            ctrl.addPatient(new Patient("john", "1112244455114", "some adr"));
            ctrl.addPatient(new Patient("doew", "1112244455115", "some adr"));
        } catch (PatientException e) {
            e.printStackTrace();
        }
    }

    private void refreshContext(){
        refreshFiles(patients);
        refreshFiles(consultations);
        repo = new Repository(patients, consultations);
        ctrl = new DoctorController(repo);
    }

    private void refreshFiles(String file){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File(file));
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
