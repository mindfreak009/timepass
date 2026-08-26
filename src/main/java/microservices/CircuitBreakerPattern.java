package microservices;

public class CircuitBreakerPattern {

    public static void main(String[] args) {

    }

//    Solution: Use Resilience4j CircuitBreaker to monitor failures and temporary stop calls
//       @CircuitBreaker(name="orderService", fallbackMethod="fallbackResponse")
//       public String callOrderService() {
//         return restTemplate.getForObject("http://order-service/api/orders", String.class);
//       }

    public String fallbackResponse(Exception ex) {
        return "Fallback: Order Service is unavailable. Please try again later..";
    }


}
