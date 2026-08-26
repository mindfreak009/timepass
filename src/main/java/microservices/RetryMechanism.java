package microservices;

public class RetryMechanism {
    public static void main(String[] args) {

    }

//  If the failure is intermittent, retrying after a short delay can resolve the issue.
//  Solution : Use Spring Retry to automatically retry failed attempts

//    @Retryable(value="{HttpServerException.class}, maxAttempts = 3, backoff = @Backoff(delay=2000))
//    public ResponseEntity<String> callPaymentService() {
//        return restTemplate.getForEntity("http://payment-service/api/payments", String.class);
//    }


}