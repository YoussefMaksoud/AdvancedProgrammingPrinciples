public class SizeFactorException extends Exception {

    public SizeFactorException(){
        super("\nThe dimensions are not allowed to be scaled by this factor");
    }
}
