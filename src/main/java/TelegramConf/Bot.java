package TelegramConf;
import KeyboardMarkup.InlineKeyboard;
import Values.Steps;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {
    String step = "";
    private static final String TOKEN = "";       // Убрал :)
    private static final String USERNAME = "";    // Белокрылого (

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            if (update.getMessage().getText().equals("/start")) {
                try {
                    execute(InlineKeyboard.sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } else if (update.getCallbackQuery().getData().equalsIgnoreCase("Create")) { //   Главный метод создания
            try {
                step = Steps.STEP1.toString();
                execute(new SendMessage().setText("Имя заказчика").setChatId(update.getMessage().getChatId()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if (step.equals(Steps.STEP1.toString())) {
            try {
                step = Steps.STEP2.toString();
                execute(new SendMessage().setText("Наименовние процедуры").setChatId(update.getMessage().getChatId()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            if (step.equals(Steps.STEP2.toString())) {
                try {
                    step = Steps.STEP3.toString();
                    execute(new SendMessage().setText("Дата").setChatId(update.getMessage().getChatId()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
                if (step.equals(Steps.STEP3.toString())) {
                    try {
                        step = Steps.STEP4.toString();
                        execute(new SendMessage().setText("Место исполнения").setChatId(update.getMessage().getChatId()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
        }

        else if (update.getCallbackQuery().getData().equals("SMS")) {
                    try {
                        execute(new SendMessage().setText("ON OFF").setChatId(update.getCallbackQuery().getMessage().getChatId()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                } else if (update.getCallbackQuery().getData().equals("Database")) { // Посмотреть список внесенных в базу
                    try {
                        execute(new SendMessage().setText("DATE")
                                .setChatId(update.getCallbackQuery().getMessage().getChatId()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("TESTONE");
            }
}



