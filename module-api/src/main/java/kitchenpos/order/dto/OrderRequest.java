package kitchenpos.order.dto;

import kitchenpos.order.domain.OrderStatus;

import java.util.List;

public class OrderRequest {
    private Long orderTableId;

    private OrderStatus orderStatus;

    private List<OrderLineItemRequest> orderLineItemRequests;

    public OrderRequest(Long orderTableId, OrderStatus orderStatus, List<OrderLineItemRequest> orderLineItems) {
        this.orderTableId = orderTableId;
        this.orderStatus = orderStatus;
        this.orderLineItemRequests = orderLineItems;
    }

    public Long getOrderTableId() {
        return orderTableId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<OrderLineItemRequest> getOrderLineItemRequests() {
        return orderLineItemRequests;
    }
}
