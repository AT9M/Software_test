package ie.project;

import ie.project.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class miniprojectTest {

    Assistant assistant =new Assistant();


    //First Test How the app handle assertequals
    @Test
    public void testAssitantOption() throws IOException {
        assistant.modifyAssistantOption("getOption","");
        assertEquals("Name: Liam Name Assistant:Alsa",assistant.AssistantOption);
    }

    @Test
    public void testAssitantData() throws IOException {
        assistant.requestData("getData","","");
        assertEquals("Name Data: House of the rising sun kind of Data:Music",assistant.DataAsRequested);
    }

    @Test
    public void testAssitantPlace() throws IOException {
        assistant.FindAddress("221B Baker Street");
        assertEquals(" 221B Baker Street is in Ireland (Galway) //hardcode for simplicity",assistant.AddressPlace);
    }
    @Test
    public void testAssitantMeeting() throws IOException {
        assistant.MeetingOrganizer("getMeeting","", LocalDate.of(2021,04,20));
        assertEquals("Meeting name: Reunion with Paul Meeting Time 20-04-2021",assistant.MeetingInfo);
    }
    @Test
    public void testAssitantTravel() throws IOException {
        assistant.TravelOrganization("getTravel","","","");
        assertEquals("You will go to Toulon in France using a Boat",assistant.TravelInfo);
    }

    @Test
    public void testAssitantComm() throws IOException {
        assistant.cmdCommunication("getInfo","");
        assertEquals("Name sender: Liam Phone sender: +3312345678923 Name Receiver: Guo Phone Receiver: +8698765432123",assistant.ComInfo);
    }

    @Test
    public void testAssitantCommCall() throws IOException {
        assistant.cmdCommunication("call","");
        assertEquals("Liam called from +3312345678923 to Guo at +8698765432123 | Timestamp",assistant.ComInfo);
    }
    @Test
    public void testAssitantCommMsg() throws IOException {
        assistant.cmdCommunication("message","011");
        assertEquals("Liam called from +3312345678923 to Guo at +8698765432123 | Timestamp The message is :011",assistant.ComInfo);
    }

    //Now let's try with intentional errors

    @Test
    public void testAssitantOptionWUserName() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                AssistantOption assistantOption = new AssistantOption("f","dfsd");
            }
        });
        assertEquals("not a valid name", e.getMessage());
    }
    @Test
    public void testAssitantOptionWAssistantName() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                AssistantOption assistantOption = new AssistantOption("fqsfsdf","e");
            }
        });
        assertEquals("not a valid name", e.getMessage());
    }
    @Test
    public void testWDataName() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                DataRequest dataRequest = new DataRequest("Music","v");
            }
        });
        assertEquals("not enought characters", e.getMessage());
    }
    @Test
    public void testWKindofData() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                DataRequest dataRequest = new DataRequest("O","sdfsd");
            }
        });
        assertEquals("not a valid kind of data", e.getMessage());
    }
    @Test
    public void testWPlace() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Find_place findPlace = new Find_place("a");
            }
        });
        assertEquals("Not a valid address", e.getMessage());
    }
    @Test
    public void testWNameMeeting() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Meeting meeting = new Meeting("a",LocalDate.of(2200,05,13));
            }
        });
        assertEquals("not enought characters", e.getMessage());
    }
    @Test
    public void testWTimeMeeting() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Meeting meeting = new Meeting("afsdfs",LocalDate.of(1020,05,13));
            }
        });
        assertEquals("You can't time travel yet...", e.getMessage());
    }
    @Test
    public void testWPlaceTravel() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Travel travel = new Travel("","dsf","Boat");
            }
        });
        assertEquals("Not a valid place", e.getMessage());
    }
    @Test
    public void testWCountryTravel() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Travel travel = new Travel("gdfg","g","Boat");
            }
        });
        assertEquals("Not a valid country", e.getMessage());
    }
    @Test
    public void testWMethodTravel() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Travel travel = new Travel("dfggdf","dsgdff","gdsf");
            }
        });
        assertEquals("not a valid kind of transport", e.getMessage());
    }
    @Test
    public void testWComNameSender() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Communication communication= new Communication("","gvghgvhsdfdsfsdfs","sdfsdf","sdfsdfdsfdsfsd");
            }
        });
        assertEquals("not a valid name", e.getMessage());
    }
    @Test
    public void testWComPhoneSender() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Communication communication= new Communication("sdfsdfsd","","sdfsdf","sdfsdfdsfdsfsd");
            }
        });
        assertEquals("not a valid Phone Number pass it as follow : +(country indicatif)XXXXXXXXXX", e.getMessage());
    }
    @Test
    public void testWComNameReceiver() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Communication communication= new Communication("sdfsdfsdf","gvghgvhsdfdsfsdfs","","sdfsdfdsfdsfsd");
            }
        });
        assertEquals("not a valid name", e.getMessage());
    }
    @Test
    public void testWComPhoneReceiver() throws IOException {

        Exception e = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Communication communication= new Communication("sdfsdfsdf","gvghgvhsdfdsfsdfs","sdfsdf","");
            }
        });
        assertEquals("not a valid Phone Number pass it as follow : +(country indicatif)XXXXXXXXXX", e.getMessage());
    }
}




