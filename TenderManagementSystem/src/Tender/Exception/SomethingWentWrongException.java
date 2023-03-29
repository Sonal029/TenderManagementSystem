package Tender.Exception;

public class SomethingWentWrongException extends Exception 
{
	@Override
    public String toString() {
	return "Some thing went wrong, try again later";
}
}
