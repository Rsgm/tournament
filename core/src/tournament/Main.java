package tournament;

public class Main {

    public static void main(String[] args) {
        try {
            new Tournament().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
