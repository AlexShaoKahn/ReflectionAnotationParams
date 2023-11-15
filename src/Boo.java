public class Boo {
    @TestAnnotation()
    private String boo(int a, int b) {
        return String.valueOf(a).repeat(b) +
                String.valueOf(b).repeat(a);
    }
}
