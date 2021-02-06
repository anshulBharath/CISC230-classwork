
public class TestingMain {

	public static void main(String[] args) {
		
		StockIndexCard sic;
		
		/*try {
			sic = new StockIndexCard(1, "Pointing at Bad Guys", "Ralph Waldo", -2.00, 50);
		}
		catch(NegativePriceException ex){
			System.out.println(ex.getMessage());
			System.out.println("Making card with positve price");
			sic = new StockIndexCard(1, "Pointing at Bad Guys", "Ralph Waldo", 12.00, 50);
		}
		catch(IllegalArgumentException ex){
			System.out.println(ex.getMessage());
			sic = null;
		}
		System.out.println(sic);*/
		
		try {
			sic = new StockIndexCard(1, "Pointing at Bad Guys", "Ralph Waldo", 12.00, 50);
		}
		catch(NegativePriceException ex) {
			try {
				sic = new StockIndexCard(1, "Pointing at Bad Guys", "Ralph Waldo", 12.00, -50);
			}
			catch(Exception e) {
				System.out.println("Chezburger");
				sic = null;
			}
			
		}
		System.out.println(sic.toString());
	}

}
