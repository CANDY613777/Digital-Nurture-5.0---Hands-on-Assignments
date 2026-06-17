public class ForecastTest {

    public static void main(String[] args) {

        double initialValue = 10000;
        double growthRate = 0.10;
        int years = 5;

        double futureValue =
                FinancialForecast.predictFutureValue(
                        initialValue,
                        growthRate,
                        years);

        System.out.printf(
                "Predicted Future Value after %d years: %.2f",
                years,
                futureValue);
    }
}