package helpers;

import pages.CalculatorPage;

public class PagesProvider {

    DriverHelpers driverHelpers;

    public PagesProvider(DriverHelpers driverHelpers) {
        this.driverHelpers = driverHelpers;
    }

    CalculatorPage calculatorPage;

    public CalculatorPage getCalculatorPage() {
        return (calculatorPage == null) ? calculatorPage = new CalculatorPage(driverHelpers) : calculatorPage;
    }

}
