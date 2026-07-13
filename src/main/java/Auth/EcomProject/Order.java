package Auth.EcomProject;

import java.awt.*;
import java.util.List;

public class Order {
    public List<OrderDetails> getOrder() {
        return order;
    }

    public void setOrder(List<OrderDetails> order) {
        this.order = order;
    }

    private List<OrderDetails> order;
}
