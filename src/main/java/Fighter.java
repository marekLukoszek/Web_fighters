public class Fighter {
    String surname;
    String firstName;
    String style;
    String nationality;

    public Fighter(String surname, String firstName, String style, String nationality) {
        this.surname = surname;
        this.firstName = firstName;
        this.style = style;
        this.nationality = nationality;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStyle() {
        return style;
    }

    public String getNationality() {
        return nationality;
    }

}
