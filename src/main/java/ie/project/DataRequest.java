package ie.project;

public class DataRequest extends Checker {
    public String Kind_ofData;
    public String nameData;

    public DataRequest() {
    }

    public DataRequest(String kind_ofData, String nameData) {
       setKind_ofData(kind_ofData);
       setNameData(nameData);
    }

    public String getKind_ofData() {
        return Kind_ofData;
    }

    public void setKind_ofData(String kind_ofData) {
        if(checkOption(kind_ofData,"Document","Music","Picture","Video")){
            this.Kind_ofData = kind_ofData;
        }
       else{
           throw new IllegalArgumentException("not a valid kind of data");
        }
    }

    public String getNameData() {
        return nameData;
    }

    public void setNameData(String nameData) {
        if(nameData.length()>3) {
            this.nameData = nameData;
        }
        else{
            throw new IllegalArgumentException("not enought characters");
        }
    }


}
