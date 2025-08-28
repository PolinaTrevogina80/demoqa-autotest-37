package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.TextBoxResultComponent;

public class TextBoxWithPOTest extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    TextBoxResultComponent result = new TextBoxResultComponent();

    @Test
    public void textBoxOpenTest(){
        textBoxPage.openPage();
    }

    @Test
    public void textBoxFullFillTest(){
        String fullName="Test Test",
                email="test@test.ts",
                currentAddress="Current Address test1",
                permanentAddress="Permament Address test2";

        textBoxPage.openPage()
                .removeAdds()
                .setFullName(fullName)
                .setUserEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit();

        result.checkResultAppear()
                .checkResults(fullName,email,currentAddress,permanentAddress);
    }

    @Test
    public void textBoxNegativeTest(){

        textBoxPage.openPage()
                .removeAdds()
                .submit();

        result.checkResultNotAppear();
    }
}
