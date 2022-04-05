package pages;

import base.BasePage;
import data.TimeWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQAItemsListPage extends BasePage {
    private final WebDriver driver;

    public DemoQAItemsListPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By positionToAdd = By.xpath("//*[contains(text(),'Tokyo Talkies')]");
    private final By wishListButton = By.cssSelector("#noo-site > div.page_fullwidth > div:nth-child(4) > div > div.padding-stylebox.wpb_column.vc_column_container.vc_col-sm-12.vc_col-lg-7.vc_col-md-7 > div > div > div > div.noo-sh-product-grid.woocommerce > div.noo-sh-product-html.columns_3.no_masonry.three.row.is-flex > div.noo-product-item.noo-product-sm-4.not_featured.post-704.product.type-product.status-publish.has-post-thumbnail.product_cat-dress.product_tag-dress.product_tag-women.has-featured.first.instock.sale.shipping-taxable.purchasable.product-type-variable.has-default-attributes > div > div.noo-product-thumbnail > div > div.yith-wcwl-add-to-wishlist.add-to-wishlist-704.wishlist-fragment.on-first-load > div > a");
    private final By wishListPage = By.xpath("//*[contains(text(),'My Wishlist')]");
    private final By messageItemIsAdded = By.xpath("//div[@id='yith-wcwl-message']");


    public DemoQAItemsListPage addingPositionToWL() {
        moveToElement(positionToAdd);
        click(wishListButton, TimeWait.TIME_WAIT_5);
        waitVisibility(messageItemIsAdded);
        return this;
    }

    public WishListPage openingWishList() {
        click(wishListPage,TimeWait.TIME_WAIT_10);
        return new WishListPage(driver);
    }

}
//B) в задании использовать паттерн page object
//1. Open shop.demoqa.com
//2. Favorite Tokyo-Talkies (Add to Wishlist)
//3. Open wishlist
//4. Verify that Tokyo-Talkies is present in wishlist