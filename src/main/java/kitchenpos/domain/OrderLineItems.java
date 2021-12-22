package kitchenpos.domain;

import org.springframework.util.CollectionUtils;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.List;

@Embeddable
public class OrderLineItems {
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderLineItem> orderLineItems;

    public OrderLineItems() {

    }

    public List<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public OrderLineItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public long size() {
        return this.orderLineItems.size();
    }

    public boolean empty() {
        return CollectionUtils.isEmpty(orderLineItems);
    }

    public void add(OrderLineItem orderLineItem) {
        this.orderLineItems.add(orderLineItem);
    }
}
