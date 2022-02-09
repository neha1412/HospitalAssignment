package HospitalAssignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Patients {

    private String patientName;
    private String location;
    private List<LocalDate> visitDate;

    public Patients(String patientName, String location) {
        this.patientName = patientName;
        this.location = location;
        visitDate = new ArrayList<LocalDate>();
    }

    public String getPatientName() {
        return patientName;
    }

    public String getLocation() {
        return location;
    }

    public List<LocalDate> addVisits(LocalDate... visitDates) {
        for (LocalDate date : visitDates) {
            visitDate.add(date);
        }
        return visitDate;
    }

    public List<LocalDate> getvisitDate() {
            return visitDate.stream().filter(VisitDate -> VisitDate.getDate()).collect(Collectors.toList());

        }

        public boolean isVisitDateBetweenRange(LocalDate startDate,LocalDate endDate){
        if(getvisitDate().stream().filter(VisitDate -> VisitDate.isAfter(startDate) && VisitDate.isBefore(endDate)).count() > 0)
            return true;
        else
            return false;
        }
    }

