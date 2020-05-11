package ie.project;


import java.time.LocalDate;

public class Assistant {                    // For faciliting the test  we will use already make constructor

    AssistantOption assistantOption = new AssistantOption("Alsa","Liam");
    Communication communication = new Communication("Liam","+3312345678923","Guo","+8698765432123");
    DataRequest dataRequest = new DataRequest("Music","House of the rising sun");
    Find_place findPlace = new Find_place("221B Baker Street");
    Meeting meeting = new Meeting("Reunion with Paul",LocalDate.of(2021,04,20));
    Travel travel = new Travel("Toulon","France","Boat");

    String AssistantOption="";
    String DataAsRequested="";
    String AddressPlace="";
    String MeetingInfo="";
    String TravelInfo="";
    String ComInfo="";

    public void modifyAssistantOption(String cmd,String input) throws FormatException {
        if(cmd.equalsIgnoreCase("setname")){ 
            assistantOption.setName(input);
        }
        else if(cmd.equalsIgnoreCase("setnameUser")){
            assistantOption.setNameUser(input);
        }
        else if(cmd.equalsIgnoreCase("getOption")){
            AssistantOption = "Name: "+assistantOption.getNameUser()+" Name Assistant:"+assistantOption.getNameAssitant();

        }
    }

    public void cmdCommunication(String cmd,String input) throws FormatException {
        if(cmd.equalsIgnoreCase("nameCaller")){
            communication.setName_CallerCom(input);
        }
        else if(cmd.equalsIgnoreCase("nameReceiver")){
            communication.setName_CallerCom(input);
        }
        else if(cmd.equalsIgnoreCase("phoneCaller")){
            communication.setPhoneNumber_Caller(input);
        }
        else if(cmd.equalsIgnoreCase("phoneReceiver")){
            communication.setPhoneNumber_Receiver(input);
        }
        else if(cmd.equalsIgnoreCase("call")){
            ComInfo=communication.call(communication.getName_Caller(),communication.getPhoneNumber_Caller(),communication.getName_Receiver(),communication.getPhoneNumber_Receiver());

        }
        else if(cmd.equalsIgnoreCase("message")){
            ComInfo=communication.msg(communication.getName_Caller(),communication.getPhoneNumber_Caller(),communication.getName_Receiver(),communication.getPhoneNumber_Receiver(),input);

        }
        else if(cmd.equalsIgnoreCase("getInfo")){
            ComInfo=communication.getInfo();

        }
    }

    public void requestData(String cmd,String input,String input2){
        if(cmd.equalsIgnoreCase("setData")){
            dataRequest.setNameData(input);
            dataRequest.setKind_ofData(input2);
        }
        if(cmd.equalsIgnoreCase("getData")){
            DataAsRequested= "Name Data: "+dataRequest.getNameData()+" kind of Data:"+dataRequest.getKind_ofData();

        }
    }

    public void FindAddress(String input){
        findPlace.setAddress(input);
        AddressPlace=findPlace.WhereItis();
        System.out.println(AddressPlace);
    }

    public void MeetingOrganizer(String cmd, String input, LocalDate input2) throws FormatException {
        if(cmd.equalsIgnoreCase("setMeeting")){
            meeting.setName_Meeting(input);
            meeting.setTime_of_Meeting(input2);
        }
        if(cmd.equalsIgnoreCase("getMeeting")){
            MeetingInfo= "Meeting name: "+meeting.getName_Meeting()+" Meeting Time "+meeting.getTime_of_Meeting();
            System.out.println(MeetingInfo);
        }
    }

    public void TravelOrganization(String cmd,String input,String input2,String input3) throws FormatException {
        if(cmd.equalsIgnoreCase("setPlace")){
            travel.setPlace_to_go(input);
            travel.setCountry(input2);
            travel.setMethodTransport(input3);
        }
        if(cmd.equalsIgnoreCase("getTravel")){
            TravelInfo=travel.format();
            System.out.println(TravelInfo);
        }
    }
}
