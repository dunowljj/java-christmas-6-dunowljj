package christmas.dto.response;

import christmas.domain.order.Order;
import christmas.domain.order.Orders;

import java.util.List;
import java.util.stream.Stream;

public class OrdersResponse {

    private final List<OrderDto> orderDtos;

    public OrdersResponse(List<Order> orders) {
        orderDtos = orders.stream()
                .map(this::toDto)
                .toList();
    }

    private OrderDto toDto(Order order) {
        return new OrderDto(order.getMenuName(), order.getCount());
    }

    public static OrdersResponse from(Orders orders) {
        return new OrdersResponse(orders.getOrders());
    }

    public Stream<OrderDto> stream() {
        return orderDtos.stream();
    }

    public static class OrderDto {
        private final String menuName;
        private final int menuCount;

        public OrderDto(String menuName, int menuCount) {
            this.menuName = menuName;
            this.menuCount = menuCount;
        }

        @Override
        public String toString() {
            return String.format("%s %d개", menuName, menuCount);
        }
    }
}
