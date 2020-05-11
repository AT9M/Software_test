package ie.project;

import java.time.LocalDate;

public class DateComparator {


    public boolean Compare_Date(LocalDate date){
        LocalDate datenow = LocalDate.now();
        if(date.isBefore(datenow)){
            return false;
        }
        else {
            return true;
        }
    }
}
