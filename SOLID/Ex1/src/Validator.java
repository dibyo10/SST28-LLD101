import java.util.ArrayList;
import java.util.List;

public class Validator {

    public void validate(RegistrationRequest req){
        List<String> errors = new ArrayList<>();
        if (req.name().isBlank()) errors.add("name is required");
        if (req.email().isBlank() || !req.email().contains("@")) errors.add("email is invalid");
        if (req.phone().isBlank() || !req.phone().chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(req.program().equals("CSE") || req.program().equals("AI") || req.program().equals("SWE"))) errors.add("program is invalid");

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join(", ", errors));
        }
    }
}
