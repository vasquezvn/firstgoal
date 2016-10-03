package Scripts;

import Framework.BrowserManager;
import Pages.LoginPage;
import Pages.Products.NewProductForm;
import Pages.Products.ProductProfile;
import Pages.Products.ProductsHome;
import Pages.TopBar.TabBar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ivan on 3/10/16.
 */
public class EditProduct {

    TabBar tapBar;
    ProductsHome productsHome;
    NewProductForm newProductForm;
    ProductProfile productProfile;

    //region values
    private String  productName = "product_001";
    private String  productNameUpdated = "product_002";
    private String  productCode = "prod_001";
    private String  productCodeUpdated = "prod_002";
    private String  descriptionProduct = "description Test";
    private String  descriptionProductUpdated = "description Test2";
    private boolean isActive = true;
    private String  productFamily = "None";
    private String  productFamilyUpdated = "";
    //endregion

    @Before
    public void BeforeTest() {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        tapBar = new LoginPage()
                .setUserNameField("automationqa@test.com")
                .setPasswordField("Control123")
                .clickLoginToSalesForceButton();

        createProduct();

    }

    private void createProduct() {
        productsHome = tapBar
                .clickProductsTab();

        newProductForm = productsHome
                .clickNewButton();

        productProfile = newProductForm
                .setProductName(productName)
                .setProductCode(productCode)
                .checkActiveFlag(isActive)
                .chooseProductFamilyDdl(productFamily)
                .setDescription(descriptionProduct)
                .pressSaveBtn();
    }

    @Test
    public void EditProduct() {
        newProductForm = productProfile
                .pressEditBtn();

        productProfile = newProductForm
                .setProductName(productNameUpdated)
                .setProductCode(productCodeUpdated)
                .uncheckActiveFlag(isActive)
                .chooseProductFamilyDdl(productFamilyUpdated)
                .setDescription(descriptionProductUpdated)
                .pressSaveBtn();

        Assert.assertEquals(productProfile.getProductName(), productNameUpdated);
        Assert.assertEquals(productProfile.getProductcode(), productCodeUpdated);
        Assert.assertEquals(productProfile.isActiveFlag(), false);
        Assert.assertEquals(productProfile.getProductFamily(), "-None-");
        Assert.assertEquals(productProfile.getDescription(), descriptionProductUpdated);

    }

    @After
    public void afterTest() {
        productProfile.pressDeleteBtn();

    }
}
