import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


import java.util.Date;

public class Main {

    public static void main(String[] args) throws TelegramApiException {


        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();
        Date currentDate = new Date();
        try
        {
            telegramBotsApi.registerBot(bot);
            //Выводим в консоль что бот запустился.
            System.out.println(currentDate);
            System.out.println("Bot running...");

        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

    }
}