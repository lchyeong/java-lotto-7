package lotto.service;

import java.util.List;
import lotto.validator.NumberParser;
import lotto.validator.NumberValidator;
import lotto.validator.PurchaseValidator;
import lotto.view.InputView;

public class InputService {
    private final InputView inputView;
    private final PurchaseValidator purchaseValidator;
    private final NumberValidator numberValidator;

    public InputService(InputView inputView, PurchaseValidator purchaseValidator, NumberValidator numberValidator) {
        this.inputView = inputView;
        this.purchaseValidator = purchaseValidator;
        this.numberValidator = numberValidator;
    }

    private String input;
    private boolean pass;

    public int promptAndValidatePurchaseMoney() {
        do {
            input = inputView.promptPurchaseAmount();
            pass = purchaseValidator.validatePurchaseMoney(input);
        } while (!pass);
        return Integer.parseInt(input);
    }

    public List<Integer> promptAndValidateWinningNumbers() {
        do {
            input = inputView.promptWinningNumbers();
            pass = numberValidator.validateWinningNumbers(input);
        } while (!pass);
        return NumberParser.toNumbers(input);
    }

    public int promptAndValidateBonusNumber() {
        do {
            input = inputView.promptBounusNumber();
            pass = numberValidator.validateBonusNumber(input);
        } while (!pass);
        return Integer.parseInt(input);
    }
}