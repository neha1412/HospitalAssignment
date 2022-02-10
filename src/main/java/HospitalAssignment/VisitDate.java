package HospitalAssignment;

import java.time.LocalDate;

public class VisitDate {

    LocalDate dateOfVisit;

    public LocalDate getDateOfVisit() {
        return this.dateOfVisit;
    }

    public VisitDate(LocalDate date) {
        this.dateOfVisit = date;
    }
}
