public class CgrRule implements EligibilityRule {
    public String evaluate(StudentProfile student) {
        if (student.cgr < 8.0) {
            return "CGR below 8.0";
        }
        return null;
    }
}
