package io.thorntail.example;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * <br>
 * Date: 10/8/18
 */
@ApplicationScoped
public class AProvider {

    @Timeout(500L)
    @Fallback(fallbackMethod = "mockIt")
    @Retry(maxRetries = 2, maxDuration = 500)
    public String get() {
        try {
            Thread.sleep(501L);
        } catch (InterruptedException ignored) {
        }
        return "Some ad that should never be returned";
    }

    private String mockIt() {
        return "Keep an eye on what's coming in Thorntail v4!";
    }
}
