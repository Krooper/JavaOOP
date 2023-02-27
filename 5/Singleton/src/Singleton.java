public class Singleton {
    private static Singleton instance;
    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton Inst(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}

