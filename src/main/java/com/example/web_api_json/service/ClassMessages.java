package com.example.web_api_json.service;

import java.time.LocalDateTime;


public class ClassMessages {
    public interface IMessage {

    }

    // класс простого сообщения
    public static class Message implements IMessage {
        public String message;           // сообщение
        public LocalDateTime time;       // время

        public Message(String message) {
            this.message = message;
            this.time = LocalDateTime.now();
        }

        @Override
        public String toString() {
            return time + ": " + message;
        }
    }

    // входящее сообщение
    public static class InputMessage implements IMessage {
        // параметры
        public LocalDateTime date1;
        public LocalDateTime date2;
        public String typeResult;

        InputMessage(LocalDateTime date1, LocalDateTime date2, String typeResult) {
            this.date1 = date1;
            this.date2 = date2;
            this.typeResult = typeResult;
        }

        @Override
        public String toString() {
            return "InputMessage{" +
                    "date1=" + date1 +
                    ", date2=" + date2 +
                    ", typeResult='" + typeResult + '\'' +
                    '}';
        }
    }

    // ответ
    public static class OutputMessage implements IMessage {
        public LocalDateTime date1;
        public LocalDateTime date2;
        public String typeResult;
        public String result;

        public OutputMessage(LocalDateTime date1, LocalDateTime date2, String typeResult, String result) {
            this.date1 = date1;
            this.date2 = date2;
            this.typeResult = typeResult;
            this.result = result;
        }

        @Override
        public String toString() {
            return "Date1 " + date1 + ", date2 " + date2 + ". TypeResult: " + typeResult + "Result: " + result;
        }
    }


    public static class ErrorMessage extends Message {
        public ErrorMessage(String error) {
            super(error);
        }
    }
}
