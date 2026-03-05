public class Main {
    public static void main(String[] args) {
        // สร้าง Object ของ Xpay และกำหนดค่า
        Xpay xpay = new XpayImpl();
        xpay.setCreditCardNo("4789565874102365");
        xpay.setCustomerName("Somchai Jaidee");
        xpay.setCardExpMonth("09");
        xpay.setCardExpYear("25");
        xpay.setCardCVVNo((short) 235);
        xpay.setAmount(2565.23);

        // ใช้ Adapter เพื่อให้ Xpay ทำงานในรูปแบบของ PayD
        PayD payD = new XpayToPayDAdapter(xpay);

        // ทดสอบดึงข้อมูลผ่าน Interface ของ PayD
        System.out.println("--- Payment Details (Adapted) ---");
        System.out.println("Credit Card Number: " + payD.getCreditCardNo());
        System.out.println("Card Owner Name: " + payD.getCardOwnerName());
        System.out.println("Card Expiry Date: " + payD.getCardExpMonthYear());
        System.out.println("CVV: " + payD.getCVVNo());
        System.out.println("Total Amount: " + payD.getTotalAmount());
    }
}