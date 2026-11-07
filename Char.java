public class Char {

    private String name;
    private String description;
    private String skill;
    private String rarity;

    public Char(String name, String rarity, String skill, String description) {
        this.name = name;
        this.rarity = rarity;
        this.skill = skill;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSkill() {
        return skill;
    }

    public String getRarity() {
        return rarity;
    }

    public String getInfo() {
        String formattedSkill = skill.replace(";", "\n       ");
    
        return "Name: " + name + 
           "\nRarity: " + rarity + 
           "\nSkill: " + formattedSkill + 
           "\nDescription: " + description;
    }

}
