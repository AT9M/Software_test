package ie.project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Meeting implements Formatter{
    public String name_Meeting;
    public LocalDate Time_of_Meeting;
    DateComparator dateComparator = new DateComparator();
    public String pattern = "dd-MM-yyyy";

    public Meeting() {
    }

    public Meeting(String name_Meeting, LocalDate time_of_Meeting) {
       setName_Meeting(name_Meeting);
       setTime_of_Meeting(time_of_Meeting);
    }


    public String getName_Meeting() {
        return name_Meeting;
    }

    public void setName_Meeting(String name_Meeting) {
        if(name_Meeting.length()>5){
        this.name_Meeting = name_Meeting;}
        else {
            throw new IllegalArgumentException("not enought characters");
        }
    }

    public LocalDate getTime_of_Meeting_LocalDate() {
        return Time_of_Meeting;
    }

    public void setTime_of_Meeting(LocalDate time_of_Meeting) {
        if(dateComparator.Compare_Date(time_of_Meeting)){
            Time_of_Meeting = time_of_Meeting;
        }
        else{
            throw new IllegalArgumentException("You can't time travel yet...");
        }

    }

    @Override
    public String format() throws FormatException {
        return getTime_of_Meeting_LocalDate().format(DateTimeFormatter.ofPattern(pattern));
    }

    public String getTime_of_Meeting() throws FormatException {
        return format();
    }
}
