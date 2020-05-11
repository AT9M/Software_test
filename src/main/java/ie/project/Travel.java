package ie.project;

public class Travel extends Checker implements Formatter{
    public String place_to_go;
    public String Country;
    public String MethodTransport;

    public Travel() {
    }

    public Travel(String place_to_go, String country, String methodTransport) {
        setPlace_to_go(place_to_go);
        setCountry(country);
        setMethodTransport(methodTransport);
    }

    public String getPlace_to_go() {
        return place_to_go;
    }

    public void setPlace_to_go(String place_to_go) {
        if(place_to_go.length()>=1){
            this.place_to_go = place_to_go;
        }
        else {
            throw new IllegalArgumentException("Not a valid place");
        }
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        if(country.length()>=2){
            this.Country = country;
        }
        else {
            throw new IllegalArgumentException("Not a valid country");
        }
    }

    public String getMethodTransport() {
        return MethodTransport;
    }

    public void setMethodTransport(String methodTransport) {
        if(checkOption(methodTransport,"Car","Plane","Train","Boat")){
            MethodTransport = methodTransport;
        }
        else{
            throw new IllegalArgumentException("not a valid kind of transport");
        }

    }


    @Override
    public String format() throws FormatException {
        return "You will go to "+getPlace_to_go()+" in "+getCountry()+" using a "+getMethodTransport();
    }
}
