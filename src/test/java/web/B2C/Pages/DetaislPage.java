package web.B2C.Pages;

import org.openqa.selenium.By;

public class DetaislPage {

    private static By getTotalPrice = By.xpath("//span[@class=\"price\"]");

    private static By grandTotalAmount = By.xpath("//div[@class=\"payable-right-section\"]//span[@class=\"grand_total_amount\"]");
}
