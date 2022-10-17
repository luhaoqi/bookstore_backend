package com.example.my_bookstore_backend.Listener;

import com.example.my_bookstore_backend.entity.OrderList;
import com.example.my_bookstore_backend.service.OrderListService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderListListener {
    @Autowired
    private OrderListService orderListService;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "bookstore_purchase", groupId = "group_topic")
    public void purchaseListener(ConsumerRecord<String, String> record) {
        System.out.println("In Listener! " + record.value());
        String[] value = record.value().split(",");
        int uid = Integer.parseInt(value[1]);
        String tel = value[2], address = value[3], name = value[4];
        OrderList o;
        o = orderListService.purchase(uid, tel, address, name);
        if (o != null)
        {
            kafkaTemplate.send("bookstore_done", "done", "Done: orderListId=" + o.getOrderListId());
            return;
        }
        o = new OrderList();
        o.setOrderListId(0);
        kafkaTemplate.send("bookstore_done", "done", "Error");
        return;
    }

    @KafkaListener(topics = "bookstore_done", groupId = "group_topic")
    public void topic2Listener(ConsumerRecord<String, String> record) {
        String value = record.value();
        System.out.println(value);
    }
}
