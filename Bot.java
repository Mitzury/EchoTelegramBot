import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Date;

public class Bot extends TelegramLongPollingBot  {

    public String chatId;
    public String uName;
    public String mytime;
    public String message;
    public String uSecondName;
    public String uNick;

    public void sndMsg(String uChatId) throws InterruptedException {

        SendMessage msg = new SendMessage();
        msg.setChatId(uChatId);
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        // Проверка на сообщение
        if (update.hasMessage()) {
            // Проверка что оно текст
            if (update.getMessage().hasText()) {
                // Принимаем текст от пользователя
                this.message = update.getMessage().getText().trim();
                this.chatId = update.getMessage().getChatId().toString();
                this.mytime = new Date((long) update.getMessage().getDate() * 1000).toString();
                //Данные о пользователе
                User user = update.getMessage().getFrom();
                this.uName = user.getFirstName();
                this.uSecondName = user.getLastName();
                this.uNick = user.getUserName();
                //Пишем лог пользователя в консоль бота.
                System.out.println("Пользователь: " + user.getFirstName() + " " + user.getLastName() + " aka " + user.getUserName() + " написал: "
                        + message + " at " + mytime + " | " + chatId);
                SendMessage msg = new SendMessage();
                msg.setChatId(chatId);
                // Пишем Эхо ответ.


                try {
                    msg.setText(message);
                    execute(msg);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    @Override
    public String getBotUsername() {
        return "";
    }
    @Override
    public String getBotToken() {
        return "";
    }

}