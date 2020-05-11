package ie.project;

public class AssistantOption extends Checker  {
    private String nameAssitant;
    private String nameUser;

    public AssistantOption(String name, String nameUser) {
        setName(name);
        setNameUser(nameUser);
    }



    public void setName(String name) {
        if(checkNameLenght(name)){
            this.nameAssitant = name;
        }
        else {
            throw new IllegalArgumentException("not a valid name");
        }
    }



    public void setNameUser(String nameUser) {
        if(checkNameLenght(nameUser)){
            this.nameUser = nameUser;
        }
        else {
            throw new IllegalArgumentException("not a valid name");
        }
    }


    public String getNameAssitant() {
        return nameAssitant;
    }

    public String getNameUser() {
        return nameUser;
    }
}
