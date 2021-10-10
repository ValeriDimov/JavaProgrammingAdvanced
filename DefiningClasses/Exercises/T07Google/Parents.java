package DefiningClasses.Exercises.T07Google;

public class Parents {
    private String parentName;
    private String parentBirthday;

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    public String getParentName() {
        return parentName;
    }

    public String getParentBirthday() {
        return parentBirthday;
    }

    @Override
    public String toString() {
        if (this.parentName != null) {
            return String.format("%s %s", this.parentName, this.parentBirthday);
        } else {
            return "";
        }
    }
}
