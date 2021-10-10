package DefiningClasses.Exercises.T07Google;

public class Children {
    private String childName;
    private String childBirthday;

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    public String getChildName() {
        return childName;
    }

    public String getChildBirthday() {
        return childBirthday;
    }

    @Override
    public String toString() {
        if (this.childName != null) {
            return String.format("%s %s", this.childName, this.childBirthday);
        } else {
            return "";
        }
    }
}
