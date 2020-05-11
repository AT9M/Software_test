package ie.project;

public interface Namer {
    public String getNameUser_Caller() throws FormatException;
    public String getNameAssistant_Receiver() throws FormatException;
}
