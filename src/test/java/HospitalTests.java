import HospitalAssignment.Hospital;
import HospitalAssignment.Patients;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

public class HospitalTests {

    Patients p1,p2,p3,p4;
    Hospital h1;

    @BeforeClass
    public void createPatients(){

        p1= new Patients("Patient1", "Bangalore" );
        p1.addVisits(LocalDate.parse("2022-01-15"));
        p2= new Patients("Patient2","KGF");
        p2.addVisits(LocalDate.parse("2022-01-16"));
        p3= new Patients("patient3","Mysore");
        p3.addVisits(LocalDate.parse("2022-01-10"));
        p4= new Patients("patient4","Bangalore");
        p4.addVisits(LocalDate.parse("2022-01-12"));
        h1= new Hospital("Bangalore");
    }

    @Test
    public void toAddPatientstoHospital(){
        List<Patients> patientsList= h1.addPatient(p1,p2,p3,p4);
        Assert.assertEquals(patientsList.size(),4);

    }

    @Test
    public void toCheckifPatientisLocalorOutstation() {
        List<Patients> patientList = h1.addPatient(p1, p2, p3, p4);
        for (Patients patients : patientList) {
            if (patients.getLocation().equals("Bangalore")) {
                Reporter.log("Patient is a local patient" + patients.getPatientName());
            } else {
                Reporter.log("Patient is from outstation " + patients.getPatientName());
            }

        }
    }

    @Test
    public void toGetCountOfLocalPatients(){
        double localCount=0.0;
        List<Patients> patientList = h1.addPatient(p1, p2, p3, p4);
        for (Patients patients : patientList)
        {

            localCount = h1.getTotalLocalPatientsWithinATimeRange(LocalDate.parse("2022-01-10"), LocalDate.parse("2022-01-19"));
        }
        Assert.assertEquals(2,localCount);

        }

        @Test
        public void toGetCountOfOutstationPatients(){
            double countOutstation=0.0;
            List<Patients> patientList = h1.addPatient(p1, p2, p3, p4);
            for (Patients patients : patientList)
            {
                countOutstation = h1.getTotalLocalPatientsWithinATimeRange(LocalDate.parse("2022-01-10"), LocalDate.parse("2022-01-19"));
            }
            Assert.assertEquals(2,countOutstation);
        }

        @Test
        public void percentOfLocalPatient(){
        double localPercent;
        localPercent= h1.getLocalPatientPercentageWithinATimeRange(LocalDate.parse("2022-01-10"), LocalDate.parse("2022-01-19"));
        Assert.assertEquals(localPercent,50);
        }

        @Test
        public void percentofOutstationPatient(){
        double outstationPercent;
        outstationPercent= h1.getOutstationPatientPercentageWithinATimeRange(LocalDate.parse("2022-01-10"),LocalDate.parse("2022-01-19"));
        Assert.assertEquals(outstationPercent,50);
    }
}
