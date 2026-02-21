import java.util.*;

public class OnboardingService {
    private final Parser parser;
    private final Validator validator;
    private final StudentMaker maker;
    private final FakeDb db;

    public OnboardingService(FakeDb db) {
        this.db = db;
        this.parser = new Parser();
        this.validator = new Validator();
        this.maker = new StudentMaker();
    }

    public StudentRecord registerFromRawInput(String raw) {
        Map<String,String> map = parser.parse(raw);

        RegistrationRequest req = new RegistrationRequest(
                map.get("name"),
                map.get("email"),
                map.get("phone"),
                map.get("program")
        );

        validator.validate(req);

        StudentRecord rec = maker.make(req, db.count());

        db.save(rec);

        return rec;
    }
}
