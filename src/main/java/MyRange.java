public class MyRange {
    private final String input;

    public MyRange(String input) {
        this.input = input;
    }

    public boolean starWithInclude() {
        return this.input.startsWith("[");
    }

    public boolean endWithInclude() {
        return  this.input.endsWith("]");
    }

    public void validate() throws InputInvalidException {
        if(!this.input.startsWith("(")|| !this.input.startsWith("[")){
            throw new InputInvalidException("Input error");
        }
    }
}
