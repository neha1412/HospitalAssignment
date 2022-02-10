package HospitalAssignment;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder

public class Patients {

    private String patientName;
    private String location;
    private List<LocalDate> visitDate;

    public Patients(String patientName, String location) {
        this.patientName = patientName;
        this.location = location;
        visitDate = new ArrayList<LocalDate>();
    }

    public List<LocalDate> addVisits(LocalDate... visitDates) {
        for (LocalDate date : visitDates) {
            visitDate.add(date);
        }
        return visitDate;
    }

    public List<LocalDate> getvisitDate() {
            return visitDate.stream().filter(VisitDate->VisitDate.getDateOfVisit()).collect(Collectors.toList());

        }

        public boolean isVisitDateBetweenRange(LocalDate startDate,LocalDate endDate){
        if(getvisitDate().stream().filter(VisitDate -> VisitDate.isAfter(startDate) && VisitDate.isBefore(endDate)).count() > 0)
            return true;
        else
            return false;
        }
    }

