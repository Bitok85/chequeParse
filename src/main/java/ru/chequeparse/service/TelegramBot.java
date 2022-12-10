package ru.chequeparse.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.chequeparse.config.BotConfig;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private static final Logger LOG = Logger.getLogger(TelegramBot.class.getSimpleName());
    private final BotConfig config;

    public TelegramBot(BotConfig config) {
        this.config = config;
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String msgText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String userName = update.getMessage().getChat().getUserName();
            if (msgText.equals("/start")) {
                try {
                    startCommandReceived(chatId, userName);
                } catch (RuntimeException e) {
                    LOG.error("Exception", e);
                }
            } else {
                sendMessage(chatId, "sorry, I'm dumb yet");
            }
        }
    }

    private void startCommandReceived(long chatId, String name) {
        String answer = "Hi" + name;
        sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId, String msgToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(msgToSend);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            LOG.error("Sending message error");
        }
    }
}
