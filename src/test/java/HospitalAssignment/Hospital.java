package HospitalAssignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hospital {

    private List<Patients> patientList;
    String location;

    public Hospital(String location) {
        patientList = new ArrayList<>();
        this.location = location;
    }

    public List<Patients> getPatientList() {
        return patientList;
    }

    public String getLocation() {
        return location;
    }

    public List<Patients> addPatient(Patients... patients) {
        for (Patients patients1 : patients) {
            patientList.add(patients1);

        }
        return patientList;
    }

    public long getTotalPatientWithinATimeRange(LocalDate startDate, LocalDate EndDate){
            return patientList.stream().filter(s-> s.isVisitDateBetweenRange(startDate,EndDate)).count();

        }

    public long getTotalLocalPatientsWithinATimeRange(LocalDate startDate, LocalDate EndDate){
        return patientList.stream().filter(s -> s.getLocation().equals(this.location) && s.isVisitDateBetweenRange(startDate, EndDate)).count();

    }

    public long getTotalOutStationPatientsWithinATimeRange(LocalDate startDate, LocalDate EndDate){
        return getTotalLocalPatientsWithinATimeRange(startDate,EndDate)-getTotalOutStationPatientsWithinATimeRange(startDate, EndDate);

    }

    public double getLocalPatientPercentageWithinATimeRange(LocalDate startDate, LocalDate EndDate){
        double localPercent=0.0;
        long totPatients= getTotalPatientWithinATimeRange(startDate, EndDate);
        long localPatients = getTotalLocalPatientsWithinATimeRange(startDate, EndDate);
        localPercent = ((localPatients)/totPatients)*100;
        return localPercent;
    }

    public double getOutstationPatientPercentageWithinATimeRange(LocalDate startDate, LocalDate EndDate){
        double localPercent=0.0;
        long totPatients= getTotalPatientWithinATimeRange(startDate, EndDate);
        long outStationPatients = getTotalLocalPatientsWithinATimeRange(startDate, EndDate);
        localPercent = ((outStationPatients)/totPatients)*100;
        return localPercent;
    }

}
