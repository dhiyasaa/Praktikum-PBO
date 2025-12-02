public class Textbook extends Book {
    private String studyField;

    public Textbook(String title, String author, String studyField) {
        super(title, author);
        this.studyField = studyField;
    }

    public String getStudyField() { return studyField; }
}