package ie.project;

abstract class Checker {
    public Boolean checkNameLenght(String name){
        if(name.length()>1){
            return true;
        }
        else {
            return false;
        }

    }
    public Boolean checkPhone(String phone){
        if(phone.length()>12){
            return true;
        }
        else {
            return false;
        }

    }
    public Boolean checkOption(String test,String A,String B,String C,String D){
        if((test.equalsIgnoreCase(A))||(test.equalsIgnoreCase(B))||(test.equalsIgnoreCase(C))||(test.equalsIgnoreCase(D))){
            return true;
        }
        else{
            return false;
        }
    }
}
