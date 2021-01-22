package kitchenpos.order.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class TableGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

    @Embedded
    private OrderTables orderTables;

    protected TableGroup() {
    }

    public TableGroup(final OrderTables orderTables) {
        updateOrderTables(orderTables);
    }

    public TableGroup(Long id, LocalDateTime createdDate) {
        this.id = id;
        this.createdDate = createdDate;
    }

    public void updateOrderTables(OrderTables orderTables) {
        orderTables.updateTableGroup(this);
        this.orderTables = orderTables;
    }

    public void unGroup() {
        orderTables.checkOrderTableStatus();
        orderTables.unGroup();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public List<OrderTable> getOrderTables() {
        return orderTables.findAll();
    }

}