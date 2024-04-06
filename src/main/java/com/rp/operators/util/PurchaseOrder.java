package com.rp.operators.util;

import com.rp.util.Utils;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrder {

    private String item;
    private String price;
    private int userId;

    public PurchaseOrder(int userId) {
        this.userId = userId;
        this.item = Utils.faker().commerce().productName();
        this.price = Utils.faker().commerce().price();
    }
}
