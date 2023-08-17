package Interface;

public interface Skillful {
    String getLanguage();

    default String mainSkill() {
        return "Learn " + getLanguage();
    }
}
