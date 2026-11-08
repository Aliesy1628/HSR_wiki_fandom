import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Info {

    private List<Char> characters;
    private List<Story> stories;

    public String file_char = "data_char.txt";

    public List getCharacters() {
        return characters;
    }

    public List getStory() {
        return stories;
    }

    public Info() {
        this.characters = new ArrayList<>();
        this.stories = new ArrayList<>();
    }

    public Story cariStory(String name) {
        for (Story s : stories) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public Char cariCharacter(String name) {
        for (Char c : characters) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public void charList() {
        for (Char c : characters) {
            System.out.println("- " + c.getName());
        }
    }

    public void loadCharactersFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(file_char))) {
            characters.clear();
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String name = parts[0].trim();
                    String rarity = parts[1].trim();
                    String skill = parts[2].trim();
                    String description = parts[3].trim();
                    Char character = new Char(name, rarity, skill, description);
                    characters.add(character);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void loadStoryFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("data_story.txt"))) {
        stories.clear();
        String line;
        
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|", 2);
                
                if (parts.length >= 2) {
                    String name = parts[0].trim();
                    StringBuilder descBuilder = new StringBuilder();
                    descBuilder.append(parts[1].trim());

                    while ((line = br.readLine()) != null) {
                        if (line.trim().isEmpty()) break;
                        descBuilder.append(" ").append(line.trim());
                    }
                    
                    String description = descBuilder.toString();
                    Story story = new Story(name, description);
                    stories.add(story);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
