package qa.quru.page;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {
    public void openProfilePage() {
        open("/profile");
    }

    public void checkDisappearBook(String bookId) {
        $("[id='" + bookId + "']").shouldBe(disappear);

    }
}
