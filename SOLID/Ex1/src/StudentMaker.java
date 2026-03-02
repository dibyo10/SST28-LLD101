public class StudentMaker {
    public StudentRecord make(RegistrationRequest req, int currentCount) {
        String id = IdUtil.nextStudentId(currentCount);
        return new StudentRecord(
                id,
                req.name(),
                req.email(),
                req.phone(),
                req.program()
        );
    }
}
