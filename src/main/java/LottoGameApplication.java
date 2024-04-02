import controller.LottoGameController;
import domain.LottoGenerator;
import domain.RandomLottoGenerator;
import view.LottoGameView;

public class LottoGameApplication {
	public static void main(String[] args) {
		LottoGameView lottoGameView = new LottoGameView();
		LottoGenerator lottoGenerator = new RandomLottoGenerator();
		LottoGameController lottoGameController
			= new LottoGameController(lottoGameView, lottoGenerator);

		lottoGameController.play();
	}
}
