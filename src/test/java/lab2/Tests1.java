package lab2;

import controller.DoctorController;
import org.junit.Test;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests1 {

    @Test
    public void addPationMedsNull(){
        assertEquals(1, 1);
        List<String> str = new ArrayList<String>();
        str.add("vit c");str.add("nurofen");
//        Consultation c = new Consultation("0", "9999999999999","this is diag",str, "01.01.2019");

        String patients = "FilePatientsTest.txt";
        String consultations = "FileConsultationsTest.txt";
        Repository repo = new Repository(patients, consultations);
        DoctorController ctrl = new DoctorController(repo);

        try {
            ctrl.addConsultation("0", "9999999999999","this is diag",null, "01.01.2019");
            assertEquals("","bau");
        } catch (Exception e){
            assertEquals(e.getMessage(),"meds is null");
        }

    }

    @Test
    public void addPationOk(){
        assertEquals(1, 1);
        List<String> meds = new ArrayList<String>();
        meds.add("vit c");meds.add("nurofen");
//        Consultation c = new Consultation("0", "9999999999999","this is diag",str, "01.01.2019");

        String patients = "FilePatientsTest.txt";
        String consultations = "FileConsultationsTest.txt";
        Repository repo = new Repository(patients, consultations);
        DoctorController ctrl = new DoctorController(repo);

        try {
            ctrl.addConsultation(null, "9999999999999","this is diag",meds, "01.01.2019");
            assertEquals("","bau");
        } catch (Exception e){
            assertEquals(e.getMessage(),"invalid arguments");
        }

    }
}