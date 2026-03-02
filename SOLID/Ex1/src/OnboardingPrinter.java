public class OnboardingPrinter {
    public void printCreated(StudentRecord rec) {
        System.out.println("OK: created student " + rec.id);
    }

    public void printSaved(int totalStudents) {
        System.out.println("Saved. Total students: " + totalStudents);
    }

    public void printConfirmation(StudentRecord rec) {
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
