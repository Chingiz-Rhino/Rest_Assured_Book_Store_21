package qa.quru.tests;

import qa.quru.models.CredModel;

public class TestData {
    public static final  String LOGIN ="testtest123";
    public static final  String  PASSWORD = "Testtest123!";
    public static final  String  ISBN = "9781593277574";

    public static CredModel credModel = new CredModel(LOGIN, PASSWORD);

    public static String getISBN(){
        return ISBN;
    }

}
