package ie.project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Communication extends Checker implements Formatter  {
    public String name_Caller;
    public String phoneNumber_Caller;
    public String phoneNumber_Receiver;
    public String name_Receiver;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


    public Communication(String name_Caller, String phoneNumber_Caller,String name_Receiver ,String phoneNumber_Receiver ) {
       setName_CallerCom(name_Caller);
       setPhoneNumber_Caller(phoneNumber_Caller);
       setName_ReceiverCom(name_Receiver);
       setPhoneNumber_Receiver(phoneNumber_Receiver);
    }

    public Communication() {
    }

    public void setName_CallerCom(String name) {
        if(checkNameLenght(name)) {
            this.name_Caller = name;
        }
        else{
            throw new IllegalArgumentException("not a valid name");
        }
    }


    public String getPhoneNumber_Caller() {
        return phoneNumber_Caller;
    }

    public String getPhoneNumber_Receiver() {
        return phoneNumber_Receiver;
    }

    public void setPhoneNumber_Receiver(String phoneNumber) {
        if(checkPhone(phoneNumber)){
            this.phoneNumber_Receiver = phoneNumber;
        }
        else {
            throw new IllegalArgumentException("not a valid Phone Number pass it as follow : +(country indicatif)XXXXXXXXXX");
        }
    }



    public void setName_ReceiverCom(String name) {
        if(checkNameLenght(name)) {
            this.name_Receiver = name;
        }
        else{
            throw new IllegalArgumentException("not a valid name");
        }
    }

    public void setPhoneNumber_Caller(String phoneNumber) {
        if(checkPhone(phoneNumber)){
            this.phoneNumber_Caller = phoneNumber;
        }
        else {
            throw new IllegalArgumentException("not a valid Phone Number pass it as follow : +(country indicatif)XXXXXXXXXX");
        }
    }

    public String call(String name_Caller,String phoneNumber_Caller,String name_Receiver,String phoneNumber_Receiver){
        LocalDateTime now = LocalDateTime.now();
        return name_Caller +" called from "+phoneNumber_Caller+" to "+name_Receiver+" at "+phoneNumber_Receiver+" | Timestamp";
    }

    public String msg(String name_Caller,String phoneNumber_Caller,String name_Receiver,String phoneNumber_Receiver,String msg){
        LocalDateTime now = LocalDateTime.now();
        return name_Caller +" called from "+phoneNumber_Caller+" to "+name_Receiver+" at "+phoneNumber_Receiver+" | Timestamp The message is :"+msg;
    }

    public String getName_Caller() {
        return name_Caller;
    }

    public String getName_Receiver() {
        return name_Receiver;
    }

    @Override
    public String format() throws FormatException {
        return "Name sender: "+getName_Caller()+" Phone sender: "+getPhoneNumber_Caller()+" Name Receiver: "+getName_Receiver()+" Phone Receiver: "+getPhoneNumber_Receiver();
    }

    //for code coverage
    public String getInfo() throws FormatException {
        return format();
    }
}
