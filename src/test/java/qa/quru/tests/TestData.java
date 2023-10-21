package qa.quru.tests;

import qa.quru.models.CredModel;

public class TestData {
    private static final  String LOGIN ="testtest123";
    private static final  String  PASSWORD = "Testtest123!";
    private static final  String  ISBN = "9781593277574";

    public static CredModel credModel = new CredModel(LOGIN, PASSWORD);


   static String getISBN(){
        return ISBN;
    }

}
