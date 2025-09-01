import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // here variable is null
        String name = null;

        // putting name inside optional
        Optional<String> optionalName = Optional.ofNullable(name);

        // if null then use default name
        String result = optionalName.orElse("Default Name");
        System.out.println("Name: " + result);

        // run only if value is not null
        optionalName.ifPresent(n -> System.out.println("Uppercase: " + n.toUpperCase()));

        // orElseGet makes value if null
        String value = optionalName.orElseGet(() -> "Generated Default");
        System.out.println("Value: " + value);

        // orElseThrow will give error if null
        try {
            String mustExist = optionalName.orElseThrow(() -> new RuntimeException("Value is missing!"));
            System.out.println(mustExist);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // print the error
        }
    }
}


