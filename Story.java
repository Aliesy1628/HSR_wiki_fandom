public class Story {
    
    private String name;
    private String description;

    public Story(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getInfo() {
        String formattedDescription = description.replace(";", "\n");

        return "===========================================" +
            "\nName: " + name + 
           "\nDescription: " + formattedDescription +
           "\n===========================================" ;
    }
}
