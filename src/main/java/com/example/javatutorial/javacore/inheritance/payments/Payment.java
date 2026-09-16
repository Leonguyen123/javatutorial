package com.example.javatutorial.javacore.inheritance.payments;

/*
Bạn đang xây dựng backend cho hệ thống đặt hàng.

Hệ thống hỗ trợ:

- Thanh toán bằng thẻ tín dụng.
- Thanh toán bằng chuyển khoản ngân hàng.
- Thanh toán bằng ví điện tử.
- Mỗi phương thức thanh toán đều có:
    - `paymentId`
    - `amount`
    - `createdAt`
    - trạng thái thanh toán.
- Mỗi phương thức có cách xử lý riêng:
    - Card → gọi payment gateway.
    - Bank Transfer → kiểm tra giao dịch ngân hàng.
    - E-wallet → gọi API ví điện tử.

Ngoài ra, hệ thống cần:

```
refund()
```

nhưng **không phải phương thức thanh toán nào cũng hỗ trợ refund**.

### Nhiệm vụ

Thiết kế:

```
Payment
CardPayment
BankTransferPayment
EWalletPayment
Refundable
```

Bạn phải quyết định:

- `Payment` là class, abstract class hay interface?
- `Refundable` là gì?
- `CardPayment` kế thừa/implement cái gì?
- `BankTransferPayment` có cần `Refundable` không?
- `Payment` nên chứa state nào?
* */

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter(AccessLevel.PROTECTED)
abstract class Payment {
    // Tại sao phải là private
    private Long paymentId;
    private BigDecimal amount;
    private LocalDateTime createAt;
    private PaymentStatus status;

    public Payment(Long paymentId, BigDecimal amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.createAt = LocalDateTime.now();
        this.status = PaymentStatus.NEW;
    }

    // tại sao ? là protected
    protected void makeAsPaid(){
        this.status = PaymentStatus.PAID;
    }

    // tại sao ? là protected
    protected void cancel(){
        this.status = PaymentStatus.CANCEL;
    }

    public abstract void process();
}
