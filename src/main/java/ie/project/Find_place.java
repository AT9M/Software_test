package ie.project;

public class Find_place {
    public String address;

    public Find_place() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address.length()>10){
            this.address = address;
        }
        else {
            throw new IllegalArgumentException("Not a valid address");
        }
    }

    public String WhereItis(){
        String addr =getAddress();
        return " "+addr+" is in Ireland (Galway) //hardcode for simplicity";
    }

    public Find_place(String address) {
        setAddress(address);
    }
}
