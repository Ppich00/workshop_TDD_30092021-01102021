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
        if(!"(".startsWith(this.input)|| !"[".startsWith(this.input)){
            throw new InputInvalidException("Input error");
        }
        if(!"(".endsWith(this.input)|| !"]".endsWith(this.input)){
            throw new InputInvalidException("Input error");
        }

    }
}
