public class EmptyKeyException extends NullPointerException {
    /**
     *
     */
    private static final long serialVersionUID = 3626276981130854347L;

    @Override
    public String getMessage() {
        return "Key is Empty";
    }
}
