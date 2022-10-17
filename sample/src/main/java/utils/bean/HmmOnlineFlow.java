package utils.bean;

public class HmmOnlineFlow {
    public String id;
    public String bill_id;
    public String biz_user_id;
    public String source_id;
    public String source_type;
    public String	status;
    public String amount;
    public String trade_fee;
    public String service_fee;
    public String	type;
    public String balance;
    public String create_time;
    public String update_time;

    @Override
    public String toString() {
        return "HmmOnlineFlow{" +
                "id='" + id + '\'' +
                ", bill_id='" + bill_id + '\'' +
                ", biz_user_id='" + biz_user_id + '\'' +
                ", source_id='" + source_id + '\'' +
                ", source_type='" + source_type + '\'' +
                ", status='" + status + '\'' +
                ", amount='" + amount + '\'' +
                ", trade_fee='" + trade_fee + '\'' +
                ", service_fee='" + service_fee + '\'' +
                ", type='" + type + '\'' +
                ", balance='" + balance + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }

    public HmmOnlineFlow(String id, String bill_id, String biz_user_id, String source_id, String source_type, String status, String amount, String trade_fee, String service_fee, String type, String balance, String create_time, String update_time) {
        this.id = id;
        this.bill_id = bill_id;
        this.biz_user_id = biz_user_id;
        this.source_id = source_id;
        this.source_type = source_type;
        this.status = status;
        this.amount = amount;
        this.trade_fee = trade_fee;
        this.service_fee = service_fee;
        this.type = type;
        this.balance = balance;
        this.create_time = create_time;
        this.update_time = update_time;
    }
}
