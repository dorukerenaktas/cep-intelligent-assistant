package com.ia.executor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ia.executor.kafka.KafkaConsumerImp;
import com.ia.executor.mail.MailAPI;
import org.apache.http.client.utils.DateUtils;
import org.apache.log4j.PropertyConfigurator;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        String broker = "localhost:9092";
        if (args.length > 0) {
            broker = args[0];
        } else if (System.getenv("KAFKA_BROKER") != null) {
            broker = System.getenv("KAFKA_BROKER");
        }

        String topic = "Actions";
        if (args.length > 1) {
            topic = args[1];
        } else if (System.getenv("KAFKA_TOPIC") != null) {
            topic = System.getenv("KAFKA_TOPIC");
        }

        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, -1);
        Date lastSend = now.getTime();

        KafkaConsumerImp consumer = new KafkaConsumerImp(broker, topic);
        consumer.addListener(message -> {
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(message).getAsJsonObject();

            JsonObject rule = json.get("rule").getAsJsonObject();
            String name = rule.get("name").getAsString();
            String action = rule.get("action").getAsString();
            if (action.contains("EMAIL")) {
                String to = "dorukerena@gmail.com";
                if (action.split(" ").length > 1) {
                    to = action.split(" ")[1];
                }

                Calendar current = Calendar.getInstance();
                current.add(Calendar.MINUTE, -1);

                if (current.getTimeInMillis() > lastSend.getTime()) {
                    MailAPI.sendMail(to, name,"EMAIL action by rule: " + name);
                }
            }
        });
        consumer.start();

//        ArrayList<Long> eventDelay = new ArrayList<>();
//        ArrayList<Long> processDelay = new ArrayList<>();
//        ArrayList<Long> actionDelay = new ArrayList<>();
//
//        AtomicReference<Long> totalEventCount = new AtomicReference<>(0L);
//        AtomicReference<Long> totalActionCount = new AtomicReference<>(0L);
//
//        KafkaConsumerImp eventsConsumer = new KafkaConsumerImp("localhost:9092", "Events");
//        eventsConsumer.addListener(message -> {
//            long count = totalEventCount.get() + 1;
//            totalEventCount.getAndSet(count);
//
//            if (count % 100 == 0) {
//                long currentTime = new Date().getTime();
//                JsonParser parser = new JsonParser();
//                JsonObject json = parser.parse(message).getAsJsonObject();
//
//                long sendTime = json.get("date").getAsLong();
//
//                eventDelay.add(currentTime - sendTime);
//            }
//        });
//        eventsConsumer.start();
//
//        KafkaConsumerImp actionsConsumer = new KafkaConsumerImp("localhost:9092", "Actions");
//        actionsConsumer.addListener(message -> {
//            long count = totalActionCount.get() + 1;
//            totalActionCount.getAndSet(count);
//            System.out.print("|");
//
//            if (count % 100 == 0) {
//                System.out.print(" " +  (count / 100));
//                long currentTime = new Date().getTime();
//                JsonParser parser = new JsonParser();
//                JsonObject json = parser.parse(message).getAsJsonObject();
//
//                long arriveTime = json.get("match").getAsJsonObject().entrySet().iterator().next().getValue().getAsJsonArray().get(0).getAsJsonObject().get("date").getAsLong();
//                long sendTime = json.get("date").getAsLong();
//
//                processDelay.add(sendTime - arriveTime);
//                actionDelay.add(currentTime - sendTime);
//
//                System.out.println();
//                System.out.print("Event Delay");
//                for (Long delay: eventDelay) {
//                    System.out.print(" " + delay);
//                }
//                System.out.println();
//
//                System.out.print("Process Delay");
//                for (Long delay: processDelay) {
//                    System.out.print(" " + delay);
//                }
//                System.out.println();
//
//                System.out.print("Action Delay");
//                for (Long delay: actionDelay) {
//                    System.out.print(" " + delay);
//                }
//                System.out.println();
//            }
//        });
//        actionsConsumer.start();
    }
}
