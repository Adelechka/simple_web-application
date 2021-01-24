package ru.itis.javalab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.models.Order;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Integer id;
    private Long userId;
    private Integer countryId;
    private Integer hotelStars;
    private Integer shippingId;
    private String preferences;

    public static OrderDto from(Order order) {
        if (order == null) {
            return null;
        }
        return OrderDto.builder()
                .userId(order.getUser().getId())
                .countryId(order.getCountry().getId())
                .hotelStars(order.getStar())
                .shippingId(order.getShipping().getId())
                .preferences(order.getPreferences())
                .build();
    }
}
