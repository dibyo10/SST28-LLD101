public class DisciplinaryFlagRule implements EligibilityRule {
    public String evaluate(StudentProfile student) {
        if (student.disciplinaryFlag != LegacyFlags.NONE) {
            return "disciplinary flag present";
        }
        return null;
    }
}
