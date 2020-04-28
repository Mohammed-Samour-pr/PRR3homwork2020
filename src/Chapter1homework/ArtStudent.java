package Chapter1homework;

public class ArtStudent extends Student {

    private int midTerm;
    private int report;
    private int finalTerm;

    public ArtStudent(int id, String name, String major, int midTerm, int report, int finalTerm) {
        super(id, name, major);
        this.midTerm = midTerm;
        this.report = report;
        this.finalTerm = finalTerm;
        this.setGrade((midTerm * 0.40) + (report * 0.10) + (finalTerm * 50));

    }

    public int getMidTerm() {
        return midTerm;
    }

    public void setMidTerm(int midTerm) {
        this.midTerm = midTerm;
    }

    public int getReport() {
        return report;
    }

    public void setReport(int report) {
        this.report = report;
    }

    public int getFinalTerm() {
        return finalTerm;
    }

    public void setFinalTerm(int finalTerm) {
        this.finalTerm = finalTerm;
    }

}
